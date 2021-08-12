package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;


@Entity
@Table(name="user_sub_scheme_map",schema="bis_dev")
public class UserSubSchemeMappingDomain implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5268079205202886047L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="degree")
	@TableGenerator(initialValue=1, allocationSize=1, name="degree")
	@Column(name="num_id")
	int num_id;
	
	@Column(name="num_sub_scheme_id",length=12)
	int num_sub_scheme_id;
	
	@Column(name="num_branch_id",length=2)
	int num_branch_id=0;
	
	@Column(name="str_application_id")
	String str_application_id;
	
	@Column(name="num_user_id",length=2)
	int num_user_id=0;
	
	@Column(name="dt_entry_date")
	Date dt_entry_date=new Date();

	public int getNum_id() {
		return num_id;
	}

	public void setNum_id(int num_id) {
		this.num_id = num_id;
	}
	
	public int getNum_sub_scheme_id() {
		return num_sub_scheme_id;
	}

	public void setNum_sub_scheme_id(int num_sub_scheme_id) {
		this.num_sub_scheme_id = num_sub_scheme_id;
	}

	public int getNum_branch_id() {
		return num_branch_id;
	}

	public void setNum_branch_id(int num_branch_id) {
		this.num_branch_id = num_branch_id;
	}

	public String getStr_application_id() {
		return str_application_id;
	}

	public void setStr_application_id(String str_application_id) {
		this.str_application_id = str_application_id;
	}

	public int getNum_user_id() {
		return num_user_id;
	}

	public void setNum_user_id(int num_user_id) {
		this.num_user_id = num_user_id;
	}

	public Date getDt_entry_date() {
		return dt_entry_date;
	}

	public void setDt_entry_date(Date dt_entry_date) {
		this.dt_entry_date = dt_entry_date;
	}
	
	

}
