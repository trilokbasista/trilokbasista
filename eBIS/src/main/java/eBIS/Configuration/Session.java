//package eBIS.Configuration;
//
//import java.util.HashMap;
//import org.joda.time.DateTime;
//
//public class Session {
//	int userid;
//	String username;
//	String EncPassword;
//	String fname;
//	String mname;
//	String lname;
//	String current_role;
//	String other_roles="";
//	String strUserForms;   	//Save all the forms assigned to the user
//	String strMasterForms;	//Save the forms with the type Master
//	String strReportForms;	//Save the forms with the type Master
//	String strOtherForms;	//Save the forms with the type Master
//	String [] strTabs;		//Save all the Tab urls assigned to the user
////	List<TilesModel> listUserTabs;
//	String strRoleName;		//Save the user's role name   
//	String stUserType;
//	String nameOfInsp="";
//	int iLogId;
//	DateTime dtLastLoginTime;	//Last Login Time for Notifications
//	int location_id;
//	int location_type;
//	int location_id_old;	//Used to Backup current location ID
//	int location_type_old;	//Used to Backup current location type ID
//	int orgLocation_type;	//orignal location type ID
//	int orgLocation_id;		//orignal location ID
//	String recognitionNo;
//	HashMap<String, String> csrfTokenStore;
//	HashMap<String, String> letterEditorData;
//	
//	//added by vivek thandle
//	private String tomcatSessionId;
//	private String browserInfo;
//	private String sessionId;
//	private String encSessionId;
//	private String encUserId;
//	
//	//added by Mahendra for LIMS session handle
//	private String authTokenForLIMS;
//	
//	
//	
//	public String getAuthTokenForLIMS() {
//		return authTokenForLIMS;
//	}
//	public String setAuthTokenForLIMS(String authTokenForLIMS) {
//		return this.authTokenForLIMS = authTokenForLIMS;
//	}
//	public String getRecognitionNo() {
//		return recognitionNo;
//	}
//	public void setRecognitionNo(String recognitionNo) {
//		this.recognitionNo = recognitionNo;
//	}
//	public String getStUserType() {
//		return stUserType;
//	}
//	public void setStUserType(String stUserType) {
//		this.stUserType = stUserType;
//	}
//	public String getStrRoleName() {
//		return strRoleName;
//	}
//	public void setStrRoleName(String strRoleName) {
//		this.strRoleName = strRoleName;
//	}
//	public String[] getStrTabs() {
//		return strTabs;
//	}
//	public void setStrTabs(String[] strTabs) {
//		this.strTabs = strTabs;
//	}
//	public String getStrUserForms() {
//		return strUserForms;
//	}
//	public void setStrUserForms(String strUserForms) {
//		this.strUserForms = strUserForms;
//	}
//	public int getLocation_id() {
//		return location_id;
//	}
//	public void setLocation_id(int location_id) {
//		this.location_id = location_id;
//	}
//	public int getLocation_type() {
//		return location_type;
//	}
//	public void setLocation_type(int location_type) {
//		this.location_type = location_type;
//	}
//	public String getEncPassword() {
//		return EncPassword;
//	}
//	public void setEncPassword(String encPassword) {
//		EncPassword = encPassword;
//	}
//	public int getiLogId() {
//		return iLogId;
//	}
//	public void setiLogId(int iLogId) {
//		this.iLogId = iLogId;
//	}
//	public String getCurrent_role() {
//		return current_role;
//	}
//	public void setCurrent_role(String current_role) {
//		this.current_role = current_role;
//	}
//	
//	public String getOther_roles() {
//		return other_roles;
//	}
//	public void setOther_roles(String other_roles) {
//		this.other_roles = other_roles;
//	}
//	public int getUserid() {
//		return userid;
//	}
//	public void setUserid(int userid) {
//		this.userid = userid;
//	}
//	public String getUsername() {
//		return username;
//	}
//	public void setUsername(String username) {
//		this.username = username;
//	}
//	public String getFname() {
//		return fname;
//	}
//	public void setFname(String fname) {
//		this.fname = fname;
//	}
//	public String getLname() {
//		return lname;
//	}
//	public void setLname(String lname) {
//		this.lname = lname;
//	}
////	public List<TilesModel> getListUserTabs() {
////		return listUserTabs;
////	}
////	public void setListUserTabs(List<TilesModel> listUserTabs) {
////		this.listUserTabs = listUserTabs;
////	}
//	
//	
//	public String getNameOfInsp() {
//		return nameOfInsp;
//	}
//	public void setNameOfInsp(String nameOfInsp) {
//		this.nameOfInsp = nameOfInsp;
//	}
//	public String getStrMasterForms() {
//		return strMasterForms;
//	}
//	public void setStrMasterForms(String strMasterForms) {
//		this.strMasterForms = strMasterForms;
//	}
//	public String getStrReportForms() {
//		return strReportForms;
//	}
//	public void setStrReportForms(String strReportForms) {
//		this.strReportForms = strReportForms;
//	}
//	public String getStrOtherForms() {
//		return strOtherForms;
//	}
//	public void setStrOtherForms(String strOtherForms) {
//		this.strOtherForms = strOtherForms;
//	}
//	public HashMap<String, String> getCsrfTokenStore() {
//		return csrfTokenStore;
//	}
//	public void setCsrfTokenStore(HashMap<String, String> csrfTokenStore) {
//		this.csrfTokenStore = csrfTokenStore;
//	}
//	public int getLocation_id_old() {
//		return location_id_old;
//	}
//	public void setLocation_id_old(int location_id_old) {
//		this.location_id_old = location_id_old;
//	}
//	public int getLocation_type_old() {
//		return location_type_old;
//	}
//	public void setLocation_type_old(int location_type_old) {
//		this.location_type_old = location_type_old;
//	}
//	public int getOrgLocation_type() {
//		return orgLocation_type;
//	}
//	public void setOrgLocation_type(int orgLocation_type) {
//		this.orgLocation_type = orgLocation_type;
//	}
//	public int getOrgLocation_id() {
//		return orgLocation_id;
//	}
//	public void setOrgLocation_id(int orgLocation_id) {
//		this.orgLocation_id = orgLocation_id;
//	}
//	public HashMap<String, String> getLetterEditorData() {
//		return letterEditorData;
//	}
//	public void setLetterEditorData(HashMap<String, String> letterEditorData) {
//		this.letterEditorData = letterEditorData;
//	}
//	public String getMname() {
//		return mname;
//	}
//	public void setMname(String mname) {
//		this.mname = mname;
//	}
//	public DateTime getDtLastLoginTime() {
//		return dtLastLoginTime;
//	}
//	public void setDtLastLoginTime(DateTime dtLastLoginTime) {
//		this.dtLastLoginTime = dtLastLoginTime;
//	}
//	public String getTomcatSessionId() {
//		return tomcatSessionId;
//	}
//	public void setTomcatSessionId(String tomcatSessionId) {
//		this.tomcatSessionId = tomcatSessionId;
//	}
//	public String getBrowserInfo() {
//		return browserInfo;
//	}
//	public void setBrowserInfo(String browserInfo) {
//		this.browserInfo = browserInfo;
//	}
//	public String getSessionId() {
//		return sessionId;
//	}
//	public void setSessionId(String sessionId) {
//		this.sessionId = sessionId;
//	}
//	public String getEncSessionId() {
//		return encSessionId;
//	}
//	public void setEncSessionId(String encSessionId) {
//		this.encSessionId = encSessionId;
//	}
//	public String getEncUserId() {
//		return encUserId;
//	}
//	public void setEncUserId(String encUserId) {
//		this.encUserId = encUserId;
//	}
//	public DateTime setDtLastLoginTime2(DateTime dtLastLoginTime) {
//		return this.dtLastLoginTime = dtLastLoginTime;
//	}
//	
//	
//}
