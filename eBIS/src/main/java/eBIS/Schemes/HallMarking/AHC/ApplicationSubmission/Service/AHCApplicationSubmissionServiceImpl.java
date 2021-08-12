package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Service;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Dao.AHCApplicationSubmissionDao;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCAppSubDepttDtlsDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCAppSubTestEquipDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCApplicationSubmissionDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCCenterOwnerDetailsDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.DistrictMstDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.UserSubSchemeMappingDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model.AHCRecognitionApplicationModel;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model.CenterOwnerDetailsDTO;
import eBIS.exception.log.domain.ExceptionLog;

@Service
public class AHCApplicationSubmissionServiceImpl implements AHCApplicationSubmissionService {

	@Autowired
	AHCApplicationSubmissionDao applicationSubmissionDao;
	@Autowired
	PrimaryDaoHelper daoHelper;
	
	@Override
	public String submitAppDtls(AHCRecognitionApplicationModel modelObj,HttpServletRequest request,int userId) {
		
		// TODO Auto-generated method stub
		//logic to generate application Id	
		//getting region id first
		Transaction tx = null;
		SessionFactory sf = daoHelper.transactionsession();
		Session openSession = sf.openSession();
		String FinalApplicationId = "";
		String strAppNo="";
		String regionId="";
		boolean flag=false;
		try {
			tx = openSession.beginTransaction();
			List<DistrictMstDomain> obj = applicationSubmissionDao.getBranchIdFrmAppid(Integer.parseInt(modelObj.getOffDistrict()));
			int branchId = obj.get(0).getNumBranchId();
			regionId = applicationSubmissionDao.getRegionIdFromBranchId(branchId);
			List<String> Appid = applicationSubmissionDao.getMaxAppIdFrmRegionId(Integer.parseInt(regionId));
			String prvAppID = "";
			prvAppID = modelObj.getAppId();
			if (prvAppID.isEmpty()) {
				if (Appid.get(0) != null) {
					strAppNo = Appid.get(0);
					Long lnAppNo = Long.parseLong(strAppNo);
					Long NewId = lnAppNo + 1;
					FinalApplicationId = NewId.toString();
				} else {
					String NewId = "0000000001";
					String NewApplicationNo = regionId + NewId;
					FinalApplicationId = NewApplicationNo;
				}
				modelObj.setAppId(FinalApplicationId);
				modelObj.setRegionId(regionId);
				userDtlsinUserSubSchemeMappingDomain(modelObj,FinalApplicationId,regionId,userId,openSession);
				convertModelToAhcRecogDomain(modelObj, FinalApplicationId,regionId,userId,openSession);
				tx.commit();
			} else {
				modelObj.setAppId(Appid.get(0));
				modelObj.setRegionId(regionId);
				FinalApplicationId = prvAppID;
				//modelObj.setApplicationStatus(404);
				convertModelToAhcRecogDomainDraftApp(modelObj, FinalApplicationId,regionId,userId, openSession);
				tx.commit();
			}
			}catch(Exception ex)
			{
				tx.rollback();
				flag=true;
				ex.printStackTrace();
				ExceptionLog exceptiondomain=new ExceptionLog();
				exceptiondomain.setException_date(new Date());
				exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
				exceptiondomain.setException_remarks(ex.getLocalizedMessage());
				exceptiondomain.setIs_valid("1");
				exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
				exceptiondomain=(ExceptionLog) openSession.merge(exceptiondomain);
				JSONObject dataJson = new JSONObject();
				try {
					dataJson.put("ex_id", exceptiondomain.getNum_id());
					dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
					//flag=	dataJson.toString();
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}finally {
				openSession.clear();
		       	openSession.close();
			}
		if(flag)
		{
			return "";
		}
		else
		{
			return FinalApplicationId+","+regionId;
		}
	}
	
	
	
	
	private void userDtlsinUserSubSchemeMappingDomain(AHCRecognitionApplicationModel modelObj, String finalApplicationId,	String regionId, int userId,Session openSession) {
		UserSubSchemeMappingDomain domainObj = new UserSubSchemeMappingDomain();
		domainObj.setNum_branch_id(Integer.parseInt(regionId));
		domainObj.setNum_sub_scheme_id(13);
		domainObj.setNum_user_id(userId);
		domainObj.setStr_application_id(finalApplicationId);
		applicationSubmissionDao.submitUserDtls(domainObj, openSession);
		
	}

	private void convertModelToAhcRecogDomainDraftApp(AHCRecognitionApplicationModel modelObj,
			String finalApplicationId, String regionId,int userId, Session openSession) {
		List<AHCApplicationSubmissionDomain> domainObjList = applicationSubmissionDao.getSaveAppDtlsAhcRecog(finalApplicationId,Integer.parseInt(regionId));
		AHCApplicationSubmissionDomain domainObj = new AHCApplicationSubmissionDomain();
		if(domainObjList.size() > 0)
		{
			domainObj = domainObjList.get(0);
		}
		domainObj.setNumEntryEmpId(userId);
		if(modelObj.getNumId() != null)
		domainObj.setNumId(Integer.parseInt(modelObj.getNumId()));
		domainObj.setStrAppId(finalApplicationId);
		domainObj.setNumRegionId(Integer.parseInt(regionId));
		domainObj.setStrCenterName(modelObj.getCenterName());
		domainObj.setStrGstin(modelObj.getGstin());
		domainObj.setStrOffAddr1(modelObj.getOffaddr1());
		domainObj.setStrOffAddr2(modelObj.getOffaddr2());
		domainObj.setNumOffCountryId(Integer.parseInt(modelObj.getOffCountry()));
		domainObj.setNumOffStateId(Integer.parseInt(modelObj.getOffState()));
		domainObj.setNumOffDistrictId(Integer.parseInt(modelObj.getOffDistrict()));
		domainObj.setOffCity(modelObj.getOffCity());
		domainObj.setAhcPincode(modelObj.getAhcPincode());
		domainObj.setAhcLatitude(modelObj.getAhcLatitude());
		domainObj.setAhcLongitude(modelObj.getAhcLongitude());
		domainObj.setStrOffmail(modelObj.getOffMail());
		domainObj.setStrOffNo(modelObj.getOffMobNo());
		domainObj.setNumOCAuthorize(modelObj.getNumOCA());
		domainObj.setStrNameOwner(modelObj.getOwnerName());
		domainObj.setStrDesigOwner(modelObj.getOwnerDesig());
		domainObj.setStrAddDiff(modelObj.getRdoAddress());
		domainObj.setStrRegOffAddr1(modelObj.getRegaddr1());
		domainObj.setStrRegOffAddr2(modelObj.getRegaddr2());
		domainObj.setNumRegOffCountryId(Integer.parseInt(modelObj.getRegCountry()));
		domainObj.setNumRegOffStateId(Integer.parseInt(modelObj.getRegState()));
		domainObj.setNumRegOffDistrictId(Integer.parseInt(modelObj.getRegDistrict()));
		domainObj.setRegCity(modelObj.getRegCity());
		domainObj.setOfficePincode(modelObj.getOfficePincode());
		domainObj.setStrRegOffmail(modelObj.getRegMail());
		domainObj.setStrRegOffNo(modelObj.getRegMobNo());
		domainObj.setStrTypeOwnership(modelObj.getTypeOwnership());
		domainObj.setStrRecogScope(modelObj.getRecogAppliedFor());

		
		if(modelObj.getApplicationStatus()==404 || modelObj.getApplicationStatus()==462)
		{
			if(!modelObj.getHasChangesProposedInScopeOfRecognition().equalsIgnoreCase("Yes"))
			{
				domainObj.setChangesProposedInScopeOfRecognition("");
			}
			else
			{
				domainObj.setChangesProposedInScopeOfRecognition(modelObj.getChangesProposedInScopeOfRecognition());
			}
			domainObj.setHasChangesProposedInScopeOfRecognition(modelObj.getHasChangesProposedInScopeOfRecognition());
			domainObj.setRecognitionValidity(modelObj.getRecognitionValidity());
			domainObj.setStr_app_no(modelObj.getStr_app_no());
			domainObj.setStr_recognition_number(modelObj.getStr_recognition_number());
			//domainObj.setStr_recognition_number(modelObj.getNum_region_for_recog().concat(modelObj.getStr_recognition_farmete()).concat(modelObj.getStr_recognition_number()));
		}
				//AHC Form-2nd Information Start
				domainObj.setStrNamePerQualityMngmtCntr(modelObj.getNamePerQualityMngmtCntr());
				domainObj.setStrDesigPerQualityMngmtCntr(modelObj.getDesigPerQualityMngmtCntr());
				domainObj.setNumNoOfEmpCenter(Integer.parseInt(modelObj.getNoOfEmpCenter()));
				
				domainObj.setStrLayOutSpace(modelObj.getLayOutSpace());
				domainObj.setStrAssayRroomSpace(modelObj.getStrAssayRroomSpace());
				domainObj.setStrWaterSupplySource(modelObj.getWaterSupplySource());
				domainObj.setStrHalideFreeWater(modelObj.getHalideFreeWater());
				domainObj.setStrPowerSupplySource(modelObj.getPowerSupplySource());
				domainObj.setStrAvailableLoad(modelObj.getAvailableLoad());
				domainObj.setStrGeneratorCapacity(modelObj.getGeneratorCapacity());
				domainObj.setStrLoadRequirement(modelObj.getLoadRequirement());
				domainObj.setStrUninterruptedPower(modelObj.getUninterruptedPower());
				domainObj.setStrUninterruptedPowerReason(modelObj.getUninterruptedPowerReason());
				domainObj.setElectricMeterNumber(modelObj.getElectricMeterNumber());
				addDepartmentDetailsAHCRecogApp(modelObj, openSession);
				addTestEquipDetailsAHCRecogApp(modelObj, openSession);
				addTestEquipSilverDetailsAHCRecogApp(modelObj, openSession);
				//AHC Form-2nd Information End
				
				//AHC Form-3rd Information Start
				domainObj.setStrCentreAccredited(modelObj.getCentreAccredited());
				domainObj.setStrAccreditationValidity(modelObj.getAccreditationValidity());
				domainObj.setStrQualityManualImplemented(modelObj.getQualityManualImplemented());
				
				domainObj.setStrProficiencyTesting(modelObj.getProficiencyTesting());
				domainObj.setStrProficiencyTestingReason(modelObj.getProficiencyTestingReason());
				domainObj.setStrControllingAccess(modelObj.getControllingAccess());
				domainObj.setStrControllingAccessReason(modelObj.getControllingAccessReason());
				domainObj.setStrEnsuringSecurity(modelObj.getEnsuringSecurity());
				domainObj.setStrEnsuringSecurityReason(modelObj.getEnsuringSecurityReason());
				domainObj.setStrIndemnityInsurance(modelObj.getIndemnityInsurance());
				domainObj.setStrIndemnityInsurancePolicy(modelObj.getIndemnityInsurancePolicy());
				domainObj.setStrIndemnityInsuranceValidity(modelObj.getIndemnityInsuranceValidity());
				
				domainObj.setStrIndemnityInsuranceAmount(modelObj.getIndemnityInsuranceAmount());
				domainObj.setStrArtefactsInsurance(modelObj.getArtefactsInsurance());
				domainObj.setStrArtefactsInsurancePolicy(modelObj.getArtefactsInsurancePolicy());
				domainObj.setStrArtefactsInsuranceValidity(modelObj.getArtefactsInsuranceValidity());
				domainObj.setStrArtefactsInsuranceAmount(modelObj.getArtefactsInsuranceAmount());
				
				domainObj.setStrAssessmentReadyDt(modelObj.getAssessmentReadyDt());
				domainObj.setStrPreviousCancellation(modelObj.getPreviousCancellation());
				//AHC Form-3rd Information Start End
		applicationSubmissionDao.submitAhcRecogApp1(domainObj, openSession);
		applicationSubmissionDao.deleteCenterOwnerDetailsAHCRecogApp(Long.valueOf(domainObj.getNumId()), openSession);
		for(CenterOwnerDetailsDTO centerOwnerDetailsDTO:modelObj.getCenterOwnerDetailsDTOList())
		{
			if(centerOwnerDetailsDTO.getName()==null || centerOwnerDetailsDTO.getName().length()==0)
			{
				continue;
			}
			AHCCenterOwnerDetailsDomain centerOwnerDetails =new AHCCenterOwnerDetailsDomain();
			centerOwnerDetails.setHallCenterOwnerDetailsId(centerOwnerDetailsDTO.getCenterOwnerDetailsId());
			centerOwnerDetails.setApplicationIdFk(Long.valueOf(domainObj.getNumId()));
			centerOwnerDetails.setCenterOwnerName(centerOwnerDetailsDTO.getName());
			centerOwnerDetails.setOwnerDesignation(centerOwnerDetailsDTO.getDesignation());
			centerOwnerDetails.setStatus(true);
			centerOwnerDetails.setCreatedBy(userId);
			centerOwnerDetails.setCreateDate(new Date());
			centerOwnerDetails.setUpdatedBy(userId);
			centerOwnerDetails.setUpdateDate(new Date());
			centerOwnerDetails.setIpAddress(modelObj.getIpAddress());
			applicationSubmissionDao.saveCenterOwnerDetails(centerOwnerDetails, openSession);
		}
		
		//applicationSubmissionDao.submitAhcRecogApp1(domainObj);
		
	}

	private void convertModelToAhcRecogDomain(AHCRecognitionApplicationModel modelObj,
			String finalApplicationId, String regionId,int userId,Session openSession) {
		AHCApplicationSubmissionDomain domainObj = new AHCApplicationSubmissionDomain();
		AHCApplicationSubmissionDomain domainObjNew = new AHCApplicationSubmissionDomain();
		if(modelObj.getApplicationStatus()==26)
		{
			 domainObj = new AHCApplicationSubmissionDomain();
		}
		else if(modelObj.getApplicationStatus()==404 || modelObj.getApplicationStatus()==462)
		{
			 domainObjNew=getSaveAppDtlsAhcRecog(modelObj.getPreviousAppId(),Integer.valueOf(regionId));
			 
		}		
		
		domainObj.setNumEntryEmpId(userId);
		domainObj.setNumStatus(modelObj.getApplicationStatus());
		if(modelObj.getNumId() != null)
		domainObj.setNumId(Integer.parseInt("0"));
		domainObj.setStrAppId(finalApplicationId);
		domainObj.setNumRegionId(Integer.parseInt(regionId));
		domainObj.setStrCenterName(modelObj.getCenterName());
		domainObj.setStrGstin(modelObj.getGstin());
		domainObj.setStrOffAddr1(modelObj.getOffaddr1());
		domainObj.setStrOffAddr2(modelObj.getOffaddr2());
		domainObj.setNumOffCountryId(Integer.parseInt(modelObj.getOffCountry()));
		domainObj.setNumOffStateId(Integer.parseInt(modelObj.getOffState()));
		domainObj.setNumOffDistrictId(Integer.parseInt(modelObj.getOffDistrict()));
		domainObj.setOffCity(modelObj.getOffCity());
		domainObj.setAhcPincode(modelObj.getAhcPincode());
		domainObj.setAhcLatitude(modelObj.getAhcLatitude());
		domainObj.setAhcLongitude(modelObj.getAhcLongitude());
		domainObj.setStrOffmail(modelObj.getOffMail());
		domainObj.setStrOffNo(modelObj.getOffMobNo());
		domainObj.setNumOCAuthorize(modelObj.getNumOCA());
		domainObj.setStrNameOwner(modelObj.getOwnerName());
		domainObj.setStrDesigOwner(modelObj.getOwnerDesig());
		domainObj.setStrAddDiff(modelObj.getRdoAddress());
		domainObj.setStrRegOffAddr1(modelObj.getRegaddr1());
		domainObj.setStrRegOffAddr2(modelObj.getRegaddr2());
		domainObj.setNumRegOffCountryId(Integer.parseInt(modelObj.getRegCountry()));
		domainObj.setNumRegOffStateId(Integer.parseInt(modelObj.getRegState()));
		domainObj.setNumRegOffDistrictId(Integer.parseInt(modelObj.getRegDistrict()));
		domainObj.setRegCity(modelObj.getRegCity());
		domainObj.setOfficePincode(modelObj.getOfficePincode());
		domainObj.setStrRegOffmail(modelObj.getRegMail());
		domainObj.setStrRegOffNo(modelObj.getRegMobNo());
		domainObj.setStrTypeOwnership(modelObj.getTypeOwnership());
		domainObj.setStrRecogScope(modelObj.getRecogAppliedFor());

		if(modelObj.getApplicationStatus()==404 || modelObj.getApplicationStatus()==462)
		{
			if(!modelObj.getHasChangesProposedInScopeOfRecognition().equalsIgnoreCase("Yes"))
			{
				domainObj.setChangesProposedInScopeOfRecognition("");
			}
			else
			{
				domainObj.setChangesProposedInScopeOfRecognition(modelObj.getChangesProposedInScopeOfRecognition());
			}
			domainObj.setHasChangesProposedInScopeOfRecognition(modelObj.getHasChangesProposedInScopeOfRecognition());
			domainObj.setRecognitionValidity(modelObj.getRecognitionValidity());
			domainObj.setStr_app_no(modelObj.getStr_app_no());
			domainObj.setStr_recognition_number(modelObj.getStr_recognition_number());
			//domainObj.setStr_recognition_number(modelObj.getNum_region_for_recog().concat(modelObj.getStr_recognition_farmete()).concat(modelObj.getStr_recognition_number()));
		

		}
			//AHC Form-2nd Information Start
		domainObj.setStrNamePerQualityMngmtCntr(modelObj.getNamePerQualityMngmtCntr());
		domainObj.setStrDesigPerQualityMngmtCntr(modelObj.getDesigPerQualityMngmtCntr());
		domainObj.setNumNoOfEmpCenter(Integer.parseInt(modelObj.getNoOfEmpCenter()));
		
		domainObj.setStrLayOutSpace(modelObj.getLayOutSpace());
		domainObj.setStrAssayRroomSpace(modelObj.getStrAssayRroomSpace());
		domainObj.setStrWaterSupplySource(modelObj.getWaterSupplySource());
		domainObj.setStrHalideFreeWater(modelObj.getHalideFreeWater());
		domainObj.setStrPowerSupplySource(modelObj.getPowerSupplySource());
		domainObj.setStrAvailableLoad(modelObj.getAvailableLoad());
		domainObj.setStrGeneratorCapacity(modelObj.getGeneratorCapacity());
		domainObj.setStrLoadRequirement(modelObj.getLoadRequirement());
		domainObj.setStrUninterruptedPower(modelObj.getUninterruptedPower());
		domainObj.setStrUninterruptedPowerReason(modelObj.getUninterruptedPowerReason());
		domainObj.setElectricMeterNumber(modelObj.getElectricMeterNumber());
		addDepartmentDetailsAHCRecogApp(modelObj, openSession);
		addTestEquipDetailsAHCRecogApp(modelObj, openSession);
		addTestEquipSilverDetailsAHCRecogApp(modelObj, openSession);
		//AHC Form-2nd Information End
		
		//AHC Form-3rd Information Start
		domainObj.setStrCentreAccredited(modelObj.getCentreAccredited());
		domainObj.setStrAccreditationValidity(modelObj.getAccreditationValidity());
		domainObj.setStrQualityManualImplemented(modelObj.getQualityManualImplemented());
		
		domainObj.setStrProficiencyTesting(modelObj.getProficiencyTesting());
		domainObj.setStrProficiencyTestingReason(modelObj.getProficiencyTestingReason());
		domainObj.setStrControllingAccess(modelObj.getControllingAccess());
		domainObj.setStrControllingAccessReason(modelObj.getControllingAccessReason());
		domainObj.setStrEnsuringSecurity(modelObj.getEnsuringSecurity());
		domainObj.setStrEnsuringSecurityReason(modelObj.getEnsuringSecurityReason());
		domainObj.setStrIndemnityInsurance(modelObj.getIndemnityInsurance());
		domainObj.setStrIndemnityInsurancePolicy(modelObj.getIndemnityInsurancePolicy());
		domainObj.setStrIndemnityInsuranceValidity(modelObj.getIndemnityInsuranceValidity());
		
		domainObj.setStrIndemnityInsuranceAmount(modelObj.getIndemnityInsuranceAmount());
		domainObj.setStrArtefactsInsurance(modelObj.getArtefactsInsurance());
		domainObj.setStrArtefactsInsurancePolicy(modelObj.getArtefactsInsurancePolicy());
		domainObj.setStrArtefactsInsuranceValidity(modelObj.getArtefactsInsuranceValidity());
		domainObj.setStrArtefactsInsuranceAmount(modelObj.getArtefactsInsuranceAmount());
		
		domainObj.setStrAssessmentReadyDt(modelObj.getAssessmentReadyDt());
		domainObj.setStrPreviousCancellation(modelObj.getPreviousCancellation());
		//AHC Form-3rd Information Start End
		applicationSubmissionDao.submitAhcRecogApp1(domainObj, openSession);
		applicationSubmissionDao.deleteCenterOwnerDetailsAHCRecogApp(Long.valueOf(domainObj.getNumId()), openSession);
		for(CenterOwnerDetailsDTO centerOwnerDetailsDTO:modelObj.getCenterOwnerDetailsDTOList())
		{
			if(centerOwnerDetailsDTO.getName()==null || centerOwnerDetailsDTO.getName().length()==0)
			{
				continue;
			}
			AHCCenterOwnerDetailsDomain centerOwnerDetails =new AHCCenterOwnerDetailsDomain();
			centerOwnerDetails.setHallCenterOwnerDetailsId(centerOwnerDetailsDTO.getCenterOwnerDetailsId());
			centerOwnerDetails.setApplicationIdFk(Long.valueOf(domainObj.getNumId()));
			centerOwnerDetails.setCenterOwnerName(centerOwnerDetailsDTO.getName());
			centerOwnerDetails.setOwnerDesignation(centerOwnerDetailsDTO.getDesignation());
			centerOwnerDetails.setStatus(true);
			centerOwnerDetails.setCreatedBy(userId);
			centerOwnerDetails.setCreateDate(new Date());
			centerOwnerDetails.setUpdatedBy(userId);
			centerOwnerDetails.setUpdateDate(new Date());
			centerOwnerDetails.setIpAddress(modelObj.getIpAddress());
			applicationSubmissionDao.saveCenterOwnerDetails(centerOwnerDetails, openSession);
		}
	}
	
	private void addDepartmentDetailsAHCRecogApp(AHCRecognitionApplicationModel modelObj,Session openSession) {
		applicationSubmissionDao.deleteDepartmentDetailsAHCRecogApp(modelObj.getAppId(),Integer.parseInt(modelObj.getRegionId()), openSession);
		
		String[] deptt = modelObj.getArrDepartment();
		String[] name = modelObj.getArrDeptName();
		String[] desig = modelObj.getArrDeptDesig();
		String[] quali = modelObj.getArrDeptQuali();
		String[] experience = modelObj.getArrDeptExper();
		String[] training = modelObj.getArrDeptTraining();
		String[] deputyName = modelObj.getArrDeptDeputyName();
		
		int sizedeptt = modelObj.getArrDepartment().length;
		int sizename = modelObj.getArrDeptName().length;
		int sizedesig = modelObj.getArrDeptDesig().length;
		int sizequali = modelObj.getArrDeptQuali().length;
		int sizeexperience = modelObj.getArrDeptExper().length;
		int sizetraining = modelObj.getArrDeptTraining().length;
		int sizedeputyName = modelObj.getArrDeptDeputyName().length;
		int idSize = modelObj.getIdDept().length;
		
		if(idSize == 1 && sizedeputyName > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizedeputyName; k++){
				deputyName[i] = deputyName[i] +","+  deputyName[k];
			}
		}
		
		if(idSize == 1 && sizetraining > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizetraining; k++){
				training[i] = training[i] +","+  training[k];
			}
		}
		
