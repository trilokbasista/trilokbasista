package eBIS.HomePage.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import eBIS.HomePage.Service.HomePageService;


@Controller
public class HomePageController {
	@Autowired
	HomePageService service;
//	@Autowired
//	EmailConfiguration sendmail;
	@GetMapping(value = "/Home")
	 public ModelAndView HomePagePage(HttpServletRequest  request) {  
		ModelAndView mv=new ModelAndView(); 
		HttpSession httpsession = request.getSession(false);  
		if(httpsession!=null) {
			System.out.println("Session IN2");
			System.out.println("Session ID: "+httpsession.getId());
		}else {
			System.out.println("Session Out");
		}

//        ArrayList<String> CCMAIL = new ArrayList<String>();
//        CCMAIL.add("vivek.kumar@cdac.in");
//        CCMAIL.add("nitinkumarvarshney@cdac.in");
//        CCMAIL.add("gourmohan@cdac.in");
//        String[] CCMAILARR = CCMAIL.stream().toArray(String[]::new);
//        System.out.println(Arrays.toString(CCMAILARR));
//		sendmail.SingleMailSender("vivek.kumar@cdac.in", CCMAILARR, "Test mail", "Test mail for Spring boot");
       mv.setViewName("eBIS.HomePage.Body");
       return mv;   
   }
}
