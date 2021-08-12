package eBIS.nswsAPI.Model;

public class NSWSAuthenticationModel {
private String nswsId="";
private String nswsKey="";
//private String nswsUniqueUser="";
//private String nswsUserFirstName="";
//private String nswsUserMiddleName="";
//private String nswsUserLastName="";
//private String nswsUserDOB="";
//private String nswsUserEmail="";
//private String nswsUserMobile="";

public String getNswsId() {
	return nswsId;
}
public void setNswsId(String nswsId) {
	this.nswsId = nswsId;
}
public String getNswsKey() {
	return nswsKey;
}
public void setNswsKey(String nswsKey) {
	this.nswsKey = nswsKey;
}

@Override
public String toString() {
	return "NSWSAuthenticationModel [nswsId=" + nswsId + ", nswsKey=" + nswsKey + "]";
}



}
