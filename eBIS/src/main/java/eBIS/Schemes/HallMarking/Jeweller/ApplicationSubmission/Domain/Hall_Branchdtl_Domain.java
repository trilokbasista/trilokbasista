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
@Table(name="hall_appsub_jeweller_branch_details", schema="bis_hall")
public class Hall_Branchdtl_Domain {

	@Id
	@Column(name="num_HallMarkApp_Branch_dtId")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_appsub_jeweller_branch_details")
	@TableGenerator(
			initialValue=6,
			name = "hall_appsub_jeweller_branch_details",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="hall_appsub_jeweller_branch_details",
	        allocationSize = 1        
				)
			int num_hallmarkapp_branch_dtid;
	
	@Column(name = "num_hallmarkapp_id")
	String num_hallmarkapp_id;

	@Column(name = "str_brnhNm")
	String str_brnhNm;

	@Column(name = "num_country_id")
	int num_country_id;

	@Column(name = "str_address_1")
	String str_address_1;

	@Column(name = "str_address_2")
	String str_address_2;

	@Column(name = "num_district_id")
	int num_district_id;

	@Column(name = "num_State_Id")
	int num_state_id;

	@Column(name = "str_City")
	String str_city="";

	@Column(name = "num_city_Id",nullable=false,columnDefinition="int default 0")
	int num_city_Id;

	@Column(name = "str_PinCode")
	String str_pincode;

	@Column(name = "str_ContPersn_Name")
	String str_contpersn_name;

	@Column(name = "Str_ContPersn_No")
	String str_contpersn_no;

	@Column(name = "str_Fax")
	String str_fax="";

	@Column(name = "str_ContPersn_EmailId")
	String str_contpersn_emailid;

	@Column(name = "Num_Entry_Emp_ID", length = 10)
	long num_entry_emp_id;

	@Column(name = "dt_entry_date")
	Date dt_entry_date = new Date();

	@Column(name = "IS_VALID")
	int is_valid = 1;

	@Column(name = "num_branch_id")
	int num_branch_id;

	@Column(name = "num_Outlet_branch_id")
	int num_outlet_branch_id;

	@Column(name = "str_Doc")
	String str_doc="";

	@Column(name = "str_num_doc")
	String str_num_doc="";

	@Column(name = "str_renewal_flag")
	String str_renewal_flag="";

	@Column(name = "str_del_flag")
	String str_del_flag = "0";

	@Column(name = "strPopulation")
	String strpopulation="";

	@Column(name = "str_document_type")
	String str_document_type;

	@Column(name = "num_id_old")
	String num_id_old = "0";

	@Column(name = "str_app_id_old")
	String str_app_id_old = "0";

	@Column(name = "check_firm_same")
	String check_firm_same="";

	@Column(name = "str_latitude", length = 200)
	String str_latitude;

	@Column(name = "str_longitude", length = 200)
	String str_longitude;

	@Column(name = "str_turnover", length = 200)
	String str_turnover;

	@Column(name = "str_application_id_ref")
	String str_application_id_ref="";
	
	@Column(nullable=false,columnDefinition="character varying default '0' " )
	String outlet_sequence_id="0";
	
	public int getNum_hallmarkapp_branch_dtid() {
		return num_hallmarkapp_branch_dtid;
	}

	public void setNum_hallmarkapp_branch_dtid(int num_hallmarkapp_branch_dtid) {
		this.num_hallmarkapp_branch_dtid = num_hallmarkapp_branch_dtid;
	}

	public String getNum_hallmarkapp_id() {
		return num_hallmarkapp_id;
	}

	public void setNum_hallmarkmpp_id(String num_hallmarkapp_id) {
		this.num_hallmarkapp_id = num_hallmarkapp_id;
	}

	public String getStr_brnhNm() {
		return str_brnhNm;
	}

	public void setStr_brnhNm(String str_brnhNm) {
		this.str_brnhNm = str_brnhNm;
	}

	public int getNum_country_id() {
		return num_country_id;
	}

	public void setNum_country_id(int num_country_id) {
		this.num_country_id = num_country_id;
	}

	public String getStr_address_1() {
		return str_address_1;
	}

	public void setStr_address_1(String str_address_1) {
		this.str_address_1 = str_address_1;
	}

	public String getStr_address_2() {
		return str_address_2;
	}

	public void setStr_address_2(String str_address_2) {
		this.str_address_2 = str_address_2;
	}

	public int getNum_district_id() {
		return num_district_id;
	}

	public void setNum_district_id(int num_district_id) {
		this.num_district_id = num_district_id;
	}

	public int getNum_state_id() {
		return num_state_id;
	}

	public void setNum_state_id(int num_state_id) {
		this.num_state_id = num_state_id;
	}

	public String getStr_city() {
		return str_city;
	}

	public void setStr_city(String str_city) {
		this.str_city = str_city;
	}

	public int getNum_city_Id() {
		return num_city_Id;
	}

	public void setNum_city_Id(int num_city_Id) {
		this.num_city_Id = num_city_Id;
	}

	public String getStr_pincode() {
		return str_pincode;
	}

	public void setStr_pincode(String str_pincode) {
		this.str_pincode = str_pincode;
	}

	public String getStr_contpersn_name() {
		return str_contpersn_name;
	}

	public void setStr_contpersn_name(String str_contpersn_name) {
		this.str_contpersn_name = str_contpersn_name;
	}

