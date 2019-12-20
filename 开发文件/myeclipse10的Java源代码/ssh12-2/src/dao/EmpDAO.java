package dao;

import java.sql.Timestamp;
import java.util.List;
import org.hibernate.LockMode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import entity.Emp;

/**
 * A data access object (DAO) providing persistence and search support for Emp
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see entity.Emp
 * @author MyEclipse Persistence Tools
 */
public class EmpDAO extends HibernateDaoSupport {
	private static final Logger log = LoggerFactory.getLogger(EmpDAO.class);
	// property constants
	public static final String ENAME = "ename";
	public static final String JOB = "job";
	public static final String MGR = "mgr";
	public static final String SAL = "sal";
	public static final String COMM = "comm";

	protected void initDao() {
		// do nothing
	}

	public void save(Emp transientInstance) {
		log.debug("saving Emp instance");
		try {
			
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Emp persistentInstance) {
		log.debug("deleting Emp instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Emp findById(java.lang.Short id) {
		log.debug("getting Emp instance with id: " + id);
		try {
			Emp instance = (Emp) getHibernateTemplate().get("dao.Emp", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Emp instance) {
		log.debug("finding Emp instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Emp instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Emp as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByEname(Object ename) {
		return findByProperty(ENAME, ename);
	}

	public List findByJob(Object job) {
		return findByProperty(JOB, job);
	}

	public List findByMgr(Object mgr) {
		return findByProperty(MGR, mgr);
	}

	public List findBySal(Object sal) {
		return findByProperty(SAL, sal);
	}

	public List findByComm(Object comm) {
		return findByProperty(COMM, comm);
	}

	public List findAll() {
		log.debug("finding all Emp instances");
		try {
			String queryString = "from Emp";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Emp merge(Emp detachedInstance) {
		log.debug("merging Emp instance");
		try {
			Emp result = (Emp) getHibernateTemplate().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Emp instance) {
		log.debug("attaching dirty Emp instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Emp instance) {
		log.debug("attaching clean Emp instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static EmpDAO getFromApplicationContext(ApplicationContext ctx) {
		return (EmpDAO) ctx.getBean("EmpDAO");
	}
}