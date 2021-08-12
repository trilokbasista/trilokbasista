package eBIS.nswsAPI.Model;

public class NSWSRegistrationModel {
	private String nswsUniqueUser="";
	private String nswsUserFirstName="";
	private String nswsUserMiddleName="";
	private String nswsUserLastName="";
	private String nswsUserDOB="";
	private String nswsUserEmail="";
	private String nswsUserMobile="";
	public String getNswsUniqueUser() {
		return nswsUniqueUser;
	}
	public void setNswsUniqueUser(String nswsUniqueUser) {
		this.nswsUniqueUser = nswsUniqueUser;
	}
	public String getNswsUserFirstName() {
		return nswsUserFirstName;
	}
	public void setNswsUserFirstName(String nswsUserFirstName) {
		this.nswsUserFirstName = nswsUserFirstName;
	}
	public String getNswsUserMiddleName() {
		return nswsUserMiddleName;
	}
	public void setNswsUserMiddleName(String nswsUserMiddleName) {
		this.nswsUserMiddleName = nswsUserMiddleName;
	}
	public String getNswsUserLastName() {
		return nswsUserLastName;
	}
	public void setNswsUserLastName(String nswsUserLastName) {
		this.nswsUserLastName = nswsUserLastName;
	}
	public String getNswsUserDOB() {
		return nswsUserDOB;
	}
	public void setNswsUserDOB(String nswsUserDOB) {
		this.nswsUserDOB = nswsUserDOB;
	}
	public String getNswsUserEmail() {
		return nswsUserEmail;
	}
	public void setNswsUserEmail(String nswsUserEmail) {
		this.nswsUserEmail = nswsUserEmail;
	}
	public String getNswsUserMobile() {
		return nswsUserMobile;
	}
	public void setNswsUserMobile(String nswsUserMobile) {
		this.nswsUserMobile = nswsUserMobile;
	}
	@Override
	public String toString() {
		return "NSWSRegistrationModel [nswsUniqueUser=" + nswsUniqueUser + ", nswsUserFirstName=" + nswsUserFirstName
				+ ", nswsUserMiddleName=" + nswsUserMiddleName + ", nswsUserLastName=" + nswsUserLastName
				+ ", nswsUserDOB=" + nswsUserDOB + ", nswsUserEmail=" + nswsUserEmail + ", nswsUserMobile="
				+ nswsUserMobile + "]";
	}
	
}
