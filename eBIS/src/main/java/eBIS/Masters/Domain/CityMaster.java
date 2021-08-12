package eBIS.Masters.Domain;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;




@Entity
@Table(name="gblt_city_mst", schema="bis_dev")
public class CityMaster  {

	
	@Id
	@Column(name="num_city_id", length=100)
	private int num_city_id;
	
	@Column(name="str_city_name", length=200)
	String str_city_name;
	
	@Column(name="num_pic_code", length=15)
	private int num_pic_code;
	
	@Column(name="str_taluk_name", length=200)
	String str_taluk_name;
	
	@Column(name="str_district_name", length=200)
	String str_district_name;
	
	@Column(name="str_state_name", length = 200)
	String str_state_name;
	
	@Column(name="num_district_id", length=5)
	private int num_district_id;
	
	@Column(name="num_state_id", length=5)
	private int num_state_id;
	
	@Column(name="num_isvalid",length=1)
	private int num_isvalid=1;
	
	@Column(name="num_entry_emp_id", length=10)
	private int num_entry_emp_id;

	public int getNum_city_id() {
		return num_city_id;
	}

	public void setNum_city_id(int num_city_id) {
		this.num_city_id = num_city_id;
	}

	public String getStr_city_name() {
		return str_city_name;
	}

	public void setStr_city_name(String str_city_name) {
		this.str_city_name = str_city_name;
	}

	public int getNum_pic_code() {
		return num_pic_code;
	}

	public void setNum_pic_code(int num_pic_code) {
		this.num_pic_code = num_pic_code;
	}

	public String getStr_taluk_name() {
		return str_taluk_name;
	}

	public void setStr_taluk_name(String str_taluk_name) {
		this.str_taluk_name = str_taluk_name;
	}

	public String getStr_district_name() {
		return str_district_name;
	}

	public void setStr_district_name(String str_district_name) {
		this.str_district_name = str_district_name;
	}

	public String getStr_state_name() {
		return str_state_name;
	}

	public void setStr_state_name(String str_state_name) {
		this.str_state_name = str_state_name;
	}

	public int getNum_district_id() {
		return num_district_id;
	}

	public void setNum_district_id(int num_district_id) {
		this.num_district_id = num_district_id;
	}

	public int getNum_state_id() {
		return num_state_id;
	}

	public void setNum_state_id(int num_state_id) {
		this.num_state_id = num_state_id;
	}

	public int getNum_isvalid() {
		return num_isvalid;
	}

	public void setNum_isvalid(int num_isvalid) {
		this.num_isvalid = num_isvalid;
	}

	public int getNum_entry_emp_id() {
		return num_entry_emp_id;
	}

	public void setNum_entry_emp_id(int num_entry_emp_id) {
		this.num_entry_emp_id = num_entry_emp_id;
	}

	@Override
	public String toString() {
		return "CityMaster [num_city_id=" + num_city_id + ", str_city_name=" + str_city_name + ", num_pic_code="
				+ num_pic_code + ", str_taluk_name=" + str_taluk_name + ", str_district_name=" + str_district_name
				+ ", str_state_name=" + str_state_name + ", num_district_id=" + num_district_id + ", num_state_id="
				+ num_state_id + ", num_isvalid=" + num_isvalid + ", num_entry_emp_id=" + num_entry_emp_id + "]";
	}

	
}
