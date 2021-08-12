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
@Table(name="hall_cml_licence_status_dtl", schema="bis_hall")
public class hall_cmlstatusdetails_Domain {

	@Id
	@Column(name="NUM_ID")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_cml_licence_status_dtl")
	@TableGenerator(
		initialValue=1,
		name = "hall_cml_licence_status_dtl",
        table = "hibernate_sequences",
        pkColumnName = "sequence_name",
        pkColumnValue="hall_cml_licence_status_dtl",
        allocationSize = 1        
			)
		int num_id;
	
	@Column(name="STR_CML_NO")
	  String str_cml_no;
	    
	 @Column(name="NUM_CML_STATUS_ID")
	  int num_cml_status_id;
	    
	 @Column(name="DT_STATUS_DATE",nullable = true)
	   Date dt_status_date = new Date();     
	
	 @Column(name="DT_CLOSURE_DATE",nullable = true)
	   Date dt_closure_date;  
	 
	 @Column(name="STR_REMARKS", length=512)
	  	String str_remarks;
	    
	 @Column(name="STR_REASON", length=512)
	  	String str_reason;
	    
	 @Column(name="STR_NOTES", length=512)
	  	String str_notes;
	 
	@Column(name="DT_ENTRY_DATE",nullable = true)
	   Date dt_entry_date = new Date();   

	 @Column(name="NUM_BRANCH_ID", length=3)
	    int num_branch_id;
	 
	 @Column(name="STR_ENTRY_EMP_ID", length=10)
	    long str_entry_emp_id;
	 
	 @Column(name="Str_cdac_remarks", length=200)
	    String Str_cdac_remarks;

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

	public int getNum_cml_status_id() {
		return num_cml_status_id;
	}

	public void setNum_cml_status_id(int num_cml_status_id) {
		this.num_cml_status_id = num_cml_status_id;
	}

	public Date getDt_status_date() {
		return dt_status_date;
	}

	public void setDt_status_date(Date dt_status_date) {
		this.dt_status_date = dt_status_date;
	}

	public Date getDt_closure_date() {
		return dt_closure_date;
	}

	public void setDt_closure_date(Date dt_closure_date) {
		this.dt_closure_date = dt_closure_date;
	}

	public String getStr_remarks() {
		return str_remarks;
	}

	public void setStr_remarks(String str_remarks) {
		this.str_remarks = str_remarks;
	}

	public String getStr_reason() {
		return str_reason;
	}

	public void setStr_reason(String str_reason) {
		this.str_reason = str_reason;
	}

	public String getStr_notes() {
		return str_notes;
	}

	public void setStr_notes(String str_notes) {
		this.str_notes = str_notes;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public long getStr_entry_emp_id() {
		return str_entry_emp_id;
	}

	public void setStr_entry_emp_id(long str_entry_emp_id) {
		this.str_entry_emp_id = str_entry_emp_id;
	}

	public String getStr_cdac_remarks() {
		return Str_cdac_remarks;
	}

	public void setStr_cdac_remarks(String str_cdac_remarks) {
		Str_cdac_remarks = str_cdac_remarks;
	}
	
}
