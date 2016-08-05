package System.Par.bigdeal;

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
 * Bigdeal entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see System.Par.bigdeal.Bigdeal
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class BigdealDAO {
	private static final Logger log = LoggerFactory.getLogger(BigdealDAO.class);
	// property constants
	public static final String AMOUNT = "amount";
	public static final String AHEADTIME = "aheadtime";

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

	public void save(Bigdeal transientInstance) {
		log.debug("saving Bigdeal instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Bigdeal persistentInstance) {
		log.debug("deleting Bigdeal instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Bigdeal findById(java.lang.Integer id) {
		log.debug("getting Bigdeal instance with id: " + id);
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			Bigdeal instance = (Bigdeal) session.get(
					"System.Par.bigdeal.Bigdeal", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Bigdeal instance) {
		log.debug("finding Bigdeal instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("System.Par.bigdeal.Bigdeal")
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
		log.debug("finding Bigdeal instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Bigdeal as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAmount(Object amount) {
		return findByProperty(AMOUNT, amount);
	}

	public List findByAheadtime(Object aheadtime) {
		return findByProperty(AHEADTIME, aheadtime);
	}

	public List findAll() {
		log.debug("finding all Bigdeal instances");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			String queryString = "from Bigdeal";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Bigdeal merge(Bigdeal detachedInstance) {
		log.debug("merging Bigdeal instance");
		try {
			Bigdeal result = (Bigdeal) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Bigdeal instance) {
		log.debug("attaching dirty Bigdeal instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Bigdeal instance) {
		log.debug("attaching clean Bigdeal instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static BigdealDAO getFromApplicationContext(ApplicationContext ctx) {
		return (BigdealDAO) ctx.getBean("BigdealDAO");
	}

	public void update(Bigdeal b) {
		
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(b);
			session.getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		

	}
}