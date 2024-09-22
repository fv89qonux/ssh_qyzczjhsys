package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShenqing;

/**
 * A data access object (DAO) providing persistence and search support for
 * TShenqing entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TShenqing
 * @author MyEclipse Persistence Tools
 */

public class TShenqingDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TShenqingDAO.class);
	// property constants
	public static final String XSID = "xsid";
	public static final String SBID = "sbid";
	public static final String SQSJ = "sqsj";
	public static final String SPYJ = "spyj";
	public static final String ZT = "zt";

	protected void initDao() {
		// do nothing
	}

	public void save(TShenqing transientInstance) {
		log.debug("saving TShenqing instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TShenqing persistentInstance) {
		log.debug("deleting TShenqing instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TShenqing findById(java.lang.Integer id) {
		log.debug("getting TShenqing instance with id: " + id);
		try {
			TShenqing instance = (TShenqing) getHibernateTemplate().get(
					"com.model.TShenqing", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShenqing instance) {
		log.debug("finding TShenqing instance by example");
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
		log.debug("finding TShenqing instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TShenqing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByXsid(Object xsid) {
		return findByProperty(XSID, xsid);
	}

	public List findBySbid(Object sbid) {
		return findByProperty(SBID, sbid);
	}

	public List findBySqsj(Object sqsj) {
		return findByProperty(SQSJ, sqsj);
	}

	public List findBySpyj(Object spyj) {
		return findByProperty(SPYJ, spyj);
	}

	public List findByZt(Object zt) {
		return findByProperty(ZT, zt);
	}

	public List findAll() {
		log.debug("finding all TShenqing instances");
		try {
			String queryString = "from TShenqing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShenqing merge(TShenqing detachedInstance) {
		log.debug("merging TShenqing instance");
		try {
			TShenqing result = (TShenqing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShenqing instance) {
		log.debug("attaching dirty TShenqing instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TShenqing instance) {
		log.debug("attaching clean TShenqing instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TShenqingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TShenqingDAO) ctx.getBean("TShenqingDAO");
	}
}