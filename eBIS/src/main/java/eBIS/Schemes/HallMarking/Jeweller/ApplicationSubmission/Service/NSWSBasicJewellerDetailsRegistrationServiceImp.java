package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eBIS.Masters.Domain.BranchISMappingMaster;
import eBIS.Masters.Domain.DistrictMaster;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Dao.NSWSBasicJewellerDetailsRegistrationDAO;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSUbJewellerDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSubJewellerFirmDetails;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSBasicJewellerDetailsRegistrationModel;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;

@Service
public class NSWSBasicJewellerDetailsRegistrationServiceImp implements NSWSBasicJewellerDetailsRegistrationService {
	@Autowired
	NSWSBasicJewellerDetailsRegistrationDAO dao;
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
			for(int i = 0; i< bids.length; i++) {
			List<BranchISMappingMaster> mapList =  dao.getbranchId(is, Integer.parseInt(bids[i]));
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
	public String syncCheck(int branchId) {
		return dao.syncCheck(branchId);
	}

	@Override
	public List<NSWSApplicationFormMapping> getAppidNSWSId(String nsws_unique_application_id) {
		return dao.getAppidNSWSId(nsws_unique_application_id);
	}

	@Override
	public String saveApplicationData(NSWSBasicJewellerDetailsRegistrationModel mod) {
		 HallAppSUbJewellerDomain dom = convertToAppSubDomain(mod);
			HallAppSubJewellerFirmDetails  firmDom = convert_to_hall_appsub_jeweller_firm_details(mod); 
			return dao.saveApplicationData(mod,dom,firmDom);
	}

	private HallAppSubJewellerFirmDetails convert_to_hall_appsub_jeweller_firm_details(
			NSWSBasicJewellerDetailsRegistrationModel mod) {

		HallAppSubJewellerFirmDetails dom = new HallAppSubJewellerFirmDetails();
		dom.setNum_branch_id(mod.getBranchId());
		dom.setNum_city_id(mod.getCityId());
		dom.setNum_country_id(mod.getCountryId());
		dom.setNum_district_id(mod.getDistrictId());
		dom.setNum_entry_emp_id(mod.getUserId());
		dom.setNum_hallmarkapp_id(mod.getAppId());
		dom.setNum_state_id(mod.getStateId());
		dom.setStr_address_1(mod.getAddress1());
		dom.setStr_address_2(mod.getAddress2());
		dom.setStr_application_id_ref(mod.getAppIdref());
		dom.setStr_contactperson_emailid(mod.getEmailContact());
		dom.setStr_contactperson_name(mod.getNameContact());
		dom.setStr_contactperson_no(mod.getMobContact());
		dom.setStr_designation(mod.getDesigContact());
		dom.setStr_firm_name(mod.getFirmName());
		dom.setStr_gst_no(mod.getGstNo());
		dom.setStr_latitude(mod.getLatitude());
		dom.setStr_longitude(mod.getLongitude());
		dom.setStr_party_code(mod.getPartyCode());
		dom.setStr_pin_code(mod.getPinCode());
		dom.setStr_turnover(mod.getTurnOver());
		//ask NITIN sir ki firm initials kaha se aaenge;
		return dom;
	
	}

	private HallAppSUbJewellerDomain convertToAppSubDomain(NSWSBasicJewellerDetailsRegistrationModel mod) {

		HallAppSUbJewellerDomain dom = new HallAppSUbJewellerDomain();
		
		dom.setIs_valid(1);
		dom.setNum_application_status_id(27);
		dom.setNum_branch_id(mod.getBranchId());
		dom.setNum_gbl_user_id(mod.getUserId());
		dom.setNum_outlet_no(mod.getNum_outlet());
		dom.setNum_scale_id(0);
		dom.setNum_sector_id(mod.getSector());
		if(mod.getStndrdyr() == null || mod.getStndrdyr() != ""){
			int yr=dao.getStandardstdyr(mod.getApplication_for());
			dom.setNum_std_yr(yr);
		}else{
			dom.setNum_std_yr(Integer.parseInt(mod.getStndrdyr()));
		}
		dom.setReceipt_no(mod.getReceiptNo());
		dom.setStr_application_id_ref(mod.getAppIdref());
		dom.setStr_applicensetype("Voluntary");
		dom.setStr_ca_certificate(mod.getIsTurnoverLT40());
		dom.setStr_gst_no(mod.getGstNo());
		dom.setStr_is_number(mod.getApplication_for());
		dom.setStr_latlong("");
		// ask NITIN sir ki latitude or longitude ka column same h dom m
		dom.setStr_outlet_type(""+mod.getNum_outlet());
		dom.setStr_ownershiptypename(mod.getTypeFirm());
		dom.setStr_party_code(mod.getPartyCode());
		dom.setStr_pre_cancellicensedetail(mod.getPreConvictionDetails());
		dom.setStr_prelicencedetail(mod.getPreLicenceDetails());
		dom.setStr_product_id(dao.getStandardprodid(mod.getApplication_for()));
		dom.setStr_turnover(mod.getTurnOver());
		dom.setStrappliedyear(mod.getAppliedYear());
		dom.setStrpayfeeyear(mod.getFeePaidYears());
		dom.setStr_application_id(mod.getAppId());
		dom.setStr_outlet_type("Jewellery Outlet");
		return dom;
	
	}

}
