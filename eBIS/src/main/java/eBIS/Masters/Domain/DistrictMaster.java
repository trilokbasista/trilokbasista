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
@Table(name="gblt_district_mst", schema="bis_dev")
public class DistrictMaster {

	@Id
	@Column(name="num_district_id")
	@GeneratedValue(strategy=GenerationType.TABLE, generator="gblt_district_mst")
	@TableGenerator(
			initialValue=1,
			name = "gblt_district_mst",
	        table = "hibernate_sequences",
	        pkColumnName = "sequence_name",
	        pkColumnValue="gblt_district_mst",
	        allocationSize = 1        
	)
	private int num_district_id;
	
	@Column(name="str_district_name", length=50,nullable = false)
	String str_district_name;
	
	
	@Column(name="num_isvalid", length=1)
	int num_isvalid = 1;
	
	
	@Column(name="DT_ENTRY_DATE")
	Date dt_entry_date=new Date();
	
	
	@Column(name="num_STATE_ID", precision=3,nullable = false)
	int num_state_id;
	
		
	@Column(name="num_entry_emp_id", length=10)
	long num_entry_emp_id;
	
	
	@Column(name="num_branch_id", precision=3,nullable = false)
	int num_branch_id;
	
	
	@Column(name="str_mapped_branch_id", length=100,nullable = false)
	String str_mapped_branch_id;
	
	@Column(name="str_state_name", length=60,nullable = false)
	String str_state_name;

	public int getNum_district_id() {
		return num_district_id;
	}

	public void setNum_district_id(int num_district_id) {
		this.num_district_id = num_district_id;
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

	public int getNum_state_id() {
		return num_state_id;
	}

	public void setNum_state_id(int num_state_id) {
		this.num_state_id = num_state_id;
	}

	public long getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(long num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public String getStr_mapped_branch_id() {
		return str_mapped_branch_id;
	}

	public void setStr_mapped_branch_id(String str_mapped_branch_id) {
		this.str_mapped_branch_id = str_mapped_branch_id;
	}

	public String getStr_state_name() {
		return str_state_name;
	}

	public void setStr_state_name(String str_state_name) {
		this.str_state_name = str_state_name;
	}

	public String getStr_district_name() {
		return str_district_name;
	}

	public void setStr_district_name(String str_district_name) {
		this.str_district_name = str_district_name;
	}
	
}
