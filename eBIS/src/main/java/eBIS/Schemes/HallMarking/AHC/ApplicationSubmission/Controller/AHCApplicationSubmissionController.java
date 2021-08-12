package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCApplicationSubmissionDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model.AHCAPIResponseModel;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model.AHCRecognitionApplicationModel;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Service.AHCApplicationSubmissionService;
import eBIS.nswsAPI.Services.NSWSServiceUtility;

@RestController
@RequestMapping("API/NSWS")
public class AHCApplicationSubmissionController {
	
	@Autowired
	AHCApplicationSubmissionService ahcApplicationSubmissionService;
	@Autowired
	NSWSServiceUtility NSWSServiceUtilityObject;

	@PostMapping(value = "/AHCRecogAPI")//National Single Window System API
	public @ResponseBody AHCAPIResponseModel saveAPIDetails(@RequestBody AHCRecognitionApplicationModel modelObj, HttpServletRequest request)
	{
		AHCAPIResponseModel ahcAPIResponseModel= new AHCAPIResponseModel();
		try
		{
			String ManakAccessToken = modelObj.getManak_access_token();
			int count = NSWSServiceUtilityObject.NSWScheckAccesTokenNSWS(ManakAccessToken);
			if (count == 0) {
				ahcAPIResponseModel.setDomainObj(null);
				ahcAPIResponseModel.setError(true);
				ahcAPIResponseModel.setResponseMessage("Manak Access Token Expired");
				ahcAPIResponseModel.setStatus(500);
			} else {
				int Userid = 0;
				String[] temp;
				String delimiter = ",";
				String ManakUserId = NSWSServiceUtilityObject.getManakUserId(modelObj.getNsws_unique_username());
				if (ManakUserId.equals("0")) {
					ahcAPIResponseModel.setDomainObj(null);
					ahcAPIResponseModel.setError(true);
					ahcAPIResponseModel.setResponseMessage("User Not Found");
					ahcAPIResponseModel.setStatus(400);
				} else {
					String msg= validateModelData(modelObj);
					if(msg.equalsIgnoreCase(""))
					{
						Userid = Integer.parseInt(ManakUserId);
						modelObj.setApplicationStatus(26);
						String stResponse = ahcApplicationSubmissionService.submitAppDtls(modelObj, request, Userid);
						if(stResponse.equalsIgnoreCase(""))
						{
							ahcAPIResponseModel.setDomainObj(null);
							ahcAPIResponseModel.setError(true);
							ahcAPIResponseModel.setResponseMessage("Exception Occured");
							ahcAPIResponseModel.setStatus(400);
						}
						
						AHCApplicationSubmissionDomain domainObj = ahcApplicationSubmissionService
								.getSaveAppDtlsAhcRecog(modelObj.getAppId(), Integer.parseInt(modelObj.getRegionId()));
						ahcAPIResponseModel.setDomainObj(domainObj);
						ahcAPIResponseModel.setError(false);
						ahcAPIResponseModel.setResponseMessage("Success");
						ahcAPIResponseModel.setStatus(200);
					}
					else
					{
						ahcAPIResponseModel.setDomainObj(null);
						ahcAPIResponseModel.setError(true);
						ahcAPIResponseModel.setResponseMessage(msg);
						ahcAPIResponseModel.setStatus(400);
					}
				}

			}
		}
		catch(Exception e)
		{
			e.printStackTrace();	
			ahcAPIResponseModel.setDomainObj(null);
			ahcAPIResponseModel.setError(true);
			ahcAPIResponseModel.setResponseMessage("Exception Occured");
			ahcAPIResponseModel.setStatus(400);
		}
		return ahcAPIResponseModel;
	}
	
