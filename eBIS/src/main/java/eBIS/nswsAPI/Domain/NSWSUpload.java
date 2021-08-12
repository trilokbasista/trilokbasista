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
@Table(name="NSWS_upload",schema="bis_nsws")
public class NSWSUpload {
	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="nsws_upload_log")
	@TableGenerator(
			initialValue=1,
			name = "nsws_upload_log",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="nsws_upload_log",
	        allocationSize = 1        
	)
	private Long num_id;
	@Column(nullable=false) 
	private String nsws_unique_user_name="";
	@Column(nullable=false)
	private String manak_doc_id="";
	@Column(nullable=false)
	private String manak_sub_doc_id="";
	@Column(nullable=false) 
	private String nsws_doc_id="";
	@Column(nullable=false)
	private String nsws_unique_app_id="";
	@Column(nullable=false)
	private String manak_app_id="";
	@Column(nullable=false)
	private String manak_branch_id="";
	@Column(nullable=false)
	private String manak_doc_parent_id="";
	@Column(nullable=false)
	private String oulet_doc_parent_id="";
	@Column(nullable=false)
	private Integer num_is_valid=1;
	@Column(nullable=false)
	private Date dt_entry_date=new Date();
	@Column(nullable=false,columnDefinition="character varying default '0' ")
	private String manak_scheme_id="2";
	public Long getNum_id() {
		return num_id;
	}
	public void setNum_id(Long num_id) {
		this.num_id = num_id;
	}

	public String getNsws_unique_user_name() {
		return nsws_unique_user_name;
	}
	public void setNsws_unique_user_name(String nsws_unique_user_name) {
		this.nsws_unique_user_name = nsws_unique_user_name;
	}
	public String getManak_doc_id() {
		return manak_doc_id;
	}
	public void setManak_doc_id(String manak_doc_id) {
		this.manak_doc_id = manak_doc_id;
	}
	public String getNsws_doc_id() {
		return nsws_doc_id;
	}
	public void setNsws_doc_id(String nsws_doc_id) {
		this.nsws_doc_id = nsws_doc_id;
	}

	public String getNsws_unique_app_id() {
		return nsws_unique_app_id;
	}
	public void setNsws_unique_app_id(String nsws_unique_app_id) {
		this.nsws_unique_app_id = nsws_unique_app_id;
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
	public String getManak_doc_parent_id() {
		return manak_doc_parent_id;
	}
	public void setManak_doc_parent_id(String manak_doc_parent_id) {
		this.manak_doc_parent_id = manak_doc_parent_id;
	}
	public Date getDt_entry_date() {
		return dt_entry_date;
	}
	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	
	public String getOulet_doc_parent_id() {
		return oulet_doc_parent_id;
	}
	public void setOulet_doc_parent_id(String oulet_doc_parent_id) {
		this.oulet_doc_parent_id = oulet_doc_parent_id;
	}
	public String getManak_sub_doc_id() {
		return manak_sub_doc_id;
	}
	public void setManak_sub_doc_id(String manak_sub_doc_id) {
		this.manak_sub_doc_id = manak_sub_doc_id;
	}
	
	public Integer getNum_is_valid() {
		return num_is_valid;
	}
	public void setNum_is_valid(Integer num_is_valid) {
		this.num_is_valid = num_is_valid;
	}
	
	public String getManak_scheme_id() {
		return manak_scheme_id;
	}
	public void setManak_scheme_id(String manak_scheme_id) {
		this.manak_scheme_id = manak_scheme_id;
	}
	@Override
	public String toString() {
		return "NSWSUpload [num_id=" + num_id + ", nsws_unique_user_name=" + nsws_unique_user_name + ", manak_doc_id="
				+ manak_doc_id + ", manak_sub_doc_id=" + manak_sub_doc_id + ", nsws_doc_id=" + nsws_doc_id
				+ ", nsws_unique_app_id=" + nsws_unique_app_id + ", manak_app_id=" + manak_app_id + ", manak_branch_id="
				+ manak_branch_id + ", manak_doc_parent_id=" + manak_doc_parent_id + ", oulet_doc_parent_id="
				+ oulet_doc_parent_id + ", num_is_valid=" + num_is_valid + ", dt_entry_date=" + dt_entry_date
				+ ", manak_scheme_id=" + manak_scheme_id + "]";
	}
	
}
