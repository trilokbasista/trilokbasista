package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import eBIS.Masters.Domain.BranchISMappingMaster;
import eBIS.Masters.Domain.DistrictMaster;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Dao.NSWSJewellerOutletDetailsRegistrationDAO;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSUbJewellerDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_Licence_Details_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSJewellerOutletDetailsRegistrationModel;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;


@Service
public class NSWSJewellerOutletDetailsRegistrationServiceImp implements NSWSJewellerOutletDetailsRegistrationService {

	@Autowired
	NSWSJewellerOutletDetailsRegistrationDAO dao;

	@Override
	public int generateBranchId(int districtId, String isNo) {
		int bid = 0;
		List<DistrictMaster> bid_mapped = dao.getbid_mapped(districtId);
		if(!bid_mapped.get(0).getStr_mapped_branch_id().contains(","))
			bid = Integer.parseInt(bid_mapped.get(0).getStr_mapped_branch_id());
		else
		{
			String [] bids = bid_mapped.get(0).getStr_mapped_branch_id().split(",");

			String is = dao.getStandardprodid(isNo);
			for (String bid2 : bids) {
			List<BranchISMappingMaster> mapList =  dao.getbranchId(is, Integer.parseInt(bid2));
			if(mapList.size()>0)
			{
				bid = mapList.get(0).getNum_branch_id();
				break;
			}
			}
		}
		return bid;
	}

	@Override
	public String saveOutletData(NSWSJewellerOutletDetailsRegistrationModel mod) {
		List<HallAppSUbJewellerDomain> appData = dao.getAppData(mod.getHmAppid());
		int minOutlets = appData.get(0).getNum_outlet_no();
		String isNo = appData.get(0).getStr_is_number();
		
		return dao.saveOutletDetails(mod, minOutlets, isNo);
	}

@Override
public String getstdYr(String nswsappId) {
	String stdyr = "";
	List<HallAppSUbJewellerDomain> appData = dao.getAppData(nswsappId);
	if(appData.size()>0) {
		stdyr = ""+appData.get(0).getNum_std_yr();
	}
	return stdyr;
}

@Override
public String getisNo(String nswsappId) {
	String isNo="";
	 List<HallAppSUbJewellerDomain> appData = dao.getAppData(nswsappId);
	if(appData.size()>0) {
		isNo = appData.get(0).getStr_is_number();
	}
	return isNo;
}
	@Override
	public List<NSWSApplicationFormMapping> getAppidNSWSId(String nswsappId) {
		return dao.getAppidNSWSId(nswsappId);
	}

	@Override
	public List<Hall_Licence_Details_Domain> getcmldetails(String appid, String branch_id) {
		return dao.getcmldetails(appid,branch_id);

	}

	@Override
	public int getAppData(String hmAppid) {
		List<HallAppSUbJewellerDomain> appData = dao.getAppData(hmAppid);
		int minOutlets = appData.get(0).getNum_outlet_no();
		return minOutlets;
	}

	@Override
	public void downloadcmlentry(String checksum, NSWSJewellerOutletDetailsRegistrationModel model) {
		dao.downloadcmlentry(checksum,model);
		
	}

	@Override
	public String updatebranchcml(String appid, String branch_id) {
		return dao.updatebranchcml(appid,branch_id);
	}

	@Override
	public String checkuploadentry(String[] addressproof,String appid, String branch_id) {
		return dao.checkuploadentry(addressproof,appid, branch_id);
	}

}
