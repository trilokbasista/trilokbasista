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
@Table(name="gblt_district_mst",schema="bis_dev")
public class DistrictMstDomain implements Serializable {
	

	private static final long serialVersionUID = -6161352923350643521L;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	////////id as auto_generated key///////////////
	
	@Id
	@Column(name="num_district_id", length=3)
	@GeneratedValue(strategy=GenerationType.TABLE, generator="district_mst")
	@TableGenerator(name="district_mst", initialValue = 1, allocationSize = 1)
	int numDistrictId;
	
		
	@Column(name="str_district_name", length=50,nullable = false)
	String districtname;
	
	
	@Column(name="num_isvalid", length=1)
	int IsValid = 1;
	
	
	@Column(name="DT_ENTRY_DATE")
	Date date=new Date();
	
	
	@Column(name="num_STATE_ID", precision=3,nullable = false)
	int numStateId;
	
		
	@Column(name="num_entry_emp_id", length=10)
	long numEntryEmpId;
	
	
	@Column(name="num_branch_id", precision=3,nullable = false)
	int numBranchId;
	
	
	@Column(name="str_mapped_branch_id", length=100,nullable = false)
	String str_mapped_branch_id;
	
	@Column(name="str_state_name", length=60,nullable = false)
	String str_state_name;
	
		
	public int getNumDistrictId() {
		return numDistrictId;
	}

	public int getNumStateId() {
		return numStateId;
	}

	public void setNumStateId(int numStateId) {
		this.numStateId = numStateId;
	}

	public int getNumBranchId() {
		return numBranchId;
	}

	public void setNumBranchId(int numBranchId) {
		this.numBranchId = numBranchId;
	}

	public void setNumDistrictId(int numDistrictId) {
		this.numDistrictId = numDistrictId;
	}

	public String getDistrictname() {
		return districtname;
	}

	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}

	public int getIsValid() {
		return IsValid;
	}

	public void setIsValid(int isValid) {
		IsValid = isValid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public long getNumEntryEmpId() {
		return numEntryEmpId;
	}

	public void setNumEntryEmpId(long numEntryEmpId) {
		this.numEntryEmpId = numEntryEmpId;
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

	
		
	
	
	
}