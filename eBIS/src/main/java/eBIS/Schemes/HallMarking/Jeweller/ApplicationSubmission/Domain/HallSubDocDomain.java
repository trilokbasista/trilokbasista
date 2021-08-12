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
@Table(name="hall_subdoc_domain", schema="bis_hall")
public class HallSubDocDomain {
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="hall_subdoc_domain")
	@TableGenerator(initialValue=1, allocationSize=1, name="hall_subdoc_domain")
	@Column(name="num_id")
	int num_id;
	
	@Column(name="str_sub_doc_name")
	String str_sub_doc_name;
	
	@Column(name="num_doc_id")
	int num_doc_id;
	
	@Column(name="num_entry_emp_id", length=10)
	long num_entry_emp_id;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date=new Date();
	
	@Column(name="is_valid")
	int is_valid;

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public String getStr_sub_doc_name() {
		return str_sub_doc_name;
	}

	public void setStr_sub_doc_name(String str_sub_doc_name) {
		this.str_sub_doc_name = str_sub_doc_name;
	}

	public int getNum_doc_id() {
		return num_doc_id;
	}

	public void setNum_doc_id(int num_doc_id) {
		this.num_doc_id = num_doc_id;
	}

	public long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
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

	@Override
	public String toString() {
		return "HallSubDocDomain [num_id=" + num_id + ", str_sub_doc_name=" + str_sub_doc_name + ", num_doc_id="
				+ num_doc_id + ", num_entry_emp_id=" + num_entry_emp_id + ", dt_entry_date=" + dt_entry_date
				+ ", is_valid=" + is_valid + "]";
	}


}
