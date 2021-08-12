package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model;

import java.util.ArrayList;
import java.util.List;

public class AHCRecognitionApplicationModel {
	String numId;
	String appId;
	String regionId;
	String centerName;
	String offaddr1;
	String offaddr2;
	String offCountry;
	String offState;
	String offDistrict;
	String offMail;
	String offMobNo;
	String ownerName;
	String ownerDesig;
	String rdoAddress;
	String typeOfOwnership;
	String regaddr1;
	String regaddr2;
	String regCountry;
	String regState;
	String regDistrict;
	String regMail;
	String regMobNo;
	String stCSRFToken;
	String mode;
	private int offCity;	
	private int regCity;
	String typeOwnership;
	String recogAppliedFor;
	int numOCA;
	//Objects for second 2nd page
	
	String namePerQualityMngmtCntr;
	String desigPerQualityMngmtCntr;
	String noOfEmpCenter;
	private String[] arrDepartment;
	private String[] arrDeptName;
	private String[] arrDeptDesig;
	private String[] arrDeptQuali;
	private String[] arrDeptExper;
	private String[] arrDeptTraining;
	private String[] arrDeptDeputyName;
	private String[] idDept;
	String layOutSpace;
	String waterSupplySource;
	String halideFreeWater;
	String powerSupplySource;
	String availableLoad;
	String generatorCapacity;
	String loadRequirement;
	String uninterruptedPower;
	String uninterruptedPowerReason;
	private String[] arrIsNo;
	private String[] arrMethodTest;
	private String[] arrTestFacility;
	private String[] arrModelType;
	private String[] arrRange;
	private String[] arrLeastCount;
	private String[] arrValidity;
	private String[] arrTraceability;
	private String[] arrRemarksAny;
	private String[] idTestEquop;
	
	//for testing eupmet for silver
	private String[] arrIsNo1;	
	private String[] arrTestFacility1;
	private String[] arrModelType1;
	private String[] arrRange1;
	private String[] arrLeastCount1;
	private String[] arrRemarksAny1;
	private String[] idTestEquop1;
	private String[] arrMethodTest1;
	private String[] arrTraceability1;
	private String[] arrValidity1;
	
	
	//for calibrating 
	private int[] numEqipmentMat;
	private String[] arrCalibrate;
	private String[] arrCalibValidUp;
	//objects for third page
	
	String centreAccredited;
	String accreditationValidity;
	String qualityManualImplemented;
	String proficiencyTesting;
	String proficiencyTestingReason;
	String controllingAccess;
	String controllingAccessReason;
	String ensuringSecurity;
	String ensuringSecurityReason;
	String indemnityInsurance;
	String indemnityInsurancePolicy;
	String indemnityInsuranceValidity;
	String indemnityInsuranceAmount;
	String artefactsInsurance;
	String artefactsInsurancePolicy;
	String artefactsInsuranceValidity;
	String artefactsInsuranceAmount;
	String assessmentReadyDt;
	String previousCancellation;
	String ipAddress;
	private String ahcPincode;
	private String officePincode;
	private String ahcLatitude;
	private String ahcLongitude;
	private String electricMeterNumber;		
	String strAssayRroomSpace;
	List<CenterOwnerDetailsDTO> centerOwnerDetailsDTOList = new ArrayList<CenterOwnerDetailsDTO>();
	private String recognitionValidity;	
	private String changesProposedInScopeOfRecognition;
	private String hasChangesProposedInScopeOfRecognition;
	private int applicationStatus;
	private String previousAppId;
    private boolean underTaking;
	String gstin;
	String str_recognition_number;
	String num_region_for_recog;
	String str_recognition_farmete = "RAHC/R-";
	String str_app_no;
	private String manak_access_token;
	private String nsws_unique_username = "";
	
	public String getNum_region_for_recog() {
		return num_region_for_recog;
	}
	public void setNum_region_for_recog(String num_region_for_recog) {
		this.num_region_for_recog = num_region_for_recog;
	}
	public String getStr_recognition_farmete() {
		return str_recognition_farmete;
	}
	public void setStr_recognition_farmete(String str_recognition_farmete) {
		this.str_recognition_farmete = str_recognition_farmete;
	}
	public String getGstin() {
		return gstin;
	}
	public void setGstin(String gstin) {
		this.gstin = gstin;
	}
    
