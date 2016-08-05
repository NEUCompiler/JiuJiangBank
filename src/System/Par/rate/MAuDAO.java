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
 * A data access object (DAO) providing persistence and search support for MAu
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see System.Par.rate.MAu
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MAuDAO {
	private static final Logger log = LoggerFactory.getLogger(MAuDAO.class);
	// property constants
	public static final String AU_NAME = "auName";
	public static final String AU_PATH = "auPath";
	public static final String PARENTAU_ID = "parentauId";
	public static final String STATE = "state";

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

	public void save(MAu transientInstance) {
		log.debug("saving MAu instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MAu persistentInstance) {
		log.debug("deleting MAu instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MAu findById(java.lang.Integer id) {
		log.debug("getting MAu instance with id: " + id);
		try {
			MAu instance = (MAu) getCurrentSession().get("System.Par.rate.MAu",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MAu instance) {
		log.debug("finding MAu instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("System.Par.rate.MAu")
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
		log.debug("finding MAu instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MAu as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByAuName(Object auName) {
		return findByProperty(AU_NAME, auName);
	}

	public List findByAuPath(Object auPath) {
		return findByProperty(AU_PATH, auPath);
	}

	public List findByParentauId(Object parentauId) {
		return findByProperty(PARENTAU_ID, parentauId);
	}

	public List findByState(Object state) {
		return findByProperty(STATE, state);
	}

	public List findAll() {
		log.debug("finding all MAu instances");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			String queryString = "from MAu";
			Query queryObject = session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MAu merge(MAu detachedInstance) {
		log.debug("merging MAu instance");
		try {
			MAu result = (MAu) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MAu instance) {
		log.debug("attaching dirty MAu instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MAu instance) {
		log.debug("attaching clean MAu instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MAuDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MAuDAO) ctx.getBean("MAuDAO");
	}
}