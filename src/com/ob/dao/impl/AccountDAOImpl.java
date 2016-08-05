package com.ob.dao.impl;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;

import com.ob.dao.AccountDAO;
import com.ob.model.Account;

public class AccountDAOImpl implements AccountDAO {
	private static final Logger log = LoggerFactory.getLogger(AccountDAO.class);
	// property constants
	public static final String DEALPASSWORD = "dealpassword";
	public static final String AMOUNT = "amount";
	public static final String TERM = "term";
	public static final String ISLOSS = "isloss";
	public static final String CDLIMIT = "cdlimit";
	public static final String INTEGRATE = "integrate";
	public static final String ISACTIVE = "isactive";
	public static final String ISOPENOB = "isopenob";
	public static final String CLIENTID = "clientid";
	public static final String SIGN = "sign";
	public static final String IDENTITYID = "identityid";
	public static final String OTHERNAME = "othername";
	public static final String SEARCHPASSWORD = "searchpassword";
	public static final String DEALWITHOUTPASSWORD = "dealwithoutpassword";

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

	public void save(Account transientInstance) {
		log.debug("saving Account instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Account persistentInstance) {
		log.debug("deleting Account instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Account findById(java.lang.String id) {
		log.debug("getting Account instance with id: " + id);
		try {
			Account instance = (Account) getCurrentSession().get(
					"com.ob.model.Account", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Account instance) {
		log.debug("finding Account instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ob.model.Account")
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
		log.debug("finding Account instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Account as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDealpassword(Object dealpassword) {
		return findByProperty(DEALPASSWORD, dealpassword);
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByTerm(Object term) {
		return findByProperty(TERM, term);
	}

	public List findByIsloss(Object isloss) {
		return findByProperty(ISLOSS, isloss);
	}

	public List findByCdlimit(Object cdlimit) {
		return findByProperty(CDLIMIT, cdlimit);
	}

	public List findByIntegrate(Object integrate) {
		return findByProperty(INTEGRATE, integrate);
	}

	public List findByIsactive(Object isactive) {
		return findByProperty(ISACTIVE, isactive);
	}

	public List findByIsopenob(Object isopenob) {
		return findByProperty(ISOPENOB, isopenob);
	}

	public List findByClientid(Object clientid) {
		return findByProperty(CLIENTID, clientid);
	}

	public List findBySign(Object sign) {
		return findByProperty(SIGN, sign);
	}

	public List findByIdentityid(Object identityid) {
		return findByProperty(IDENTITYID, identityid);
	}

	public List findByOthername(Object othername) {
		return findByProperty(OTHERNAME, othername);
	}

	public List findBySearchpassword(Object searchpassword) {
		return findByProperty(SEARCHPASSWORD, searchpassword);
	}

	public List findByDealwithoutpassword(Object dealwithoutpassword) {
		return findByProperty(DEALWITHOUTPASSWORD, dealwithoutpassword);
	}

	public List findAll() {
		log.debug("finding all Account instances");
		try {
			String queryString = "from Account";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Account merge(Account detachedInstance) {
		log.debug("merging Account instance");
		try {
			Account result = (Account) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Account instance) {
		log.debug("attaching dirty Account instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Account instance) {
		log.debug("attaching clean Account instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AccountDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AccountDAO) ctx.getBean("AccountDAO");
	}
	
	//WZJ
	//通过accountid获取accountInfo
	public List getAccountInfo(String clientid){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		Query query=session.createQuery("from Account where clientid="+clientid);
		List accountInfo = query.list();
		session.close();
		return accountInfo;
	}
	//修改Account
	public boolean addOrUpdateAccount(Account account){
		Session session = sessionFactory.openSession();
		Transaction ts = session.beginTransaction();
		session.saveOrUpdate(account);
		ts.commit();
		session.close();
		return true;
	}
}
