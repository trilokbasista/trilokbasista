package eBIS.Schemes.HallMarking.Jeweller.ApplicationSubmission.Model;

import java.util.Arrays;

public class NSWSBasicJewellerDetailsRegistrationModel {
	private String nsws_unique_username = "";
	private String nsws_unique_application_id = "";
	private String manak_access_token = "";
	private String nswsUserFirstName = "";
	private String nswsUserMiddleName = "";
	private String nswsUserLastName = "";
	private String nswsUserDOB = "";
	private String nswsUserEmail = "";
	private String nswsUserMobile = "";
	private String application_for;
	private int num_outlet = 1;
	private int sector;
	private String firmName;
	private String typeFirm;
	private String address1;
	private String address2;
	private int countryId = 91;
	private int stateId;
	private int districtId;
	private int cityId;
	private String pinCode;
	private String turnOver;
	private String latitude;
	private String longitude;
	private String gstNo;
	private String isTurnoverLT40;
	private String[] nameMgmt;
	private String[] desigMgmt;
	private String[] authSigMgmt;
	private String nameContact;
	private String desigContact;
	private String mobContact;
	private String emailContact;
	private String telephontContact;
	private String preLicenceDetails;
	private String preConvictionDetails;
	private int branchId;
	private String appId;
	private int applicationStatus = 27;
	private Long userId;
	private String stndrdyr;
	private String receiptNo;
	private String appIdref;
	private String nswsAppId;
	private String partyCode;
	private String appliedYear;
	private String feePaidYears;
	private String outletType;
	private String[] certificatenoPrevious;
	private String[] productPreviuos;
	private String[] previousIsNo;
	private String[] prevoiusValidity;
	private String[] preCancelCertificateNo;
	private String[] preCancelproduct;
	private String[] preCancelIsNo;
	private String[] preCancelDateCancellation;
	private String[] preCancelDetails;
	private String[] preconvictionCertificateNo;
	private String[] preconvictionproduct;
	private String[] preconvictionIsNo;
	private String[] preconvictionDate;
	private String[] preconvictionDetails;

	public String getManak_access_token() {
		return manak_access_token;
	}

	public void setManak_access_token(String manak_access_token) {
		this.manak_access_token = manak_access_token;
	}

	public String getApplication_for() {
		return application_for;
	}

	public void setApplication_for(String application_for) {
		this.application_for = application_for;
	}

	public int getNum_outlet() {
		return num_outlet;
	}

	public void setNum_outlet(int num_outlet) {
		this.num_outlet = num_outlet;
	}

	public int getSector() {
		return sector;
	}

	public void setSector(int sector) {
		this.sector = sector;
	}

	public String getFirmName() {
		return firmName;
	}

	public void setFirmName(String firmName) {
		this.firmName = firmName;
	}

	public String getTypeFirm() {
		return typeFirm;
	}

