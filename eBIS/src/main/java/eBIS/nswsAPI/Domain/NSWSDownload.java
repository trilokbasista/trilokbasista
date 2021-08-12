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
@Table(name="NSWS_download",schema="bis_nsws")
public class NSWSDownload {
	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="nsws_download_log")
	@TableGenerator(
			initialValue=1,
			name = "nsws_download_log",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="nsws_download_log",
	        allocationSize = 1        
	)
	private Long num_id;
	@Column(nullable=false) 
	private String nsws_unique_user_name="";
	@Column(nullable=false)
	private String nsws_unique_app_id="";
	@Column(nullable=false)
	private String manak_app_id="";
	@Column(nullable=false)
	private String manak_branch_id="";
	@Column(nullable=false)
	private String manak_cml_no="";
	@Column(nullable=false)
	private Integer num_is_valid=1;
	@Column(nullable=false)
	private Date dt_entry_date=new Date();
	@Column(nullable=false)
	private String file_checksum="";
	@Column(nullable=false)
	private String file_extension="";
	
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
	public String getManak_cml_no() {
		return manak_cml_no;
	}
	public void setManak_cml_no(String manak_cml_no) {
		this.manak_cml_no = manak_cml_no;
	}
	public Integer getNum_is_valid() {
		return num_is_valid;
	}
	public void setNum_is_valid(Integer num_is_valid) {
		this.num_is_valid = num_is_valid;
	}
	public Date getDt_entry_date() {
		return dt_entry_date;
	}
	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	public String getFile_checksum() {
		return file_checksum;
	}
	public void setFile_checksum(String file_checksum) {
		this.file_checksum = file_checksum;
	}
	public String getFile_extension() {
		return file_extension;
	}
	public void setFile_extension(String file_extension) {
		this.file_extension = file_extension;
	}
	@Override
	public String toString() {
		return "NSWSDownload [num_id=" + num_id + ", nsws_unique_user_name=" + nsws_unique_user_name
				+ ", nsws_unique_app_id=" + nsws_unique_app_id + ", manak_app_id=" + manak_app_id + ", manak_branch_id="
				+ manak_branch_id + ", manak_cml_no=" + manak_cml_no + ", num_is_valid=" + num_is_valid
				+ ", dt_entry_date=" + dt_entry_date + ", file_checksum=" + file_checksum + ", file_extension="
				+ file_extension + "]";
	}
	
	
}
