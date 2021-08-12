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

//import eBIS.JRXML.Service.JRXMLGenerateService;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_Licence_Details_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSJewellerOutletDetailsRegistrationModel;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service.NSWSJewellerOutletDetailsRegistrationService;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;
import eBIS.nswsAPI.Domain.NSWSRequestLog;
import eBIS.nswsAPI.Services.NSWSAuthenticationService;
import eBIS.nswsAPI.Services.NSWSServiceUtility;

@RestController
@RequestMapping("API/NSWS")
public class NSWSJewellerOutletDetailsRegistrationController {
	
	@Autowired
	NSWSJewellerOutletDetailsRegistrationService serv;
	@Autowired
	NSWSServiceUtility NSWSServiceUtilityObject;
	@Autowired
	NSWSAuthenticationService service;
//	@Autowired
//	JRXMLGenerateService JRXMLService;
	private static String OS = System.getProperty("os.name").toLowerCase();
	@PostMapping("/JewellerOutletDetailsRegistration")
	public HashMap<String, String> saveOutletData(HttpServletRequest request,
			@RequestBody NSWSJewellerOutletDetailsRegistrationModel model)throws Exception {
		List<HashMap<String, String>> responseMap = new ArrayList<HashMap<String, String>>();
		HashMap<String, String> tempresponse = new HashMap<String, String>();
		NSWSRequestLog log = new NSWSRequestLog();
		Gson g = new Gson();
		try {
			log.setNsws_access_token(model.getManak_access_token());
			log.setNsws_unique_user_id(model.getNsws_unique_username());
			String json = g.toJson(model);
			log.setRequest_Json(json);
			log.setNsws_request_url("JewellerOutletDetailsRegistration");
			NSWSRequestLog temp = service.submitLog(log);
			log = temp;
			String ManakAccessToken = model.getManak_access_token();
			int count = NSWSServiceUtilityObject.NSWScheckAccesTokenNSWS(ManakAccessToken);
			if (count == 0) {
				tempresponse.put("output_response_string", "ManakAccessTokenExpire");
			} else {
				String nswsappId = model.getNsws_unique_application_id();
				List<NSWSApplicationFormMapping> list = serv.getAppidNSWSId(nswsappId);
				if (list.size() > 0) {
					String appid = list.get(0).getManak_app_id();
					String branch_id = list.get(0).getManak_branch_id();
					model.setStdYr(serv.getstdYr(appid));
					model.setIsNo(serv.getisNo(appid));
					model.setHmAppid(appid);
					model.setBranchId(Integer.parseInt(branch_id));
					int outletflag=0;
					String ManakUserId = NSWSServiceUtilityObject.getManakUserId(model.getNsws_unique_username());
					if (ManakUserId.equals("0")) {
						tempresponse.put("output_response_string", "User Not Found");
					} else {
						
						model.setUserId(Long.parseLong(ManakUserId));
						int minOutlets =  serv.getAppData(model.getHmAppid());
						if(minOutlets==0) {
							tempresponse.put("output_response_string", "Invalid License Type");
						}else {
							if(minOutlets == 1) {
								if(model.getOutletName().length == 1) {
									outletflag=1;
								}else {
									tempresponse.put("output_response_string", "Only one outlet is allowed in single license");	
								}
							}else {
								if(model.getOutletName().length >= 5) {
									outletflag=1;
								}else {
									tempresponse.put("output_response_string", "Atleast 5 outlet should be filled in corporate license");	
								}
							}	
						}
						if(outletflag==1) {
							String checkstatment = validator(model);
							if(checkstatment.equals("1")) {
								String[] addressproof = model.getAddressProofDocType();
								String uploadflag = serv.checkuploadentry(addressproof,appid, branch_id);
								if(uploadflag.equals("1")) {
								String flag = serv.saveOutletData(model);
								if (flag.equals("1")) {
									serv.updatebranchcml(appid, branch_id);
									 List<Hall_Licence_Details_Domain> cmllist = serv.getcmldetails(appid, branch_id);
									if (cmllist.size() > 0) {
										tempresponse.put("status", "Operative");
										tempresponse.put("cml_no", cmllist.get(0).getStr_cml_no());
										tempresponse.put("validity_date", cmllist.get(0).getDt_validity_date().toString());
										HashMap<String, Object> parameters = new HashMap<>();
								        parameters.put("appid", appid);
									    parameters.put("branchid", Integer.parseInt(branch_id+""));
									    parameters.put("cmlno", cmllist.get(0).getStr_cml_no());
									    model.setCmlno(cmllist.get(0).getStr_cml_no());
									    String JRXMLName = "";
										if(OS.contains("win")) {
											JRXMLName = "licence_doc_hallmark_outlet_winodws.jrxml";
										}else {										
											JRXMLName = "licence_doc_hallmark_outlet.jrxml";
										}
										System.out.println("JRXMLName: "+JRXMLName);
//										String checksum = JRXMLService.GenerateJRXMLPDF(JRXMLName, parameters);
//										if(!checksum.equals("0")) {
//											serv.downloadcmlentry(checksum,model);
//										}
										String url = request.getRequestURL().toString().split("/eBIS/")[0];
										System.out.println("url: "+url);
										tempresponse.put("lic_doc_url", url+"/eBIS/API/NSWS/HMCMLDownload?nsws_unique_application_id="+model.getNsws_unique_application_id());
									} else {
										tempresponse.put("output_response_string", "CML not found");
									}
									
								} else {
									if(flag.equals("2")) {
										tempresponse.put("output_response_string", "License already exists");									
									}else {
										tempresponse.put("output_response_string", flag);	
									}								
								}
							}else {
								tempresponse.put("output_response_string", uploadflag);
							}
							}else {
								tempresponse.put("output_response_string", checkstatment);
							}
								
						}
						
						
					}

				} else {
					tempresponse.put("output_response_string", "MANAK Application Id not found");
				}
			}
		} catch (Exception ex) {
			tempresponse.put("exception", ex.getClass().getSimpleName());
			ex.printStackTrace();
		}
		responseMap.add(tempresponse);
		log.setResponse_Json(tempresponse.toString());
		service.submitLog(log);
		return tempresponse;
	}
	private String validator(NSWSJewellerOutletDetailsRegistrationModel model) {
		String statement="1";
		String stdYr=model.getStdYr();
		String isNo=model.getIsNo();
		String [] outletName=model.getOutletName();
		int [] turnover=model.getTurnover();
		String [] address1outlet=model.getAddress1outlet();
		String [] address2outlet=model.getAddress2outlet();
		int [] stateId=model.getStateId();
		int [] districtId=model.getDistrictId();
		int [] cityId=model.getCityId();
		String [] pinCode=model.getPinCode();
		String [] latitude=model.getLatitude();
		String [] longitude=model.getLongitude();
		String [] nameContact=model.getNameContact();
		String [] mobContact=model.getMobContact();
		String [] telephoneContact=model.getTelephoneContact();
		String [] emailContact=model.getEmailContact();
		String [] addressProofDocType=model.getAddressProofDocType();
		if(isNo==null)
		{
		return	statement= "Null is not allowed in isNo field";
		}
		if(!(isNo.equals("IS 1417") || isNo.equals("IS 2112")))
		{
		return	statement= "Wrong IS entered for Gold/Silver";
		}
		if(stdYr==null)
		{
		return	statement= "Null is not allowed in stdYr field";
		}
		if(!(outletName.length==turnover.length && turnover.length==address1outlet.length
			&& address1outlet.length==address2outlet.length && address2outlet.length== stateId.length
			&& stateId.length==districtId.length 
			&& districtId.length==cityId.length && cityId.length==pinCode.length
			&& pinCode.length==latitude.length && latitude.length==longitude.length
			&& longitude.length==nameContact.length && nameContact.length==mobContact.length
			&& mobContact.length==telephoneContact.length && telephoneContact.length==emailContact.length
			&& emailContact.length==addressProofDocType.length)) {
			String temp="outletName.length="+outletName.length+", ";
			temp+="turnover.length="+turnover.length+", ";
			temp+="address1outlet.length="+address1outlet.length+", ";
			temp+="address2outlet.length="+address2outlet.length+", ";
			temp+="stateId.length="+stateId.length+", ";
			temp+="districtId.length="+districtId.length+", ";
			temp+="cityId.length="+cityId.length+", ";
			temp+="pinCode.length="+pinCode.length+", ";
			temp+="latitude.length="+latitude.length+", ";
			temp+="longitude.length="+longitude.length+", ";
			temp+="nameContact.length="+nameContact.length+", ";
			temp+="mobContact.length="+mobContact.length+", ";
			temp+="telephoneContact.length="+telephoneContact.length+", ";
			temp+="emailContact.length="+emailContact.length+", ";
			temp+="addressProofDocType.length="+addressProofDocType.length;
			return	statement= "Array Size mismatch ( "+temp+" )";
		}else {
			for(int i=0;i<outletName.length;i++) {
				if(outletName[i]==null) {
					return	statement= "Null is not allowed in outlet name";
				}
				if(turnover[i]==0) {
					return	statement= "Turn Over=0 of outlet is invalid";
				}
				if(address1outlet[i]==null) {
					return	statement= "Null is not allowed in address 1 field";
				}
				if(address2outlet[i]==null) {
					return	statement= "Null is not allowed in address 2 field";
				}
				if(stateId[i]==0) {
					return	statement= "Invalid stateId value=0";
				}
				if(districtId[i]==0) {
					return	statement= "Invalid districtId value=0";
				}
				if(cityId[i]==0) {
					return	statement= "Invalid cityId value=0";
				}
				if(pinCode[i]==null) {
					return	statement= "Null is not allowed in pincode field";
				}
				if(latitude[i]==null) {
					return	statement= "Null is not allowed in latitude field";
				}
				if(longitude[i]==null) {
					return	statement= "Null is not allowed in longitude field";
				}
				if(nameContact[i]==null) {
					return	statement= "Null is not allowed in nameContact field";
				}
				if(mobContact[i]==null) {
					return	statement= "Null is not allowed in mobContact field";
				}
				if(telephoneContact[i]==null) {
					return	statement= "Null is not allowed in telephoneContact field";
				}
				if(emailContact[i]==null) {
					return	statement= "Null is not allowed in emailContact field";
				}
				if(addressProofDocType[i]==null) {
					return	statement= "Null is not allowed in addressProofDocType field";
				}
			}
		}
		return statement;
	}

}
