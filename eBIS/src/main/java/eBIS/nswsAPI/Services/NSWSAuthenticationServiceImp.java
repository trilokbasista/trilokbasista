package eBIS.nswsAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eBIS.Global.Registration.Domain.RegisterDomain;
import eBIS.nswsAPI.DAO.NSWSAuthenticationDAO;
import eBIS.nswsAPI.Domain.NSWSRequestLog;
import eBIS.nswsAPI.Model.NSWSAuthenticationModel;
import eBIS.nswsAPI.Model.NSWSRegistrationModel;

@Service
public class NSWSAuthenticationServiceImp implements NSWSAuthenticationService {
	
	@Autowired
	NSWSAuthenticationDAO dao;
	@Override
	public NSWSRequestLog submitLog(NSWSRequestLog log) {
		return dao.submitLog(log);
		
	}
	@Override
	public int checkExisitingUser(NSWSRegistrationModel model) {
		return dao.checkExisitingUser(model);
		
	}
	@Override
	public List<RegisterDomain> checkExisitingUserforNSWS(NSWSRegistrationModel model) {
		return dao.checkExisitingUserforNSWS(model);
	}
	@Override
	public String generateUserforNSWS(NSWSRegistrationModel model) {
		return dao.generateUserforNSWS(model);
		
	}
	@Override
	public int checkPasswordforNSWS(NSWSAuthenticationModel model) {
		return dao.checkPasswordforNSWS(model);
		
	}

}
