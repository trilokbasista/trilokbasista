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
@Table(name="hm_jeweler_application_tracking", schema="bis_hall")
public class HMJewApplicationTrackingDomain {

	@Id
	@Column(name="NUM_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hm_jeweler_application_tracking")
	@TableGenerator(
			initialValue=1,
			name = "hm_jeweler_application_tracking",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="hm_jeweler_application_tracking",
	        allocationSize = 1        
				)
			int num_id;
	
	@Column(name="str_application_id",length=12)
	String str_application_id;
	
	 @Column(name="str_cml_no")
	 String str_cml_no="";
	
	@Column(name="num_app_status", length=5)
	int num_app_status;
	
	@Column(name="str_remarks",length=500)
	String str_remarks="";
	
	@Column(name="num_entry_emp_id",length=10)
	Long num_entry_emp_id;
	
	@Column(name="num_entry_role_id",length=10)
	int num_entry_role_id;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date=new Date();
	
	@Column(name="dt_propose_date")
	Date dt_propose_date;
	
	@Column(name="num_branch_id",length=2)
	int num_branch_id;
	
	@Column(name="num_visible_applicant",length=2)
	int num_visible_applicant;
	
	
	@Column(name="num_flag_task_complete",length=2)
	int num_flag_task_complte = 1;

	@Column(name="str_flag_renew",length=5)
	String str_flag_renew="";

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public String getStr_application_id() {
		return str_application_id;
	}

	public void setStr_application_id(String str_application_id) {
		this.str_application_id = str_application_id;
	}

	public String getStr_cml_no() {
		return str_cml_no;
	}

	public void setStr_cml_no(String str_cml_no) {
		this.str_cml_no = str_cml_no;
	}

	public int getNum_app_status() {
		return num_app_status;
	}

	public void setNum_app_status(int num_app_status) {
		this.num_app_status = num_app_status;
	}

	public String getStr_remarks() {
		return str_remarks;
	}

	public void setStr_remarks(String str_remarks) {
		this.str_remarks = str_remarks;
	}

	public Long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(Long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	public int getNum_entry_role_id() {
		return num_entry_role_id;
	}

	public void setNum_entry_role_id(int num_entry_role_id) {
		this.num_entry_role_id = num_entry_role_id;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public Date getDt_propose_date() {
		return dt_propose_date;
	}

	public void setDt_propose_date(Date dt_propose_date) {
		this.dt_propose_date = dt_propose_date;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public int getNum_visible_applicant() {
		return num_visible_applicant;
	}

	public void setNum_visible_applicant(int num_visible_applicant) {
		this.num_visible_applicant = num_visible_applicant;
	}

	public int getNum_flag_task_complte() {
		return num_flag_task_complte;
	}

	public void setNum_flag_task_complte(int num_flag_task_complte) {
		this.num_flag_task_complte = num_flag_task_complte;
	}

	public String getStr_flag_renew() {
		return str_flag_renew;
	}

	public void setStr_flag_renew(String str_flag_renew) {
		this.str_flag_renew = str_flag_renew;
	}
	
}
