package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TWeixiu;

/**
 * A data access object (DAO) providing persistence and search support for
 * TWeixiu entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TWeixiu
 * @author MyEclipse Persistence Tools
 */

public class TWeixiuDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TWeixiuDAO.class);
	// property constants
	public static final String SBID = "sbid";
	public static final String WXSJ = "wxsj";
	public static final String WXNR = "wxnr";
	public static final String WXR = "wxr";
	public static final String WXJE = "wxje";
	public static final String BZ = "bz";

	protected void initDao() {
		// do nothing
	}

	public void save(TWeixiu transientInstance) {
		log.debug("saving TWeixiu instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TWeixiu persistentInstance) {
		log.debug("deleting TWeixiu instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TWeixiu findById(java.lang.Integer id) {
		log.debug("getting TWeixiu instance with id: " + id);
		try {
			TWeixiu instance = (TWeixiu) getHibernateTemplate().get(
					"com.model.TWeixiu", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TWeixiu instance) {
		log.debug("finding TWeixiu instance by example");
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
		log.debug("finding TWeixiu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TWeixiu as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySbid(Object sbid) {
		return findByProperty(SBID, sbid);
	}

	public List findByWxsj(Object wxsj) {
		return findByProperty(WXSJ, wxsj);
	}

	public List findByWxnr(Object wxnr) {
		return findByProperty(WXNR, wxnr);
	}

	public List findByWxr(Object wxr) {
		return findByProperty(WXR, wxr);
	}

	public List findByWxje(Object wxje) {
		return findByProperty(WXJE, wxje);
	}

	public List findByBz(Object bz) {
		return findByProperty(BZ, bz);
	}

	public List findAll() {
		log.debug("finding all TWeixiu instances");
		try {
			String queryString = "from TWeixiu";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TWeixiu merge(TWeixiu detachedInstance) {
		log.debug("merging TWeixiu instance");
		try {
			TWeixiu result = (TWeixiu) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TWeixiu instance) {
		log.debug("attaching dirty TWeixiu instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TWeixiu instance) {
		log.debug("attaching clean TWeixiu instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TWeixiuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TWeixiuDAO) ctx.getBean("TWeixiuDAO");
	}
}