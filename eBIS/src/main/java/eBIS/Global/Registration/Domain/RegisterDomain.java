package eBIS.Global.Registration.Domain;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="user_registration_mst", schema="bis_dev")
public class RegisterDomain {
	@Id
	@Column (name="num_user_id",length=50)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="user_registration_mst")
	@TableGenerator(
			initialValue=1,
			name = "user_registration_mst",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="user_registration_mst",
	        allocationSize = 1        
	)
	private Integer num_user_id;
	
	@Column(name="str_email",length=50)
	String str_email="";
	
	@Column(name="str_fname", length=100)
	String str_fname="";
	
	@Column(name="str_mname", length=50)
	String str_mname="";
	
	@Column(name="str_lname", length=50)
	String str_lname="";
	
	@Column(name="str_password")
	String str_password="";
	
	@Column(name="dt_dob", length=30)
	String dt_dob="";
			
	@Column(name="str_id_number", length=30)
	String str_id_number="";
		
	@Column(name="num_mobile",length=50)
	String num_mobile="";
	
	
	@Column(name="str_fmcd_user_country_code",length=8)
	String str_fmcd_user_country_code="";

	@Column(name="str_indian_rep_mobile",length=15)
	String str_indian_rep_mobile="";
	
	@Column(name="str_indian_rep_name",length=50)
	String str_indian_rep_name="";
	
	@Column(name="str_indian_rep_email",length=50)
	String str_indian_rep_email="";
	
	@Column(name="str_security_question_answer", length=30)
	String str_security_question_answer="";

	@Column(name="str_single_use_token", length=25)
	String str_single_use_token="";
	
	@Column(name="num_salutation_id",length=3)
	Integer num_salutation_id=0;
	
	@Column(name="num_gender_id",length=3)
	Integer num_gender_id=0;
	
	
	@Column(name="num_country_id",length=3)
	Integer num_country_id=0;
	
	@Column(name="num_security_question_id",length=3)
	Integer num_security_question_id=0;
	
	@Column(name="num_identification_id",length=3)
	Integer num_identification_id=0;
	
	@Column(name="dt_entry_date", length=15)
	Date  dt_entry_date=new Date();
	
	@Column(name="num_isvalid", length=1)
	Integer num_isvalid=1;
	
	@Column(name="dt_varification_date", length=15)
	String dt_varification_date="";
	
	@Column(name="num_failure_attempt", length=2)
	Integer num_failure_attempt=Integer.parseInt("0");
	 
	@Column(name="str_bis_user_id", length=12)
	Integer str_bis_user_id;
	
	@Column(name="str_bis_emp_id", length=10)
	Integer str_bis_emp_id;
	
	@Column(name="num_vertification_status", length=10)
	Integer num_vertification_status =Integer.parseInt("0");
	
	@Column(name="str_old_password", length=20)
	String str_old_password="";
	
	@Column(name="str_user_type", length=10)
	String str_user_type="P";
	
	@Column(name="dt_registration_date", length=15)
	Date  dt_registration_date=new Date();
	
	@Column(name="str_email_c", length=30)
	String str_email_c = "";
	
	@Column(name="num_document_id",length=4)
	Integer num_document_id = 0;
	
	@Column(name="str_document_number", length=15)
	String str_document_number="";
	
	@Column(name="dt_document_date", length=15)
	Date  dt_document_date=new Date();
	
	@Column(name="str_status", length=15)
	String str_status="";
	
	@Column(name="entry_emp_id", length=15)
	Integer entry_emp_id=0;
	
	@Column(name="str_user_name", length=50)
	String str_user_name="";
	
	@Column(name="str_contact_number", length=30)
	String str_contact_number="";

	@Column(name="num_password_change",length=1)
	Integer num_password_change = 0;

	@Column(name="str_fmcd_user_mobile",length=15)
	String str_fmcd_user_mobile="";
	
	@Column(name="str_nsws_user_name",nullable=false,columnDefinition="character varying default '0' " )
	String str_nsws_user_name="0";
	public Integer getNum_user_id() {
		return num_user_id;
	}

	public void setNum_user_id(Integer num_user_id) {
		this.num_user_id = num_user_id;
	}

	public String getStr_email() {
		return str_email;
	}

	public void setStr_email(String str_email) {
		this.str_email = str_email;
	}

	public String getStr_fname() {
		return str_fname;
	}

	public void setStr_fname(String str_fname) {
		this.str_fname = str_fname;
	}

	public String getStr_mname() {
		return str_mname;
	}

	public void setStr_mname(String str_mname) {
		this.str_mname = str_mname;
	}

	public String getStr_lname() {
		return str_lname;
	}

	public void setStr_lname(String str_lname) {
		this.str_lname = str_lname;
	}

	public String getStr_password() {
		return str_password;
	}

	public void setStr_password(String str_password) {
		this.str_password = str_password;
	}

	public String getDt_dob() {
		return dt_dob;
	}

	public void setDt_dob(String dt_dob) {
		this.dt_dob = dt_dob;
	}

	public String getStr_id_number() {
		return str_id_number;
	}

	public void setStr_id_number(String str_id_number) {
		this.str_id_number = str_id_number;
	}

	public String getNum_mobile() {
		return num_mobile;
	}

	public void setNum_mobile(String num_mobile) {
		this.num_mobile = num_mobile;
	}

	public String getStr_fmcd_user_country_code() {
		return str_fmcd_user_country_code;
	}

	public void setStr_fmcd_user_country_code(String str_fmcd_user_country_code) {
		this.str_fmcd_user_country_code = str_fmcd_user_country_code;
	}

	public String getStr_indian_rep_mobile() {
		return str_indian_rep_mobile;
	}

	public void setStr_indian_rep_mobile(String str_indian_rep_mobile) {
		this.str_indian_rep_mobile = str_indian_rep_mobile;
	}

	public String getStr_indian_rep_name() {
		return str_indian_rep_name;
	}

	public void setStr_indian_rep_name(String str_indian_rep_name) {
		this.str_indian_rep_name = str_indian_rep_name;
	}

	public String getStr_indian_rep_email() {
		return str_indian_rep_email;
	}

	public void setStr_indian_rep_email(String str_indian_rep_email) {
		this.str_indian_rep_email = str_indian_rep_email;
	}

	public String getStr_security_question_answer() {
		return str_security_question_answer;
	}

	public void setStr_security_question_answer(String str_security_question_answer) {
		this.str_security_question_answer = str_security_question_answer;
	}

	public String getStr_single_use_token() {
		return str_single_use_token;
	}

	public void setStr_single_use_token(String str_single_use_token) {
		this.str_single_use_token = str_single_use_token;
	}

	public Integer getNum_salutation_id() {
		return num_salutation_id;
	}

	public void setNum_salutation_id(Integer num_salutation_id) {
		this.num_salutation_id = num_salutation_id;
	}

	public Integer getNum_gender_id() {
		return num_gender_id;
	}

	public void setNum_gender_id(Integer num_gender_id) {
		this.num_gender_id = num_gender_id;
	}

	public Integer getNum_country_id() {
		return num_country_id;
	}

	public void setNum_country_id(Integer num_country_id) {
		this.num_country_id = num_country_id;
	}

	public Integer getNum_security_question_id() {
		return num_security_question_id;
	}

	public void setNum_security_question_id(Integer num_security_question_id) {
		this.num_security_question_id = num_security_question_id;
	}

	public Integer getNum_identification_id() {
		return num_identification_id;
	}

	public void setNum_identification_id(Integer num_identification_id) {
		this.num_identification_id = num_identification_id;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public Integer getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(Integer num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public String getDt_varification_date() {
		return dt_varification_date;
	}

	public void setDt_varification_date(String dt_varification_date) {
		this.dt_varification_date = dt_varification_date;
	}

	public Integer getNum_failure_attempt() {
		return num_failure_attempt;
	}

	public void setNum_failure_attempt(Integer num_failure_attempt) {
		this.num_failure_attempt = num_failure_attempt;
	}

	public Integer getStr_bis_user_id() {
		return str_bis_user_id;
	}

	public void setStr_bis_user_id(Integer str_bis_user_id) {
		this.str_bis_user_id = str_bis_user_id;
	}

	public Integer getStr_bis_emp_id() {
		return str_bis_emp_id;
	}

	public void setStr_bis_emp_id(Integer str_bis_emp_id) {
		this.str_bis_emp_id = str_bis_emp_id;
	}

	public Integer getNum_vertification_status() {
		return num_vertification_status;
	}

	public void setNum_vertification_status(Integer num_vertification_status) {
		this.num_vertification_status = num_vertification_status;
	}

	public String getStr_old_password() {
		return str_old_password;
	}

	public void setStr_old_password(String str_old_password) {
		this.str_old_password = str_old_password;
	}

	public String getStr_user_type() {
		return str_user_type;
	}

	public void setStr_user_type(String str_user_type) {
		this.str_user_type = str_user_type;
	}

	public Date getDt_registration_date() {
		return dt_registration_date;
	}

	public void setDt_registration_date(Date dt_registration_date) {
		this.dt_registration_date = dt_registration_date;
	}

	public String getStr_email_c() {
		return str_email_c;
	}

	public void setStr_email_c(String str_email_c) {
		this.str_email_c = str_email_c;
	}

	public Integer getNum_document_id() {
		return num_document_id;
	}

	public void setNum_document_id(Integer num_document_id) {
		this.num_document_id = num_document_id;
	}

	public String getStr_document_number() {
		return str_document_number;
	}

	public void setStr_document_number(String str_document_number) {
		this.str_document_number = str_document_number;
	}

	public Date getDt_document_date() {
		return dt_document_date;
	}

	public void setDt_document_date(Date dt_document_date) {
		this.dt_document_date = dt_document_date;
	}

	public String getStr_status() {
		return str_status;
	}

	public void setStr_status(String str_status) {
		this.str_status = str_status;
	}


	public Integer getEntry_emp_id() {
		return entry_emp_id;
	}

	public void setEntry_emp_id(Integer entry_emp_id) {
		this.entry_emp_id = entry_emp_id;
	}

	public String getStr_user_name() {
		return str_user_name;
	}

	public void setStr_user_name(String str_user_name) {
		this.str_user_name = str_user_name;
	}

	public String getStr_contact_number() {
		return str_contact_number;
	}

	public void setStr_contact_number(String str_contact_number) {
		this.str_contact_number = str_contact_number;
	}

	public Integer getNum_password_change() {
		return num_password_change;
	}

	public void setNum_password_change(Integer num_password_change) {
		this.num_password_change = num_password_change;
	}

	public String getStr_fmcd_user_mobile() {
		return str_fmcd_user_mobile;
	}

	public void setStr_fmcd_user_mobile(String str_fmcd_user_mobile) {
		this.str_fmcd_user_mobile = str_fmcd_user_mobile;
	}

	public String getStr_nsws_user_name() {
		return str_nsws_user_name;
	}

	public void setStr_nsws_user_name(String str_nsws_user_name) {
		this.str_nsws_user_name = str_nsws_user_name;
	}

	@Override
	public String toString() {
		return "RegisterDomain [num_user_id=" + num_user_id + ", str_email=" + str_email + ", str_fname=" + str_fname
				+ ", str_mname=" + str_mname + ", str_lname=" + str_lname + ", str_password=" + str_password
				+ ", dt_dob=" + dt_dob + ", str_id_number=" + str_id_number + ", num_mobile=" + num_mobile
				+ ", str_fmcd_user_country_code=" + str_fmcd_user_country_code + ", str_indian_rep_mobile="
				+ str_indian_rep_mobile + ", str_indian_rep_name=" + str_indian_rep_name + ", str_indian_rep_email="
				+ str_indian_rep_email + ", str_security_question_answer=" + str_security_question_answer
				+ ", str_single_use_token=" + str_single_use_token + ", num_salutation_id=" + num_salutation_id
				+ ", num_gender_id=" + num_gender_id + ", num_country_id=" + num_country_id
				+ ", num_security_question_id=" + num_security_question_id + ", num_identification_id="
				+ num_identification_id + ", dt_entry_date=" + dt_entry_date + ", num_isvalid=" + num_isvalid
				+ ", dt_varification_date=" + dt_varification_date + ", num_failure_attempt=" + num_failure_attempt
				+ ", str_bis_user_id=" + str_bis_user_id + ", str_bis_emp_id=" + str_bis_emp_id
				+ ", num_vertification_status=" + num_vertification_status + ", str_old_password=" + str_old_password
				+ ", str_user_type=" + str_user_type + ", dt_registration_date=" + dt_registration_date
				+ ", str_email_c=" + str_email_c + ", num_document_id=" + num_document_id + ", str_document_number="
				+ str_document_number + ", dt_document_date=" + dt_document_date + ", str_status=" + str_status
				+ ", entry_emp_id=" + entry_emp_id + ", str_user_name=" + str_user_name + ", str_contact_number="
				+ str_contact_number + ", num_password_change=" + num_password_change + ", str_fmcd_user_mobile="
				+ str_fmcd_user_mobile + ", str_nsws_user_name=" + str_nsws_user_name + "]";
	}
	
	
}
