package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Dao;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCAppSubDepttDtlsDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCAppSubTestEquipDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCApplicationSubmissionDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCCenterOwnerDetailsDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.BranchMasterDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.DistrictMstDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.UserSubSchemeMappingDomain;

@Repository
public class AHCApplicationSubmissionDao {

	@Autowired
	PrimaryDaoHelper daoHelper;
	
	
	public void submitUserDtls(UserSubSchemeMappingDomain domainObj,Session openSession) {
		openSession.merge(domainObj);
	}
	
	public List<AHCApplicationSubmissionDomain> getSaveAppDtlsAhcRecog(String appId,int regionId) {
		String qry = "SELECT c from AHCApplicationSubmissionDomain c where c.strAppId = '"+ appId + "' and c.numRegionId="+regionId+"";
		System.out.println("query...-"+qry);
		return daoHelper.findByQuery(qry);
	}
	
	public void submitAhcRecogApp1(AHCApplicationSubmissionDomain domainObj, Session openSession) {
		//daoHelper.maintainRecordInLog(new firmDtlsDomainLog() , FirmDtlsDomainObj);
		if(domainObj.getNumId()==0)
		{
			openSession.persist(domainObj); //To get New Generated id for entry in new table 
		}
		else
		{
			openSession.merge(domainObj);
		}
	}
	
	public void deleteCenterOwnerDetailsAHCRecogApp(long appId, Session openSession) {
		String query="delete from AHCCenterOwnerDetailsDomain r where r.applicationIdFk="+appId;
		openSession.createQuery(query).executeUpdate();
	}
	
	public void saveCenterOwnerDetails(AHCCenterOwnerDetailsDomain ahcCenterOwnerDetailsDomain,  Session openSession)
	{
		openSession.merge(ahcCenterOwnerDetailsDomain);		
	}
	
	public String getRegionIdFromBranchId(int branchId) 
	{
		String regionId="";
		try
		{
			String qry="select c from BranchMasterDomain c where c.numBranchId ="+branchId+"";
			List<BranchMasterDomain> branchMasteDomainList=daoHelper.findByQuery(qry);
			if(branchMasteDomainList.size()>0)
			{
				regionId= String.valueOf(branchMasteDomainList.get(0).getNumRoId());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			System.out.println("roid...-"+regionId);
			return regionId;
	}
	
	public List getMaxAppIdFrmRegionId(int regionId) {
		String qry = "SELECT max(c.strAppId) from AHCApplicationSubmissionDomain c where c.strAppId like '"+ regionId + "%'";
		return daoHelper.findByQuery(qry);
	}
	
	public List<DistrictMstDomain> getBranchIdFrmAppid(int distId)  
	{
		String query="select r from DistrictMstDomain r where r.numDistrictId="+distId+"";
		return daoHelper.findByQuery(query);	
	}
	
	public void deleteDepartmentDetailsAHCRecogApp(String appId,int regionId,Session openSession) {
		String query="delete from AHCAppSubDepttDtlsDomain r where r.strAppId='"+appId+"' and r.numRegionId="+regionId+"";
		openSession.createQuery(query).executeUpdate();
	}
	
	public void addDepartmentDetailsAHCRecogApp(AHCAppSubDepttDtlsDomain domainObj,Session openSession) {
		openSession.merge(domainObj);
	}
	
	public void deleteTestEquipDetailsAHCRecogApp(String appId,int regionId, Session openSession) {
		String query="delete from AHCAppSubTestEquipDomain r where r.strAppId='"+appId+"' and r.numRegionId="+regionId+" and r.strIsNo='1417'";
		openSession.createQuery(query).executeUpdate();
	}
	
	public void addTestEquipAHCRecogApp(AHCAppSubTestEquipDomain domainObj,  Session openSession) {
		openSession.merge(domainObj);
	}
	
	public void deleteTestEquipDetailsAHCRecogAppSilver(String appId,int regionId,  Session openSession) {
		String query="delete from AHCAppSubTestEquipDomain r where r.strAppId='"+appId+"' and r.numRegionId="+regionId+" and r.strIsNo='2112'";
		openSession.createQuery(query).executeUpdate();
	}
}
