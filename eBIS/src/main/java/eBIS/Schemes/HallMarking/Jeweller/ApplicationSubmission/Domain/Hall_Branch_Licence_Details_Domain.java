package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="hall_cml_branch_licence_detail", schema="bis_hall")
public class Hall_Branch_Licence_Details_Domain {

	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_cml_branch_licence_detail")
	@TableGenerator(
			initialValue=1,
			name = "hall_cml_branch_licence_detail",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="hall_cml_branch_licence_detail",
	        allocationSize = 1        
				)
			int num_id;
	
	@Column(name="str_cml_no")
	private String str_cml_no;
	
	
	@Column(name="str_app_id")
	private String str_app_id;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_granted_date")
	private Date dt_granted_date;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_renewal_date")
	private Date dt_renewal_date;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_operative_date")
	private Date dt_operative_date;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_validity_date")
	private Date dt_validity_date;
	

	@Temporal(TemporalType.DATE)
	@Column(name="dt_last_renewal_date")
	private Date dt_last_renewal_date;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_licence_renewal_due_date")
	private Date dt_licence_renewal_due_date;
	
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_last_licence_renewal_due_date")
	private Date dt_last_licence_renewal_due_date;
	
	
	@Column(name="str_product_id")
	private String str_product_id;
	
	
	@Column(name="str_is_no")
	private String str_is_no;
	
	
	@Column(name="num_branch_id",length=3)
	private int num_branch_id;
	
	
	@Column(name="str_outlet_name" , length=150)
	private String str_outlet_name;
	
	
	@Column(name="num_fac_country_id",length=3)
	private int num_fac_country_id;
	
	
	@Column(name="num_fac_state_id",length=3)
	private int num_fac_state_id;
	
	
	@Column(name="num_fac_district_id",length=3)
	private int num_fac_district_id;
	
	
	@Column(name="num_fac_pin_code",length=6)
	private Long num_fac_pin_code;
	
	
	@Column(name="str_fac_address1",length=250)
	private String str_fac_address1;
	
	
	@Column(name="str_fac_address2",length=100)
	private String str_fac_address2;
	
	
	@Column(name="str_fac_city_name",length=50)
	private String str_fac_city_name="";
	
	
	@Column(name="str_fac_email",length=100)
	private String str_fac_email;

	
	@Column(name="str_fac_fax_no",length=50)
	private String str_fac_fax_no="";

	
	@Column(name="str_fac_person_contact_number",length=100)
	private String str_fac_person_contact_number;
	
	
	@Column(name="str_mobile",length=100)
	private String str_mobile;
	
	
	@Column(name="dt_entry_date",nullable = true)
	private  Date dt_entry_date = new Date(); 
	
    @Column(name="num_entry_emp_id", length=10)
	private long num_entry_emp_id;
    
    @Column(name="num_app_user_id", length=10)
	private long num_app_user_id;
	   
	     
	@Column(name="is_year",length=10)
	private String is_year;
	
	
	@Column(name="num_outlet_branch_id",length=3)
	private int num_outlet_branch_id;

	@Column(name="num_isvalid")
	private int num_isvalid=1;
	
	@Column(name="check_firm_same")
	String check_firm_same="";

	@Column(name="str_latitude",length=200)
	String str_latitude;
	
	@Column(name="str_longitude",length=200)
	String str_longitude;
	
	@Column(name="str_turnover",length=200)
	String str_turnover;
	

    @Column(name="num_city_id",length= 100)
	int num_city_Id;
    
    @Column(name="num_outlet_doc_id",length=200)
	int num_outlet_doc_id;
    
    @Column(name = "num_country_id")
	int num_country_id;

    
    @Column(name = "str_contpersn_name")
	String str_contpersn_name;
    
    @Column(name = "str_document_type")
   	String str_document_type;

    @Column(name = "num_role_id")
   	String num_role_id="3";       
    
    @Column(name="renewal_num_id")
	private int renewal_num_id=0;
    
    
    @Column(name = "str_inclusion")
   	String str_inclusion="";
    
    @Column(nullable=false,columnDefinition="character varying default '0' " )
	String outlet_sequence_id="0";

