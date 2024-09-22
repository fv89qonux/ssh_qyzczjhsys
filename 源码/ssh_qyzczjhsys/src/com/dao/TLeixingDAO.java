package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TLeixing;

/**
 * A data access object (DAO) providing persistence and search support for
 * TLeixing entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TLeixing
 * @author MyEclipse Persistence Tools
 */

public class TLeixingDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TLeixingDAO.class);
	// property constants
	public static final String MIAOSHU = "miaoshu";
	public static final String DEL = "del";

	protected void initDao() {
		// do nothing
	}

	public void save(TLeixing transientInstance) {
		log.debug("saving TLeixing instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TLeixing persistentInstance) {
		log.debug("deleting TLeixing instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TLeixing findById(java.lang.Integer id) {
		log.debug("getting TLeixing instance with id: " + id);
		try {
			TLeixing instance = (TLeixing) getHibernateTemplate().get(
					"com.model.TLeixing", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TLeixing instance) {
		log.debug("finding TLeixing instance by example");
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
		log.debug("finding TLeixing instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TLeixing as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByMiaoshu(Object miaoshu) {
		return findByProperty(MIAOSHU, miaoshu);
	}

	public List findByDel(Object del) {
		return findByProperty(DEL, del);
	}

	public List findAll() {
		log.debug("finding all TLeixing instances");
		try {
			String queryString = "from TLeixing";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TLeixing merge(TLeixing detachedInstance) {
		log.debug("merging TLeixing instance");
		try {
			TLeixing result = (TLeixing) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TLeixing instance) {
		log.debug("attaching dirty TLeixing instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TLeixing instance) {
		log.debug("attaching clean TLeixing instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TLeixingDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TLeixingDAO) ctx.getBean("TLeixingDAO");
	}
}