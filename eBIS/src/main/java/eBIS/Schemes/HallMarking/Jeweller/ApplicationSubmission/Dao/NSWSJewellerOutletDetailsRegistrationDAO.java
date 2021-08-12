package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Configuration.ReadonlyDaoHelper;
import eBIS.Masters.Domain.BranchISMappingMaster;
import eBIS.Masters.Domain.DistrictMaster;
import eBIS.Masters.Domain.StandardMaster;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HMJewApplicationTrackingDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSUbJewellerDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallAppSubJewellerFirmDetails;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallJewelManagementDetailDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.HallOutletDocDtl;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_Branch_Licence_Details_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_Branchdtl_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_Licence_Details_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_firmDtlsContactLicenceDomain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.Hall_jewel_ManagementDetail_Domain_licence;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain.hall_cmlstatusdetails_Domain;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model.NSWSJewellerOutletDetailsRegistrationModel;
import eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Service.NSWSJewellerOutletDetailsRegistrationService;
import eBIS.exception.log.domain.ExceptionLog;
import eBIS.nswsAPI.Domain.NSWSApplicationFormMapping;
import eBIS.nswsAPI.Domain.NSWSDownload;
import eBIS.nswsAPI.Domain.NSWSUpload;
import eBIS.payment.domain.BypassPaymentHM;

@Repository
public class NSWSJewellerOutletDetailsRegistrationDAO {

	@Autowired
	PrimaryDaoHelper daohelper;
	@Autowired
	ReadonlyDaoHelper readonlyDaoHelper;
	@Autowired
	NSWSJewellerOutletDetailsRegistrationService service;

	public List<DistrictMaster> getbid_mapped(int districtId) {
		String qry = "select o from DistrictMaster o where o.num_district_id = " + districtId + "";
		return daohelper.findByQuery(qry);
	}

	public String getStandardprodid(String ISno) {
		String s = "";
		String std = "select c from StandardMaster c where c.str_standard_no='" + ISno + "'";
		List<StandardMaster> stdid = readonlyDaoHelper.findByQuery(std);
		if (stdid.size() > 0) {
			s = stdid.get(0).getStr_product_id();
		}
		return s;
	}


	public List<BranchISMappingMaster> getbranchId(String is, int districtId) {
		String qry = "select o from BranchISMappingMaster o where o.str_standard_no = '" + is
				+ "' and o.num_branch_id = " + districtId + "";
		return daohelper.findByQuery(qry);
	}


	public List<HallAppSUbJewellerDomain> getAppData(String appId) {
		String qry = "select o from HallAppSUbJewellerDomain o where o.str_application_id = '" + appId + "'";
		return daohelper.findByQuery(qry);
	}

	public List<NSWSApplicationFormMapping> getAppidNSWSId(String nswsappId) {
		String sql = "select c from NSWSApplicationFormMapping c where c.is_valid=1 and c.nsws_unique_app_id='"
				+ nswsappId + "'";
		return daohelper.findByQuery(sql);
	}


	public String getLast_Cml_No(int branchID) {

		String cml_no = "";
		String query = "select max(to_number(m.str_cml_no)) from Hall_Licence_Details_Domain m where  m.str_cml_no like '"
				+ branchID + "%' and length(str_cml_no)>=10";
		System.out.println("max licence number query DAO " + query);
		List max_cml = daohelper.findByQuery(query);
		cml_no = "" + max_cml.get(0);
		System.out.println("max_cml_no- DAO " + cml_no);
		return cml_no;

	}


	public List<Hall_Branchdtl_Domain> getBrachAppList(String hmAppid) {
		String qry = "select o from Hall_Branchdtl_Domain o where o.num_hallmarkapp_id = '" + hmAppid + "'";
		return daohelper.findByQuery(qry);
	}


	public List<HallAppSUbJewellerDomain> getAppDataFromAppId(String hmAppid) {
		String qry = "select o from HallAppSUbJewellerDomain o where o.str_application_id = '" + hmAppid + "'";
		return daohelper.findByQuery(qry);
	}


	public List<HallJewelManagementDetailDomain> getMgmtList(String hmAppid) {
		String qry = "select o from HallJewelManagementDetailDomain o where o.str_app_id = '" + hmAppid + "'";
		return daohelper.findByQuery(qry);

	}


