package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_Licence_Details_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSJewellerOutletDetailsRegistrationModel;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;

public interface NSWSJewellerOutletDetailsRegistrationService {

	int generateBranchId(int districtId, String isno);
	
	@Transactional(propagation = Propagation.REQUIRED,rollbackFor = Exception.class)
	String saveOutletData(NSWSJewellerOutletDetailsRegistrationModel mod);

	List<NSWSApplicationFormMapping> getAppidNSWSId(String nswsappId);
	
	String getstdYr(String appid);
	
	String getisNo(String appid);
	
	List<Hall_Licence_Details_Domain> getcmldetails(String appid, String branch_id);
	
	int getAppData(String hmAppid);

	void downloadcmlentry(String checksum, NSWSJewellerOutletDetailsRegistrationModel model);

	String updatebranchcml(String appid, String branch_id);

	String checkuploadentry(String[] addressproof, String appid, String branch_id);


}
