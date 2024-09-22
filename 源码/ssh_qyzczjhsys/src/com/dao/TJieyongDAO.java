package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TJieyong;

/**
 * A data access object (DAO) providing persistence and search support for
 * TJieyong entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TJieyong
 * @author MyEclipse Persistence Tools
 */

public class TJieyongDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TJieyongDAO.class);
	// property constants
	public static final String XSID = "xsid";
	public static final String SBID = "sbid";
	public static final String JYSJ = "jysj";
	public static final String KHSJ = "khsj";
	public static final String SFSH = "sfsh";
	public static final String PCJE = "pcje";
	public static final String BZ = "bz";
	public static final String ZT = "zt";

	protected void initDao() {
		// do nothing
	}

	public void save(TJieyong transientInstance) {
		log.debug("saving TJieyong instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TJieyong persistentInstance) {
		log.debug("deleting TJieyong instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TJieyong findById(java.lang.Integer id) {
		log.debug("getting TJieyong instance with id: " + id);
		try {
			TJieyong instance = (TJieyong) getHibernateTemplate().get(
					"com.model.TJieyong", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TJieyong instance) {
		log.debug("finding TJieyong instance by example");
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
		log.debug("finding TJieyong instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TJieyong as model where model."
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

	public List findByJysj(Object jysj) {
		return findByProperty(JYSJ, jysj);
	}

	public List findByKhsj(Object khsj) {
		return findByProperty(KHSJ, khsj);
	}

	public List findBySfsh(Object sfsh) {
		return findByProperty(SFSH, sfsh);
	}

	public List findByPcje(Object pcje) {
		return findByProperty(PCJE, pcje);
	}

	public List findByBz(Object bz) {
		return findByProperty(BZ, bz);
	}

	public List findByZt(Object zt) {
		return findByProperty(ZT, zt);
	}

	public List findAll() {
		log.debug("finding all TJieyong instances");
		try {
			String queryString = "from TJieyong";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TJieyong merge(TJieyong detachedInstance) {
		log.debug("merging TJieyong instance");
		try {
			TJieyong result = (TJieyong) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TJieyong instance) {
		log.debug("attaching dirty TJieyong instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TJieyong instance) {
		log.debug("attaching clean TJieyong instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TJieyongDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TJieyongDAO) ctx.getBean("TJieyongDAO");
	}
}