		if(idSize == 1 && sizeexperience > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeexperience; k++){
				experience[i] = experience[i] +","+  experience[k];
			}
		}
		
		if(idSize == 1 && sizequali > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizequali; k++){
				quali[i] = quali[i] +","+  quali[k];
			}
		}
		
		if(idSize == 1 && sizedesig > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizedesig; k++){
				desig[i] = desig[i] +","+  desig[k];
			}
		}
		
		if(idSize == 1 && sizename > 1){
			//if we pass comma separated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizename; k++){
				name[i] = name[i] +","+  name[k];
			}
		}
		
		if(idSize == 1 && sizedeptt > 1){
			//if we pass comma separated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizedeptt; k++){
				deptt[i] = deptt[i] +","+  deptt[k];
			}
		}
		
		for (int i = 0; i < idSize; i++) 
		{
			AHCAppSubDepttDtlsDomain doaminObj = new AHCAppSubDepttDtlsDomain();
			doaminObj.setStrAppId(modelObj.getAppId());
			doaminObj.setNumRegionId(Integer.parseInt(modelObj.getRegionId()));
			if(deptt.length > i ){
				doaminObj.setStrDepartment(deptt[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(name.length > i ){
				doaminObj.setStrDeptName(name[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(desig.length > i ){
				doaminObj.setStrDeptDesig(desig[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(quali.length > i ){
				doaminObj.setStrDeptQuali(quali[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(experience.length > i ){
				doaminObj.setStrDeptExper(experience[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(training.length > i ){
				doaminObj.setStrDeptTraining(training[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(deputyName.length > i ){
				doaminObj.setStrDeptDeputyName(deputyName[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			applicationSubmissionDao.addDepartmentDetailsAHCRecogApp(doaminObj, openSession);
		}
	}
	
	private void addTestEquipDetailsAHCRecogApp(AHCRecognitionApplicationModel modelObj, Session openSession) {
		applicationSubmissionDao.deleteTestEquipDetailsAHCRecogApp(modelObj.getAppId(),Integer.parseInt(modelObj.getRegionId()), openSession);
		String[] arrIsNo = modelObj.getArrIsNo();
		String[] arrMethodTest = modelObj.getArrMethodTest();
		String[] arrTestFacility = modelObj.getArrTestFacility();
		String[] arrModelType = modelObj.getArrModelType();
		String[] arrRange = modelObj.getArrRange();
		String[] arrLeastCount = modelObj.getArrLeastCount();
		String[] arrValidity = modelObj.getArrValidity();
		String[] arrTraceability = modelObj.getArrTraceability();
		String[] arrRemarksAny = modelObj.getArrRemarksAny();
		
		int sizeArrTraceability = 0;
		int sizeArrValidity = 0;
		int sizeArrIsNo = 0;
		int sizeArrTestFacility = 0;
		int sizeArrModelType = 0;
		int sizeArrRange = 0;
		int sizeArrRemarksAny = 0;
		int idTestEquop = 0;
		int sizeArrLeastCount = 0;
		
		if(modelObj.getArrIsNo()!=null){
			sizeArrIsNo = modelObj.getArrIsNo().length;
		}
		if(modelObj.getArrTestFacility()!=null){
			sizeArrTestFacility = modelObj.getArrTestFacility().length;
		}
		if(modelObj.getArrModelType()!=null){
			sizeArrModelType = modelObj.getArrModelType().length;
		}
		if(modelObj.getArrRange()!=null){
			sizeArrRange = modelObj.getArrRange().length;
		}
		if(modelObj.getArrLeastCount()!=null){
			sizeArrLeastCount = modelObj.getArrLeastCount().length;
		}	
		if(modelObj.getArrRemarksAny()!=null){
			sizeArrRemarksAny = modelObj.getArrRemarksAny().length;
		}
		if(modelObj.getIdTestEquop()!=null){
			idTestEquop = modelObj.getIdTestEquop().length;
		}
		
		if(idTestEquop == 1 && sizeArrIsNo > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrIsNo; k++){
				arrIsNo[i] = arrIsNo[i] +","+  arrIsNo[k];
			}
		}
		
		if(idTestEquop == 1 && sizeArrTestFacility > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrTestFacility; k++){
				arrTestFacility[i] = arrTestFacility[i] +","+  arrTestFacility[k];
			}
		}
		
		if(idTestEquop == 1 && sizeArrModelType > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrModelType; k++){
				arrModelType[i] = arrModelType[i] +","+  arrModelType[k];
			}
		}
		
		if(idTestEquop == 1 && sizeArrRange > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrRange; k++){
				arrRange[i] = arrRange[i] +","+  arrRange[k];
			}
		}
		
		if(idTestEquop == 1 && sizeArrLeastCount > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrLeastCount; k++){
				arrLeastCount[i] = arrLeastCount[i] +","+  arrLeastCount[k];
			}
		}
		
		if(idTestEquop == 1 && sizeArrValidity > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrValidity; k++){
				arrValidity[i] = arrValidity[i] +","+  arrValidity[k];
			}
		}
		
		if(idTestEquop == 1 && sizeArrTraceability > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrTraceability; k++){
				arrTraceability[i] = arrTraceability[i] +","+  arrTraceability[k];
			}
		}
		
		
		if(idTestEquop == 1 && sizeArrRemarksAny > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrRemarksAny; k++){
				arrRemarksAny[i] = arrRemarksAny[i] +","+  arrRemarksAny[k];
			}
		}
			
		/*if(idTestEquop == 1 && sizeCalibrate > 1){
				//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
				int i=0;
				for(int k=1; k < sizeCalibrate; k++){
					Calibrate[i] = Calibrate[i] +","+  Calibrate[k];
				}
			}
			
			if(idTestEquop == 1 && sizeCalibValidUp > 1){
				//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
				int i=0;
				for(int k=1; k < sizeCalibValidUp; k++){
					CalibValidUp[i] = CalibValidUp[i] +","+  CalibValidUp[k];
			}
		}*/
		
		
		for (int i = 0; i < idTestEquop; i++) 
		{
			AHCAppSubTestEquipDomain doaminObj = new AHCAppSubTestEquipDomain();
			doaminObj.setStrAppId(modelObj.getAppId());
			doaminObj.setNumRegionId(Integer.parseInt(modelObj.getRegionId()));
			if(arrIsNo.length > i ){
				doaminObj.setStrIsNo(arrIsNo[i]);
			}
			if(arrMethodTest.length > i ){
				doaminObj.setStrMethodTest(arrMethodTest[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrTestFacility.length > i ){
				doaminObj.setStrTestFacility(arrTestFacility[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrModelType.length > i ){
				doaminObj.setStrModelType(arrModelType[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrRange.length > i ){
				doaminObj.setStrRange(arrRange[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrLeastCount.length > i ){
				doaminObj.setStrLeastCount(arrLeastCount[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrValidity.length > i ){
				doaminObj.setStrValidity(arrValidity[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrTraceability.length > i ){
				doaminObj.setStrTraceability(arrTraceability[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			if(arrRemarksAny.length > i ){
				doaminObj.setStrRemarksAny(arrRemarksAny[i].replaceAll("[^\\x00-\\x7F]",""));
			}
			/*if(Calibrate.length > i ){
				doaminObj.setStrCalibratName(Calibrate[i]);
			}
			if(CalibValidUp.length > i ){
				doaminObj.setStrCalibratValidity(CalibValidUp[i]);
			}*/
		
			applicationSubmissionDao.addTestEquipAHCRecogApp(doaminObj, openSession);
		}				
	}

	private void addTestEquipSilverDetailsAHCRecogApp(AHCRecognitionApplicationModel modelObj, Session openSession) {
		applicationSubmissionDao.deleteTestEquipDetailsAHCRecogAppSilver(modelObj.getAppId(),Integer.parseInt(modelObj.getRegionId()), openSession);
		String[] arrIsNo1 = modelObj.getArrIsNo1();
		String[] arrMethodTest1 = modelObj.getArrMethodTest1();
		String[] arrTestFacility1 = modelObj.getArrTestFacility1();
		String[] arrModelType1 = modelObj.getArrModelType1();
		String[] arrRange1 = modelObj.getArrRange1();
		String[] arrLeastCount1 = modelObj.getArrLeastCount1();
		String[] arrRemarksAny1 = modelObj.getArrRemarksAny1();
		String[] arrTraceability1 = modelObj.getArrTraceability1();
		String[] arrValidity1= modelObj.getArrValidity1();
	/*	String[] Calibrate = modelObj.getArrCalibrate();
		String[] CalibValidUp =modelObj.getArrCalibValidUp();
		
		int sizeCalibrate=0;
		int sizeCalibValidUp =0;*/
		int sizeArrTraceability1 = 0;
		int sizeArrValidity1 = 0;
		int sizeArrIsNo1 = 0;
		int sizeArrTestFacility1 = 0;
		int sizeArrModelType1 = 0;
		int sizeArrRange1 = 0;
		int sizeArrLeastCount1 = 0;
		int sizeArrRemarksAny1 = 0;
		int idTestEquop1 = 0;
		
	/*	if(modelObj.getArrCalibrate()!=null){
			sizeCalibrate =modelObj.getArrCalibrate().length;
		} 
		if(modelObj.getArrCalibValidUp()!=null){
			sizeCalibValidUp = modelObj.getArrCalibValidUp().length;
		}*/
		if(modelObj.getArrIsNo1()!=null){
			sizeArrIsNo1 = modelObj.getArrIsNo1().length;
		} 
		/*if(modelObj.getArrTestFacility1()!=null){
			sizeArrTestFacility1 = modelObj.getArrTestFacility1().length;
		}*/
		if(modelObj.getArrModelType1()!=null){
			sizeArrModelType1 = modelObj.getArrModelType1().length;
		}
		if(modelObj.getArrRange1()!=null){
			sizeArrRange1 = modelObj.getArrRange1().length;
		}
		if(modelObj.getArrLeastCount1()!=null){
			sizeArrLeastCount1 = modelObj.getArrLeastCount1().length;
		}
		if(modelObj.getArrRemarksAny1()!=null){
			sizeArrRemarksAny1 = modelObj.getArrRemarksAny1().length;
		}
		if(modelObj.getIdTestEquop1()!=null){
			idTestEquop1 = modelObj.getIdTestEquop1().length;
		}
		if(modelObj.getArrTraceability1()!=null){
			sizeArrTraceability1 = modelObj.getArrTraceability1().length;
		}
		if(modelObj.getArrValidity1()!=null){
			sizeArrValidity1 = modelObj.getArrValidity1().length;
		}
		//int sizeArrMethodTest = modelObj.getArrMethodTest().length;
		if(idTestEquop1 == 1 && sizeArrIsNo1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrIsNo1; k++){
				arrIsNo1[i] = arrIsNo1[i] +","+  arrIsNo1[k];
			}
		}
		
		if(idTestEquop1 == 1 && sizeArrTestFacility1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrTestFacility1; k++){
				arrTestFacility1[i] = arrTestFacility1[i] +","+  arrTestFacility1[k];
			}
		}
		
		if(idTestEquop1 == 1 && sizeArrModelType1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrModelType1; k++){
				arrModelType1[i] = arrModelType1[i] +","+  arrModelType1[k];
			}
		}
		
		if(idTestEquop1 == 1 && sizeArrRange1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrRange1; k++){
				arrRange1[i] = arrRange1[i] +","+  arrRange1[k];
			}
		}
		
		if(idTestEquop1 == 1 && sizeArrLeastCount1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrLeastCount1; k++){
				arrLeastCount1[i] = arrLeastCount1[i] +","+  arrLeastCount1[k];
			}
		}
		
		
		if(idTestEquop1 == 1 && sizeArrRemarksAny1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrRemarksAny1; k++){
				arrRemarksAny1[i] = arrRemarksAny1[i] +","+  arrRemarksAny1[k];
			}
		}
		
		if(idTestEquop1 == 1 && sizeArrTraceability1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrTraceability1; k++){
				arrTraceability1[i] = arrTraceability1[i] +","+  arrTraceability1[k];
			}
		}
		
		if(idTestEquop1 == 1 && sizeArrValidity1 > 1){
			//if we pass comma seperated values in a single field, then java breaks those values into separated array values which gives wrong results, thus they need to be put together as a one string
			int i=0;
			for(int k=1; k < sizeArrValidity1; k++){
				arrValidity1[i] = arrValidity1[i] +","+  arrValidity1[k];
			}
		}
		
		
		for (int i = 0; i < idTestEquop1; i++) 
		{
			AHCAppSubTestEquipDomain doaminObj = new AHCAppSubTestEquipDomain();
			doaminObj.setStrAppId(modelObj.getAppId());
			doaminObj.setNumRegionId(Integer.parseInt(modelObj.getRegionId()));
			if(arrIsNo1.length > i ){
				doaminObj.setStrIsNo(arrIsNo1[i]);
			}
			if(arrMethodTest1.length > i ){
				doaminObj.setStrMethodTest(arrMethodTest1[i]);
			}
			if(arrTestFacility1.length > i ){
				doaminObj.setStrTestFacility(arrTestFacility1[i]);
			}
			if(arrModelType1.length > i ){
				doaminObj.setStrModelType(arrModelType1[i]);
			}
			if(arrRange1.length > i ){
				doaminObj.setStrRange(arrRange1[i]);
			}
			if(arrLeastCount1.length > i ){
				doaminObj.setStrLeastCount(arrLeastCount1[i]);
			}
			if(arrValidity1.length > i ){
				doaminObj.setStrValidity(arrValidity1[i]);
			}
			if(arrTraceability1.length > i ){
				doaminObj.setStrTraceability(arrTraceability1[i]);
			}
			if(arrRemarksAny1.length > i ){
				doaminObj.setStrRemarksAny(arrRemarksAny1[i]);
			}
		/*	if(arrTraceability1.length > i ){
				doaminObj.setStrCalibratName(arrTraceability1[i]);
			}
			if(arrValidity.length > i ){
				doaminObj.setStrCalibratValidity(arrValidity1[i]);
			}*/
			applicationSubmissionDao.addTestEquipAHCRecogApp(doaminObj, openSession);
		}				
	}
	
	
	@Override
	public AHCApplicationSubmissionDomain getSaveAppDtlsAhcRecog(String appId,int regionId) {
		AHCApplicationSubmissionDomain returnObj = null;
		List<AHCApplicationSubmissionDomain> domainObj = applicationSubmissionDao.getSaveAppDtlsAhcRecog(appId,regionId);
		if(domainObj.size() > 0)
		{			
			returnObj = domainObj.get(0);
		}
		return returnObj;
	}

	
}
