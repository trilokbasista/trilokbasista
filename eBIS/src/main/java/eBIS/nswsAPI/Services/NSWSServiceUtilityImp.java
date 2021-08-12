package eBIS.nswsAPI.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import eBIS.Global.Registration.Domain.RegisterDomain;
import eBIS.nswsAPI.DAO.NSWSServiceUtilityDAO;

@Service
public class NSWSServiceUtilityImp implements NSWSServiceUtility {

	@Autowired
	NSWSServiceUtilityDAO dao;
	@Override
	public int NSWScheckAccesTokenNSWS(String accessToken) {
		return dao.NSWScheckAccesTokenNSWS(accessToken);
	}
	@Override
	public String getManakUserId(String nswsUniqueUser) {
		List<RegisterDomain> list = dao.getManakUserId(nswsUniqueUser);
		String ManakUserId="";
		if(list.size()>0) {
			ManakUserId=list.get(0).getStr_bis_user_id().toString();
		}
		else {
			ManakUserId="0";
		}
		return ManakUserId;
	}

}
