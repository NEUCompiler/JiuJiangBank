package Operater.db;

import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import static org.hibernate.criterion.Example.create;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

/**
 * A data access object (DAO) providing persistence and search support for
 * Operater entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see Operater.db.Operater
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class OperaterDAO {
	private static final Logger log = LoggerFactory
			.getLogger(OperaterDAO.class);
	// property constants
	public static final String OPERATER_NAME = "operaterName";
	public static final String OPERATER_PASS_W = "operaterPassW";
	public static final String OPERATER_TYPE = "operaterType";
	public static final String OPERATER_SEX = "operaterSex";

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

	public boolean save(Operater transientInstance) {
		log.debug("saving Operater instance");
		try {
			ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionFactory = (SessionFactory) c.getBean("sessionFactory");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(transientInstance);
			session.getTransaction().commit(); 
			log.debug("save successful");
			return true;
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public boolean delete(Integer operaterName) {
		log.debug("deleting Operater instance");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		Operater O= (Operater) session.get(Operater.class, operaterName);
		try {
			session.beginTransaction();
			session.delete(O);
	        session.getTransaction().commit(); 
			log.debug("delete successful");
			return true;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Operater findById(java.lang.Integer id) {
		log.debug("getting Operater instance with id: " + id);
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			Operater instance = (Operater) session.get("Operater.db.Operater", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Operater> findByExample(Operater instance) {
		log.debug("finding Operater instance by example");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			List<Operater> results = (List<Operater>) session
					.createCriteria("Operater.db.Operater")
					.add(create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Operater instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Operater as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Operater> findByOperaterName(Object operaterName) {
		return findByProperty(OPERATER_NAME, operaterName);
	}

	public List<Operater> findByOperaterPassW(Object operaterPassW) {
		return findByProperty(OPERATER_PASS_W, operaterPassW);
	}

	public List<Operater> findByOperaterType(Object operaterType) {
		return findByProperty(OPERATER_TYPE, operaterType);
	}

	public List<Operater> findByOperaterSex(Object operaterSex) {
		return findByProperty(OPERATER_SEX, operaterSex);
	}

	public List findAll() {
		log.debug("finding all Operater instances");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			String queryString = "from Operater";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Operater merge(Operater detachedInstance) {
		log.debug("merging Operater instance");
		try {
			Operater result = (Operater) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Operater instance) {
		log.debug("attaching dirty Operater instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Operater instance) {
		log.debug("attaching clean Operater instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static OperaterDAO getFromApplicationContext(ApplicationContext ctx) {
		return (OperaterDAO) ctx.getBean("OperaterDAO");
	}

	public Boolean update(Operater o) {
		try {
			ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionFactory = (SessionFactory) c.getBean("sessionFactory");
			Session session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(o);
			session.getTransaction().commit(); 
			log.debug("save successful");
			return true;
			
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}
}