package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Service;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCApplicationSubmissionDomain;
import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model.AHCRecognitionApplicationModel;

public interface AHCApplicationSubmissionService {

	@Transactional(propagation=Propagation.REQUIRED)
	public String submitAppDtls(AHCRecognitionApplicationModel modelObj, HttpServletRequest request,int Userid);
	
	/*
	 * @Transactional(propagation=Propagation.REQUIRED) public String
	 * submitAppDtls1(AHCRecognitionApplicationModel modelObj, HttpServletRequest
	 * request,Session openSession);
	 * 
	 * @Transactional(propagation=Propagation.REQUIRED) public String
	 * submitAppDtls2(AHCRecognitionApplicationModel modelObj, HttpServletRequest
	 * request, Session openSession);
	 */
	
	@Transactional(propagation=Propagation.REQUIRED)
	public AHCApplicationSubmissionDomain getSaveAppDtlsAhcRecog(String appId, int regionId);
}