	public boolean isUnderTaking() {
		return underTaking;
	}
	public void setUnderTaking(boolean underTaking) {
		this.underTaking = underTaking;
	}
	public String getPreviousAppId() {
		return previousAppId;
	}
	public void setPreviousAppId(String previousAppId) {
		this.previousAppId = previousAppId;
	}
	public String getAhcPincode() {
		return ahcPincode;
	}
	public void setAhcPincode(String ahcPincode) {
		this.ahcPincode = ahcPincode;
	}
	public String getOfficePincode() {
		return officePincode;
	}
	public void setOfficePincode(String officePincode) {
		this.officePincode = officePincode;
	}
	public String getAhcLatitude() {
		return ahcLatitude;
	}
	public void setAhcLatitude(String ahcLatitude) {
		this.ahcLatitude = ahcLatitude;
	}
	public String getAhcLongitude() {
		return ahcLongitude;
	}
	public void setAhcLongitude(String ahcLongitude) {
		this.ahcLongitude = ahcLongitude;
	}	
	

	public String getElectricMeterNumber() {
		return electricMeterNumber;
	}
	public void setElectricMeterNumber(String electricMeterNumber) {
		this.electricMeterNumber = electricMeterNumber;
	}
	public List<CenterOwnerDetailsDTO> getCenterOwnerDetailsDTOList() {
		return centerOwnerDetailsDTOList;
	}
	public void setCenterOwnerDetailsDTOList(List<CenterOwnerDetailsDTO> centerOwnerDetailsDTOList) {
		this.centerOwnerDetailsDTOList = centerOwnerDetailsDTOList;
	}
	public int[] getNumEqipmentMat() {
		return numEqipmentMat;
	}
	public void setNumEqipmentMat(int[] numEqipmentMat) {
		this.numEqipmentMat = numEqipmentMat;
	}
	public String[] getArrCalibrate() {
		return arrCalibrate;
	}
	public void setArrCalibrate(String[] arrCalibrate) {
		this.arrCalibrate = arrCalibrate;
	}
	public String[] getArrCalibValidUp() {
		return arrCalibValidUp;
	}
	public void setArrCalibValidUp(String[] arrCalibValidUp) {
		this.arrCalibValidUp = arrCalibValidUp;
	}
	public String[] getArrIsNo1() {
		return arrIsNo1;
	}
	public void setArrIsNo1(String[] arrIsNo1) {
		this.arrIsNo1 = arrIsNo1;
	}
	public String[] getArrTestFacility1() {
		return arrTestFacility1;
	}
	public void setArrTestFacility1(String[] arrTestFacility1) {
		this.arrTestFacility1 = arrTestFacility1;
	}
	public String[] getArrModelType1() {
		return arrModelType1;
	}
	public void setArrModelType1(String[] arrModelType1) {
		this.arrModelType1 = arrModelType1;
	}
	public String[] getArrRange1() {
		return arrRange1;
	}
	public void setArrRange1(String[] arrRange1) {
		this.arrRange1 = arrRange1;
	}
	public String[] getArrLeastCount1() {
		return arrLeastCount1;
	}
	public void setArrLeastCount1(String[] arrLeastCount1) {
		this.arrLeastCount1 = arrLeastCount1;
	}
	public String[] getArrRemarksAny1() {
		return arrRemarksAny1;
	}
	public void setArrRemarksAny1(String[] arrRemarksAny1) {
		this.arrRemarksAny1 = arrRemarksAny1;
	}
	public String[] getIdTestEquop1() {
		return idTestEquop1;
	}
	public void setIdTestEquop1(String[] idTestEquop1) {
		this.idTestEquop1 = idTestEquop1;
	}
	public int getNumOCA() {
		return numOCA;
	}
	public void setNumOCA(int numOCA) {
		this.numOCA = numOCA;
	}
	public String getCentreAccredited() {
		return centreAccredited;
	}
	public void setCentreAccredited(String centreAccredited) {
		this.centreAccredited = centreAccredited;
	}
	public String getAccreditationValidity() {
		return accreditationValidity;
	}
	public void setAccreditationValidity(String accreditationValidity) {
		this.accreditationValidity = accreditationValidity;
	}
	public String getQualityManualImplemented() {
		return qualityManualImplemented;
	}
	public void setQualityManualImplemented(String qualityManualImplemented) {
		this.qualityManualImplemented = qualityManualImplemented;
	}
	public String getProficiencyTesting() {
		return proficiencyTesting;
	}
	public void setProficiencyTesting(String proficiencyTesting) {
		this.proficiencyTesting = proficiencyTesting;
	}
	public String getProficiencyTestingReason() {
		return proficiencyTestingReason;
	}
	public void setProficiencyTestingReason(String proficiencyTestingReason) {
		this.proficiencyTestingReason = proficiencyTestingReason;
	}
	public String getControllingAccess() {
		return controllingAccess;
	}
	public void setControllingAccess(String controllingAccess) {
		this.controllingAccess = controllingAccess;
	}
	public String getControllingAccessReason() {
		return controllingAccessReason;
	}
	public void setControllingAccessReason(String controllingAccessReason) {
		this.controllingAccessReason = controllingAccessReason;
	}
	public String getEnsuringSecurity() {
		return ensuringSecurity;
	}
	public void setEnsuringSecurity(String ensuringSecurity) {
		this.ensuringSecurity = ensuringSecurity;
	}
	public String getEnsuringSecurityReason() {
		return ensuringSecurityReason;
	}
	public void setEnsuringSecurityReason(String ensuringSecurityReason) {
		this.ensuringSecurityReason = ensuringSecurityReason;
	}
	public String getIndemnityInsurance() {
		return indemnityInsurance;
	}
	public void setIndemnityInsurance(String indemnityInsurance) {
		this.indemnityInsurance = indemnityInsurance;
	}
	public String getIndemnityInsurancePolicy() {
		return indemnityInsurancePolicy;
	}
	public void setIndemnityInsurancePolicy(String indemnityInsurancePolicy) {
		this.indemnityInsurancePolicy = indemnityInsurancePolicy;
	}
	public String getIndemnityInsuranceValidity() {
		return indemnityInsuranceValidity;
	}
	public void setIndemnityInsuranceValidity(String indemnityInsuranceValidity) {
		this.indemnityInsuranceValidity = indemnityInsuranceValidity;
	}
	public String getIndemnityInsuranceAmount() {
		return indemnityInsuranceAmount;
	}
	public void setIndemnityInsuranceAmount(String indemnityInsuranceAmount) {
		this.indemnityInsuranceAmount = indemnityInsuranceAmount;
	}
	public String getArtefactsInsurance() {
		return artefactsInsurance;
	}
	public void setArtefactsInsurance(String artefactsInsurance) {
		this.artefactsInsurance = artefactsInsurance;
	}
	public String getArtefactsInsurancePolicy() {
		return artefactsInsurancePolicy;
	}
	public void setArtefactsInsurancePolicy(String artefactsInsurancePolicy) {
		this.artefactsInsurancePolicy = artefactsInsurancePolicy;
	}
	public String getArtefactsInsuranceValidity() {
		return artefactsInsuranceValidity;
	}
	public void setArtefactsInsuranceValidity(String artefactsInsuranceValidity) {
		this.artefactsInsuranceValidity = artefactsInsuranceValidity;
	}
	public String getArtefactsInsuranceAmount() {
		return artefactsInsuranceAmount;
	}
	public void setArtefactsInsuranceAmount(String artefactsInsuranceAmount) {
		this.artefactsInsuranceAmount = artefactsInsuranceAmount;
	}
	public String getAssessmentReadyDt() {
		return assessmentReadyDt;
	}
	public void setAssessmentReadyDt(String assessmentReadyDt) {
		this.assessmentReadyDt = assessmentReadyDt;
	}
	public String getPreviousCancellation() {
		return previousCancellation;
	}
	public void setPreviousCancellation(String previousCancellation) {
		this.previousCancellation = previousCancellation;
	}
	public String[] getArrIsNo() {
		return arrIsNo;
	}
	public void setArrIsNo(String[] arrIsNo) {
		this.arrIsNo = arrIsNo;
	}
	public String[] getArrMethodTest() {
		return arrMethodTest;
	}
	public void setArrMethodTest(String[] arrMethodTest) {
		this.arrMethodTest = arrMethodTest;
	}
	public String[] getArrTestFacility() {
		return arrTestFacility;
	}
	public void setArrTestFacility(String[] arrTestFacility) {
		this.arrTestFacility = arrTestFacility;
	}
	public String[] getArrModelType() {
		return arrModelType;
	}
	public void setArrModelType(String[] arrModelType) {
		this.arrModelType = arrModelType;
	}
	public String[] getArrRange() {
		return arrRange;
	}
	public void setArrRange(String[] arrRange) {
		this.arrRange = arrRange;
	}
	public String[] getArrLeastCount() {
		return arrLeastCount;
	}
	public void setArrLeastCount(String[] arrLeastCount) {
		this.arrLeastCount = arrLeastCount;
	}
	public String[] getArrValidity() {
		return arrValidity;
	}
	public void setArrValidity(String[] arrValidity) {
		this.arrValidity = arrValidity;
	}
	public String[] getArrTraceability() {
		return arrTraceability;
	}
	public void setArrTraceability(String[] arrTraceability) {
		this.arrTraceability = arrTraceability;
	}
	public String[] getArrRemarksAny() {
		return arrRemarksAny;
	}
	public void setArrRemarksAny(String[] arrRemarksAny) {
		this.arrRemarksAny = arrRemarksAny;
	}
	public String[] getIdTestEquop() {
		return idTestEquop;
	}
	public void setIdTestEquop(String[] idTestEquop) {
		this.idTestEquop = idTestEquop;
	}
	public String getLayOutSpace() {
		return layOutSpace;
	}
	public void setLayOutSpace(String layOutSpace) {
		this.layOutSpace = layOutSpace;
	}
	public String getWaterSupplySource() {
		return waterSupplySource;
	}
	public void setWaterSupplySource(String waterSupplySource) {
		this.waterSupplySource = waterSupplySource;
	}
	public String getHalideFreeWater() {
		return halideFreeWater;
	}
	public void setHalideFreeWater(String halideFreeWater) {
		this.halideFreeWater = halideFreeWater;
	}
	public String getPowerSupplySource() {
		return powerSupplySource;
	}
	public void setPowerSupplySource(String powerSupplySource) {
		this.powerSupplySource = powerSupplySource;
	}
	public String getAvailableLoad() {
		return availableLoad;
	}
	public void setAvailableLoad(String availableLoad) {
		this.availableLoad = availableLoad;
	}
	public String getGeneratorCapacity() {
		return generatorCapacity;
	}
	public void setGeneratorCapacity(String generatorCapacity) {
		this.generatorCapacity = generatorCapacity;
	}
	public String getLoadRequirement() {
		return loadRequirement;
	}
	public void setLoadRequirement(String loadRequirement) {
		this.loadRequirement = loadRequirement;
	}
	public String getUninterruptedPower() {
		return uninterruptedPower;
	}
	public void setUninterruptedPower(String uninterruptedPower) {
		this.uninterruptedPower = uninterruptedPower;
	}
	public String getUninterruptedPowerReason() {
		return uninterruptedPowerReason;
	}
	public void setUninterruptedPowerReason(String uninterruptedPowerReason) {
		this.uninterruptedPowerReason = uninterruptedPowerReason;
	}
	public String[] getIdDept() {
		return idDept;
	}
	public void setIdDept(String[] idDept) {
		this.idDept = idDept;
	}
	public String getNamePerQualityMngmtCntr() {
		return namePerQualityMngmtCntr;
	}
	public void setNamePerQualityMngmtCntr(String namePerQualityMngmtCntr) {
		this.namePerQualityMngmtCntr = namePerQualityMngmtCntr;
	}
	public String getDesigPerQualityMngmtCntr() {
		return desigPerQualityMngmtCntr;
	}
	public void setDesigPerQualityMngmtCntr(String desigPerQualityMngmtCntr) {
		this.desigPerQualityMngmtCntr = desigPerQualityMngmtCntr;
	}
	public String getNoOfEmpCenter() {
		return noOfEmpCenter;
	}
	public void setNoOfEmpCenter(String noOfEmpCenter) {
		this.noOfEmpCenter = noOfEmpCenter;
	}
	public String[] getArrDepartment() {
		return arrDepartment;
	}
	public void setArrDepartment(String[] arrDepartment) {
		this.arrDepartment = arrDepartment;
	}
	public String[] getArrDeptName() {
		return arrDeptName;
	}
	public void setArrDeptName(String[] arrDeptName) {
		this.arrDeptName = arrDeptName;
	}
	public String[] getArrDeptDesig() {
		return arrDeptDesig;
	}
	public void setArrDeptDesig(String[] arrDeptDesig) {
		this.arrDeptDesig = arrDeptDesig;
	}
	public String[] getArrDeptQuali() {
		return arrDeptQuali;
	}
	public void setArrDeptQuali(String[] arrDeptQuali) {
		this.arrDeptQuali = arrDeptQuali;
	}
	public String[] getArrDeptExper() {
		return arrDeptExper;
	}
	public void setArrDeptExper(String[] arrDeptExper) {
		this.arrDeptExper = arrDeptExper;
	}
	public String[] getArrDeptTraining() {
		return arrDeptTraining;
	}
	public void setArrDeptTraining(String[] arrDeptTraining) {
		this.arrDeptTraining = arrDeptTraining;
	}
	public String[] getArrDeptDeputyName() {
		return arrDeptDeputyName;
	}
	public void setArrDeptDeputyName(String[] arrDeptDeputyName) {
		this.arrDeptDeputyName = arrDeptDeputyName;
	}
	public String getNumId() {
		return numId;
	}
	public void setNumId(String numId) {
		this.numId = numId;
	}
	public String getRegionId() {
		return regionId;
	}
	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}
	public String getAppId() {
		return appId;
	}
	public void setAppId(String appId) {
		this.appId = appId;
	}
		public String getTypeOwnership() {
		return typeOwnership;
	}
	public void setTypeOwnership(String typeOwnership) {
		this.typeOwnership = typeOwnership;
	}
	public String getRecogAppliedFor() {
		return recogAppliedFor;
	}
	public void setRecogAppliedFor(String recogAppliedFor) {
		this.recogAppliedFor = recogAppliedFor;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public String getStCSRFToken() {
		return stCSRFToken;
	}
	public void setStCSRFToken(String stCSRFToken) {
		this.stCSRFToken = stCSRFToken;
	}
	/*int criminalcheck;
	int irregularitycheck;
	String hiddenAppID;
	int hiddenAHCID=0;
	private String  mode;*/
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		this.centerName = centerName;
	}
	public String getOffaddr1() {
		return offaddr1;
	}
	public void setOffaddr1(String offaddr1) {
		this.offaddr1 = offaddr1;
	}
	public String getOffaddr2() {
		return offaddr2;
	}
	public void setOffaddr2(String offaddr2) {
		this.offaddr2 = offaddr2;
	}
	public String getOffCountry() {
		return offCountry;
	}
	public void setOffCountry(String offCountry) {
		this.offCountry = offCountry;
	}
	public String getOffState() {
		return offState;
	}
	public void setOffState(String offState) {
		this.offState = offState;
	}
	public String getOffDistrict() {
		return offDistrict;
	}
	public void setOffDistrict(String offDistrict) {
		this.offDistrict = offDistrict;
	}
	public String getOffMail() {
		return offMail;
	}
	public void setOffMail(String offMail) {
		this.offMail = offMail;
	}
	public String getOffMobNo() {
		return offMobNo;
	}
	public void setOffMobNo(String offMobNo) {
		this.offMobNo = offMobNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getOwnerDesig() {
		return ownerDesig;
	}
	public void setOwnerDesig(String ownerDesig) {
		this.ownerDesig = ownerDesig;
	}
	public String getRdoAddress() {
		return rdoAddress;
	}
	public void setRdoAddress(String rdoAddress) {
		this.rdoAddress = rdoAddress;
	}
	public String getRegaddr1() {
		return regaddr1;
	}
	public void setRegaddr1(String regaddr1) {
		this.regaddr1 = regaddr1;
	}
	public String getRegaddr2() {
		return regaddr2;
	}
	public void setRegaddr2(String regaddr2) {
		this.regaddr2 = regaddr2;
	}
	public String getRegCountry() {
		return regCountry;
	}
	public void setRegCountry(String regCountry) {
		this.regCountry = regCountry;
	}
	public String getRegState() {
		return regState;
	}
	public void setRegState(String regState) {
		this.regState = regState;
	}
	public String getRegDistrict() {
		return regDistrict;
	}
	public void setRegDistrict(String regDistrict) {
		this.regDistrict = regDistrict;
	}
	public String getRegMail() {
		return regMail;
	}
	public void setRegMail(String regMail) {
		this.regMail = regMail;
	}
	public String getRegMobNo() {
		return regMobNo;
	}
	public void setRegMobNo(String regMobNo) {
		this.regMobNo = regMobNo;
	}
	
	public String getTypeOfOwnership() {
		return typeOfOwnership;
	}
	public void setTypeOfOwnership(String typeOfOwnership) {
		this.typeOfOwnership = typeOfOwnership;
	}


	public int getOffCity() {
		return offCity;
	}
	public void setOffCity(int offCity) {
		this.offCity = offCity;
	}
	public int getRegCity() {
		return regCity;
	}
	public void setRegCity(int regCity) {
		this.regCity = regCity;
	}

	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getRecognitionValidity() {
		return recognitionValidity;
	}
	public void setRecognitionValidity(String recognitionValidity) {
		this.recognitionValidity = recognitionValidity;
	}
	public String getChangesProposedInScopeOfRecognition() {
		return changesProposedInScopeOfRecognition;
	}
	public void setChangesProposedInScopeOfRecognition(String changesProposedInScopeOfRecognition) {
		this.changesProposedInScopeOfRecognition = changesProposedInScopeOfRecognition;
	}
	public String getHasChangesProposedInScopeOfRecognition() {
		return hasChangesProposedInScopeOfRecognition;
	}
	public void setHasChangesProposedInScopeOfRecognition(String hasChangesProposedInScopeOfRecognition) {
		this.hasChangesProposedInScopeOfRecognition = hasChangesProposedInScopeOfRecognition;
	}
	public int getApplicationStatus() {
		return applicationStatus;
	}
	public void setApplicationStatus(int applicationStatus) {
		this.applicationStatus = applicationStatus;
	}
	public String[] getArrMethodTest1() {
		return arrMethodTest1;
	}
	public void setArrMethodTest1(String[] arrMethodTest1) {
		this.arrMethodTest1 = arrMethodTest1;
	}
	public String[] getArrTraceability1() {
		return arrTraceability1;
	}
	public void setArrTraceability1(String[] arrTraceability1) {
		this.arrTraceability1 = arrTraceability1;
	}
	public String[] getArrValidity1() {
		return arrValidity1;
	}
	public void setArrValidity1(String[] arrValidity1) {
		this.arrValidity1 = arrValidity1;
	}
	public String getStrAssayRroomSpace() {
		return strAssayRroomSpace;
	}
	public void setStrAssayRroomSpace(String strAssayRroomSpace) {
		this.strAssayRroomSpace = strAssayRroomSpace;
	}
	public String getStr_app_no() {
		return str_app_no;
	}
	public void setStr_app_no(String str_app_no) {
		this.str_app_no = str_app_no;
	}
	public String getStr_recognition_number() {
		return str_recognition_number;
	}
	public void setStr_recognition_number(String str_recognition_number) {
		this.str_recognition_number = str_recognition_number;
	}
	public String getManak_access_token() {
		return manak_access_token;
	}
	public void setManak_access_token(String manak_access_token) {
		this.manak_access_token = manak_access_token;
	}
	public String getNsws_unique_username() {
		return nsws_unique_username;
	}
	public void setNsws_unique_username(String nsws_unique_username) {
		this.nsws_unique_username = nsws_unique_username;
	}
	
	


}
