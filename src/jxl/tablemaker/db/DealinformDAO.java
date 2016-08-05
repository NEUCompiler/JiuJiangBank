package jxl.tablemaker.db;

import java.util.Date;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dealinform entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see jxl.tablemaker.db.Dealinform
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DealinformDAO {
	private static final Logger log = LoggerFactory
			.getLogger(DealinformDAO.class);
	// property constants
	public static final String ACCOUNTID = "accountid";
	public static final String DEALINFORM = "dealinform";
	public static final String DEALTYPE = "dealtype";
	public static final String DEAL_DESTI = "dealDesti";
	public static final String DEALSTATE = "dealstate";
	public static final String DEAAMOUNTL = "deaamountl";

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

	public void save(Dealinform transientInstance) {
		log.debug("saving Dealinform instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Dealinform persistentInstance) {
		log.debug("deleting Dealinform instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Dealinform findById(java.lang.String id) {
		log.debug("getting Dealinform instance with id: " + id);
		try {
			Dealinform instance = (Dealinform) getCurrentSession().get(
					"jxl.tablemaker.db.Dealinform", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Dealinform instance) {
		log.debug("finding Dealinform instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("jxl.tablemaker.db.Dealinform")
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
		log.debug("finding Dealinform instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Dealinform as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAccountid(Object accountid) {
		return findByProperty(ACCOUNTID, accountid);
	}

	public List findByDealinform(Object dealinform) {
		return findByProperty(DEALINFORM, dealinform);
	}

	public List findByDealtype(Object dealtype) {
		return findByProperty(DEALTYPE, dealtype);
	}

	public List findByDealDesti(Object dealDesti) {
		return findByProperty(DEAL_DESTI, dealDesti);
	}

	public List findByDealstate(Object dealstate) {
		return findByProperty(DEALSTATE, dealstate);
	}

	public List findByDeaamountl(Object deaamountl) {
		return findByProperty(DEAAMOUNTL, deaamountl);
	}

	public List findAll() {
		log.debug("finding all Dealinform instances");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			String queryString = "from Dealinform";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Dealinform merge(Dealinform detachedInstance) {
		log.debug("merging Dealinform instance");
		try {
			Dealinform result = (Dealinform) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Dealinform instance) {
		log.debug("attaching dirty Dealinform instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Dealinform instance) {
		log.debug("attaching clean Dealinform instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DealinformDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DealinformDAO) ctx.getBean("DealinformDAO");
	}
}