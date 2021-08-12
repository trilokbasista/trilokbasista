package eBIS.nswsAPI.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Global.Registration.Domain.RegisterDomain;

@Repository
public class NSWSServiceUtilityDAO {
//	@Autowired
//	@Qualifier(value="primaryjdbcTemplate")
//	JdbcTemplate primaryjdbcTemplate;
	
	@Autowired
	PrimaryDaoHelper daohelper;

	public int NSWScheckAccesTokenNSWS(String accessToken) {
		String sql="select * from bis_dev.spring_session where session_id='"+accessToken+"'";
		return daohelper.nativeQuery(sql).size();
	}

	public List<RegisterDomain> getManakUserId(String nswsUniqueUser) {
		String sql="select c from RegisterDomain c where c.str_nsws_user_name='"+nswsUniqueUser+"' and c.num_isvalid=1";
		return daohelper.findByQuery(sql);
	}
}
