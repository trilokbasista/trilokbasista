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
@Table(name="hall_jeweller_firm_contact_details_licence", schema="bis_hall")
public class Hall_firmDtlsContactLicenceDomain {

		@Id
		@Column(name="num_id")
		@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_jeweller_firm_contact_details_licence")
		@TableGenerator(
				initialValue=1,
				name = "hall_jeweller_firm_contact_details_licence",
				table = "hibernate_sequences",
				pkColumnName = "sequence_name",
				pkColumnValue="hall_jeweller_firm_contact_details_licence",
				allocationSize = 1        
				)
		int num_id;
	
	@Column(name="str_app_id",length=12)
	String str_app_id;
	
	@Column(name="str_cml_no",length=12)
	String str_cml_no;
	
	@Column(name="num_branch_id",length=3)
	int num_branch_id;
	
	@Column(name="str_firm_name")
	String str_firm_name;
	
	@Column(name="str_contactperson_name")
	String str_contactperson_name;
	
	@Column(name="str_contactPerson_no")
	String str_contactPerson_no;
	
	@Column(name="str_fax")
	String  str_fax;
	
	@Column(name="str_contactperson_emailid",length=50)
	String str_contactperson_emailid;
	
	@Column(name="str_designation",length=100)
	String str_designation;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date=new Date();
	
	@Column(name="is_valid")
	int is_valid=1;
	
	@Column(name="num_entry_emp_id", length=10)
	long num_entry_emp_id;

	@Column(name="num_role_id")
	String num_role_id;

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public String getStr_app_id() {
		return str_app_id;
	}

	public void setStr_app_id(String str_app_id) {
		this.str_app_id = str_app_id;
	}

	public String getStr_cml_no() {
		return str_cml_no;
	}

	public void setStr_cml_no(String str_cml_no) {
		this.str_cml_no = str_cml_no;
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

	public String getStr_contactperson_name() {
		return str_contactperson_name;
	}

	public void setStr_contactperson_name(String str_contactperson_name) {
		this.str_contactperson_name = str_contactperson_name;
	}

	public String getStr_contactPerson_no() {
		return str_contactPerson_no;
	}

	public void setStr_contactPerson_no(String str_contactPerson_no) {
		this.str_contactPerson_no = str_contactPerson_no;
	}

	public String getStr_fax() {
		return str_fax;
	}

	public void setStr_fax(String str_fax) {
		this.str_fax = str_fax;
	}

	public String getStr_designation() {
		return str_designation;
	}

	public void setStr_designation(String str_designation) {
		this.str_designation = str_designation;
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

	public String getNum_role_id() {
		return num_role_id;
	}

	public void setNum_role_id(String num_role_id) {
		this.num_role_id = num_role_id;
	}

	public String getStr_contactperson_emailid() {
		return str_contactperson_emailid;
	}

	public void setStr_contactperson_emailid(String str_contactperson_emailid) {
		this.str_contactperson_emailid = str_contactperson_emailid;
	}
	
}
