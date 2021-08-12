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
@Table(name="gblt_sub_scheme_mst", schema="bis_dev")
public class SubSchemeMaster {
	
	private static final long serialVersionUID = 5417354371927066831L;
	
    @Id			
	@GeneratedValue(strategy=GenerationType.TABLE, generator="BIS_SCHEME")
	@TableGenerator(name="BIS_SCHEME", initialValue=1, allocationSize=1)
    @Column (name="NUM_SUB_SCHEME_ID")
	private int num_sub_scheme_id;
    
    @Column(name="STR_SUB_SCHEME_NAME", unique=true)
    String str_sub_scheme_name;
    
    @Column(name="NUM_PARENT_SCHEME_ID")
    int num_parent_scheme_id;

	@Column(name="NUM_ISVALID")
	int num_isvalid=1;
    
    @Column(name="DT_ENTRY_DATE",nullable = true)
    Date dt_entry_date = new Date();         
    
    @Column(name="str_ENTRY_EMP_id")
    long str_entry_emp_name = 0;

	public int getNum_sub_scheme_id() {
		return num_sub_scheme_id;
	}

	public void setNum_sub_scheme_id(int num_sub_scheme_id) {
		this.num_sub_scheme_id = num_sub_scheme_id;
	}

	public String getStr_sub_scheme_name() {
		return str_sub_scheme_name;
	}

	public void setStr_sub_scheme_name(String str_sub_scheme_name) {
		this.str_sub_scheme_name = str_sub_scheme_name;
	}

	public int getNum_parent_scheme_id() {
		return num_parent_scheme_id;
	}

	public void setNum_parent_scheme_id(int num_parent_scheme_id) {
		this.num_parent_scheme_id = num_parent_scheme_id;
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

	public long getStr_entry_emp_name() {
		return str_entry_emp_name;
	}

	public void setStr_entry_emp_name(long str_entry_emp_name) {
		this.str_entry_emp_name = str_entry_emp_name;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}         
  
    
    


}