	public String getStr_contpersn_no() {
		return str_contpersn_no;
	}

	public void setStr_contpersn_no(String str_contpersn_no) {
		this.str_contpersn_no = str_contpersn_no;
	}

	public String getStr_fax() {
		return str_fax;
	}

	public void setStr_fax(String str_fax) {
		this.str_fax = str_fax;
	}

	public String getStr_contpersn_emailid() {
		return str_contpersn_emailid;
	}

	public void setStr_contpersn_emailid(String str_contpersn_emailid) {
		this.str_contpersn_emailid = str_contpersn_emailid;
	}

	public long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
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

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public int getNum_outlet_branch_id() {
		return num_outlet_branch_id;
	}

	public void setNum_outlet_branch_id(int num_outlet_branch_id) {
		this.num_outlet_branch_id = num_outlet_branch_id;
	}

	public String getStr_doc() {
		return str_doc;
	}

	public void setStr_doc(String str_doc) {
		this.str_doc = str_doc;
	}

	public String getStr_num_doc() {
		return str_num_doc;
	}

	public void setStr_num_doc(String str_num_doc) {
		this.str_num_doc = str_num_doc;
	}

	public String getStr_renewal_flag() {
		return str_renewal_flag;
	}

	public void setStr_renewal_flag(String str_renewal_flag) {
		this.str_renewal_flag = str_renewal_flag;
	}

	public String getStr_del_flag() {
		return str_del_flag;
	}

	public void setStr_del_flag(String str_del_flag) {
		this.str_del_flag = str_del_flag;
	}

	public String getStrpopulation() {
		return strpopulation;
	}

	public void setStrpopulation(String strpopulation) {
		this.strpopulation = strpopulation;
	}

	public String getStr_document_type() {
		return str_document_type;
	}

	public void setStr_document_type(String str_document_type) {
		this.str_document_type = str_document_type;
	}

	public String getNum_id_old() {
		return num_id_old;
	}

	public void setNum_id_old(String num_id_old) {
		this.num_id_old = num_id_old;
	}

	public String getStr_app_id_old() {
		return str_app_id_old;
	}

	public void setStr_app_id_old(String str_app_id_old) {
		this.str_app_id_old = str_app_id_old;
	}

	public String getCheck_firm_same() {
		return check_firm_same;
	}

	public void setCheck_firm_same(String check_firm_same) {
		this.check_firm_same = check_firm_same;
	}

	public String getStr_latitude() {
		return str_latitude;
	}

	public void setStr_latitude(String str_latitude) {
		this.str_latitude = str_latitude;
	}

	public String getStr_longitude() {
		return str_longitude;
	}

	public void setStr_longitude(String str_longitude) {
		this.str_longitude = str_longitude;
	}

	public String getStr_turnover() {
		return str_turnover;
	}

	public void setStr_turnover(String str_turnover) {
		this.str_turnover = str_turnover;
	}

	public String getStr_application_id_ref() {
		return str_application_id_ref;
	}

	public void setStr_application_id_ref(String str_application_id_ref) {
		this.str_application_id_ref = str_application_id_ref;
	}

	public String getOutlet_sequence_id() {
		return outlet_sequence_id;
	}

	public void setOutlet_sequence_id(String outlet_sequence_id) {
		this.outlet_sequence_id = outlet_sequence_id;
	}

	public void setNum_hallmarkapp_id(String num_hallmarkapp_id) {
		this.num_hallmarkapp_id = num_hallmarkapp_id;
	}

	@Override
	public String toString() {
		return "Hall_Branchdtl_Domain [num_hallmarkapp_branch_dtid=" + num_hallmarkapp_branch_dtid
				+ ", num_hallmarkapp_id=" + num_hallmarkapp_id + ", str_brnhNm=" + str_brnhNm + ", num_country_id="
				+ num_country_id + ", str_address_1=" + str_address_1 + ", str_address_2=" + str_address_2
				+ ", num_district_id=" + num_district_id + ", num_state_id=" + num_state_id + ", str_city=" + str_city
				+ ", num_city_Id=" + num_city_Id + ", str_pincode=" + str_pincode + ", str_contpersn_name="
				+ str_contpersn_name + ", str_contpersn_no=" + str_contpersn_no + ", str_fax=" + str_fax
				+ ", str_contpersn_emailid=" + str_contpersn_emailid + ", num_entry_emp_id=" + num_entry_emp_id
				+ ", dt_entry_date=" + dt_entry_date + ", is_valid=" + is_valid + ", num_branch_id=" + num_branch_id
				+ ", num_outlet_branch_id=" + num_outlet_branch_id + ", str_doc=" + str_doc + ", str_num_doc="
				+ str_num_doc + ", str_renewal_flag=" + str_renewal_flag + ", str_del_flag=" + str_del_flag
				+ ", strpopulation=" + strpopulation + ", str_document_type=" + str_document_type + ", num_id_old="
				+ num_id_old + ", str_app_id_old=" + str_app_id_old + ", check_firm_same=" + check_firm_same
				+ ", str_latitude=" + str_latitude + ", str_longitude=" + str_longitude + ", str_turnover="
				+ str_turnover + ", str_application_id_ref=" + str_application_id_ref + ", outlet_sequence_id="
				+ outlet_sequence_id + "]";
	}
	
}
