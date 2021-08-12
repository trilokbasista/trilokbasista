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
@Table(name = "gblt_branch_mst", schema = "bis_dev")
public class BranchMasterDomain implements Serializable {
	private static final long serialVersionUID = -6161352923350643521L;

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "gblt_branch_mst")
	@TableGenerator(initialValue = 1, allocationSize = 1, name = "gblt_branch_mst")
	@Column(name = "str_branch_code", length = 25)
	int str_branch_code;

	@Column(name = "num_branch_id", length = 3)
	int numBranchId;

	public int getNumBranchId() {
		return numBranchId;
	}

	public void setNumBranchId(int numBranchId) {
		this.numBranchId = numBranchId;
	}

	@Column(name = "num_ro_id", length = 2)
	int numRoId;

	public int getNumRoId() {
		return numRoId;
	}

	public void setNumRoId(int numRoId) {
		this.numRoId = numRoId;
	}

	@Column(name = "str_branch_name", length = 100)
	String strBranchName;

	public String getStrBranchName() {
		return strBranchName;
	}

	public void setStrBranchName(String strBranchName) {
		this.strBranchName = strBranchName;
	}

	@Column(name = "str_branc_short_Name", length = 10)
	String strBrShortName;

	public String getStrBrShortName() {
		return strBrShortName;
	}

	public void setStrBrShortName(String strBrShortName) {
		this.strBrShortName = strBrShortName;
	}

	@Column(name = "str_branch_detail", length = 200)
	String strBranchDetail;

	public int getStr_branch_code() {
		return str_branch_code;
	}

	public void setStr_branch_code(int str_branch_code) {
		this.str_branch_code = str_branch_code;
	}
	
	public String getStrBranchDetail() {
		return strBranchDetail;
	}

	public void setStrBranchDetail(String strBranchDetail) {
		this.strBranchDetail = strBranchDetail;
	}

	@Column(name = "str_address1", length = 200)
	String address1;

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "str_address2", length = 200)
	String address2;

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/*
	 * @Column(name="str_address3") String address3; public String getAddress3() {
	 * return address3; } public void setAddress3(String address3) { this.address3 =
	 * address3; }
	 */

	@Column(name = "str_city", length = 100)
	String strCity;

	public String getStrCity() {
		return strCity;
	}

	public void setStrCity(String strCity) {
		this.strCity = strCity;
	}

	@Column(name = "num_district_id", length = 3)
	int numDistrId;

	public int getNumDistrId() {
		return numDistrId;
	}

	public void setNumDistrId(int numDistrId) {
		this.numDistrId = numDistrId;
	}

	@Column(name = "num_pincode", length = 8)
	int numPincode;

	public int getNumPincode() {
		return numPincode;
	}

	public void setNumPincode(int numPincode) {
		this.numPincode = numPincode;
	}

	// foreign key branch head//

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name="num_branch_head", nullable=false) Emp_Mst_Domain
	 * branMstdom;
	 */
	@Column(name = "num_branch_head", length = 10)
	long numBranchHead;

	public long getNumBranchHead() {
		return numBranchHead;
	}

	public void setNumBranchHead(long numBranchHead) {
		this.numBranchHead = numBranchHead;
	}

	@Column(name = "str_branch_contact", length = 100)
	String strBranchContact;

	public String getStrBranchContact() {
		return strBranchContact;
	}

	public void setStrBranchContact(String strBranchContact) {
		this.strBranchContact = strBranchContact;
	}

	@Column(name = "str_branch_fax", length = 50)
	String strBranchFax;

	public String getStrBranchFax() {
		return strBranchFax;
	}

	public void setStrBranchFax(String strBranchFax) {
		this.strBranchFax = strBranchFax;
	}

	@Column(name = "str_branch_mail", length = 50)
	String strBranchMail;

	public String getStrBranchMail() {
		return strBranchMail;
	}

	public void setStrBranchMail(String strBranchMail) {
		this.strBranchMail = strBranchMail;
	}

	@Column(name = "str_branch_hd_mail", length = 50)
	String strBrnHeadMail;

	public String getStrBrnHeadMail() {
		return strBrnHeadMail;
	}

	public void setStrBrnHeadMail(String strBrnHeadMail) {
		this.strBrnHeadMail = strBrnHeadMail;
	}

	@Column(name = "str_username", length = 50)
	String strUsername;

	public String getStrUsername() {
		return strUsername;
	}

	public void setStrUsername(String strUsername) {
		this.strUsername = strUsername;
	}

	@Column(name = "num_isvalid", length = 1)
	int IsValid = 1;

	public int getIsValid() {
		return IsValid;
	}

	public void setIsValid(int isValid) {
		IsValid = isValid;
	}

	@Column(name = "num_entry_emp_id")
	long strEntryEmpId;

	@Column(name = "dt_entry_date")
	Date date = new Date();

	public long getStrEntryEmpId() {
		return strEntryEmpId;
	}

	public void setStrEntryEmpId(long strEntryEmpId) {
		this.strEntryEmpId = strEntryEmpId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Column(name = "num_state_id", length = 2)
	int numStateId;

	public int getNumStateId() {
		return numStateId;
	}

	public void setNumStateId(int numStateId) {
		this.numStateId = numStateId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name = "str_gst_no", length = 50)
	private String gstNumber;
	@Column(name = "str_pan", length = 20)
	private String panNumber;

	public String getGstNumber() {
		return gstNumber;
	}

	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

}
