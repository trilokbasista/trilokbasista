package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="hall_appsub_jeweller", schema="bis_hall")
public class HallAppSUbJewellerDomain {

	@Id
	@Column(name="num_hallmarkapp_auto_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_appsub_jeweller")
	@TableGenerator(
			initialValue=1,
			name = "hall_appsub_jeweller",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="hall_appsub_jeweller",
	        allocationSize = 1        
	)
	long num_hallmarkapp_auto_id;
	

	@Column(name="str_application_id")
	String str_application_id;
	
	@Column(name="str_is_number")
	String str_is_number;
	
	@Column(name="num_outlet_no")		 
	int num_outlet_no;
	
	@Column(name="str_outlet_type") 
	String str_outlet_type;
	
	@Column(name="str_existornew_id")
	String str_existornew_id;
	
	@Column(name="str_party_code")
	String str_party_code;
			
	@Column(name="str_ownershipyypename") 
	String str_ownershipyypename;
	
	@Column(name="str_turnover")
	String str_turnover;
	
	@Column(name="str_gst_no")
	String str_gst_no;
	
	/*@Column(name="str_PrvLicense_No")
	String strPrvLicenseNo;
	 
	@Column(name="str_ReasonForCancel")
	String strReasonForCancel;
	 
	@Column(name="str_DtlsConviction")
	String str_DtlsConviction;*/
	
	@Column(name="num_location_id",length=3)
	int num_branch_id;
	 
	@Column(name="str_latlong")
	String str_latlong; 
	
	@Column(name="num_gbl_user_id", length=10)
	long num_gbl_user_id;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date = new Date();
	
	@Column(name="is_valid")
	int is_valid;
	 
	@Column(name="num_application_status_id",length=2)
	int num_application_status_id=26;

	@Column(name="num_scale_id")
	int num_scale_id;
	
	@Column(name="num_sector_id")
	int num_sector_id;
	
	@Column(name="str_product_id")
	String str_product_id;
	
	@Column(name="num_std_year")
	int num_std_yr;
	
	@Column(name="str_applicensetype")
	String str_applicensetype;
	
	@Column(name="str_prelicencedetail")
	String str_prelicencedetail;
	
	@Column(name="str_pre_cancellicensedetail")
	String str_pre_cancellicensedetail;
	
	@Column(name="strappliedyear")
	String strappliedyear;
	
	@Column(name="strpayfeeyear")
	String strpayfeeyear="5";
	
	@Column(name="receipt_no")
	String receipt_no="";
	
	@Column(name="str_corp_level")
	String str_corp_level;
	
	@Column(name="str_ca_certificate" ,nullable=false, columnDefinition = "String default 'No'")
	String str_ca_certificate;
	
	@Column(name="str_application_id_ref")
	String str_application_id_ref;
	
	@Column(name="str_ownershiptypename") 
	String str_ownershiptypename="";
	
	public long getNum_hallmarkapp_auto_id() {
		return num_hallmarkapp_auto_id;
	}

	public void setNum_hallmarkapp_auto_id(long num_hallmarkapp_auto_id) {
		this.num_hallmarkapp_auto_id = num_hallmarkapp_auto_id;
	}

	public String getStr_application_id() {
		return str_application_id;
	}

	public void setStr_application_id(String str_application_id) {
		this.str_application_id = str_application_id;
	}

	public String getStr_is_number() {
		return str_is_number;
	}

	public void setStr_is_number(String str_is_number) {
		this.str_is_number = str_is_number;
	}

	public int getNum_outlet_no() {
		return num_outlet_no;
	}

	public void setNum_outlet_no(int num_outlet_no) {
		this.num_outlet_no = num_outlet_no;
	}

	public String getStr_outlet_type() {
		return str_outlet_type;
	}

	public void setStr_outlet_type(String str_outlet_type) {
		this.str_outlet_type = str_outlet_type;
	}

	public String getStr_existornew_id() {
		return str_existornew_id;
	}

	public void setStr_existornew_id(String str_existornew_id) {
		this.str_existornew_id = str_existornew_id;
	}

	public String getStr_party_code() {
		return str_party_code;
	}

	public void setStr_party_code(String str_party_code) {
		this.str_party_code = str_party_code;
	}

	public String getStr_ownershipyypename() {
		return str_ownershipyypename;
	}

	public void setStr_ownershipyypename(String str_ownershipyypename) {
		this.str_ownershipyypename = str_ownershipyypename;
	}

	public String getStr_turnover() {
		return str_turnover;
	}

	public void setStr_turnover(String str_turnover) {
		this.str_turnover = str_turnover;
	}

	public String getStr_gst_no() {
		return str_gst_no;
	}

