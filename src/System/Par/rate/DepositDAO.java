package System.Par.rate;

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
 * Deposit entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see System.Par.rate.Deposit
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class DepositDAO {
	private static final Logger log = LoggerFactory.getLogger(DepositDAO.class);
	// property constants
	public static final String RATE = "rate";
	public static final String INTEREST = "interest";
	public static final String TIME = "time";
	public static final String SIGN = "sign";

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

	public void save(Deposit transientInstance) {
		log.debug("saving Deposit instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Deposit persistentInstance) {
		log.debug("deleting Deposit instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Deposit findById(java.lang.Integer id) {
		log.debug("getting Deposit instance with id: " + id);
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			Deposit instance = (Deposit) session.get(
					"System.Par.rate.Deposit", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Deposit instance) {
		log.debug("finding Deposit instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("System.Par.rate.Deposit")
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
		log.debug("finding Deposit instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Deposit as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRate(Object rate) {
		return findByProperty(RATE, rate);
	}

	public List findByInterest(Object interest) {
		return findByProperty(INTEREST, interest);
	}

	public List findByTime(Object time) {
		return findByProperty(TIME, time);
	}

	public List findBySign(Object sign) {
		return findByProperty(SIGN, sign);
	}

	public List findAll() {
		log.debug("finding all Deposit instances");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			String queryString = "from Deposit";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Deposit merge(Deposit detachedInstance) {
		log.debug("merging Deposit instance");
		try {
			Deposit result = (Deposit) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Deposit instance) {
		log.debug("attaching dirty Deposit instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Deposit instance) {
		log.debug("attaching clean Deposit instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static DepositDAO getFromApplicationContext(ApplicationContext ctx) {
		return (DepositDAO) ctx.getBean("DepositDAO");
	}

	public void udate(Deposit d) {
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(d);
//			session.flush();
			session.getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}
}