package eBIS.payment.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="Bypass_Payment_HM", schema="bis_hall")
public class BypassPaymentHM {

	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="Bypass_Payment_HM")
	@TableGenerator(
			initialValue=1,
			name = "Bypass_Payment_HM",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="Bypass_Payment_HM",
	        allocationSize = 1        
				)
			int num_id;
	@Column(name="str_application_id_ref")
	private String str_application_id_ref="";
	@Column(name="str_cml_no")
	private String str_cml_no="";
	@Column(name="strUserId")
	private String strUserId="";
	@Column(name="num_std_year")
	private String num_std_year="";
	@Column(name="str_is_number")
	private String str_is_number="";
	@Column(name="appID")
	private String appID="";
	@Column(name="branchId")
	private String branchId="";
	@Column(name="dt_entry_date")
	private Date dt_entry_date=new Date();
	public int getNum_id() {
		return num_id;
	}
	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}
	public String getStr_application_id_ref() {
		return str_application_id_ref;
	}
	public void setStr_application_id_ref(String str_application_id_ref) {
		this.str_application_id_ref = str_application_id_ref;
	}
	public String getStr_cml_no() {
		return str_cml_no;
	}
	public void setStr_cml_no(String str_cml_no) {
		this.str_cml_no = str_cml_no;
	}
	public String getStrUserId() {
		return strUserId;
	}
	public void setStrUserId(String strUserId) {
		this.strUserId = strUserId;
	}
	public String getNum_std_year() {
		return num_std_year;
	}
	public void setNum_std_year(String num_std_year) {
		this.num_std_year = num_std_year;
	}
	public String getStr_is_number() {
		return str_is_number;
	}
	public void setStr_is_number(String str_is_number) {
		this.str_is_number = str_is_number;
	}
	public String getAppID() {
		return appID;
	}
	public void setAppID(String appID) {
		this.appID = appID;
	}
	public String getBranchId() {
		return branchId;
	}
	public void setBranchId(String branchId) {
		this.branchId = branchId;
	}
	public Date getDt_entry_date() {
		return dt_entry_date;
	}
	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	@Override
	public String toString() {
		return "BypassPaymentHM [num_id=" + num_id + ", str_application_id_ref=" + str_application_id_ref
				+ ", str_cml_no=" + str_cml_no + ", strUserId=" + strUserId + ", num_std_year=" + num_std_year
				+ ", str_is_number=" + str_is_number + ", appID=" + appID + ", branchId=" + branchId
				+ ", dt_entry_date=" + dt_entry_date + "]";
	}
	
}
