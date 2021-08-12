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
@Table(name="hall_appsub_jeweller_firm_details", schema="bis_hall")
public class HallAppSubJewellerFirmDetails {

	
	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_appsub_jeweller_firm_details")
	@TableGenerator(
		initialValue=1,
		name = "hall_appsub_jeweller_firm_details",
        table = "hibernate_sequences",
        pkColumnName = "sequence_name",
        pkColumnValue="hall_appsub_jeweller_firm_details",
        allocationSize = 1        
			)
		Long num_id;
	
	@Column(name="num_hallmarkapp_id",length=12)
	String num_hallmarkapp_id;
	
	@Column(name="num_branch_id",length=3)
	int num_branch_id;
	
	@Column(name="str_firm_name")
	String str_firm_name;
	
	@Column(name="str_firm_intial",length=2)
	String str_firm_intial;
	
	@Column(name="str_address_1",length=100) 
	String str_address_1;
	 
	@Column(name="str_address_2",length=100) 
	String str_address_2;
	
	@Column(name="num_country_id",length= 3) 
	int num_country_id;
	
	@Column(name="num_state_id",length= 3)
	int num_state_id;
	
	@Column(name="num_district_id",length= 3)
	int num_district_id;
	
	@Column(name="num_city_id",length= 100)
	int num_city_id;
	 
	@Column(name="str_city",length= 50)
	String str_city;
	 
	@Column(name="str_pin_code",length=6)
	String str_pin_code;
	
	@Column(name="str_contactperson_name",length=30)
	String str_contactperson_name;
	
	@Column(name="str_contactperson_no")
	String str_contactperson_no;
	
	@Column(name="str_fax")
	String  str_fax;
	
	@Column(name="str_contactperson_emailid",length=50)
	String str_contactperson_emailid;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date=new Date();
	
	@Column(name="is_valid")
	int is_valid=1;
	
	@Column(name="num_entry_emp_id", length=10)
	long num_entry_emp_id;
	
	@Column(name="str_party_code",length=10)
	String str_party_code;
	
	@Column(name="str_latitude",length=50)
	String str_latitude;
	
	@Column(name="str_longitude",length=50)
	String str_longitude;
	
	@Column(name="str_turnover",length=200)
	String str_turnover;
	
	@Column(name="str_designation",length=100)
	String str_designation;
	
	@Column(name="str_gst_no",length=100)
	String str_gst_no;
	
	@Column(name="str_application_id_ref")
	String str_application_id_ref;

	public Long getNum_id() {
		return num_id;
	}

	public void setNum_id(Long num_id) {
		this.num_id = num_id;
	}

	public String getNum_hallmarkapp_id() {
		return num_hallmarkapp_id;
	}

	public void setNum_hallmarkapp_id(String num_hallmarkapp_id) {
		this.num_hallmarkapp_id = num_hallmarkapp_id;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public String getStr_firm_name() {
		return str_firm_name;
	}

	public void setStr_firm_name(String str_firm_name) {
		this.str_firm_name = str_firm_name;
	}

	public String getStr_firm_intial() {
		return str_firm_intial;
	}

	public void setStr_firm_intial(String str_firm_intial) {
		this.str_firm_intial = str_firm_intial;
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

	public int getNum_country_id() {
		return num_country_id;
	}

	public void setNum_country_id(int num_country_id) {
		this.num_country_id = num_country_id;
	}

	public int getNum_state_id() {
		return num_state_id;
	}

	public void setNum_state_id(int num_state_id) {
		this.num_state_id = num_state_id;
	}

	public int getNum_district_id() {
		return num_district_id;
	}

	public void setNum_district_id(int num_district_id) {
		this.num_district_id = num_district_id;
	}

	public int getNum_city_id() {
		return num_city_id;
	}

	public void setNum_city_id(int num_city_id) {
		this.num_city_id = num_city_id;
	}

	public String getStr_city() {
		return str_city;
	}

	public void setStr_city(String str_city) {
		this.str_city = str_city;
	}

	public String getStr_pin_code() {
		return str_pin_code;
	}

	public void setStr_pin_code(String str_pin_code) {
		this.str_pin_code = str_pin_code;
	}

	public String getStr_contactperson_name() {
		return str_contactperson_name;
	}

	public void setStr_contactperson_name(String str_contactperson_name) {
		this.str_contactperson_name = str_contactperson_name;
	}

	public String getStr_contactperson_no() {
		return str_contactperson_no;
	}

	public void setStr_contactperson_no(String str_contactperson_no) {
		this.str_contactperson_no = str_contactperson_no;
	}

	public String getStr_fax() {
		return str_fax;
	}

	public void setStr_fax(String str_fax) {
		this.str_fax = str_fax;
	}

	public String getStr_contactperson_emailid() {
		return str_contactperson_emailid;
	}

	public void setStr_contactperson_emailid(String str_contactperson_emailid) {
		this.str_contactperson_emailid = str_contactperson_emailid;
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

	public long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	public String getStr_party_code() {
		return str_party_code;
	}

	public void setStr_party_code(String str_party_code) {
		this.str_party_code = str_party_code;
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

	public String getStr_designation() {
		return str_designation;
	}

	public void setStr_designation(String str_designation) {
		this.str_designation = str_designation;
	}

	public String getStr_gst_no() {
		return str_gst_no;
	}

	public void setStr_gst_no(String str_gst_no) {
		this.str_gst_no = str_gst_no;
	}

	public String getStr_application_id_ref() {
		return str_application_id_ref;
	}

	public void setStr_application_id_ref(String str_application_id_ref) {
		this.str_application_id_ref = str_application_id_ref;
	}

	@Override
	public String toString() {
		return "HallAppSubJewellerFirmDetails [num_id=" + num_id + ", num_hallmarkapp_id=" + num_hallmarkapp_id
				+ ", num_branch_id=" + num_branch_id + ", str_firm_name=" + str_firm_name + ", str_firm_intial="
				+ str_firm_intial + ", str_address_1=" + str_address_1 + ", str_address_2=" + str_address_2
				+ ", num_country_id=" + num_country_id + ", num_state_id=" + num_state_id + ", num_district_id="
				+ num_district_id + ", num_city_id=" + num_city_id + ", str_city=" + str_city + ", str_pin_code="
				+ str_pin_code + ", str_contactperson_name=" + str_contactperson_name + ", str_contactperson_no="
				+ str_contactperson_no + ", str_fax=" + str_fax + ", str_contactperson_emailid="
				+ str_contactperson_emailid + ", dt_entry_date=" + dt_entry_date + ", is_valid=" + is_valid
				+ ", num_entry_emp_id=" + num_entry_emp_id + ", str_party_code=" + str_party_code + ", str_latitude="
				+ str_latitude + ", str_longitude=" + str_longitude + ", str_turnover=" + str_turnover
				+ ", str_designation=" + str_designation + ", str_gst_no=" + str_gst_no + ", str_application_id_ref="
				+ str_application_id_ref + "]";
	}	
}
