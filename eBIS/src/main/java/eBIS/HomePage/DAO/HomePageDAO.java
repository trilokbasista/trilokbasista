package eBIS.HomePage.DAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import eBIS.Configuration.PrimaryDaoHelper;
//import eBIS.nswsAPI.Domain.BypassPaymentHM;


@Repository
public class HomePageDAO {

	@Autowired
	PrimaryDaoHelper daohelper;

	public void getcount() {
//		String sql="select c from BypassPaymentHM c";
//		Transaction tx = null;
//		SessionFactory sf = daohelper.transactionsession();
//		Session opensession = sf.openSession();
//		try {
//			tx = opensession.beginTransaction();
//			BypassPaymentHM domain=new BypassPaymentHM();
//			domain.setAppID("1");
//			domain.setBranchId("1");
//			domain.setDt_entry_date(new Date());
//			domain.setNum_std_year("1");
//			domain.setStr_application_id_ref("1");
//			domain.setStr_cml_no("1");
//			domain.setStr_is_number("1");
//			domain.setStrUserId("1");
//			domain.setType("1");
//			opensession.persist(domain);
//			System.out.println(domain.toString());
//			tx.commit();
//		}catch(Exception ex) {
//			tx.rollback();
//		}
//		finally {
//	       	opensession.clear();
//	       	opensession.close();
//	       }
//		List<BypassPaymentHM> list = daohelper.findByQuery(sql);
//		if(list.size()>0)
//		{
//			for(int i=0;i<list.size();i++)
//			{
//				System.out.println("list["+i+"]: "+list.get(i).toString());
//			}
//		}else {
//			System.out.println("Not Found");
//		}
	}
	
}