	public String validateModelData(AHCRecognitionApplicationModel modelObj)
	{
		String msg="";
		if(modelObj==null)
		{
			
		}else
		{
			if(modelObj.getCenterName()==null || modelObj.getCenterName().equalsIgnoreCase(""))
			{
				msg="CenterName can not be empty!!";
				return msg;
			}
			if(modelObj.getOffaddr1()==null || modelObj.getOffaddr1().equalsIgnoreCase(""))
			{
				msg="Offaddr1 can not be empty!!";
				return msg;
			}
			/*
			 * if(modelObj.getOffaddr2().equalsIgnoreCase("")) {
			 * 
			 * }
			 */
			if(modelObj.getOffCountry()==null || modelObj.getOffCountry().equalsIgnoreCase(""))
			{
				msg="OffCountry can not be empty!!";
				return msg;
			}	
			if(modelObj.getOffState()==null || modelObj.getOffState().equalsIgnoreCase(""))
			{
				msg="OffState can not be empty!!";
				return msg;
			}	
			if(modelObj.getOffDistrict()==null || modelObj.getOffDistrict().equalsIgnoreCase(""))
			{
				msg="OffDistrict can not be empty!!";
				return msg;
			}	
			if(modelObj.getOffCity()==0)
			{
				msg="OffCity can not be empty!!";
				return msg;
			}	
			if(modelObj.getAhcPincode()==null || modelObj.getAhcPincode().equalsIgnoreCase(""))
			{
				msg="AhcPincode can not be empty!!";
				return msg;
			}	
			if(modelObj.getOffMail()==null || modelObj.getOffMail().equalsIgnoreCase(""))
			{
				msg="OffMail can not be empty!!";
				return msg;
			}	
			if(modelObj.getOffMobNo()==null || modelObj.getOffMobNo().equalsIgnoreCase(""))
			{
				msg="OffMobNo can not be empty!!";
				return msg;
			}	
			if(modelObj.getAhcLatitude()==null || modelObj.getAhcLatitude().equalsIgnoreCase(""))
			{
				msg="AhcLatitude can not be empty!!";
				return msg;
			}	
			if(modelObj.getAhcLongitude()==null || modelObj.getAhcLongitude().equalsIgnoreCase(""))
			{
				msg="AhcLongitude can not be empty!!";
				return msg;
			}
			if(modelObj.getRdoAddress()==null || modelObj.getRdoAddress().equalsIgnoreCase("") )
			{
				msg="RdoAddress can not be empty!!";
				return msg;
			}
			if(modelObj.getRdoAddress().equalsIgnoreCase("Y"))//If registered office address different from AHC address
			{
				if(modelObj.getRegaddr1()==null || modelObj.getRegaddr1().equalsIgnoreCase(""))
				{
					msg="Regaddr1 can not be empty!!";
					return msg;
				}	
				if(modelObj.getRegCountry()==null || modelObj.getRegCountry().equalsIgnoreCase(""))
				{
					msg="RegCountry can not be empty!!";
					return msg;
				}	
				if(modelObj.getRegState()==null || modelObj.getRegState().equalsIgnoreCase(""))
				{
					msg="RegState can not be empty!!";
					return msg;
				}	
				if(modelObj.getRegDistrict()==null || modelObj.getRegDistrict().equalsIgnoreCase(""))
				{
					msg="RegDistrict can not be empty!!";
					return msg;
				}	
				if(modelObj.getRegCity()==0)
				{
					msg="RegCity can not be empty!!";
					return msg;
				}	
				if(modelObj.getOfficePincode()==null || modelObj.getOfficePincode().equalsIgnoreCase(""))
				{
					msg="OfficePincode can not be empty!!";
					return msg;
				}	
				if(modelObj.getRegMail()==null || modelObj.getRegMail().equalsIgnoreCase(""))
				{
					msg="RegMail can not be empty!!";
					return msg;
				}	
				if(modelObj.getRegMobNo()==null || modelObj.getRegMobNo().equalsIgnoreCase(""))
				{
					msg="RegMobNo can not be empty!!";
					return msg;
				}	
			}
			if(modelObj.getOwnerName()==null || modelObj.getOwnerName().equalsIgnoreCase(""))
			{
				msg="OwnerName can not be empty!!";
				return msg;
			}	
			if(modelObj.getOwnerDesig()==null || modelObj.getOwnerDesig().equalsIgnoreCase(""))
			{
				msg="OwnerDesig can not be empty!!";
				return msg;
			}	
			if(modelObj.getTypeOwnership()==null || modelObj.getTypeOwnership().equalsIgnoreCase(""))
			{
				msg="TypeOwnership can not be empty!!";
				return msg;
			}	
			if(modelObj.getRecogAppliedFor()==null || modelObj.getRecogAppliedFor().equalsIgnoreCase(""))
			{
				msg="RecogAppliedFor can not be empty!!";
				return msg;
			}	
			if(modelObj.getCenterOwnerDetailsDTOList()==null || modelObj.getCenterOwnerDetailsDTOList().size()==0)
			{
				msg="CenterOwnerDetailsDTOList can not be empty!!";
				return msg;
			}	
			if(modelObj.getNamePerQualityMngmtCntr()==null || modelObj.getNamePerQualityMngmtCntr().equalsIgnoreCase(""))
			{
				msg="NamePerQualityMngmtCntr can not be empty!!";
				return msg;
			}	
			if(modelObj.getDesigPerQualityMngmtCntr()==null || modelObj.getDesigPerQualityMngmtCntr().equalsIgnoreCase(""))
			{
				msg="DesigPerQualityMngmtCntr can not be empty!!";
				return msg;
			}	
			if(modelObj.getNoOfEmpCenter()==null || modelObj.getNoOfEmpCenter().equalsIgnoreCase(""))
			{
				msg="NoOfEmpCenter can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDepartment()==null || modelObj.getArrDepartment().length==0)
			{
				msg="ArrDepartment can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDeptName()==null || modelObj.getArrDeptName().length==0)
			{
				msg="ArrDeptName can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDeptDesig()==null || modelObj.getArrDeptDesig().length==0)
			{
				msg="ArrDeptDesig can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDeptQuali()==null || modelObj.getArrDeptQuali().length==0)
			{
				msg="ArrDeptQuali can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDeptExper()==null || modelObj.getArrDeptExper().length==0)
			{
				msg="ArrDeptExper can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDeptTraining()==null || modelObj.getArrDeptTraining().length==0)
			{
				msg="ArrDeptTraining can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrDeptDeputyName()==null || modelObj.getArrDeptDeputyName().length==0)
			{
				msg="ArrDeptDeputyName can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrIsNo()==null || modelObj.getArrIsNo().length==0)
			{
				msg="ArrIsNo can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrMethodTest()==null || modelObj.getArrMethodTest().length==0)
			{
				msg="ArrMethodTest can not be empty!!";
				return msg;
			}
			if(modelObj.getArrTestFacility()==null || modelObj.getArrTestFacility().length==0)
			{
				msg="ArrTestFacility can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrModelType()==null || modelObj.getArrModelType().length==0)
			{
				msg="ArrModelType can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrRange()==null || modelObj.getArrRange().length==0)
			{
				msg="ArrRange can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrLeastCount()==null || modelObj.getArrLeastCount().length==0)
			{
				msg="ArrLeastCount can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrValidity()==null || modelObj.getArrValidity().length==0)
			{
				msg="ArrValidity can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrTraceability()==null || modelObj.getArrTraceability().length==0)
			{
				msg="ArrTraceability can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrRemarksAny()==null || modelObj.getArrRemarksAny().length==0)
			{
				msg="ArrRemarksAny can not be empty!!";
				return msg;
			}
			if(modelObj.getArrIsNo1()==null || modelObj.getArrIsNo1().length==0)
			{
				msg="ArrIsNo1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrMethodTest1()==null || modelObj.getArrMethodTest1().length==0)
			{
				msg="ArrMethodTest1 can not be empty!!";
				return msg;
			}
			if(modelObj.getArrTestFacility1()==null || modelObj.getArrTestFacility1().length==0)
			{
				msg="ArrTestFacility1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrModelType1()==null || modelObj.getArrModelType1().length==0)
			{
				msg="ArrModelType1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrRange1()==null || modelObj.getArrRange1().length==0)
			{
				msg="ArrRange1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrLeastCount1()==null || modelObj.getArrLeastCount1().length==0)
			{
				msg="ArrLeastCount1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrValidity1()==null || modelObj.getArrValidity1().length==0)
			{
				msg="ArrValidity1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrTraceability1()==null || modelObj.getArrTraceability1().length==0)
			{
				msg="ArrTraceability1 can not be empty!!";
				return msg;
			}	
			if(modelObj.getArrRemarksAny1()==null || modelObj.getArrRemarksAny1().length==0)
			{
				msg="ArrRemarksAny1 can not be empty!!";
				return msg;
			}
			if(modelObj.getLayOutSpace()==null || modelObj.getLayOutSpace().equalsIgnoreCase(""))
			{
				msg="LayOutSpace can not be empty!!";
				return msg;
			}	
			if(modelObj.getStrAssayRroomSpace()==null || modelObj.getStrAssayRroomSpace().equalsIgnoreCase(""))
			{
				msg="StrAssayRroomSpace can not be empty!!";
				return msg;
			}	
			if(modelObj.getWaterSupplySource()==null || modelObj.getWaterSupplySource().equalsIgnoreCase(""))
			{
				msg="WaterSupplySource can not be empty!!";
				return msg;
			}	
			if(modelObj.getHalideFreeWater()==null || modelObj.getHalideFreeWater().equalsIgnoreCase(""))
			{
				msg="HalideFreeWater can not be empty!!";
				return msg;
			}	
			if(modelObj.getPowerSupplySource()==null || modelObj.getPowerSupplySource().equalsIgnoreCase(""))
			{
				msg="PowerSupplySource can not be empty!!";
				return msg;
			}	
			if(modelObj.getAvailableLoad()==null || modelObj.getAvailableLoad().equalsIgnoreCase(""))
			{
				msg="AvailableLoad can not be empty!!";
				return msg;
			}	
			if(modelObj.getGeneratorCapacity()==null || modelObj.getGeneratorCapacity().equalsIgnoreCase(""))
			{
				msg="GeneratorCapacity can not be empty!!";
				return msg;
			}	
			if(modelObj.getLoadRequirement()==null || modelObj.getLoadRequirement().equalsIgnoreCase(""))
			{
				msg="LoadRequirement can not be empty!!";
				return msg;
			}	
			if(modelObj.getUninterruptedPower()==null || modelObj.getUninterruptedPower().equalsIgnoreCase(""))
			{
				msg="UninterruptedPower can not be empty!!";
				return msg;
			}	
			if(modelObj.getUninterruptedPower()==null || modelObj.getUninterruptedPower().equalsIgnoreCase("No"))
			{
				if(modelObj.getUninterruptedPowerReason()==null || modelObj.getUninterruptedPowerReason().equalsIgnoreCase(""))
				{
					msg="UninterruptedPowerReason can not be empty!!";
					return msg;
				}	
			}
			if(modelObj.getElectricMeterNumber()==null || modelObj.getElectricMeterNumber().equalsIgnoreCase(""))
			{
				msg="ElectricMeterNumber can not be empty!!";
				return msg;
			}
			if(modelObj.getCentreAccredited()==null || modelObj.getCentreAccredited().equalsIgnoreCase(""))
			{
				msg="CentreAccredited can not be empty!!";
				return msg;
			}
			if(modelObj.getCentreAccredited()==null || modelObj.getCentreAccredited().equalsIgnoreCase("Yes"))
			{
				if(modelObj.getAccreditationValidity()==null || modelObj.getAccreditationValidity().equalsIgnoreCase(""))
				{
					msg="AccreditationValidity can not be empty!!";
					return msg;
				}
			}
			if(modelObj.getQualityManualImplemented()==null || modelObj.getQualityManualImplemented().equalsIgnoreCase(""))
			{
				msg="QualityManualImplemented can not be empty!!";
				return msg;
			}
			if(modelObj.getProficiencyTesting()==null || modelObj.getProficiencyTesting().equalsIgnoreCase(""))
			{
				msg="ProficiencyTesting can not be empty!!";
				return msg;
			}
			
			if(modelObj.getProficiencyTesting()==null || modelObj.getProficiencyTesting().equalsIgnoreCase("No"))
			{
				if(modelObj.getProficiencyTestingReason()==null || modelObj.getProficiencyTestingReason().equalsIgnoreCase(""))
				{
					msg="ProficiencyTestingReason can not be empty!!";
					return msg;
				}
			}
			if(modelObj.getControllingAccess()==null || modelObj.getControllingAccess().equalsIgnoreCase(""))
			{
				msg="ControllingAccess can not be empty!!";
				return msg;
			}
			if(modelObj.getControllingAccess()==null || modelObj.getControllingAccess().equalsIgnoreCase("No"))
			{
				if(modelObj.getControllingAccessReason()==null || modelObj.getControllingAccessReason().equalsIgnoreCase(""))
				{
					msg="ControllingAccessReason can not be empty!!";
					return msg;
				}
			}
			
			if(modelObj.getEnsuringSecurity()==null || modelObj.getEnsuringSecurity().equalsIgnoreCase(""))
			{
				msg="EnsuringSecurity can not be empty!!";
				return msg;
			}
			if(modelObj.getEnsuringSecurity()==null || modelObj.getEnsuringSecurity().equalsIgnoreCase("No"))
			{
				if(modelObj.getEnsuringSecurityReason()==null || modelObj.getEnsuringSecurityReason().equalsIgnoreCase(""))
				{
					msg="EnsuringSecurityReason can not be empty!!";
					return msg;
				}
			}
			if(modelObj.getIndemnityInsurance()==null || modelObj.getIndemnityInsurance().equalsIgnoreCase(""))
			{
				msg="IndemnityInsurance can not be empty!!";
				return msg;
			}
			if(modelObj.getIndemnityInsurance()==null || modelObj.getIndemnityInsurance().equalsIgnoreCase("Yes"))
			{
				if(modelObj.getIndemnityInsurancePolicy()==null || modelObj.getIndemnityInsurancePolicy().equalsIgnoreCase(""))
				{
					msg="IndemnityInsurancePolicy can not be empty!!";
					return msg;
				}
				if(modelObj.getIndemnityInsuranceAmount()==null || modelObj.getIndemnityInsuranceAmount().equalsIgnoreCase(""))
				{
					msg="IndemnityInsuranceAmount can not be empty!!";
					return msg;
				}
				if(modelObj.getIndemnityInsuranceValidity()==null || modelObj.getIndemnityInsuranceValidity().equalsIgnoreCase(""))
				{
					msg="IndemnityInsuranceValidity can not be empty!!";
					return msg;
				}
				
			}
			
			
			if(modelObj.getArtefactsInsurance()==null || modelObj.getArtefactsInsurance().equalsIgnoreCase(""))
			{
				msg="ArtefactsInsurance can not be empty!!";
				return msg;
			}
			if(modelObj.getArtefactsInsurance()==null || modelObj.getArtefactsInsurance().equalsIgnoreCase("Yes"))
			{
				if(modelObj.getArtefactsInsuranceAmount()==null || modelObj.getArtefactsInsuranceAmount().equalsIgnoreCase(""))
				{
					msg="ArtefactsInsuranceAmount can not be empty!!";
					return msg;
				}
				if(modelObj.getArtefactsInsurancePolicy()==null || modelObj.getArtefactsInsurancePolicy().equalsIgnoreCase(""))
				{
					msg="ArtefactsInsurancePolicy can not be empty!!";
					return msg;
				}
				if(modelObj.getArtefactsInsuranceValidity()==null || modelObj.getArtefactsInsuranceValidity().equalsIgnoreCase(""))
				{
					msg="ArtefactsInsuranceValidity can not be empty!!";
					return msg;
				}
			}
			
			if(modelObj.getAssessmentReadyDt()==null || modelObj.getAssessmentReadyDt().equalsIgnoreCase(""))
			{
				msg="AssessmentReadyDt can not be empty!!";
				return msg;
			}
			
			
				
		}
		return msg;
	}
}

