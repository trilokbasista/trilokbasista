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
@Table(name="ahcrecogapplicationsub",schema="bis_hall")
public class AHCApplicationSubmissionDomain implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2037711149399495971L;

	@Id
	@GeneratedValue(strategy=GenerationType.TABLE, generator="ahcrecogapplicationsub")
	@TableGenerator(initialValue=1, allocationSize=1, name="ahcrecogapplicationsub")
	@Column(name="numId")
	int numId;
	
	@Column(name="numentryempid",length=5)
	int numEntryEmpId;
	
	@Column(name="strappid",length=12)
	String strAppId;
	
	@Column(name="numregionid",length=2)
	int numRegionId=0;
	
	@Column(name="numstatus",length=5)
	int numStatus=0;
	
	@Column(name="strcentername",length=100)
	String strCenterName;
	
	@Column(name="stroffaddr1", length=50)
	String strOffAddr1;
	
	@Column(name="stroffaddr2", length=50)
	String strOffAddr2;
	
	@Column(name="numoffcountryid")
	int numOffCountryId = 0;
	
	@Column(name="numoffstateid", length = 3)
	int numOffStateId;
	
	@Column(name="numoffdistrictid", length = 3)
	int numOffDistrictId;
	
	@Column(name="stroffmail", length=100)
	String strOffmail;
	
	@Column(name="stroffno", length=20)
	String strOffNo;
	
	@Column(name="strnameowner",length=100)
	String strNameOwner;
	
	@Column(name="strdesigowner",length=100)
	String strDesigOwner;
	
	@Column(name="stradddiff",length=2)
	String strAddDiff;
	
	
	@Column(name="strregoffaddr1", length=50)
	String strRegOffAddr1;
	
	@Column(name="strregoffaddr2", length=50)
	String strRegOffAddr2;
	
	@Column(name="numregoffcountryid")
	int numRegOffCountryId = 0;
	
	@Column(name="numregoffstateid", length = 3)
	int numRegOffStateId;
	
	@Column(name="numregoffdistrictid", length = 3)
	int numRegOffDistrictId;
	
	@Column(name="strregoffmail", length=100)
	String strRegOffmail;
	
	@Column(name="strregoffno", length=20)
	String strRegOffNo;
	
	@Column(name="strtypeownership", length=20)
	String strTypeOwnership;
	
	@Column(name="strrecogscope", length=250)
	String strRecogScope;

	@Column(name="dtentrydate",length=20)
	Date dtEntryDate=new Date();
	
	@Column(name="numocauthorize",length=4)
	int numOCAuthorize;
	
	
	//-----------------------------page 1 fields finished------------//
	@Column(name="strnameperqualitymngmtcntr", length=100)
	String strNamePerQualityMngmtCntr;
	
	@Column(name="strdesigperqualitymngmtcntr", length=100)
	String strDesigPerQualityMngmtCntr;
	
	@Column(name="numnoofempcenter", length=5)
	int numNoOfEmpCenter = 0;
	
	@Column(name="strlayoutspace", length=50)
	String strLayOutSpace;
	
	@Column(name="str_assay_room_space", length=50)
	String strAssayRroomSpace;

	@Column(name="strwatersupplysource", length=20)
	String strWaterSupplySource;
	
	@Column(name="strhalidefreewater", length=100)
	String strHalideFreeWater;
	
	@Column(name="strpowersupplysource", length=50)
	String strPowerSupplySource;
	
	@Column(name="stravailableload", length=100)
	String strAvailableLoad;
	
	@Column(name="strgeneratorcapacity", length=100)
	String strGeneratorCapacity;
	
	@Column(name="strloadrequirement", length=100)
	String strLoadRequirement;
	
	@Column(name="struninterruptedpower", length=100)
	String strUninterruptedPower;
	
	@Column(name="struninterruptedpowerreason", length=100)
	String strUninterruptedPowerReason;
	
	//-----------------------------page 2 fields finished------------//
	
	
	@Column(name="strcentreaccredited", length=100)
	String strCentreAccredited;
	
	
	@Column(name="straccreditationvalidity", length=100)
	String strAccreditationValidity;
	
	
	@Column(name="strqualitymanualimplemented", length=100)
	String strQualityManualImplemented;
	
	
	@Column(name="strproficiencytesting", length=100)
	String strProficiencyTesting;
	

	@Column(name="strproficiencytestingreason", length=100)
	String strProficiencyTestingReason;
	
	
	@Column(name="strcontrollingaccess", length=100)
	String strControllingAccess;
	
	
	@Column(name="strcontrollingaccessreason", length=100)
	String strControllingAccessReason;
	
	
	@Column(name="strensuringsecurity", length=100)
	String strEnsuringSecurity;
	
	
	@Column(name="strensuringsecurityreason", length=100)
	String strEnsuringSecurityReason;
	
	
	@Column(name="strindemnityinsurance", length=100)
	String strIndemnityInsurance;
	
	
	@Column(name="strindemnityinsurancepolicy", length=100)
	String strIndemnityInsurancePolicy;
	
	
	@Column(name="strindemnityinsurancevalidity", length=100)
	String strIndemnityInsuranceValidity;
	
	
	@Column(name="strindemnityinsuranceamount", length=100)
	String strIndemnityInsuranceAmount;
	
	
	@Column(name="strartefactsinsurance", length=100)
	String strArtefactsInsurance;
	
	
	@Column(name="strartefactsinsurancepolicy", length=100)
	String strArtefactsInsurancePolicy;
	
	
	@Column(name="strartefactsinsurancevalidity", length=100)
	String strArtefactsInsuranceValidity;
	
	@Column(name="strartefactsinsuranceamount", length=100)
	String strArtefactsInsuranceAmount;
	
	@Column(name="strassessmentreadydt", length=20)
	String strAssessmentReadyDt;
	
	@Column(name="strpreviouscancellation", length=100)
	String strPreviousCancellation;
		
	
	@Column(name="receipt_no")
	String receipt_no;
	
	@Column(name="ahc_pincode")
	private String ahcPincode;
	
	@Column(name="office_pincode")
	private String officePincode;
	
	@Column(name="ahc_latitude")
	private String ahcLatitude;
	
	@Column(name="ahc_longitude")
	private String ahcLongitude;
	
	@Column(name="electric_meter_num")
	private String electricMeterNumber;	
	
	@Column(name="off_city_id")
	private int offCity;	
	
	@Column(name="reg_city_id")
	private int regCity;
	
	@Column(name="recognition_validity")
	private String recognitionValidity;	
	
	@Column(name="changes_proposed_in_scope_of_recognition")
	private String changesProposedInScopeOfRecognition;
	
	@Column(name="has_changes_proposed_in_scope_of_recognition")
	private String hasChangesProposedInScopeOfRecognition;
	
	@Column(name="strgstin",length=20)	
	String strGstin;
	
	@Column(name="str_oldapp_no",length=12)
	String str_app_no;
	
	@Column(name="str_recognition_number",length=25)
	String str_recognition_number;
	
	String num_region_for_recog;
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

	String str_recognition_farmete = "RAHC/R-";

	
	
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


	
	public String getElectricMeterNumber() {
		return electricMeterNumber;
	}

	public void setElectricMeterNumber(String electricMeterNumber) {
		this.electricMeterNumber = electricMeterNumber;
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



	public String getReceipt_no() {
		return receipt_no;
	}

	public void setReceipt_no(String receipt_no) {
		this.receipt_no = receipt_no;
	}
	
	
	public int getNumOCAuthorize() {
		return numOCAuthorize;
	}

	public void setNumOCAuthorize(int numOCAuthorize) {
		this.numOCAuthorize = numOCAuthorize;
	}

	public int getNumStatus() {
		return numStatus;
	}

	public void setNumStatus(int numStatus) {
		this.numStatus = numStatus;
	}

	public int getNumEntryEmpId() {
		return numEntryEmpId;
	}

	public void setNumEntryEmpId(int numEntryEmpId) {
		this.numEntryEmpId = numEntryEmpId;
	}

	public String getStrCentreAccredited() {
		return strCentreAccredited;
	}

	public void setStrCentreAccredited(String strCentreAccredited) {
		this.strCentreAccredited = strCentreAccredited;
	}

	public String getStrAccreditationValidity() {
		return strAccreditationValidity;
	}

	public void setStrAccreditationValidity(String strAccreditationValidity) {
		this.strAccreditationValidity = strAccreditationValidity;
	}

	public String getStrQualityManualImplemented() {
		return strQualityManualImplemented;
	}

	public void setStrQualityManualImplemented(String strQualityManualImplemented) {
		this.strQualityManualImplemented = strQualityManualImplemented;
	}

	public String getStrProficiencyTesting() {
		return strProficiencyTesting;
	}

	public void setStrProficiencyTesting(String strProficiencyTesting) {
		this.strProficiencyTesting = strProficiencyTesting;
	}

	public String getStrProficiencyTestingReason() {
		return strProficiencyTestingReason;
	}

	public void setStrProficiencyTestingReason(String strProficiencyTestingReason) {
		this.strProficiencyTestingReason = strProficiencyTestingReason;
	}

	public String getStrControllingAccess() {
		return strControllingAccess;
	}

	public void setStrControllingAccess(String strControllingAccess) {
		this.strControllingAccess = strControllingAccess;
	}

	public String getStrControllingAccessReason() {
		return strControllingAccessReason;
	}

	public void setStrControllingAccessReason(String strControllingAccessReason) {
		this.strControllingAccessReason = strControllingAccessReason;
	}

	public String getStrEnsuringSecurity() {
		return strEnsuringSecurity;
	}

	public void setStrEnsuringSecurity(String strEnsuringSecurity) {
		this.strEnsuringSecurity = strEnsuringSecurity;
	}

	public String getStrEnsuringSecurityReason() {
		return strEnsuringSecurityReason;
	}

	public void setStrEnsuringSecurityReason(String strEnsuringSecurityReason) {
		this.strEnsuringSecurityReason = strEnsuringSecurityReason;
	}

	public String getStrIndemnityInsurance() {
		return strIndemnityInsurance;
	}

	public void setStrIndemnityInsurance(String strIndemnityInsurance) {
		this.strIndemnityInsurance = strIndemnityInsurance;
	}

	public String getStrIndemnityInsurancePolicy() {
		return strIndemnityInsurancePolicy;
	}

	public void setStrIndemnityInsurancePolicy(String strIndemnityInsurancePolicy) {
		this.strIndemnityInsurancePolicy = strIndemnityInsurancePolicy;
	}

	public String getStrIndemnityInsuranceValidity() {
		return strIndemnityInsuranceValidity;
	}

	public void setStrIndemnityInsuranceValidity(
			String strIndemnityInsuranceValidity) {
		this.strIndemnityInsuranceValidity = strIndemnityInsuranceValidity;
	}

	public String getStrIndemnityInsuranceAmount() {
		return strIndemnityInsuranceAmount;
	}

	public void setStrIndemnityInsuranceAmount(String strIndemnityInsuranceAmount) {
		this.strIndemnityInsuranceAmount = strIndemnityInsuranceAmount;
	}

	public String getStrArtefactsInsurance() {
		return strArtefactsInsurance;
	}

	public void setStrArtefactsInsurance(String strArtefactsInsurance) {
		this.strArtefactsInsurance = strArtefactsInsurance;
	}

	public String getStrArtefactsInsurancePolicy() {
		return strArtefactsInsurancePolicy;
	}

	public void setStrArtefactsInsurancePolicy(String strArtefactsInsurancePolicy) {
		this.strArtefactsInsurancePolicy = strArtefactsInsurancePolicy;
	}

	public String getStrArtefactsInsuranceValidity() {
		return strArtefactsInsuranceValidity;
	}

	public void setStrArtefactsInsuranceValidity(
			String strArtefactsInsuranceValidity) {
		this.strArtefactsInsuranceValidity = strArtefactsInsuranceValidity;
	}

	public String getStrArtefactsInsuranceAmount() {
		return strArtefactsInsuranceAmount;
	}

	public void setStrArtefactsInsuranceAmount(String strArtefactsInsuranceAmount) {
		this.strArtefactsInsuranceAmount = strArtefactsInsuranceAmount;
	}

	public String getStrAssessmentReadyDt() {
		return strAssessmentReadyDt;
	}

	public void setStrAssessmentReadyDt(String strAssessmentReadyDt) {
		this.strAssessmentReadyDt = strAssessmentReadyDt;
	}

	public String getStrPreviousCancellation() {
		return strPreviousCancellation;
	}

	public void setStrPreviousCancellation(String strPreviousCancellation) {
		this.strPreviousCancellation = strPreviousCancellation;
	}

	public String getStrLayOutSpace() {
		return strLayOutSpace;
	}

	public void setStrLayOutSpace(String strLayOutSpace) {
		this.strLayOutSpace = strLayOutSpace;
	}

	public String getStrWaterSupplySource() {
		return strWaterSupplySource;
	}

	public void setStrWaterSupplySource(String strWaterSupplySource) {
		this.strWaterSupplySource = strWaterSupplySource;
	}

	public String getStrHalideFreeWater() {
		return strHalideFreeWater;
	}

	public void setStrHalideFreeWater(String strHalideFreeWater) {
		this.strHalideFreeWater = strHalideFreeWater;
	}

	public String getStrPowerSupplySource() {
		return strPowerSupplySource;
	}

	public void setStrPowerSupplySource(String strPowerSupplySource) {
		this.strPowerSupplySource = strPowerSupplySource;
	}

	public String getStrAvailableLoad() {
		return strAvailableLoad;
	}

	public void setStrAvailableLoad(String strAvailableLoad) {
		this.strAvailableLoad = strAvailableLoad;
	}

	public String getStrGeneratorCapacity() {
		return strGeneratorCapacity;
	}

	public void setStrGeneratorCapacity(String strGeneratorCapacity) {
		this.strGeneratorCapacity = strGeneratorCapacity;
	}

	public String getStrLoadRequirement() {
		return strLoadRequirement;
	}

	public void setStrLoadRequirement(String strLoadRequirement) {
		this.strLoadRequirement = strLoadRequirement;
	}

	public String getStrUninterruptedPower() {
		return strUninterruptedPower;
	}

	public void setStrUninterruptedPower(String strUninterruptedPower) {
		this.strUninterruptedPower = strUninterruptedPower;
	}

	public String getStrUninterruptedPowerReason() {
		return strUninterruptedPowerReason;
	}

	public void setStrUninterruptedPowerReason(String strUninterruptedPowerReason) {
		this.strUninterruptedPowerReason = strUninterruptedPowerReason;
	}

	public String getStrNamePerQualityMngmtCntr() {
		return strNamePerQualityMngmtCntr;
	}

	public void setStrNamePerQualityMngmtCntr(String strNamePerQualityMngmtCntr) {
		this.strNamePerQualityMngmtCntr = strNamePerQualityMngmtCntr;
	}

	public String getStrDesigPerQualityMngmtCntr() {
		return strDesigPerQualityMngmtCntr;
	}

	public void setStrDesigPerQualityMngmtCntr(String strDesigPerQualityMngmtCntr) {
		this.strDesigPerQualityMngmtCntr = strDesigPerQualityMngmtCntr;
	}

	public int getNumNoOfEmpCenter() {
		return numNoOfEmpCenter;
	}

	public void setNumNoOfEmpCenter(int numNoOfEmpCenter) {
		this.numNoOfEmpCenter = numNoOfEmpCenter;
	}

	public Date getDtEntryDate() {
		return dtEntryDate;
	}

	public void setDtEntryDate(Date dtEntryDate) {
		this.dtEntryDate = dtEntryDate;
	}

	public int getNumRegionId() {
		return numRegionId;
	}

	public void setNumRegionId(int numRegionId) {
		this.numRegionId = numRegionId;
	}

	public int getNumId() {
		return numId;
	}

	public void setNumId(int numId) {
		this.numId = numId;
	}

	public String getStrAppId() {
		return strAppId;
	}

	public void setStrAppId(String strAppId) {
		this.strAppId = strAppId;
	}

	
	public String getStrCenterName() {
		return strCenterName;
	}

	public void setStrCenterName(String strCenterName) {
		this.strCenterName = strCenterName;
	}

	public String getStrOffAddr1() {
		return strOffAddr1;
	}

	public void setStrOffAddr1(String strOffAddr1) {
		this.strOffAddr1 = strOffAddr1;
	}

	public String getStrOffAddr2() {
		return strOffAddr2;
	}

	public void setStrOffAddr2(String strOffAddr2) {
		this.strOffAddr2 = strOffAddr2;
	}

	public int getNumOffCountryId() {
		return numOffCountryId;
	}

	public void setNumOffCountryId(int numOffCountryId) {
		this.numOffCountryId = numOffCountryId;
	}

	public int getNumOffStateId() {
		return numOffStateId;
	}

	public void setNumOffStateId(int numOffStateId) {
		this.numOffStateId = numOffStateId;
	}

	public int getNumOffDistrictId() {
		return numOffDistrictId;
	}

	public void setNumOffDistrictId(int numOffDistrictId) {
		this.numOffDistrictId = numOffDistrictId;
	}

	public String getStrOffmail() {
		return strOffmail;
	}

	public void setStrOffmail(String strOffmail) {
		this.strOffmail = strOffmail;
	}

	public String getStrOffNo() {
		return strOffNo;
	}

	public void setStrOffNo(String strOffNo) {
		this.strOffNo = strOffNo;
	}

	public String getStrNameOwner() {
		return strNameOwner;
	}

	public void setStrNameOwner(String strNameOwner) {
		this.strNameOwner = strNameOwner;
	}

	public String getStrDesigOwner() {
		return strDesigOwner;
	}

	public void setStrDesigOwner(String strDesigOwner) {
		this.strDesigOwner = strDesigOwner;
	}

	public String getStrAddDiff() {
		return strAddDiff;
	}

	public void setStrAddDiff(String strAddDiff) {
		this.strAddDiff = strAddDiff;
	}

	public String getStrRegOffAddr1() {
		return strRegOffAddr1;
	}

	public void setStrRegOffAddr1(String strRegOffAddr1) {
		this.strRegOffAddr1 = strRegOffAddr1;
	}

	public String getStrRegOffAddr2() {
		return strRegOffAddr2;
	}

	public void setStrRegOffAddr2(String strRegOffAddr2) {
		this.strRegOffAddr2 = strRegOffAddr2;
	}

	public int getNumRegOffCountryId() {
		return numRegOffCountryId;
	}

	public void setNumRegOffCountryId(int numRegOffCountryId) {
		this.numRegOffCountryId = numRegOffCountryId;
	}

	public int getNumRegOffStateId() {
		return numRegOffStateId;
	}

	public void setNumRegOffStateId(int numRegOffStateId) {
		this.numRegOffStateId = numRegOffStateId;
	}

	public int getNumRegOffDistrictId() {
		return numRegOffDistrictId;
	}

	public void setNumRegOffDistrictId(int numRegOffDistrictId) {
		this.numRegOffDistrictId = numRegOffDistrictId;
	}

	public String getStrRegOffmail() {
		return strRegOffmail;
	}

	public void setStrRegOffmail(String strRegOffmail) {
		this.strRegOffmail = strRegOffmail;
	}

	public String getStrRegOffNo() {
		return strRegOffNo;
	}

	public void setStrRegOffNo(String strRegOffNo) {
		this.strRegOffNo = strRegOffNo;
	}

	public String getStrTypeOwnership() {
		return strTypeOwnership;
	}

	public void setStrTypeOwnership(String strTypeOwnership) {
		this.strTypeOwnership = strTypeOwnership;
	}

	public String getStrRecogScope() {
		return strRecogScope;
	}

	public void setStrRecogScope(String strRecogScope) {
		this.strRecogScope = strRecogScope;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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

	public String getStrGstin() {
		return strGstin;
	}

	public void setStrGstin(String strGstin) {
		this.strGstin = strGstin;
	}
	public String getStrAssayRroomSpace() {
		return strAssayRroomSpace;
	}

	public void setStrAssayRroomSpace(String strAssayRroomSpace) {
		this.strAssayRroomSpace = strAssayRroomSpace;
	}	
	


}
