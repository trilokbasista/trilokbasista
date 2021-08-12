package eBIS.nswsAPI.Controller;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import eBIS.nswsAPI.Domain.NSWSRequestLog;
import eBIS.nswsAPI.Model.NSWSAuthenticationModel;
import eBIS.nswsAPI.Services.NSWSAuthenticationService;

@RestController
@RequestMapping("API/NSWS")

public class NSWSAuthenticationController {
	@Autowired 
	NSWSAuthenticationService service;
	
	
	@PostMapping("/NSWSAuthentication")
	public HashMap<String, String> NSWSAuthentication(HttpServletRequest  request,@RequestBody NSWSAuthenticationModel model,HttpServletResponse response) {
		HttpSession httpsession = request.getSession();
		NSWSRequestLog log =new NSWSRequestLog();
		List<HashMap<String, String>>  responseMap = new ArrayList<HashMap<String,String>>();
		HashMap<String, String> tempresponse=new HashMap<String, String>();
		Gson g = new Gson();
		try {
			log.setNsws_unique_user_id("");
			String json = g.toJson(model);
			log.setRequest_Json(json);
			log.setNsws_request_url("NSWSAuthentication");
//	        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//	        System.out.println(passwordEncoder.encode("Nsws@123"));
			NSWSRequestLog temp = service.submitLog(log);
			log=temp;
			int flagcheck = service.checkPasswordforNSWS(model);
			if(flagcheck>0) {
				String accesstoken = httpsession.getId();
				tempresponse.put("accesstoken", accesstoken);
			}else {
				tempresponse.put("output_response_string", "Bad Credentials");	
			}
		}catch(Exception ex) {
			tempresponse.put("exception", ex.getClass().getSimpleName());	
		}
		responseMap.add(tempresponse);
		log.setResponse_Json(tempresponse.toString());
		service.submitLog(log);
		return responseMap.get(0);
	}

}
