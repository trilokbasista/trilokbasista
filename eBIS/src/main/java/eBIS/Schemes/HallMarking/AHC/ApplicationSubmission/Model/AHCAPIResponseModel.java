package eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Model;

import eBIS.Schemes.HallMarking.AHC.ApplicationSubmission.Domain.AHCApplicationSubmissionDomain;

public class AHCAPIResponseModel {
	private AHCApplicationSubmissionDomain domainObj;
	private String responseMessage;
	private boolean isError;
	private int status;
	
	public AHCApplicationSubmissionDomain getDomainObj() {
		return domainObj;
	}
	public void setDomainObj(AHCApplicationSubmissionDomain domainObj) {
		this.domainObj = domainObj;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}
	public String getResponseMessage() {
		return responseMessage;
	}
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
