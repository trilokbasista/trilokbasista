package eBIS.nswsAPI.DAO;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Global.CommonUtility.Service.BCrypt;
import eBIS.Global.Registration.Domain.BisUserSalts;
import eBIS.Global.Registration.Domain.RegisterDomain;
import eBIS.exception.log.domain.ExceptionLog;
import eBIS.nswsAPI.Domain.NSWSAuthentication;
import eBIS.nswsAPI.Domain.NSWSRequestLog;
import eBIS.nswsAPI.Model.NSWSAuthenticationModel;
import eBIS.nswsAPI.Model.NSWSRegistrationModel;

@Repository
public class NSWSAuthenticationDAO {
	static int startlpad=1;
	@Autowired
	PrimaryDaoHelper daohelper;
	public synchronized NSWSRequestLog submitLog(NSWSRequestLog log) {
		Transaction tx = null;
		NSWSRequestLog t=null;
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		try {
			tx = opensession.beginTransaction();
			//System.out.println("Before:"+log.toString());
			t = (NSWSRequestLog) opensession.merge(log);
			System.out.println("After:"+t.toString());
			tx.commit();
		}catch(Exception ex) {
			tx.rollback();
			ExceptionLog exceptiondomain=new ExceptionLog();
			exceptiondomain.setException_date(new Date());
			exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
			exceptiondomain.setException_remarks(ex.getLocalizedMessage());
			exceptiondomain.setIs_valid("1");
			exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
			exceptiondomain=(ExceptionLog) opensession.merge(exceptiondomain);
			JSONObject dataJson = new JSONObject();
			try {
				dataJson.put("ex_id", exceptiondomain.getNum_id());
				dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
				dataJson.toString();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		finally {
	       	opensession.clear();
	       	opensession.close();
	       }
		return t;
	}
	public int checkExisitingUser(NSWSRegistrationModel model) {
		String sql="select c from RegisterDomain c where c.str_nsws_user_name=0 and c.str_email='"+model.getNswsUserEmail()+"'";
		return daohelper.findByQuery(sql).size();
		
	}
	public List<RegisterDomain> checkExisitingUserforNSWS(NSWSRegistrationModel model) {
		String sql="select c from RegisterDomain c where c.str_nsws_user_name='"+model.getNswsUniqueUser()+"' and c.str_email='"+model.getNswsUserEmail()+"'";
		return daohelper.findByQuery(sql);
	}
	public  int checkPasswordforNSWS(NSWSAuthenticationModel model) {
		String sql="select c from NSWSAuthentication c where c.nsws_id='"+model.getNswsId()+"' and c.nsws_key='"+model.getNswsKey()+"'";
		List<NSWSAuthentication> list = daohelper.findByQuery(sql);
		return list.size();		
	}
	public String generateUserforNSWS(NSWSRegistrationModel model) {
		String str[] = encode("bis123");
		int maxId = getMaxUserId();  
		maxId=maxId+1;
		String firstName = model.getNswsUserFirstName();
		String lastName = model.getNswsUserLastName();
		String userName = generateUniqueUsername(firstName, lastName);
		RegisterDomain regDom = convertRegisterModelToRegisterDomain(model,str[1], userName,maxId);
		BisUserSalts bus = new BisUserSalts();
		bus.setSalts(str[0]);  
		bus.setUser_id1(maxId);
		int flag = addRegisterandsalt(regDom,bus);
		if(flag!=1) {
			userName="0";
		}
		return userName;
	}
	private RegisterDomain convertRegisterModelToRegisterDomain(NSWSRegistrationModel regModel,String str, String userName, int maxId) {
		RegisterDomain regDom = new RegisterDomain();
		regDom.setStr_security_question_answer("");
		String stDOB = regModel.getNswsUserDOB();
		regDom.setDt_dob(stDOB);
		regDom.setStr_email(regModel.getNswsUserEmail());
		regDom.setStr_fname(regModel.getNswsUserFirstName());
		regDom.setStr_mname(regModel.getNswsUserMiddleName());
		regDom.setStr_lname(regModel.getNswsUserLastName());
		regDom.setStr_user_name(userName);
		regDom.setStr_password(str);
		regDom.setNum_mobile(regModel.getNswsUserMobile());
		regDom.setStr_status("A");
		regDom.setStr_bis_user_id(maxId);
		regDom.setEntry_emp_id(maxId);
		regDom.setStr_bis_emp_id(0);
		regDom.setNum_isvalid(1);
		regDom.setStr_nsws_user_name(regModel.getNswsUniqueUser());
		return regDom;
	}
	private synchronized int addRegisterandsalt(RegisterDomain regDom, BisUserSalts bus) {
		Transaction tx = null;
		RegisterDomain t=null;
		BisUserSalts t1=null;
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		int flag=-1;
		try {
			tx = opensession.beginTransaction();
			t = (RegisterDomain) opensession.merge(regDom);
			System.out.println("addRegister After:"+t.toString());
			t1 = (BisUserSalts) opensession.merge(bus);
			System.out.println("addSalt After:"+t1.toString());
			tx.commit();
			flag=1;
		}catch(Exception ex) {
			tx.rollback();
			flag=0;
			ex.printStackTrace();
			ExceptionLog exceptiondomain=new ExceptionLog();
			exceptiondomain.setException_date(new Date());
			exceptiondomain.setException_details(Arrays.toString(ex.getStackTrace()));
			exceptiondomain.setException_remarks(ex.getLocalizedMessage());
			exceptiondomain.setIs_valid("1");
			exceptiondomain.setUser_remarks(ex.getClass().getSimpleName());
			exceptiondomain=(ExceptionLog) opensession.merge(exceptiondomain);
			JSONObject dataJson = new JSONObject();
			try {
				dataJson.put("ex_id", exceptiondomain.getNum_id());
				dataJson.put("ex_reason", exceptiondomain.getUser_remarks());
				dataJson.toString();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		finally {
	       	opensession.clear();
	       	opensession.close();
	       }
		return flag;
	}

	private String generateUniqueUsername(String stFName, String stLName) {
		int maxlenforlpad=5;
		String stUsername = generateUniqueUsernamenew(startlpad,maxlenforlpad);
		 int iCheckUsername = checkUsername(stUsername);
		 if(iCheckUsername!=0){
			startlpad=startlpad+1;
			stUsername=generateUniqueUsername(stFName, stLName);
		}
		return stUsername;
	}
	private int checkUsername(String stUsername) {
		String qry = "SELECT rdom FROM RegisterDomain rdom WHERE rdom.str_user_name='"+stUsername+"'";
		List<RegisterDomain> runQry = daohelper.findByQuery(qry);
		return runQry.size();
	}
	private String generateUniqueUsernamenew(int startlpad2, int maxlenforlpad) {
		String qry = "select 'ns'||'ws'||lpad('"+startlpad+"',"+maxlenforlpad+",'0') as uname";
		 List<Object> list = daohelper.nativeQuery(qry);
		return list.get(0).toString();
	}

	private int getMaxUserId() {
		int maxId = 0;
		String qry = "SELECT nvl(max(str_bis_user_id),0) as str_bis_user_id FROM bis_dev.user_registration_mst where str_bis_user_id ilike '15%' and length(str_bis_user_id)=9";
		 List<Object> list = daohelper.nativeQuery(qry);
		 String maxIdList = list.get(0).toString();
		if(Integer.parseInt(maxIdList)==0){			
			maxId = 150000000;
			}
		else{
			maxId = Integer.parseInt(maxIdList);
		}
		return maxId;
	}
	private String[] encode(String stPlainPwd_p) {
		String stSalt = BCrypt.gensalt();		//Generating Salt
		String stHash = BCrypt.hashpw(stPlainPwd_p, stSalt);	//Encrypting the password with the salt generated above
		String a_stEncrypted[] = {stSalt,stHash};
		return a_stEncrypted;
	}

}
