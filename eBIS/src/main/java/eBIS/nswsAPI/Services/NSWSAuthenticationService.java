package eBIS.nswsAPI.Services;

import java.util.List;

import eBIS.Global.Registration.Domain.RegisterDomain;
import eBIS.nswsAPI.Domain.NSWSRequestLog;
import eBIS.nswsAPI.Model.NSWSAuthenticationModel;
import eBIS.nswsAPI.Model.NSWSRegistrationModel;

public interface NSWSAuthenticationService {

	NSWSRequestLog submitLog(NSWSRequestLog log);

	int checkExisitingUser(NSWSRegistrationModel model);

	List<RegisterDomain> checkExisitingUserforNSWS(NSWSRegistrationModel model);

	String generateUserforNSWS(NSWSRegistrationModel model);

	int checkPasswordforNSWS(NSWSAuthenticationModel model);
}
