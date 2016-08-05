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

import com.ob.dao.ClientDAO;
import com.ob.model.Client;

/**
 * A data access object (DAO) providing persistence and search support for
 * Client entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ob.model.Client
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class ClientDAOImpl implements ClientDAO {
	private static final Logger log = LoggerFactory.getLogger(ClientDAO.class);
	// property constants
	public static final String IDENTITYID = "identityid";
	public static final String TRUENAME = "truename";
	public static final String SEX = "sex";
	public static final String PHONE = "phone";
	public static final String MAIL = "mail";
	public static final String ACCOUNTTYPE = "accounttype";
	public static final String USERNAME = "username";
	public static final String USERPASSWORD = "userpassword";

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

	public void save(Client transientInstance) {
		log.debug("saving Client instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Client persistentInstance) {
		log.debug("deleting Client instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Client findById(java.lang.Integer id) {
		log.debug("getting Client instance with id: " + id);
		try {
			Client instance = (Client) getCurrentSession().get(
					"com.ob.model.Client", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Client instance) {
		log.debug("finding Client instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ob.model.Client")
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
		log.debug("finding Client instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Client as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByIdentityid(Object identityid) {
		return findByProperty(IDENTITYID, identityid);
	}

	public List findByTruename(Object truename) {
		return findByProperty(TRUENAME, truename);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByPhone(Object phone) {
		return findByProperty(PHONE, phone);
	}

	public List findByMail(Object mail) {
		return findByProperty(MAIL, mail);
	}

	public List findByAccounttype(Object accounttype) {
		return findByProperty(ACCOUNTTYPE, accounttype);
	}

	public List findByUsername(Object username) {
		return findByProperty(USERNAME, username);
	}

	public List findByUserpassword(Object userpassword) {
		return findByProperty(USERPASSWORD, userpassword);
	}

	public List findAll() {
		log.debug("finding all Client instances");
		try {
			String queryString = "from Client";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Client merge(Client detachedInstance) {
		log.debug("merging Client instance");
		try {
			Client result = (Client) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Client instance) {
		log.debug("attaching dirty Client instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Client instance) {
		log.debug("attaching clean Client instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static ClientDAO getFromApplicationContext(ApplicationContext ctx) {
		return (ClientDAO) ctx.getBean("ClientDAO");
	}
}