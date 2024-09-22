package com.dao;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.model.TShebei;

/**
 * A data access object (DAO) providing persistence and search support for
 * TShebei entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.model.TShebei
 * @author MyEclipse Persistence Tools
 */

public class TShebeiDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(TShebeiDAO.class);
	// property constants
	public static final String LXID = "lxid";
	public static final String BH = "bh";
	//public static final String FUJIAN = "fujian";

	public static final String MIAOSHU = "miaoshu";
	public static final String GOUMAISHIJIAN = "goumaishijian";
	public static final String DEL = "del";

	protected void initDao() {
		// do nothing
	}

	public void save(TShebei transientInstance) {
		log.debug("saving TShebei instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TShebei persistentInstance) {
		log.debug("deleting TShebei instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TShebei findById(java.lang.Integer id) {
		log.debug("getting TShebei instance with id: " + id);
		try {
			TShebei instance = (TShebei) getHibernateTemplate().get(
					"com.model.TShebei", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(TShebei instance) {
		log.debug("finding TShebei instance by example");
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
		log.debug("finding TShebei instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from TShebei as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByLxid(Object lxid) {
		return findByProperty(LXID, lxid);
	}

	public List findByBh(Object bh) {
		return findByProperty(BH, bh);
	}
	/*public List findByFujian(Object fujian) {
		return findByProperty(FUJIAN, fujian);
	}*/

	public List findByMiaoshu(Object miaoshu) {
		return findByProperty(MIAOSHU, miaoshu);
	}

	public List findByGoumaishijian(Object goumaishijian) {
		return findByProperty(GOUMAISHIJIAN, goumaishijian);
	}

	public List findByDel(Object del) {
		return findByProperty(DEL, del);
	}

	public List findAll() {
		log.debug("finding all TShebei instances");
		try {
			String queryString = "from TShebei";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TShebei merge(TShebei detachedInstance) {
		log.debug("merging TShebei instance");
		try {
			TShebei result = (TShebei) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TShebei instance) {
		log.debug("attaching dirty TShebei instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TShebei instance) {
		log.debug("attaching clean TShebei instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static TShebeiDAO getFromApplicationContext(ApplicationContext ctx) {
		return (TShebeiDAO) ctx.getBean("TShebeiDAO");
	}
}