	public void setTypeFirm(String typeFirm) {
		this.typeFirm = typeFirm;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public int getCountryId() {
		return countryId;
	}

	public void setCountryId(int countryId) {
		this.countryId = countryId;
	}

	public int getStateId() {
		return stateId;
	}

	public void setStateId(int stateId) {
		this.stateId = stateId;
	}

	public int getDistrictId() {
		return districtId;
	}

	public void setDistrictId(int districtId) {
		this.districtId = districtId;
	}

	public int getCityId() {
		return cityId;
	}

	public void setCityId(int cityId) {
		this.cityId = cityId;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getTurnOver() {
		return turnOver;
	}

	public void setTurnOver(String turnOver) {
		this.turnOver = turnOver;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getGstNo() {
		return gstNo;
	}

	public void setGstNo(String gstNo) {
		this.gstNo = gstNo;
	}

	public String getIsTurnoverLT40() {
		return isTurnoverLT40;
	}

	public void setIsTurnoverLT40(String isTurnoverLT40) {
		this.isTurnoverLT40 = isTurnoverLT40;
	}

	public String[] getNameMgmt() {
		return nameMgmt;
	}

	public void setNameMgmt(String[] nameMgmt) {
		this.nameMgmt = nameMgmt;
	}

	public String[] getDesigMgmt() {
		return desigMgmt;
	}

	public void setDesigMgmt(String[] desigMgmt) {
		this.desigMgmt = desigMgmt;
	}

	public String[] getAuthSigMgmt() {
		return authSigMgmt;
	}

	public void setAuthSigMgmt(String[] authSigMgmt) {
		this.authSigMgmt = authSigMgmt;
	}

	public String getNameContact() {
		return nameContact;
	}

	public void setNameContact(String nameContact) {
		this.nameContact = nameContact;
	}

	public String getDesigContact() {
		return desigContact;
	}

	public void setDesigContact(String desigContact) {
		this.desigContact = desigContact;
	}

	public String getMobContact() {
		return mobContact;
	}

	public void setMobContact(String mobContact) {
		this.mobContact = mobContact;
	}

	public String getEmailContact() {
		return emailContact;
	}

	public void setEmailContact(String emailContact) {
		this.emailContact = emailContact;
	}

	public String getTelephontContact() {
		return telephontContact;
	}

	public void setTelephontContact(String telephontContact) {
		this.telephontContact = telephontContact;
	}

	public String getPreLicenceDetails() {
		return preLicenceDetails;
	}

	public void setPreLicenceDetails(String preLicenceDetails) {
		this.preLicenceDetails = preLicenceDetails;
	}

	public String getPreConvictionDetails() {
		return preConvictionDetails;
	}

	public void setPreConvictionDetails(String preConvictionDetails) {
		this.preConvictionDetails = preConvictionDetails;
	}

	public int getBranchId() {
		return branchId;
	}

	public void setBranchId(int branchId) {
		this.branchId = branchId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public int getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getStndrdyr() {
		return stndrdyr;
	}

	public void setStndrdyr(String stndrdyr) {
		this.stndrdyr = stndrdyr;
	}

	public String getReceiptNo() {
		return receiptNo;
	}

	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}

	public String getAppIdref() {
		return appIdref;
	}

	public void setAppIdref(String appIdref) {
		this.appIdref = appIdref;
	}

	public String getNswsAppId() {
		return nswsAppId;
	}

	public void setNswsAppId(String nswsAppId) {
		this.nswsAppId = nswsAppId;
	}

	public String getPartyCode() {
		return partyCode;
	}

	public void setPartyCode(String partyCode) {
		this.partyCode = partyCode;
	}

	public String getAppliedYear() {
		return appliedYear;
	}

	public void setAppliedYear(String appliedYear) {
		this.appliedYear = appliedYear;
	}

	public String getFeePaidYears() {
		return feePaidYears;
	}

	public void setFeePaidYears(String feePaidYears) {
		this.feePaidYears = feePaidYears;
	}

	public String[] getCertificatenoPrevious() {
		return certificatenoPrevious;
	}

	public void setCertificatenoPrevious(String[] certificatenoPrevious) {
		this.certificatenoPrevious = certificatenoPrevious;
	}

	public String[] getProductPreviuos() {
		return productPreviuos;
	}

	public void setProductPreviuos(String[] productPreviuos) {
		this.productPreviuos = productPreviuos;
	}

	public String[] getPreviousIsNo() {
		return previousIsNo;
	}

	public void setPreviousIsNo(String[] previousIsNo) {
		this.previousIsNo = previousIsNo;
	}

	public String[] getPrevoiusValidity() {
		return prevoiusValidity;
	}

	public void setPrevoiusValidity(String[] prevoiusValidity) {
		this.prevoiusValidity = prevoiusValidity;
	}

	public String[] getPreCancelCertificateNo() {
		return preCancelCertificateNo;
	}

	public void setPreCancelCertificateNo(String[] preCancelCertificateNo) {
		this.preCancelCertificateNo = preCancelCertificateNo;
	}

	public String[] getPreCancelproduct() {
		return preCancelproduct;
	}

	public void setPreCancelproduct(String[] preCancelproduct) {
		this.preCancelproduct = preCancelproduct;
	}

	public String[] getPreCancelIsNo() {
		return preCancelIsNo;
	}

	public void setPreCancelIsNo(String[] preCancelIsNo) {
		this.preCancelIsNo = preCancelIsNo;
	}

	public String[] getPreCancelDateCancellation() {
		return preCancelDateCancellation;
	}

	public void setPreCancelDateCancellation(String[] preCancelDateCancellation) {
		this.preCancelDateCancellation = preCancelDateCancellation;
	}

	public String[] getPreCancelDetails() {
		return preCancelDetails;
	}

	public void setPreCancelDetails(String[] preCancelDetails) {
		this.preCancelDetails = preCancelDetails;
	}

	public String[] getPreconvictionCertificateNo() {
		return preconvictionCertificateNo;
	}

	public void setPreconvictionCertificateNo(String[] preconvictionCertificateNo) {
		this.preconvictionCertificateNo = preconvictionCertificateNo;
	}

	public String[] getPreconvictionproduct() {
		return preconvictionproduct;
	}

	public void setPreconvictionproduct(String[] preconvictionproduct) {
		this.preconvictionproduct = preconvictionproduct;
	}

	public String[] getPreconvictionIsNo() {
		return preconvictionIsNo;
	}

	public void setPreconvictionIsNo(String[] preconvictionIsNo) {
		this.preconvictionIsNo = preconvictionIsNo;
	}

	public String[] getPreconvictionDate() {
		return preconvictionDate;
	}

	public void setPreconvictionDateconvictionlation(String[] preconvictionDate) {
		this.preconvictionDate = preconvictionDate;
	}

	public String[] getPreconvictionDetails() {
		return preconvictionDetails;
	}

	public void setPreconvictionDetails(String[] preconvictionDetails) {
		this.preconvictionDetails = preconvictionDetails;
	}

	public String getOutletType() {
		return outletType;
	}

	public void setOutletType(String outletType) {
		this.outletType = outletType;
	}

	public void setPreconvictionDate(String[] preconvictionDate) {
		this.preconvictionDate = preconvictionDate;
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
		return "NSWSBasicJewellerDetailsRegistrationModel [nsws_unique_username=" + nsws_unique_username
				+ ", nsws_unique_application_id=" + nsws_unique_application_id + ", manak_access_token="
				+ manak_access_token + ", nswsUserFirstName=" + nswsUserFirstName + ", nswsUserMiddleName="
				+ nswsUserMiddleName + ", nswsUserLastName=" + nswsUserLastName + ", nswsUserDOB=" + nswsUserDOB
				+ ", nswsUserEmail=" + nswsUserEmail + ", nswsUserMobile=" + nswsUserMobile + ", application_for="
				+ application_for + ", num_outlet=" + num_outlet + ", sector=" + sector + ", firmName=" + firmName
				+ ", typeFirm=" + typeFirm + ", address1=" + address1 + ", address2=" + address2 + ", countryId="
				+ countryId + ", stateId=" + stateId + ", districtId=" + districtId + ", cityId=" + cityId
				+ ", pinCode=" + pinCode + ", turnOver=" + turnOver + ", latitude=" + latitude + ", longitude="
				+ longitude + ", gstNo=" + gstNo + ", isTurnoverLT40=" + isTurnoverLT40 + ", nameMgmt="
				+ Arrays.toString(nameMgmt) + ", desigMgmt=" + Arrays.toString(desigMgmt) + ", authSigMgmt="
				+ Arrays.toString(authSigMgmt) + ", nameContact=" + nameContact + ", desigContact=" + desigContact
				+ ", mobContact=" + mobContact + ", emailContact=" + emailContact + ", telephontContact="
				+ telephontContact + ", preLicenceDetails=" + preLicenceDetails + ", preConvictionDetails="
				+ preConvictionDetails + ", branchId=" + branchId + ", appId=" + appId + ", applicationStatus="
				+ applicationStatus + ", userId=" + userId + ", stndrdyr=" + stndrdyr + ", receiptNo=" + receiptNo
				+ ", appIdref=" + appIdref + ", nswsAppId=" + nswsAppId + ", partyCode=" + partyCode + ", appliedYear="
				+ appliedYear + ", feePaidYears=" + feePaidYears + ", outletType=" + outletType
				+ ", certificatenoPrevious=" + Arrays.toString(certificatenoPrevious) + ", productPreviuos="
				+ Arrays.toString(productPreviuos) + ", previousIsNo=" + Arrays.toString(previousIsNo)
				+ ", prevoiusValidity=" + Arrays.toString(prevoiusValidity) + ", preCancelCertificateNo="
				+ Arrays.toString(preCancelCertificateNo) + ", preCancelproduct=" + Arrays.toString(preCancelproduct)
				+ ", preCancelIsNo=" + Arrays.toString(preCancelIsNo) + ", preCancelDateCancellation="
				+ Arrays.toString(preCancelDateCancellation) + ", preCancelDetails=" + Arrays.toString(preCancelDetails)
				+ ", preconvictionCertificateNo=" + Arrays.toString(preconvictionCertificateNo)
				+ ", preconvictionproduct=" + Arrays.toString(preconvictionproduct) + ", preconvictionIsNo="
				+ Arrays.toString(preconvictionIsNo) + ", preconvictionDate=" + Arrays.toString(preconvictionDate)
				+ ", preconvictionDetails=" + Arrays.toString(preconvictionDetails) + "]";
	}
}
