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
@Table(name="app_sub_jewel_precancellicence", schema="bis_hall")
public class AppSubJewelPreCancelLicence {

	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="app_sub_jewel_precancellicence")
	@TableGenerator(
			initialValue=1,
			name = "app_sub_jewel_precancellicence",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="app_sub_jewel_precancellicence",
	        allocationSize = 1        
				)
			int num_id;
	
	@Column (name="str_cml_previous")
	String str_cml_previous;
    
    @Column(name="str_product", length=255)
    String str_product;
    
    @Column(name="str_is_no", length=255)
    String str_is_no;
    
    @Column(name="str_detail", length=255)
    String str_detail;
    
    @Column(name="str_app_id", length=255)
    String str_app_id;
    
    @Column (name="num_branch_id")
	int num_branch_id;
    
    @Column (name="num_isvalid")
	int num_isvalid=1;
    
    @Column(name="dt_entry_date",nullable = true)
    Date dt_entry_date = new Date();         
    
    @Column(name="num_entry_emp_id")
    int num_entry_emp_id;

    @Column (name="str_cancel_date",length=300)
	String str_cancel_date;
    
    @Column(name="str_application_id_ref")
	String str_application_id_ref;

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public String getStr_cml_previous() {
		return str_cml_previous;
	}

	public void setStr_cml_previous(String str_cml_previous) {
		this.str_cml_previous = str_cml_previous;
	}

	public String getStr_product() {
		return str_product;
	}

	public void setStr_product(String str_product) {
		this.str_product = str_product;
	}

	public String getStr_is_no() {
		return str_is_no;
	}

	public void setStr_is_no(String str_is_no) {
		this.str_is_no = str_is_no;
	}

	public String getStr_detail() {
		return str_detail;
	}

	public void setStr_detail(String str_detail) {
		this.str_detail = str_detail;
	}

	public String getStr_app_id() {
		return str_app_id;
	}

	public void setStr_app_id(String str_app_id) {
		this.str_app_id = str_app_id;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public int getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}

	public int getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(int num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	public String getStr_cancel_date() {
		return str_cancel_date;
	}

	public void setStr_cancel_date(String str_cancel_date) {
		this.str_cancel_date = str_cancel_date;
	}

	public String getStr_application_id_ref() {
		return str_application_id_ref;
	}

	public void setStr_application_id_ref(String str_application_id_ref) {
		this.str_application_id_ref = str_application_id_ref;
	}


	
}
