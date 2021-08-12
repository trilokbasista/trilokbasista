package eBIS.nswsAPI.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.Type;

@Entity
@Table(name="NSWS_Request_Log",schema="bis_nsws")
public class NSWSRequestLog {

	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="nsws_request_log")
	@TableGenerator(initialValue=1,	name = "nsws_request_log", table = "hibernate_sequences",pkColumnName = "sequence_name",pkColumnValue="nsws_request_log",allocationSize = 1)
	private Long num_id;
	private String nsws_unique_user_id="";
	private String nsws_request_url="";
	private String nsws_access_token="";
	private Date dt_entry_date=new Date();
	@Type(type="text")
	private String Request_Json="";
	@Type(type="text")
	private String Response_Json="";
	public Long getNum_id() {
		return num_id;
	}
	public void setNum_id(Long num_id) {
		this.num_id = num_id;
	}
	
	public String getNsws_unique_user_id() {
		return nsws_unique_user_id;
	}
	public void setNsws_unique_user_id(String nsws_unique_user_id) {
		this.nsws_unique_user_id = nsws_unique_user_id;
	}
	public Date getDt_entry_date() {
		return dt_entry_date;
	}
	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	public String getRequest_Json() {
		return Request_Json;
	}
	public void setRequest_Json(String request_Json) {
		Request_Json = request_Json;
	}
	public String getResponse_Json() {
		return Response_Json;
	}
	public void setResponse_Json(String response_Json) {
		Response_Json = response_Json;
	}
	
	public String getNsws_request_url() {
		return nsws_request_url;
	}
	public void setNsws_request_url(String nsws_request_url) {
		this.nsws_request_url = nsws_request_url;
	}
	public String getNsws_access_token() {
		return nsws_access_token;
	}
	public void setNsws_access_token(String nsws_access_token) {
		this.nsws_access_token = nsws_access_token;
	}
	
	@Override
	public String toString() {
		return "NSWSRequestLog [num_id=" + num_id + ", nsws_unique_user_id=" + nsws_unique_user_id
				+ ", nsws_request_url=" + nsws_request_url + ", nsws_access_token=" + nsws_access_token
				+ ", dt_entry_date=" + dt_entry_date + ", Request_Json=" + Request_Json + ", Response_Json="
				+ Response_Json + "]";
	}
		
}
