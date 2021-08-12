package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import eBIS.Global.Registration.Domain.RegisterDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSBasicJewellerDetailsRegistrationModel;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service.NSWSBasicJewellerDetailsRegistrationService;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;
import eBIS.nswsAPI.Domain.NSWSRequestLog;
import eBIS.nswsAPI.Model.NSWSRegistrationModel;
import eBIS.nswsAPI.Services.NSWSAuthenticationService;
import eBIS.nswsAPI.Services.NSWSServiceUtility;

@RestController
@RequestMapping("API/NSWS")
public class NSWSBasicJewellerDetailsRegistrationController {
	@Autowired
	NSWSServiceUtility NSWSServiceUtilityObject;
	@Autowired
	NSWSAuthenticationService NSWSAuthenticationServiceObject;
	
	@Autowired
	NSWSBasicJewellerDetailsRegistrationService Service;
	
	@PostMapping("/BasicJewellerDetailsRegistration")
	public HashMap<String, String> saveDataHMFormPage1(HttpServletRequest req,@RequestBody NSWSBasicJewellerDetailsRegistrationModel mod) {
		List<HashMap<String, String>> responseMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> tempresponse = new HashMap<String, String>();
		NSWSRequestLog log = new NSWSRequestLog();
		Gson g = new Gson();
		try {
			log.setNsws_access_token(mod.getManak_access_token());
			log.setNsws_unique_user_id(mod.getNsws_unique_username());
			String json = g.toJson(mod);
			log.setRequest_Json(json);
			log.setNsws_request_url("BasicJewellerDetailsRegistration");
			NSWSRequestLog temp = NSWSAuthenticationServiceObject.submitLog(log);
			log = temp;
			String ManakAccessToken = mod.getManak_access_token();
			int count = NSWSServiceUtilityObject.NSWScheckAccesTokenNSWS(ManakAccessToken);
			if (count == 0) {
				tempresponse.put("output_response_string", "ManakAccessTokenExpire");
			} else {
				NSWSRegistrationModel model=new NSWSRegistrationModel();
				model.setNswsUniqueUser(mod.getNsws_unique_username());
				model.setNswsUserDOB(mod.getNswsUserDOB());
				model.setNswsUserEmail(mod.getNswsUserEmail());
				model.setNswsUserFirstName(mod.getNswsUserFirstName());
				model.setNswsUserLastName(mod.getNswsUserLastName());
				model.setNswsUserMiddleName(mod.getNswsUserMiddleName());
				model.setNswsUserMobile(mod.getNswsUserMobile());
				String username ="";
				int countflag = NSWSAuthenticationServiceObject.checkExisitingUser(model);
				if(countflag>0) {
					tempresponse.put("output_response_string", "User Already exists in MOL");
				}else {
					 List<RegisterDomain> list = NSWSAuthenticationServiceObject.checkExisitingUserforNSWS(model);
					 int countflagnsws=list.size();
					 
						if(countflagnsws>0) {
							if(list.get(0).getStr_user_name()!=null && !list.get(0).getStr_user_name().equalsIgnoreCase(""))
							{
								username=list.get(0).getStr_user_name();
							}else {
								username="0";
							}
						}else {
							username = NSWSAuthenticationServiceObject.generateUserforNSWS(model);
							
						}
						System.out.println("username: "+username);
				
				if(!username.equalsIgnoreCase("0")) {
					int branchId = Service.generateBranchId(mod.getDistrictId(), mod.getApplication_for());
					if (branchId == 0) {
						tempresponse.put("output_response_string", "Invalid District Id or IS no");
					} else {
						String appId = Service.syncCheck(branchId);
						if (appId.equals("")) {
							tempresponse.put("output_response_string", "App Id generation failed on MOL");
						} else {
							mod.setAppId(appId);
							mod.setBranchId(branchId);
							List<NSWSApplicationFormMapping> list2 = Service.getAppidNSWSId(mod.getNsws_unique_application_id());
							if (list2.size() > 0) {
								tempresponse.put("output_response_string", "NSWS unique App ID Already Exists in MOL");
							} else {
								String ManakUserId = NSWSServiceUtilityObject.getManakUserId(mod.getNsws_unique_username());
								if (ManakUserId.equals("0")) {
									tempresponse.put("output_response_string", "User Not Found");
								} else {
									mod.setUserId(Long.parseLong(ManakUserId));
									String flag = Service.saveApplicationData(mod);
									if (flag.equals("1")) {
										tempresponse.put("manak_app_id", appId);
									} else {
										tempresponse.put("output_response_string", flag);
									}
								}

							}
						}

					}
				}else {
					tempresponse.put("output_response_string", "User Registration Failed on MOL");
				}

			}
		}
		} catch (Exception ex) {
			tempresponse.put("exception", ex.getClass().getSimpleName());
		}
		responseMap.add(tempresponse);
		log.setResponse_Json(tempresponse.toString());
		NSWSAuthenticationServiceObject.submitLog(log);
		return tempresponse;
	}
}
