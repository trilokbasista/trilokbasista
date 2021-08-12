package eBIS.exception.log.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
import eBIS.Configuration.ReadonlyDaoHelper;
import eBIS.exception.log.domain.ExceptionLog;
import eBIS.exception.log.model.ExceptionLogModel;

@Repository
public class ExceptionLogDAO {
	@Autowired
	ReadonlyDaoHelper readonlydaohelper;
	@Autowired
	PrimaryDaoHelper daohelper;

	public ExceptionLogModel insertexceptionlog(ExceptionLogModel exceptionmodel) {
		SessionFactory sf = daohelper.transactionsession();
		Session opensession = sf.openSession();
		Transaction tx = null;
		try {
			tx = opensession.beginTransaction();
			ExceptionLog domain=new ExceptionLog();
			domain.setException_details(exceptionmodel.getException_details());
			domain.setUser_remarks(exceptionmodel.getUser_remarks());
			domain.setException_remarks(exceptionmodel.getException_remarks());
			domain=(ExceptionLog) opensession.merge(domain);
			exceptionmodel.setException_details(domain.getException_details());
			exceptionmodel.setUser_remarks(domain.getUser_remarks());
			exceptionmodel.setException_remarks(domain.getException_remarks());
			exceptionmodel.setException_date(domain.getException_date());
			exceptionmodel.setIs_valid(domain.getIs_valid());
			exceptionmodel.setNum_id(domain.getNum_id());
			tx.commit();
		}catch(Exception ex) {
			tx.rollback();
			ex.printStackTrace();
		}finally {
			opensession.clear();
	       	opensession.close();
		}
		return exceptionmodel;
	}

	public List<ExceptionLog> getUnsolvedExceptionLogList() {
		String sql=" select c from ExceptionLog c where c.is_valid=1";
		List<ExceptionLog> list = readonlydaohelper.findByQuery(sql);
		return list;
	}

	public List<ExceptionLog> getSolvedExceptionLogList() {
		String sql=" select c from ExceptionLog c where c.is_valid=0";
		List<ExceptionLog> list = readonlydaohelper.findByQuery(sql);
		return list;
	}

	public List<ExceptionLog> getExceptiondetails(String numid) {
		String sql=" select c from ExceptionLog c where c.num_id="+numid;
		List<ExceptionLog> list = readonlydaohelper.findByQuery(sql);
		return list;
	}
}
