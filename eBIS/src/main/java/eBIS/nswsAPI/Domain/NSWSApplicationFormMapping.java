package eBIS.nswsAPI.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="nsws_application_form_mapping",schema="bis_nsws")
public class NSWSApplicationFormMapping {
	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="nsws_application_form_mapping")
	@TableGenerator(
			initialValue=1,
			name = "nsws_application_form_mapping",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="nsws_application_form_mapping",
	        allocationSize = 1        
	)
	private Long num_id;
	@Column(nullable=false)
	private String nsws_unique_user_name="";
	@Column(unique = true,nullable=false)
	private String nsws_unique_app_id="";
	@Column(unique = true,nullable=false)
	private String manak_app_id="";
	@Column(nullable=false)
	private String manak_branch_id="";
	@Column(nullable=false)
	private String manak_scheme_id="2";
	@Column(nullable=false)
	private String manak_action_id="1";
	@Column(nullable=false)
	private String manak_cml_no="";
	@Column(nullable=false)
	private Integer is_valid=1;
	@Column(nullable=false)
	private Date dt_entry_date=new Date();
	public Long getNum_id() {
		return num_id;
	}
	public void setNum_id(Long num_id) {
		this.num_id = num_id;
	}
	public String getManak_app_id() {
		return manak_app_id;
	}
	public void setManak_app_id(String manak_app_id) {
		this.manak_app_id = manak_app_id;
	}
	public String getManak_branch_id() {
		return manak_branch_id;
	}
	public void setManak_branch_id(String manak_branch_id) {
		this.manak_branch_id = manak_branch_id;
	}
	
	public Date getDt_entry_date() {
		return dt_entry_date;
	}
	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	
	public String getNsws_unique_user_name() {
		return nsws_unique_user_name;
	}
	public void setNsws_unique_user_name(String nsws_unique_user_name) {
		this.nsws_unique_user_name = nsws_unique_user_name;
	}
	public String getNsws_unique_app_id() {
		return nsws_unique_app_id;
	}
	public void setNsws_unique_app_id(String nsws_unique_app_id) {
		this.nsws_unique_app_id = nsws_unique_app_id;
	}
	
	public Integer getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(Integer is_valid) {
		this.is_valid = is_valid;
	}
	
	public String getManak_scheme_id() {
		return manak_scheme_id;
	}
	public void setManak_scheme_id(String manak_scheme_id) {
		this.manak_scheme_id = manak_scheme_id;
	}
	public String getManak_action_id() {
		return manak_action_id;
	}
	public void setManak_action_id(String manak_action_id) {
		this.manak_action_id = manak_action_id;
	}
	public String getManak_cml_no() {
		return manak_cml_no;
	}
	public void setManak_cml_no(String manak_cml_no) {
		this.manak_cml_no = manak_cml_no;
	}
	@Override
	public String toString() {
		return "NSWSApplicationFormMapping [num_id=" + num_id + ", nsws_unique_user_name=" + nsws_unique_user_name
				+ ", nsws_unique_app_id=" + nsws_unique_app_id + ", manak_app_id=" + manak_app_id + ", manak_branch_id="
				+ manak_branch_id + ", manak_scheme_id=" + manak_scheme_id + ", manak_action_id=" + manak_action_id
				+ ", manak_cml_no=" + manak_cml_no + ", is_valid=" + is_valid + ", dt_entry_date=" + dt_entry_date
				+ "]";
	}
	
	
}
