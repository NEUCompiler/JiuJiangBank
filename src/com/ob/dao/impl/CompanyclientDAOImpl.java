package com.ob.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;
import com.ob.dao.CompanyclientDAO;
import com.ob.model.Companyclient;

public class CompanyclientDAOImpl implements CompanyclientDAO {
	private static final Logger log = LoggerFactory
			.getLogger(CompanyclientDAO.class);
	// property constants
	public static final String USERNAME = "username";
	public static final String USERPASSWORD = "userpassword";
	public static final String ADDDEALPASSWORD = "adddealpassword";
	public static final String PHONE = "phone";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Companyclient transientInstance) {
		log.debug("saving Companyclient instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Companyclient persistentInstance) {
		log.debug("deleting Companyclient instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Companyclient findById(java.lang.Integer id) {
		log.debug("getting Companyclient instance with id: " + id);
		try {
			Companyclient instance = (Companyclient) getCurrentSession().get(
					"com.ob.model.Companyclient", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Companyclient instance) {
		log.debug("finding Companyclient instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ob.model.Companyclient")
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
		log.debug("finding Companyclient instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Companyclient as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByUserpassword(Object userpassword) {
		return findByProperty(USERPASSWORD, userpassword);
	}

	public List findByAdddealpassword(Object adddealpassword) {
		return findByProperty(ADDDEALPASSWORD, adddealpassword);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findAll() {
		log.debug("finding all Companyclient instances");
		try {
			String queryString = "from Companyclient";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Companyclient merge(Companyclient detachedInstance) {
		log.debug("merging Companyclient instance");
		try {
			Companyclient result = (Companyclient) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Companyclient instance) {
		log.debug("attaching dirty Companyclient instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Companyclient instance) {
		log.debug("attaching clean Companyclient instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CompanyclientDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CompanyclientDAO) ctx.getBean("CompanyclientDAO");
	}
}
