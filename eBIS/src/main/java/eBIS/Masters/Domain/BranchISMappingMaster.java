package eBIS.Masters.Domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name="gblt_branch_is_mapping", schema="bis_dev")
public class BranchISMappingMaster {

	@Id
	@Column(name="num_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gblt_branch_is_mapping")
	@TableGenerator(
			initialValue=1,
			name = "gblt_branch_is_mapping",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="gblt_branch_is_mapping",
	        allocationSize = 1        
	)
	private int num_id;
	
	@Column(name="num_branch_id")
	int num_branch_id;
	
	
	@Column(name="str_product_id")
	String str_product_id;
	
	
	@Column(name="str_standard_number")
	String str_standard_number;
	
	
	@Column(name="str_standard_no")
	String str_standard_no;
	
	
	@Column(name="num_standard_year")
	int num_standard_year;
	
	@Column(name="num_is_valid")
	int num_is_valid=1;
	
	@Column(name="str_entry_emp_id")
	String str_entry_emp_id;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date=new Date();

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public String getStr_product_id() {
		return str_product_id;
	}

	public void setStr_product_id(String str_product_id) {
		this.str_product_id = str_product_id;
	}

	public String getStr_standard_number() {
		return str_standard_number;
	}

	public void setStr_standard_number(String str_standard_number) {
		this.str_standard_number = str_standard_number;
	}

	public String getStr_standard_no() {
		return str_standard_no;
	}

	public void setStr_standard_no(String str_standard_no) {
		this.str_standard_no = str_standard_no;
	}

	public int getNum_standard_year() {
		return num_standard_year;
	}

	public void setNum_standard_year(int num_standard_year) {
		this.num_standard_year = num_standard_year;
	}

	public int getNum_is_valid() {
		return num_is_valid;
	}

	public void setNum_is_valid(int num_is_valid) {
		this.num_is_valid = num_is_valid;
	}

	public String getStr_entry_emp_id() {
		return str_entry_emp_id;
	}

	public void setStr_entry_emp_id(String str_entry_emp_id) {
		this.str_entry_emp_id = str_entry_emp_id;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	
}