	public void setStr_gst_no(String str_gst_no) {
		this.str_gst_no = str_gst_no;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public String getStr_latlong() {
		return str_latlong;
	}

	public void setStr_latlong(String str_latlong) {
		this.str_latlong = str_latlong;
	}

	public long getNum_gbl_user_id() {
		return num_gbl_user_id;
	}

	public void setNum_gbl_user_id(long num_gbl_user_id) {
		this.num_gbl_user_id = num_gbl_user_id;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public int getIs_valid() {
		return is_valid;
	}

	public void setIs_valid(int is_valid) {
		this.is_valid = is_valid;
	}

	public int getNum_application_status_id() {
		return num_application_status_id;
	}

	public void setNum_application_status_id(int num_application_status_id) {
		this.num_application_status_id = num_application_status_id;
	}

	public int getNum_scale_id() {
		return num_scale_id;
	}

	public void setNum_scale_id(int num_scale_id) {
		this.num_scale_id = num_scale_id;
	}

	public int getNum_sector_id() {
		return num_sector_id;
	}

	public void setNum_sector_id(int num_sector_id) {
		this.num_sector_id = num_sector_id;
	}

	public String getStr_product_id() {
		return str_product_id;
	}

	public void setStr_product_id(String str_product_id) {
		this.str_product_id = str_product_id;
	}

	public int getNum_std_yr() {
		return num_std_yr;
	}

	public void setNum_std_yr(int num_std_yr) {
		this.num_std_yr = num_std_yr;
	}

	public String getStr_applicensetype() {
		return str_applicensetype;
	}

	public void setStr_applicensetype(String str_applicensetype) {
		this.str_applicensetype = str_applicensetype;
	}

	public String getStr_prelicencedetail() {
		return str_prelicencedetail;
	}

	public void setStr_prelicencedetail(String str_prelicencedetail) {
		this.str_prelicencedetail = str_prelicencedetail;
	}

	public String getStr_pre_cancellicensedetail() {
		return str_pre_cancellicensedetail;
	}

	public void setStr_pre_cancellicensedetail(String str_pre_cancellicensedetail) {
		this.str_pre_cancellicensedetail = str_pre_cancellicensedetail;
	}

	public String getStrappliedyear() {
		return strappliedyear;
	}

	public void setStrappliedyear(String strappliedyear) {
		this.strappliedyear = strappliedyear;
	}

	public String getStrpayfeeyear() {
		return strpayfeeyear;
	}

	public void setStrpayfeeyear(String strpayfeeyear) {
		this.strpayfeeyear = strpayfeeyear;
	}

	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}

	public String getStr_corp_level() {
		return str_corp_level;
	}

	public void setStr_corp_level(String str_corp_level) {
		this.str_corp_level = str_corp_level;
	}

	public String getStr_ca_certificate() {
		return str_ca_certificate;
	}

	public void setStr_ca_certificate(String str_ca_certificate) {
		this.str_ca_certificate = str_ca_certificate;
	}

	public String getStr_application_id_ref() {
		return str_application_id_ref;
	}

	public void setStr_application_id_ref(String str_application_id_ref) {
		this.str_application_id_ref = str_application_id_ref;
	}


	public String getStr_ownershiptypename() {
		return str_ownershiptypename;
	}

	public void setStr_ownershiptypename(String str_ownershiptypename) {
		this.str_ownershiptypename = str_ownershiptypename;
	}

	@Override
	public String toString() {
		return "HallAppSUbJewellerDomain [num_hallmarkapp_auto_id=" + num_hallmarkapp_auto_id + ", str_application_id="
				+ str_application_id + ", str_is_number=" + str_is_number + ", num_outlet_no=" + num_outlet_no
				+ ", str_outlet_type=" + str_outlet_type + ", str_existornew_id=" + str_existornew_id
				+ ", str_party_code=" + str_party_code + ", str_ownershipyypename=" + str_ownershipyypename
				+ ", str_turnover=" + str_turnover + ", str_gst_no=" + str_gst_no + ", num_branch_id=" + num_branch_id
				+ ", str_latlong=" + str_latlong + ", num_gbl_user_id=" + num_gbl_user_id + ", dt_entry_date="
				+ dt_entry_date + ", is_valid=" + is_valid + ", num_application_status_id=" + num_application_status_id
				+ ", num_scale_id=" + num_scale_id + ", num_sector_id=" + num_sector_id + ", str_product_id="
				+ str_product_id + ", num_std_yr=" + num_std_yr + ", str_applicensetype=" + str_applicensetype
				+ ", str_prelicencedetail=" + str_prelicencedetail + ", str_pre_cancellicensedetail="
				+ str_pre_cancellicensedetail + ", strappliedyear=" + strappliedyear + ", strpayfeeyear="
				+ strpayfeeyear + ", receipt_no=" + receipt_no + ", str_corp_level=" + str_corp_level
				+ ", str_ca_certificate=" + str_ca_certificate + ", str_application_id_ref=" + str_application_id_ref
				+ ", str_ownershiptypename=" + str_ownershiptypename + "]";
	}

}
