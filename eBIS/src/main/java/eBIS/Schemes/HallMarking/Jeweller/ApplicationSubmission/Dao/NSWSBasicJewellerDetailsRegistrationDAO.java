package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Dao;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Configuration.ReadonlyDaoHelper;
import eBIS.Global.CommonUtility.Domain.UserSubSchemeMapping;
import eBIS.Masters.Domain.BranchISMappingMaster;
import eBIS.Masters.Domain.DistrictMaster;
import eBIS.Masters.Domain.StandardMaster;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.AppSubJewelConvictionDetails;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.AppSubJewelPreCancelLicence;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.AppSubJewelPreLicenceDetail;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSUbJewellerDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSubJewellerFirmDetails;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallJewelManagementDetailDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSBasicJewellerDetailsRegistrationModel;
import eBIS.exception.log.domain.ExceptionLog;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;

@Repository
public class NSWSBasicJewellerDetailsRegistrationDAO {
	@Autowired
	PrimaryDaoHelper daohelper;
	@Autowired
	ReadonlyDaoHelper readonlyDaoHelper;
	public List<DistrictMaster> getbid_mapped(int districtId) {
		String qry = "select o from DistrictMaster o where o.num_district_id = "+districtId+"";
		return readonlyDaoHelper.findByQuery(qry);	
	}
	public String getStandardprodid(String ISno) {
		String s="";
		String std="select c from StandardMaster c where c.str_standard_no='"+ISno+"'";
		List<StandardMaster> stdid = readonlyDaoHelper.findByQuery(std);
		if(stdid.size()>0){
			s=stdid.get(0).getStr_product_id();
		}
		return s;
	}
	public List<BranchISMappingMaster> getbranchId(String is, int districtId) {
		String qry = "select o from BranchISMappingMaster o where o.str_standard_no = '"+is+"' and o.num_branch_id = "+districtId+"";
		return daohelper.findByQuery(qry);
	}
	public String syncCheck(int bid) {
		// Genrating application id
				String strAppNo = "";
				int factBranchID = bid;
				String FinalApplicationId="";
				int prevAppId=0;
					String qry = "SELECT a.str_application_id from HallAppSUbJewellerDomain a " +
							"where a.num_hallmarkapp_auto_id=(select max(c.num_hallmarkapp_auto_id) from HallAppSUbJewellerDomain c " +
							"where c.num_branch_id="+factBranchID+" and str_application_id like '"+factBranchID+"9%')";	//'"+factBranchID+"HMJW%'
					List<String> Appid = daohelper.findByQuery(qry);
					if (Appid.size()>0) {
			        prevAppId  = Integer.parseInt(Appid.get(0).toString()); 
					}
					//Checking the length of the Application Id
					if(prevAppId!=0){
					if((String.valueOf(prevAppId).length())<8){
						//Length is not 8, generate a new Application Id with new Sequence
						String NewId = "000001";
						String NewBranchId = Integer.toString(factBranchID);
						FinalApplicationId = NewBranchId +"9"+ NewId;
					}
					else{
						//Check if the new application id is going to be in the restricted set
						int [] restrictedSet = {18401912,65000149,85111883,63003416,63008227,63031310,91012913,71007262};
						int iDigitsToSkip = 1;
						for(int i=0;i<restrictedSet.length;i++){
							if(restrictedSet[i]==prevAppId){
								iDigitsToSkip = 2;
								break;
							}
						}
						//Now generating New App Id
						 strAppNo = prevAppId+"";
						//Splitting the AppID to remove the branch
						String stHead = strAppNo.substring(0,2);
						String stFoot = strAppNo.substring(2);
						//Parsing the Foot to Long
						Long lnAppNo = Long.parseLong(stFoot);
						//Adding 1 to create new App ID
						Long NewId = lnAppNo + iDigitsToSkip;
						String stPadded =StringUtils.leftPad(NewId.toString(), 6, "0");
						//Adding the Branch ID again to create the final application ID
						FinalApplicationId = stHead+stPadded.toString();
					}
					}
					else{
						//String NewId = "1001";
						String NewId = "000001";
						String NewBranchId = Integer.toString(factBranchID);
						String NewApplicationNo = NewBranchId +"9"+ NewId;
						FinalApplicationId = NewApplicationNo;
					}
				return FinalApplicationId;
	}
	public List<NSWSApplicationFormMapping> getAppidNSWSId(String nsws_unique_application_id) {
		String sql="select c from NSWSApplicationFormMapping c where c.is_valid=1 and c.nsws_unique_app_id='"+nsws_unique_application_id+"'";
		return daohelper.findByQuery(sql);
	}
	public int getStandardstdyr(String application_for) {
		int s=0;
		String std="select c from StandardMaster c where c.str_standard_no='"+application_for+"'";
		List<StandardMaster> stdid = readonlyDaoHelper.findByQuery(std);
		if(stdid.size()>0){
			s=stdid.get(0).getNum_std_year();
		}
		
		return s;
	}
	public String saveApplicationData(NSWSBasicJewellerDetailsRegistrationModel mod, HallAppSUbJewellerDomain dom5, HallAppSubJewellerFirmDetails firmDom) {

		Transaction tx = null;
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		String flag="";
		try {
			tx = opensession.beginTransaction();
		HallJewelManagementDetailDomain dom = new HallJewelManagementDetailDomain();
		for(int i=0; i<mod.getNameMgmt().length;i++) {
			dom.setNum_branch_id(mod.getBranchId());
			dom.setNum_entry_emp_id(Integer.parseInt(""+mod.getUserId()));
			dom.setNum_isvalid(1);
			dom.setStr_app_id(mod.getAppId());
			dom.setStr_application_id_ref(mod.getAppIdref());
			dom.setStr_auth_signatory(mod.getAuthSigMgmt()[i]);
			dom.setStr_designation(mod.getDesigMgmt()[i]);
			dom.setStr_name(mod.getNameMgmt()[i]);
			opensession.merge(dom);
		}
		AppSubJewelPreLicenceDetail dom1 = new AppSubJewelPreLicenceDetail();
		for(int i = 0; i< mod.getCertificatenoPrevious().length; i++) {
			dom1.setNum_branch_id(mod.getBranchId());
			dom1.setNum_entry_emp_id(Integer.parseInt(""+mod.getUserId()));
			dom1.setStr_app_id(mod.getAppId());
			dom1.setStr_app_id_ref(mod.getAppIdref());
			dom1.setStr_cml_previous(mod.getCertificatenoPrevious()[i]);
			dom1.setStr_is_no(mod.getPreviousIsNo()[i]);
			dom1.setStr_product(mod.getProductPreviuos()[i]);
			dom1.setStr_validity(mod.getPrevoiusValidity()[i]);
			opensession.merge(dom1);
		}
		AppSubJewelPreCancelLicence dom2 = new AppSubJewelPreCancelLicence();
		for(int i = 0; i< mod.getPreCancelCertificateNo().length; i++) {
			dom2.setNum_branch_id(mod.getBranchId());
			dom2.setNum_entry_emp_id(Integer.parseInt(""+mod.getUserId()));
			dom2.setStr_app_id(mod.getAppId());
			dom2.setStr_application_id_ref(mod.getAppIdref());
			dom2.setStr_cancel_date(mod.getPreCancelDateCancellation()[i]);
			dom2.setStr_cml_previous(mod.getPreCancelCertificateNo()[i]);
			dom2.setStr_detail(mod.getPreCancelDetails()[i]);
			dom2.setStr_is_no(mod.getPreCancelIsNo()[i]);
			dom2.setStr_product(mod.getPreCancelproduct()[i]);
			opensession.merge(dom2);
		}
		AppSubJewelConvictionDetails dom4 = new AppSubJewelConvictionDetails();		
		for(int i = 0; i< mod.getPreCancelCertificateNo().length; i++) {
			dom4.setNum_branch_id(mod.getBranchId());
			dom4.setNum_entry_emp_id(Integer.parseInt(""+mod.getUserId()));
			dom4.setStr_app_id(mod.getAppId());
			dom4.setStr_app_id_ref(mod.getAppIdref());
			dom4.setStr_conviction_date(mod.getPreconvictionDate()[i]);
			dom4.setStr_cml_convict(mod.getPreconvictionCertificateNo()[i]);
			dom4.setStr_detail(mod.getPreconvictionDetails()[i]);
			dom4.setStr_is_no(mod.getPreconvictionIsNo()[i]);
			dom4.setStr_product(mod.getPreconvictionproduct()[i]);
			opensession.merge(dom4);
			}
		opensession.merge(dom5);
		opensession.merge(firmDom);
		NSWSApplicationFormMapping domain=new NSWSApplicationFormMapping();
		domain.setDt_entry_date(new Date());
		domain.setIs_valid(1);
		domain.setManak_app_id(mod.getAppId());
		domain.setManak_branch_id(mod.getBranchId()+"");
		domain.setNsws_unique_app_id(mod.getNsws_unique_application_id());
		domain.setNsws_unique_user_name(mod.getNsws_unique_username());
		opensession.merge(domain);
		UserSubSchemeMapping UserSubSchemeMappingDomain=new UserSubSchemeMapping();
		UserSubSchemeMappingDomain.setDt_entry_date(new Date());
		UserSubSchemeMappingDomain.setNum_branch_id(mod.getBranchId());
		UserSubSchemeMappingDomain.setNum_user_id(Integer.parseInt(mod.getUserId().toString()));
		UserSubSchemeMappingDomain.setStr_application_id(mod.getAppId());
		opensession.merge(UserSubSchemeMappingDomain);
		tx.commit();
		flag="1";
		}catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			ExceptionLog exceptiondomain=new ExceptionLog();
			exceptiondomain.setException_date(new Date());
			exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
			exceptiondomain.setException_remarks(ex.getLocalizedMessage());
			exceptiondomain.setIs_valid("1");
			exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
			exceptiondomain=(ExceptionLog) opensession.merge(exceptiondomain);
			JSONObject dataJson = new JSONObject();
			try {
				dataJson.put("ex_id", exceptiondomain.getNum_id());
				dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
				flag=	dataJson.toString();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}finally {
			opensession.clear();
	       	opensession.close();
		}
		return flag;
	
	}
}