	public List<HallAppSubJewellerFirmDetails> getfirmDetail(String hmAppid) {
		String qry = "select o from HallAppSubJewellerFirmDetails o where o.num_hallmarkapp_id = '" + hmAppid + "'";
		return daohelper.findByQuery(qry);
	}


	public String saveOutletDetails(NSWSJewellerOutletDetailsRegistrationModel mod, int minOutlets, String isNo) {
		Transaction tx = null;
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		ArrayList<Hall_Branchdtl_Domain> branchDet=new ArrayList<Hall_Branchdtl_Domain>();  
		String flag="";
		try {
			tx = opensession.beginTransaction();
			if (minOutlets == 0) {

			} else if (minOutlets == 1 && mod.getOutletName().length == 1) {
				String qry = "select nextval('bis_hall.outlet_sequence_id') as outlet_sequence_id";
				String outlet_sequence_id = readonlyDaoHelper.nativeQuery(qry).get(0).toString();
				Hall_Branchdtl_Domain dom = new Hall_Branchdtl_Domain();
				dom.setNum_city_Id(mod.getCityId()[0]);
				String cityName = getCityName(mod.getCityId()[0]);
				dom.setStr_city(cityName);
				dom.setNum_country_id(91);
				dom.setNum_district_id(mod.getDistrictId()[0]);
				dom.setNum_entry_emp_id(mod.getUserId());
				dom.setNum_hallmarkmpp_id(mod.getHmAppid());
				dom.setNum_id_old("0");
				int branchId = service.generateBranchId(mod.getDistrictId()[0], isNo);
				dom.setNum_outlet_branch_id(branchId);
				dom.setNum_hallmarkapp_branch_dtid(mod.getBranchId());
				dom.setNum_state_id(mod.getStateId()[0]);
				dom.setStr_address_1(mod.getAddress1outlet()[0]);
				dom.setStr_address_2(mod.getAddress2outlet()[0]);
				dom.setStr_app_id_old("0");
				dom.setStr_brnhNm(mod.getOutletName()[0]);
				dom.setStr_contpersn_emailid(mod.getEmailContact()[0]);
				dom.setStr_contpersn_name(mod.getNameContact()[0]);
				dom.setStr_contpersn_no(mod.getMobContact()[0]);
				dom.setStr_latitude(mod.getLatitude()[0]);
				dom.setStr_longitude(mod.getLongitude()[0]);
				dom.setStr_pincode(mod.getPinCode()[0]);
				dom.setStr_turnover("" + mod.getTurnover()[0]);
				dom.setStr_document_type(mod.getAddressProofDocType()[0]);
				dom.setStr_doc(String.valueOf(System.nanoTime()));
				dom.setNum_branch_id(mod.getBranchId());
				dom.setOutlet_sequence_id(outlet_sequence_id);
				opensession.merge(dom);
				branchDet.add(dom);
			}
			else if(minOutlets == 2 && mod.getOutletName().length >= 5) {
				for(int i = 0; i< mod.getOutletName().length; i++) {
					Hall_Branchdtl_Domain dom = new Hall_Branchdtl_Domain();
					String qry = "select nextval('bis_hall.outlet_sequence_id') as outlet_sequence_id";
					String outlet_sequence_id = readonlyDaoHelper.nativeQuery(qry).get(0).toString();
					dom.setNum_city_Id(mod.getCityId()[i]);
					String cityName = getCityName(mod.getCityId()[i]);
					dom.setStr_city(cityName);
					dom.setNum_country_id(91);
					dom.setNum_branch_id(mod.getBranchId());
					dom.setNum_district_id(mod.getDistrictId()[i]);
					dom.setNum_entry_emp_id(mod.getUserId());
					dom.setNum_hallmarkmpp_id(mod.getHmAppid());
					dom.setNum_id_old("0");
					int branchId = service.generateBranchId(mod.getDistrictId()[i], isNo);
					dom.setNum_outlet_branch_id(branchId);
					dom.setNum_state_id(mod.getStateId()[i]);
					dom.setStr_address_1(mod.getAddress1outlet()[i]);
					dom.setStr_address_2(mod.getAddress2outlet()[i]);
					dom.setStr_app_id_old("0");
					dom.setStr_brnhNm(mod.getOutletName()[i]);
					dom.setStr_contpersn_emailid(mod.getEmailContact()[i]);
					dom.setStr_contpersn_name(mod.getNameContact()[i]);
					dom.setStr_contpersn_no(mod.getMobContact()[i]);
					dom.setStr_latitude(mod.getLatitude()[i]);
					dom.setStr_longitude(mod.getLongitude()[i]);
					dom.setStr_pincode(mod.getPinCode()[i]);
					dom.setStr_turnover("" + mod.getTurnover()[i]);
					dom.setStr_document_type(mod.getAddressProofDocType()[i]);
					dom.setOutlet_sequence_id(outlet_sequence_id);
					opensession.merge(dom);
					branchDet.add(dom);
				}

			}
//			tx.commit();
//			tx = opensession.beginTransaction();

			HMJewApplicationTrackingDomain domTracking = ConvertToTrackingTableDomain(mod);
			opensession.merge(domTracking);
			String LicNo = getLicenceNumber(mod.getBranchId());
			HMJewApplicationTrackingDomain domforcml = ConvertToTrackingTableDomain(mod, LicNo);
			opensession.merge(domforcml);
			BypassPaymentHM bpdomain = convert_to_BypassPaymentHM(mod, LicNo);
			opensession.merge(bpdomain);
//			 List<Hall_Branchdtl_Domain> branchDet = getBrachAppList(mod.getHmAppid());
			 List<HallAppSUbJewellerDomain> appdetdom = getAppDataFromAppId(mod.getHmAppid());
			Date date = new Date();
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
			String temp_success_date = sdf.format(date);
			try {
				cal.setTime(sdf.parse(temp_success_date));
			} catch (ParseException e) {
				e.printStackTrace();
			}
			Date today = new Date();
			Date nextYear;
			cal.add(Calendar.YEAR, 5);  //to get previous year add -1
			cal.add(Calendar.DAY_OF_MONTH, -1); /// to substract n number of days
			nextYear = cal.getTime();
			for (int i = 0; i < branchDet.size(); i++) {
				Hall_Branch_Licence_Details_Domain dom1 = new Hall_Branch_Licence_Details_Domain();
				Hall_Branchdtl_Domain bdom = branchDet.get(i);
				System.out.println("bdom[" + i + "]: " + branchDet.get(i));
				dom1.setStr_cml_no(LicNo);
				dom1.setDt_granted_date(today);
				dom1.setDt_operative_date(today);
				dom1.setDt_validity_date(nextYear);
				dom1.setDt_renewal_date(new Date()); 
				dom1.setIs_year(String.valueOf(appdetdom.get(0).getNum_std_yr()));
				dom1.setNum_branch_id(mod.getBranchId());
				dom1.setNum_entry_emp_id(mod.getUserId());
				dom1.setNum_fac_country_id(bdom.getNum_country_id());
				dom1.setNum_fac_district_id(bdom.getNum_district_id());
				dom1.setNum_fac_pin_code(
						Long.parseLong(!bdom.getStr_pincode().equals("") ? bdom.getStr_pincode() : "0"));
				dom1.setNum_fac_state_id(bdom.getNum_state_id());
				dom1.setStr_app_id(mod.getHmAppid());
				dom1.setStr_fac_address1(bdom.getStr_address_1());
				dom1.setStr_fac_address2(bdom.getStr_address_2());
				dom1.setStr_fac_city_name(bdom.getStr_city());
				dom1.setStr_fac_email(bdom.getStr_contpersn_emailid());
				dom1.setStr_fac_fax_no(bdom.getStr_fax());
				dom1.setStr_fac_person_contact_number(bdom.getStr_contpersn_no());
				dom1.setStr_outlet_name(bdom.getStr_brnhNm());
				dom1.setStr_is_no(appdetdom.get(0).getStr_is_number());
				dom1.setStr_mobile(bdom.getStr_contpersn_no());
				dom1.setStr_product_id(appdetdom.get(0).getStr_product_id());
				dom1.setNum_app_user_id(appdetdom.get(0).getNum_gbl_user_id());
				dom1.setNum_outlet_branch_id(bdom.getNum_outlet_branch_id());
				dom1.setCheck_firm_same(bdom.getCheck_firm_same());
				dom1.setStr_latitude(bdom.getStr_latitude());
				dom1.setStr_longitude(bdom.getStr_longitude());
				dom1.setStr_turnover(bdom.getStr_turnover());
				dom1.setNum_city_Id(bdom.getNum_city_Id());
				dom1.setNum_outlet_doc_id(bdom.getNum_hallmarkapp_branch_dtid());
				dom1.setNum_country_id(bdom.getNum_country_id());
				dom1.setStr_contpersn_name(bdom.getStr_contpersn_name());
				dom1.setStr_document_type(bdom.getStr_document_type());
				dom1.setOutlet_sequence_id(bdom.getOutlet_sequence_id());
				System.out.println("bdom[" + i + "]: " + dom1);
				String sql = "select c from NSWSUpload c where c.manak_doc_id=284 and c.num_is_valid=1 and c.nsws_doc_id='"
						+ bdom.getStr_document_type() + "'";
				List<NSWSUpload> list = daohelper.findByQuery(sql);
				if (list.size() > 0) {
					for (int k = 0; k < list.size(); k++) {
						NSWSUpload temp = list.get(k);
						String oulet_doc_parent_id = temp.getOulet_doc_parent_id();
						String sql2 = "select c from HallOutletDocDtl c where num_id="
								+ Integer.parseInt(oulet_doc_parent_id);
						List<HallOutletDocDtl> list2 = daohelper.findByQuery(sql2);
						if (list2.size() > 0) {
							for (int j = 0; j < list2.size(); j++) {
								HallOutletDocDtl temp2 = list2.get(j);
								temp2.setStr_outlet_numid(bdom.getOutlet_sequence_id() + "");
								opensession.merge(temp2);
							}

						}
					}

				}
				opensession.merge(dom1);
			}
			List<HallJewelManagementDetailDomain> listmangaement = getMgmtList(mod.getHmAppid());
			for (int i = 0; i < listmangaement.size(); i++) {
				Hall_jewel_ManagementDetail_Domain_licence dom2 = new Hall_jewel_ManagementDetail_Domain_licence();
				HallJewelManagementDetailDomain domm = listmangaement.get(i);
				dom2.setStr_designation(domm.getStr_designation());
				dom2.setStr_name(domm.getStr_name());
				dom2.setDt_entry_date(domm.getDt_entry_date());
				dom2.setNum_branch_id(mod.getBranchId());
				dom2.setNum_entry_emp_id(domm.getNum_entry_emp_id());
				dom2.setNum_isvalid(domm.getNum_isvalid());
				dom2.setStr_aadhar_base(domm.getStr_aadhar_base());
				dom2.setStr_aadhar_otp_verif(domm.getStr_aadhar_otp_verif());
				dom2.setStr_app_id(mod.getHmAppid());
				dom2.setStr_auth_signatory(domm.getStr_auth_signatory());
				dom2.setStr_cml_no(LicNo);
				opensession.merge(dom2);
			}
			List<HallAppSubJewellerFirmDetails> firmdetlist = getfirmDetail(mod.getHmAppid());
			for (int i = 0; i < firmdetlist.size(); i++) {
				Hall_firmDtlsContactLicenceDomain dom3 = new Hall_firmDtlsContactLicenceDomain();
				HallAppSubJewellerFirmDetails domm = firmdetlist.get(i);
				dom3.setStr_designation(domm.getStr_designation());
				dom3.setStr_firm_name(domm.getStr_firm_name());
				dom3.setDt_entry_date(domm.getDt_entry_date());
				dom3.setNum_branch_id(mod.getBranchId());
				dom3.setNum_entry_emp_id(mod.getUserId());
				dom3.setIs_valid(domm.getIs_valid());
				dom3.setStr_contactperson_name(domm.getStr_contactperson_name());
				dom3.setStr_contactPerson_no(domm.getStr_contactperson_no());
				dom3.setStr_app_id(mod.getHmAppid());
				dom3.setStr_fax(domm.getStr_fax());
				dom3.setStr_cml_no(LicNo);
				dom3.setStr_contactPerson_no(domm.getStr_contactperson_emailid());
				dom3.setStr_designation(domm.getStr_designation());
				opensession.merge(dom3);
			}
			Hall_Licence_Details_Domain licdom = convert_to_Hall_Licence_Details_Domain(mod, LicNo);
			opensession.merge(licdom);
			hall_cmlstatusdetails_Domain statusdetDom = convert_to_hall_cmlstatusdetails_Domain(mod, LicNo);
			opensession.merge(statusdetDom);
			List<NSWSApplicationFormMapping> listdomain = updateCML(mod.getHmAppid(), mod.getBranchId() + "", LicNo);
			for (int i = 0; i < listdomain.size(); i++) {
				NSWSApplicationFormMapping domain = listdomain.get(i);
				domain.setManak_cml_no(LicNo);
				opensession.merge(domain);
			}
			List<Hall_Licence_Details_Domain> templist = getcmldetails(mod.getHmAppid(), mod.getBranchId() + "");
			if (templist.size() == 0) {
				tx.commit();
				flag = "1";
			} else {
				flag = "2";
			}

		} catch (Exception ex) {
			tx.rollback();
			ex.printStackTrace();
			ExceptionLog exceptiondomain = new ExceptionLog();
			exceptiondomain.setException_date(new Date());
			exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
			exceptiondomain.setException_remarks(ex.getLocalizedMessage());
			exceptiondomain.setIs_valid("1");
			exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
			exceptiondomain = (ExceptionLog) opensession.merge(exceptiondomain);
			JSONObject dataJson = new JSONObject();
			try {
				dataJson.put("ex_id", exceptiondomain.getNum_id());
				dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
				flag = dataJson.toString();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		} finally {
			opensession.clear();
			opensession.close();
		}
		return flag;
	}

	private List<NSWSApplicationFormMapping> updateCML(String hmAppid, String branchid, String licNo) {
		String sql = "select c from NSWSApplicationFormMapping c where c.manak_app_id='" + hmAppid
				+ "' and c.manak_branch_id='" + branchid + "' and c.is_valid=1";
		List<NSWSApplicationFormMapping> listdomain = daohelper.findByQuery(sql);
		for (int i = 0; i < listdomain.size(); i++) {
			NSWSApplicationFormMapping domain = listdomain.get(i);
			domain.setManak_cml_no(licNo);
		}
		return listdomain;
	}


	private String getCityName(int cityId) {
		String hql = "select c.str_city_name from CityMaster c where c.num_isvalid=1 and c.num_city_id=" + cityId;
		System.out.println("City Name: " + hql);
		return readonlyDaoHelper.findByQuery(hql).get(0).toString();
	}


	private hall_cmlstatusdetails_Domain convert_to_hall_cmlstatusdetails_Domain(
			NSWSJewellerOutletDetailsRegistrationModel mod, String licNo) {
		hall_cmlstatusdetails_Domain dom = new hall_cmlstatusdetails_Domain();
		dom.setDt_closure_date(new Date());
		dom.setNum_branch_id(mod.getBranchId());
		dom.setNum_cml_status_id(201);
		dom.setStr_cml_no(licNo);
		dom.setStr_entry_emp_id(mod.getUserId());
		return dom;
	}

	private Hall_Licence_Details_Domain convert_to_Hall_Licence_Details_Domain(
			NSWSJewellerOutletDetailsRegistrationModel mod, String licNo) throws ParseException {
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
		String temp_success_date = sdf.format(date);
		cal.setTime(sdf.parse(temp_success_date));
		Date today = new Date();
		Date nextYear;
		cal.add(Calendar.YEAR, 5);  //to get previous year add -1
		cal.add(Calendar.DAY_OF_MONTH, -1);  //to substract n number of days
		nextYear = cal.getTime();
		List<HallAppSubJewellerFirmDetails> firmdetlist = getfirmDetail(mod.getHmAppid());
		HallAppSubJewellerFirmDetails firmdetdom = firmdetlist.get(0);
		List<HallAppSUbJewellerDomain> appdetList = getAppDataFromAppId(mod.getHmAppid());
		HallAppSUbJewellerDomain appdetdom = appdetList.get(0);
		Hall_Licence_Details_Domain dom = new Hall_Licence_Details_Domain();
		dom.setStr_cml_no(licNo);
		dom.setDt_granted_date(today);
		dom.setDt_operative_date(today);
		dom.setDt_validity_date(nextYear);
		dom.setDt_renewal_date(new Date());
		dom.setIs_year(String.valueOf(appdetdom.getNum_std_yr()));
		dom.setNum_branch_id(mod.getBranchId());
		dom.setNum_entry_emp_id(mod.getUserId());
		dom.setNum_firm_country_id(firmdetdom.getNum_country_id());
		dom.setNum_firm_district_id(firmdetdom.getNum_district_id());
		dom.setNum_firm_pin_code(
				Long.parseLong(!firmdetdom.getStr_pin_code().equals("") ? firmdetdom.getStr_pin_code() : "0"));
		dom.setNum_firm_state_id(firmdetdom.getNum_state_id());
		dom.setStr_app_id(mod.getHmAppid());
		dom.setStr_firm_address1(firmdetdom.getStr_address_1());
		dom.setStr_firm_address2(firmdetdom.getStr_address_2());
		dom.setStr_firm_city_name(firmdetdom.getStr_city());
		dom.setStr_firm_email(firmdetdom.getStr_contactperson_emailid());
		dom.setStr_firm_fax_no(firmdetdom.getStr_fax());
		dom.setStr_firm_person_contact_name(firmdetdom.getStr_contactperson_name());
		dom.setStr_firm_name(firmdetdom.getStr_firm_name());
		dom.setStr_is_no(appdetdom.getStr_is_number());
		dom.setStr_mobile(firmdetdom.getStr_contactperson_no());
		dom.setStr_product_id(appdetdom.getStr_product_id());
		dom.setNum_app_user_id(appdetdom.getNum_gbl_user_id());
		dom.setNum_city_Id(firmdetdom.getNum_city_id());
		dom.setNum_outlet_no(appdetdom.getNum_outlet_no());
		dom.setStr_turnover(firmdetdom.getStr_turnover());
		dom.setStr_latitude(firmdetdom.getStr_latitude());
		dom.setStr_longitude(firmdetdom.getStr_longitude());
		dom.setStr_gst_no(firmdetdom.getStr_gst_no());

		return dom;
	}

	private BypassPaymentHM convert_to_BypassPaymentHM(NSWSJewellerOutletDetailsRegistrationModel mod, String licNo) {
		BypassPaymentHM dom = new BypassPaymentHM();
		dom.setAppID(mod.getHmAppid());
		dom.setBranchId("" + mod.getBranchId());
		dom.setNum_std_year(mod.getStdYr());
		dom.setStrUserId(String.valueOf(mod.getUserId()));
		dom.setStr_cml_no(licNo);
		dom.setStr_is_number(mod.getIsNo());
		return dom;
	}

	public String checkDigit(long tempNo) {
		char a[] = String.valueOf(tempNo).toCharArray();
		int sum = 0;
		String finalSum = "";
		int j = 0;
		String a1;
		for (int i = a.length; i > 0; i--) {
			a1 = Character.toString(String.valueOf(tempNo).charAt(j));
			sum += (i) * Integer.parseInt(a1);
			j++;
		}

		if (String.valueOf(sum).length() > 2) {

			finalSum = checkDigit(sum);

		} else if (String.valueOf(sum).length() < 2) {

			String numberAsString = String.valueOf(sum);
			StringBuilder sb = new StringBuilder();
			while (sb.length() + numberAsString.length() < 2) {
				sb.append('0');
			}
			sb.append(sum);
			String newSum = sb.toString();

			finalSum = newSum;

		} else {

			finalSum = String.valueOf(sum);
		}
		return finalSum;
	}

	private String getLicenceNumber(int BranchID) {
		String licenseNo = "";
		String prvLicenseNo = getLast_Cml_No(BranchID);

		if (!prvLicenseNo.equals("null") && !prvLicenseNo.isEmpty()) {

			String NewBranchId = Integer.toString(BranchID);

			String lnserialNo = prvLicenseNo.substring(2, prvLicenseNo.length() - 2);

			long lnoldSerialNo = Long.parseLong(lnserialNo);
			long lnNwSerialNo = lnoldSerialNo + 1;

			String numberAsString = String.valueOf(lnNwSerialNo);
			StringBuilder sb = new StringBuilder();
			while (sb.length() + numberAsString.length() < 6) {
				sb.append('0');
			}
			sb.append(lnNwSerialNo);
			String newSerialNo = sb.toString();
			String tempChkDgt = BranchID + newSerialNo;
			long tempChkDgt1 = Long.parseLong(tempChkDgt);
			String chckdgt = checkDigit(tempChkDgt1);

			licenseNo = NewBranchId + newSerialNo + chckdgt;

		} else {
			String NewLicenseId = "00001";
			String NewBranchId = Integer.toString(BranchID);
			String NewLicenseNo = NewBranchId + "9" + NewLicenseId;
			long tempNo = Long.parseLong(NewLicenseNo);
			String chckdgt = checkDigit(tempNo);
			licenseNo = NewLicenseNo + chckdgt;
		}

		return licenseNo;
	}

	private HMJewApplicationTrackingDomain ConvertToTrackingTableDomain(NSWSJewellerOutletDetailsRegistrationModel mod,
			String licNo) {
		HMJewApplicationTrackingDomain dom = new HMJewApplicationTrackingDomain();
		dom.setNum_app_status(201);
		dom.setNum_branch_id(mod.getBranchId());
		dom.setNum_entry_emp_id(mod.getUserId());
		dom.setNum_entry_role_id(3);
		dom.setNum_flag_task_complte(1);
		dom.setNum_visible_applicant(1);
		dom.setStr_application_id(mod.getHmAppid());
		dom.setStr_cml_no(licNo);
		dom.setStr_flag_renew("");
		dom.setStr_remarks("");
		return dom;
	}

	private HMJewApplicationTrackingDomain ConvertToTrackingTableDomain(
			NSWSJewellerOutletDetailsRegistrationModel mod) {
		HMJewApplicationTrackingDomain dom = new HMJewApplicationTrackingDomain();
		dom.setNum_app_status(27);
		dom.setNum_branch_id(mod.getBranchId());
		dom.setNum_entry_emp_id(mod.getUserId());
		dom.setNum_entry_role_id(3);
		dom.setNum_flag_task_complte(1);
		dom.setNum_visible_applicant(1);
		dom.setStr_application_id(mod.getHmAppid());
		dom.setStr_cml_no("");
		dom.setStr_flag_renew("");
		dom.setStr_remarks("");
		return dom;

	}


	public List<Hall_Licence_Details_Domain> getcmldetails(String appid, String branch_id) {
		String sql = " select c from Hall_Licence_Details_Domain c where c.str_app_id='" + appid
				+ "' and c.num_branch_id=" + Integer.parseInt(branch_id);
		System.out.println("getcmldetails: " + sql);
		List<Hall_Licence_Details_Domain> list = daohelper.findByQuery(sql);
		return list;
	}

	public String downloadcmlentry(String checksum, NSWSJewellerOutletDetailsRegistrationModel model) {
		Transaction tx = null;
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		String flag = "";
		try {
			tx = opensession.beginTransaction();
			NSWSDownload domain=new NSWSDownload();
			domain.setFile_checksum(checksum);
			domain.setFile_extension("pdf");
			domain.setManak_app_id(model.getHmAppid());
			domain.setManak_branch_id(model.getBranchId()+"");
			domain.setManak_cml_no(model.getCmlno());
			domain.setNsws_unique_app_id(model.getNsws_unique_application_id());
			domain.setNsws_unique_user_name(model.getNsws_unique_username());
			opensession.merge(domain);
			tx.commit();
			flag="1";
		}catch(Exception ex) {
			tx.rollback();
			ExceptionLog exceptiondomain = new ExceptionLog();
			exceptiondomain.setException_date(new Date());
			exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
			exceptiondomain.setException_remarks(ex.getLocalizedMessage());
			exceptiondomain.setIs_valid("1");
			exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
			exceptiondomain = (ExceptionLog) opensession.merge(exceptiondomain);
			JSONObject dataJson = new JSONObject();
			try {
				dataJson.put("ex_id", exceptiondomain.getNum_id());
				dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
				flag = dataJson.toString();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}finally {
			opensession.clear();
			opensession.close();
		}
		return flag;
	}

	public String updatebranchcml(String appid, String branch_id) {
		Transaction tx = null;
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		String flag = "";
		try {
			tx = opensession.beginTransaction();
		String sql1="select c from Hall_Branchdtl_Domain c  where c. num_hallmarkapp_id='"+appid+"' and c.outlet_sequence_id!='0' and c.num_branch_id="+Integer.parseInt(branch_id);
		String sql2="select c from Hall_Branch_Licence_Details_Domain c  where c. str_app_id='"+appid+"' and c.outlet_sequence_id!='0' and c.num_branch_id="+Integer.parseInt(branch_id);
		List<Hall_Branchdtl_Domain> list1 = readonlyDaoHelper.findByQuery(sql1);
		List<Hall_Branch_Licence_Details_Domain> list2 = readonlyDaoHelper.findByQuery(sql2);
		if(list1.size()==list2.size()) {
			if(list1.size()>0 && list2.size()>0) {
				for(int i=0;i<list1.size();i++) {
					Hall_Branchdtl_Domain temp1 = list1.get(i);
					Hall_Branch_Licence_Details_Domain temp2 = list2.get(i);
					if(temp1.getOutlet_sequence_id().equals(temp2.getOutlet_sequence_id())) {
						temp2.setNum_outlet_doc_id(temp1.getNum_hallmarkapp_branch_dtid());
						opensession.merge(temp2);
					}
				}
			}
		}
		String sql3 = "select c from NSWSUpload c where c.manak_doc_id=284 and c.num_is_valid=1 and c.manak_app_id='"+appid+"' and c.manak_branch_id='"+branch_id+"'";
		List<NSWSUpload> list = daohelper.findByQuery(sql3);
		if (list.size() > 0) {
			for (int k = 0; k < list.size(); k++) {
				NSWSUpload temp = list.get(k);
				String oulet_doc_parent_id = temp.getOulet_doc_parent_id();
				String sql4 = "select c from HallOutletDocDtl c where num_id="
						+ Integer.parseInt(oulet_doc_parent_id);
				List<HallOutletDocDtl> list3 = daohelper.findByQuery(sql4);
				if (list3.size() > 0) {
					for (int j = 0; j < list3.size(); j++) {
						HallOutletDocDtl temp2 = list3.get(j);
						for(int l=0;l<list1.size();l++) {
							if(list1.get(l).getOutlet_sequence_id().toString().equals(temp2.getStr_outlet_numid()))
							{
								temp2.setStr_outlet_numid(list1.get(l).getNum_hallmarkapp_branch_dtid() + "");
							}	
						}
						
						opensession.merge(temp2);
					}

				}
			}

		}
		tx.commit();
		flag="1";
		}catch(Exception ex) {
			tx.rollback();
			ExceptionLog exceptiondomain = new ExceptionLog();
			exceptiondomain.setException_date(new Date());
			exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
			exceptiondomain.setException_remarks(ex.getLocalizedMessage());
			exceptiondomain.setIs_valid("1");
			exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
			exceptiondomain = (ExceptionLog) opensession.merge(exceptiondomain);
			JSONObject dataJson = new JSONObject();
			try {
				dataJson.put("ex_id", exceptiondomain.getNum_id());
				dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
				flag = dataJson.toString();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}finally {
			opensession.clear();
			opensession.close();
		}
		return flag;
	}

	public String checkuploadentry(String[] addressproof, String appid, String branch_id) {
		int count=0;
		int count2=0;
		String flag="1";
		ArrayList<String> arraylist=new ArrayList<String>();  
		for(int i=0;i<addressproof.length;i++) {
			if(!addressproof[i].toString().equals("")) {
				
				String sql = "select c from NSWSUpload c where c.nsws_doc_id='"+addressproof[i].toString()+"' and c.num_is_valid=1 and c.manak_app_id='"+appid+"' and c.manak_branch_id='"+branch_id+"'";
				//count2 = count2+readonlyDaoHelper.findByQuery(sql).size();
				if(readonlyDaoHelper.findByQuery(sql).size()==0)
				{
					count=count+1;
					count2=count2+1;
					arraylist.add("Document_Name: "+addressproof[i].toString()+" Not uploaded");
				}
			}	
		}
		
		if(count2!=count) {
			flag=arraylist.toString().replace("[", "").replace("]", "");
		}
		
		return flag;
	}
}