	public int getNum_id() {
		return num_id;
	}


	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}


	public String getStr_cml_no() {
		return str_cml_no;
	}


	public void setStr_cml_no(String str_cml_no) {
		this.str_cml_no = str_cml_no;
	}


	public String getStr_app_id() {
		return str_app_id;
	}


	public void setStr_app_id(String str_app_id) {
		this.str_app_id = str_app_id;
	}


	public Date getDt_granted_date() {
		return dt_granted_date;
	}


	public void setDt_granted_date(Date dt_granted_date) {
		this.dt_granted_date = dt_granted_date;
	}


	public Date getDt_renewal_date() {
		return dt_renewal_date;
	}


	public void setDt_renewal_date(Date dt_renewal_date) {
		this.dt_renewal_date = dt_renewal_date;
	}


	public Date getDt_operative_date() {
		return dt_operative_date;
	}


	public void setDt_operative_date(Date dt_operative_date) {
		this.dt_operative_date = dt_operative_date;
	}


	public Date getDt_validity_date() {
		return dt_validity_date;
	}


	public void setDt_validity_date(Date dt_validity_date) {
		this.dt_validity_date = dt_validity_date;
	}


	public Date getDt_last_renewal_date() {
		return dt_last_renewal_date;
	}


	public void setDt_last_renewal_date(Date dt_last_renewal_date) {
		this.dt_last_renewal_date = dt_last_renewal_date;
	}


	public Date getDt_licence_renewal_due_date() {
		return dt_licence_renewal_due_date;
	}


	public void setDt_licence_renewal_due_date(Date dt_licence_renewal_due_date) {
		this.dt_licence_renewal_due_date = dt_licence_renewal_due_date;
	}


	public Date getDt_last_licence_renewal_due_date() {
		return dt_last_licence_renewal_due_date;
	}


	public void setDt_last_licence_renewal_due_date(Date dt_last_licence_renewal_due_date) {
		this.dt_last_licence_renewal_due_date = dt_last_licence_renewal_due_date;
	}


	public String getStr_product_id() {
		return str_product_id;
	}


	public void setStr_product_id(String str_product_id) {
		this.str_product_id = str_product_id;
	}


	public String getStr_is_no() {
		return str_is_no;
	}


	public void setStr_is_no(String str_is_no) {
		this.str_is_no = str_is_no;
	}


	public int getNum_branch_id() {
		return num_branch_id;
	}


	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}


	public String getStr_outlet_name() {
		return str_outlet_name;
	}


	public void setStr_outlet_name(String str_outlet_name) {
		this.str_outlet_name = str_outlet_name;
	}


	public int getNum_fac_country_id() {
		return num_fac_country_id;
	}


	public void setNum_fac_country_id(int num_fac_country_id) {
		this.num_fac_country_id = num_fac_country_id;
	}


	public int getNum_fac_state_id() {
		return num_fac_state_id;
	}


	public void setNum_fac_state_id(int num_fac_state_id) {
		this.num_fac_state_id = num_fac_state_id;
	}


	public int getNum_fac_district_id() {
		return num_fac_district_id;
	}


	public void setNum_fac_district_id(int num_fac_district_id) {
		this.num_fac_district_id = num_fac_district_id;
	}


	public Long getNum_fac_pin_code() {
		return num_fac_pin_code;
	}


	public void setNum_fac_pin_code(Long num_fac_pin_code) {
		this.num_fac_pin_code = num_fac_pin_code;
	}


	public String getStr_fac_address1() {
		return str_fac_address1;
	}


	public void setStr_fac_address1(String str_fac_address1) {
		this.str_fac_address1 = str_fac_address1;
	}


	public String getStr_fac_address2() {
		return str_fac_address2;
	}


	public void setStr_fac_address2(String str_fac_address2) {
		this.str_fac_address2 = str_fac_address2;
	}


	public String getStr_fac_city_name() {
		return str_fac_city_name;
	}


	public void setStr_fac_city_name(String str_fac_city_name) {
		this.str_fac_city_name = str_fac_city_name;
	}


	public String getStr_fac_email() {
		return str_fac_email;
	}


	public void setStr_fac_email(String str_fac_email) {
		this.str_fac_email = str_fac_email;
	}


	public String getStr_fac_fax_no() {
		return str_fac_fax_no;
	}


	public void setStr_fac_fax_no(String str_fac_fax_no) {
		this.str_fac_fax_no = str_fac_fax_no;
	}


	public String getStr_fac_person_contact_number() {
		return str_fac_person_contact_number;
	}


	public void setStr_fac_person_contact_number(String str_fac_person_contact_number) {
		this.str_fac_person_contact_number = str_fac_person_contact_number;
	}


	public String getStr_mobile() {
		return str_mobile;
	}


	public void setStr_mobile(String str_mobile) {
		this.str_mobile = str_mobile;
	}


	public Date getDt_entry_date() {
		return dt_entry_date;
	}


	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}


	public long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}


	public void setNum_entry_emp_id(long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}


	public long getNum_app_user_id() {
		return num_app_user_id;
	}


	public void setNum_app_user_id(long num_app_user_id) {
		this.num_app_user_id = num_app_user_id;
	}


	public String getIs_year() {
		return is_year;
	}


	public void setIs_year(String is_year) {
		this.is_year = is_year;
	}


	public int getNum_outlet_branch_id() {
		return num_outlet_branch_id;
	}


	public void setNum_outlet_branch_id(int num_outlet_branch_id) {
		this.num_outlet_branch_id = num_outlet_branch_id;
	}


	public int getNum_isvalid() {
		return num_isvalid;
	}


	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
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


	public int getNum_city_Id() {
		return num_city_Id;
	}


	public void setNum_city_Id(int num_city_Id) {
		this.num_city_Id = num_city_Id;
	}


	public int getNum_outlet_doc_id() {
		return num_outlet_doc_id;
	}


	public void setNum_outlet_doc_id(int num_outlet_doc_id) {
		this.num_outlet_doc_id = num_outlet_doc_id;
	}


	public int getNum_country_id() {
		return num_country_id;
	}


	public void setNum_country_id(int num_country_id) {
		this.num_country_id = num_country_id;
	}


	public String getStr_contpersn_name() {
		return str_contpersn_name;
	}


	public void setStr_contpersn_name(String str_contpersn_name) {
		this.str_contpersn_name = str_contpersn_name;
	}


	public String getStr_document_type() {
		return str_document_type;
	}


	public void setStr_document_type(String str_document_type) {
		this.str_document_type = str_document_type;
	}


	public String getNum_role_id() {
		return num_role_id;
	}


	public void setNum_role_id(String num_role_id) {
		this.num_role_id = num_role_id;
	}


	public int getRenewal_num_id() {
		return renewal_num_id;
	}


	public void setRenewal_num_id(int renewal_num_id) {
		this.renewal_num_id = renewal_num_id;
	}


	public String getStr_inclusion() {
		return str_inclusion;
	}


	public void setStr_inclusion(String str_inclusion) {
		this.str_inclusion = str_inclusion;
	}


	public String getOutlet_sequence_id() {
		return outlet_sequence_id;
	}


	public void setOutlet_sequence_id(String outlet_sequence_id) {
		this.outlet_sequence_id = outlet_sequence_id;
	}


	@Override
	public String toString() {
		return "Hall_Branch_Licence_Details_Domain [num_id=" + num_id + ", str_cml_no=" + str_cml_no + ", str_app_id="
				+ str_app_id + ", dt_granted_date=" + dt_granted_date + ", dt_renewal_date=" + dt_renewal_date
				+ ", dt_operative_date=" + dt_operative_date + ", dt_validity_date=" + dt_validity_date
				+ ", dt_last_renewal_date=" + dt_last_renewal_date + ", dt_licence_renewal_due_date="
				+ dt_licence_renewal_due_date + ", dt_last_licence_renewal_due_date=" + dt_last_licence_renewal_due_date
				+ ", str_product_id=" + str_product_id + ", str_is_no=" + str_is_no + ", num_branch_id=" + num_branch_id
				+ ", str_outlet_name=" + str_outlet_name + ", num_fac_country_id=" + num_fac_country_id
				+ ", num_fac_state_id=" + num_fac_state_id + ", num_fac_district_id=" + num_fac_district_id
				+ ", num_fac_pin_code=" + num_fac_pin_code + ", str_fac_address1=" + str_fac_address1
				+ ", str_fac_address2=" + str_fac_address2 + ", str_fac_city_name=" + str_fac_city_name
				+ ", str_fac_email=" + str_fac_email + ", str_fac_fax_no=" + str_fac_fax_no
				+ ", str_fac_person_contact_number=" + str_fac_person_contact_number + ", str_mobile=" + str_mobile
				+ ", dt_entry_date=" + dt_entry_date + ", num_entry_emp_id=" + num_entry_emp_id + ", num_app_user_id="
				+ num_app_user_id + ", is_year=" + is_year + ", num_outlet_branch_id=" + num_outlet_branch_id
				+ ", num_isvalid=" + num_isvalid + ", check_firm_same=" + check_firm_same + ", str_latitude="
				+ str_latitude + ", str_longitude=" + str_longitude + ", str_turnover=" + str_turnover
				+ ", num_city_Id=" + num_city_Id + ", num_outlet_doc_id=" + num_outlet_doc_id + ", num_country_id="
				+ num_country_id + ", str_contpersn_name=" + str_contpersn_name + ", str_document_type="
				+ str_document_type + ", num_role_id=" + num_role_id + ", renewal_num_id=" + renewal_num_id
				+ ", str_inclusion=" + str_inclusion + ", outlet_sequence_id=" + outlet_sequence_id + "]";
	}
}
