package eBIS.exception.log.model;

import java.util.Date;

public class ExceptionLogModel {
	private Integer num_id;
	private String user_remarks="";
	private String exception_remarks="";
	private String exception_details="";
	private Date exception_date;
	private String is_valid="";
	public Integer getNum_id() {
		return num_id;
	}
	public void setNum_id(Integer num_id) {
		this.num_id = num_id;
	}
	
	public String getUser_remarks() {
		return user_remarks;
	}
	public void setUser_remarks(String user_remarks) {
		this.user_remarks = user_remarks;
	}
	public String getException_remarks() {
		return exception_remarks;
	}
	public void setException_remarks(String exception_remarks) {
		this.exception_remarks = exception_remarks;
	}
	public String getException_details() {
		return exception_details;
	}
	public void setException_details(String exception_details) {
		this.exception_details = exception_details;
	}
	public Date getException_date() {
		return exception_date;
	}
	public void setException_date(Date exception_date) {
		this.exception_date = exception_date;
	}
	public String getIs_valid() {
		return is_valid;
	}
	public void setIs_valid(String is_valid) {
		this.is_valid = is_valid;
	}
	@Override
	public String toString() {
		return "ExceptionLogModel [num_id=" + num_id + ", user_remarks=" + user_remarks + ", exception_remarks="
				+ exception_remarks + ", exception_details=" + exception_details + ", exception_date=" + exception_date
				+ ", is_valid=" + is_valid + "]";
	}
}
