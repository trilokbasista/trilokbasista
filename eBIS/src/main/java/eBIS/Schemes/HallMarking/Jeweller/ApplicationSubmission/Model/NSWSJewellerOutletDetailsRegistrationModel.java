package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model;

import java.util.Arrays;

public class NSWSJewellerOutletDetailsRegistrationModel {

	private String nsws_unique_username="";
	private String nsws_unique_application_id="";
	private String manak_access_token="";
	private String [] outletName;
	private int [] turnover;
	private String [] address1outlet;
	private String [] address2outlet;
	private int [] countryId;
	private int [] stateId;
	private int [] districtId;
	private int [] cityId;
	private String [] pinCode;
	private String [] latitude;
	private String [] longitude;
	private String [] nameContact;
	private String [] mobContact;
	private String [] telephoneContact;
	private String [] emailContact;
	private Long userId=(long) 0;
	private String hmAppid="";
	private String [] addressProofDocType;
	private int branchId=0;
	private String stdYr="";
	private String isNo="";
	private String cmlno="";
	
	public String[] getOutletName() {
		return outletName;
	}
	public void setOutletName(String[] outletName) {
		this.outletName = outletName;
	}
	public int[] getTurnover() {
		return turnover;
	}
	public void setTurnover(int[] turnover) {
		this.turnover = turnover;
	}
	public String[] getAddress1outlet() {
		return address1outlet;
	}
	public void setAddress1outlet(String[] address1outlet) {
		this.address1outlet = address1outlet;
	}
	public String[] getAddress2outlet() {
		return address2outlet;
	}
	public void setAddress2outlet(String[] address2outlet) {
		this.address2outlet = address2outlet;
	}
	public int[] getCountryId() {
		return countryId;
	}
	public void setCountryId(int[] countryId) {
		this.countryId = countryId;
	}
	public int[] getStateId() {
		return stateId;
	}
	public void setStateId(int[] stateId) {
		this.stateId = stateId;
	}
	public int[] getDistrictId() {
		return districtId;
	}
	public void setDistrictId(int[] districtId) {
		this.districtId = districtId;
	}
	public int[] getCityId() {
		return cityId;
	}
	public void setCityId(int[] cityId) {
		this.cityId = cityId;
	}
	public String[] getPinCode() {
		return pinCode;
	}
	public void setPinCode(String[] pinCode) {
		this.pinCode = pinCode;
	}
	public String[] getLatitude() {
		return latitude;
	}
	public void setLatitude(String[] latitude) {
		this.latitude = latitude;
	}
	public String[] getLongitude() {
		return longitude;
	}
	public void setLongitude(String[] longitude) {
		this.longitude = longitude;
	}
	public String[] getNameContact() {
		return nameContact;
	}
	public void setNameContact(String[] nameContact) {
		this.nameContact = nameContact;
	}
	public String[] getMobContact() {
		return mobContact;
	}
	public void setMobContact(String[] mobContact) {
		this.mobContact = mobContact;
	}
	public String[] getTelephoneContact() {
		return telephoneContact;
	}
	public void setTelephoneContact(String[] telephoneContact) {
		this.telephoneContact = telephoneContact;
	}
	public String[] getEmailContact() {
		return emailContact;
	}
	public void setEmailContact(String[] emailContact) {
		this.emailContact = emailContact;
	}

	public String getManak_access_token() {
		return manak_access_token;
	}
	public void setManak_access_token(String manak_access_token) {
		this.manak_access_token = manak_access_token;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getHmAppid() {
		return hmAppid;
	}
	public void setHmAppid(String hmAppid) {
		this.hmAppid = hmAppid;
	}
	public String[] getAddressProofDocType() {
		return addressProofDocType;
	}
	public void setAddressProofDocType(String[] addressProofDocType) {
		this.addressProofDocType = addressProofDocType;
	}
	public int getBranchId() {
		return branchId;
	}
	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}
	public String getStdYr() {
		return stdYr;
	}
	public void setStdYr(String stdYr) {
		this.stdYr = stdYr;
	}
	public String getIsNo() {
		return isNo;
	}
	public void setIsNo(String isNo) {
		this.isNo = isNo;
	}
	public String getNsws_unique_username() {
		return nsws_unique_username;
	}
	public void setNsws_unique_username(String nsws_unique_username) {
		this.nsws_unique_username = nsws_unique_username;
	}
	public String getNsws_unique_application_id() {
		return nsws_unique_application_id;
	}
	public void setNsws_unique_application_id(String nsws_unique_application_id) {
		this.nsws_unique_application_id = nsws_unique_application_id;
	}
	public String getCmlno() {
		return cmlno;
	}
	public void setCmlno(String cmlno) {
		this.cmlno = cmlno;
	}
	
	@Override
	public String toString() {
		return "NSWSJewellerOutletDetailsRegistrationModel [nsws_unique_username=" + nsws_unique_username
				+ ", nsws_unique_application_id=" + nsws_unique_application_id + ", manak_access_token="
				+ manak_access_token + ", outletName=" + Arrays.toString(outletName) + ", turnover="
				+ Arrays.toString(turnover) + ", address1outlet=" + Arrays.toString(address1outlet)
				+ ", address2outlet=" + Arrays.toString(address2outlet) + ", countryId=" + Arrays.toString(countryId)
				+ ", stateId=" + Arrays.toString(stateId) + ", districtId=" + Arrays.toString(districtId) + ", cityId="
				+ Arrays.toString(cityId) + ", pinCode=" + Arrays.toString(pinCode) + ", latitude="
				+ Arrays.toString(latitude) + ", longitude=" + Arrays.toString(longitude) + ", nameContact="
				+ Arrays.toString(nameContact) + ", mobContact=" + Arrays.toString(mobContact) + ", telephoneContact="
				+ Arrays.toString(telephoneContact) + ", emailContact=" + Arrays.toString(emailContact) + ", userId="
				+ userId + ", hmAppid=" + hmAppid + ", addressProofDocType=" + Arrays.toString(addressProofDocType)
				+ ", branchId=" + branchId + ", stdYr=" + stdYr + ", isNo=" + isNo + ", cmlno=" + cmlno + "]";
	}
	
	
}
