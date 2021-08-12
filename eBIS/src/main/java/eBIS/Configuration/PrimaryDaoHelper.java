package eBIS.Configuration;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PrimaryDaoHelper {

	@Autowired
	@PersistenceContext(unitName="primaryPersistence")
	@Qualifier(value="primaryEntityManager")
	private EntityManager entityManager;
	public PrimaryDaoHelper() {
	}

	public PrimaryDaoHelper(final EntityManager entityManager) {
		this.entityManager = entityManager;
	}	
	
	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public synchronized SessionFactory transactionsession() {
		entityManager=entityManager.getEntityManagerFactory().createEntityManager();
        SessionFactory sf = entityManager.unwrap(Session.class).getSessionFactory();
        return sf;
	}

	public synchronized <T> T findById(final Class<T> entityClass, final Object id) {
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		T ObjectList = null;
		try {
			if (null == entityClass)
				throw new IllegalArgumentException("entityClass can't be null");
			if (null == id)
				throw new IllegalArgumentException("id can't be null");
			ObjectList = opensession.find(entityClass, id);
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			opensession.clear();
			opensession.close();
		}
		return ObjectList;
	}
	public <T> List<T> findByQuery(final String hql) {
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		List<T> ObjectList = null;
		try {
			Query query = opensession.createQuery(hql);
			ObjectList = castResultList(query.getResultList());
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
	       	opensession.clear();
	       	opensession.close();
	    }
		return ObjectList;
	}
	private synchronized <T> List<T> castResultList(List<?> results) {
		return (List<T>) results;
	}
	
	public synchronized <T> List<T> findByFun(String fun, final Object attributeValue) {
		List<T> ObjectList = null;
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		try {
			if (null == attributeValue)
				throw new IllegalArgumentException("attributeValue can't be null");
			String hql = "select "+fun+"(?1) and num_is_valid=1";
			Query query = opensession.createQuery(hql);
			query.setParameter(1, attributeValue);
			ObjectList = castResultList(query.getResultList());
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			opensession.clear();
			opensession.close();
		}
		return ObjectList;
	}

	public synchronized <T> List<T> findByQuery(final String hql,int start,int end) {
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		List<T> ObjectList = null;
		try {
			Query query = opensession.createQuery(hql).setFirstResult(start).setMaxResults(end);
			ObjectList = castResultList(query.getResultList());
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
	       	opensession.clear();
	       	opensession.close();
	    }
		return ObjectList;
	}


	public synchronized <T> List<T> findByQueryWithLimits(final String hql, int iFirstResult, int iMaxResults) {
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		List<T> ObjectList = null;
		try {
			Query query = opensession.createQuery(hql).setFirstResult(iFirstResult).setMaxResults(iMaxResults);
			ObjectList = castResultList(query.getResultList());
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
	       	opensession.clear();
	       	opensession.close();
	    }
		return ObjectList;
	}
	public synchronized List nativeQuery(String hql)
	{
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		List ObjectList = null;
		try {
			Query query = opensession.createNativeQuery(hql);
			ObjectList = query.getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
	       	opensession.clear();
	       	opensession.close();
	    }
		return ObjectList;
	}
	
	public int deleteByQuery(final String query) {
		SessionFactory sf = transactionsession();
		Session opensession = sf.openSession();
		int result = 0;
		try {
			result=entityManager.createQuery(query).executeUpdate();	
		}catch(Exception ex) {
			ex.printStackTrace();
		}finally {
	       	opensession.clear();
	       	opensession.close();
	    }
		return result;
	}
	
	
}
