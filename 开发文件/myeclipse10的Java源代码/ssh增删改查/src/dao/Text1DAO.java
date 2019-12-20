package dao;

import java.util.List;

import javax.jms.Session;
import javax.transaction.Transaction;

import org.hibernate.LockMode;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sun.xml.internal.messaging.saaj.packaging.mime.util.BEncoderStream;

/**
 * A data access object (DAO) providing persistence and search support for Text1
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see dao.Text1
 * @author MyEclipse Persistence Tools
 */
public class Text1DAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(Text1DAO.class);
	// property constants
	public static final String NAME = "name";

	public void save(Text1 transientInstance) {
		log.debug("saving Text1 instance");
		try {
			 org.hibernate.Session session = getSession();
			 org.hibernate.Transaction beginTransaction = session.beginTransaction();
			 getSession().save(transientInstance);
			 beginTransaction.commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Text1 persistentInstance) {
		log.debug("deleting Text1 instance");
		try {
			 org.hibernate.Session session = getSession();
			 org.hibernate.Transaction beginTransaction = session.beginTransaction();
			 getSession().delete(persistentInstance);
			 beginTransaction.commit();
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}
	
	public void saveOrUpdate(Text1 persistentInstance) {
		try {
			 org.hibernate.Session session = getSession();
			 org.hibernate.Transaction beginTransaction = session.beginTransaction();
			 //saveOrUpdate����id����
			 getSession().saveOrUpdate(persistentInstance);
			 beginTransaction.commit();
		} catch (RuntimeException re) {
			throw re;
		}
	}
	public Text1 findById(java.math.BigDecimal id) {
		log.debug("getting Text1 instance with id: " + id);
		try {
			Text1 instance = (Text1) getSession().get("dao.Text1", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Text1 instance) {
		log.debug("finding Text1 instance by example");
		try {
			List results = getSession().createCriteria("dao.Text1")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Text1 instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Text1 as model where model."
					+ propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List findAll() {
		log.debug("finding all Text1 instances");
		try {
			String queryString = "from Text1";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}
	public List findAll(String name) {
		log.debug("finding all Text1 instances");
		try {
			String queryString = "from Text1 where name=?";
			Query queryObject = getSession().createQuery(queryString).setParameter(0, name);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Text1 merge(Text1 detachedInstance) {
		log.debug("merging Text1 instance");
		try {
			Text1 result = (Text1) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Text1 instance) {
		log.debug("attaching dirty Text1 instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Text1 instance) {
		log.debug("attaching clean Text1 instance");
		try {
			getSession().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}