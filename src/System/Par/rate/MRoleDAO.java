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
 * A data access object (DAO) providing persistence and search support for MRole
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see System.Par.rate.MRole
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class MRoleDAO {
	private static final Logger log = LoggerFactory.getLogger(MRoleDAO.class);
	// property constants
	public static final String ROLE_NAME = "roleName";
	public static final String AU_ID = "auId";
	public static final String ROLE_EXPL = "roleExpl";

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

	public void save(MRole transientInstance) {
		log.debug("saving MRole instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(MRole persistentInstance) {
		log.debug("deleting MRole instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public MRole findById(java.lang.Integer id) {
		log.debug("getting MRole instance with id: " + id);
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			MRole instance = (MRole) session.get(
					"System.Par.rate.MRole", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(MRole instance) {
		log.debug("finding MRole instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("System.Par.rate.MRole")
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
		log.debug("finding MRole instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from MRole as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByRoleName(Object roleName) {
		return findByProperty(ROLE_NAME, roleName);
	}

	public List findByAuId(Object auId) {
		return findByProperty(AU_ID, auId);
	}

	public List findByRoleExpl(Object roleExpl) {
		return findByProperty(ROLE_EXPL, roleExpl);
	}

	public List findAll() {
		log.debug("finding all MRole instances");
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			String queryString = "from MRole";
			Query queryObject =session.createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public MRole merge(MRole detachedInstance) {
		log.debug("merging MRole instance");
		try {
			MRole result = (MRole) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(MRole instance) {
		log.debug("attaching dirty MRole instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(MRole instance) {
		log.debug("attaching clean MRole instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MRoleDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MRoleDAO) ctx.getBean("MRoleDAO");
	}

	public void update(MRole m) {
		ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
		sessionFactory = (SessionFactory) c.getBean("sessionFactory");
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			session.update(m);
//			session.flush();
			session.getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		
	}
}
