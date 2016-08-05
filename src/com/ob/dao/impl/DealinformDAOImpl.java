package com.ob.dao.impl;

import java.util.Iterator;
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
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ob.dao.DealinformDAO;
import com.ob.model.Account;
import com.ob.model.Dealinform;

public class DealinformDAOImpl implements DealinformDAO {
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
					"com.ob.model.Dealinform", id);
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
					.createCriteria("com.ob.model.Dealinform")
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
	
	//WZJ
	//通过accountid获得Account集合
		public List getAccountDeal(String accountid){
			Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			Query query=session.createQuery("from Account where accountid='"+accountid+"'");
			List accountDeal = query.list();
			session.close();
			return accountDeal;
		}
		//通过accountid获得转账信息
		public List getTransferInfo(String accountid) {
			Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			Query query=session.createQuery("from Dealinform where accountid='"+accountid+"'and dealstate = 0");
			List transferInfo = query.list();
			session.close();
			return transferInfo;
		}
		
		//通过accountid获得交易信息
		public List getDealinformInfo(String accountid){
			Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			Query query=session.createQuery("from Dealinform where accountid='"+accountid+"'and dealstate = 1");
			List dealinformInfo = query.list();
			session.close();
			return dealinformInfo;
		}
		//通过accountid获得AccountAmount
		public int getAccountAmount(String accountid){
			Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			Account account = new Account();
			int amount = 0;
			Query query=session.createQuery("From Account where accountid ='"+accountid+"'");
			List list=query.list();
			Iterator<Account> iterator=list.iterator();
			while(iterator.hasNext()){
				account = iterator.next();
				amount = account.getAmount();
			}
			session.close();
			return amount;
		}
		
		//通过accountid获得dealpassword
			public int getAccountDealpassword(String accountid){
				Session session = sessionFactory.openSession();
				Transaction ts = session.beginTransaction();
				Account account = new Account();
				int dealpassword = 0;
				Query query=session.createQuery("From Account where accountid ='"+accountid+"'");
				List list=query.list();
				Iterator<Account> iterator=list.iterator();
				while(iterator.hasNext()){
					account = iterator.next();
					dealpassword = account.getDealpassword();
				}
				session.close();
				return dealpassword;
			}
		
		//修改dealinform并账户余额accountAmount减少
		public boolean addOrUpdatePayment(Dealinform dealinform) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			try {
				session.saveOrUpdate(dealinform);
				Account account = new Account();
				String Accountid=dealinform.getAccountid();
				Query query=session.createQuery("From Account where accountid ='"+Accountid+"'");
				List list=query.list();
				Iterator<Account> iterator=list.iterator();
				boolean b=false;
				while(iterator.hasNext()){
					if(b){
						throw new Exception("账户错误");
					}else{
						account=iterator.next();
						if(account.getAmount() >= dealinform.getDeaamountl())
						{
							Integer integer=account.getAmount()-dealinform.getDeaamountl();
							account.setAmount(integer);
							session.saveOrUpdate(account);
							b=true;
						}else{
							throw new Exception("账户余额不足");
						}
					}
				}
				if(!b){
					throw new Exception("找不到账户");
				}
				ts.commit();
			} catch (Exception e) {
				// TODO: handle exception
				session.getTransaction().rollback();
			}
			session.close();
			return true;
		}
		//修改dealinform并转入账户余额accountAmount增加
		public boolean addOrUpdatePaymentIn(Dealinform dealinform) {
			// TODO Auto-generated method stub
			Session session = sessionFactory.openSession();
			Transaction ts = session.beginTransaction();
			try {
				session.saveOrUpdate(dealinform);
				Account account = new Account();
				String Accountid=dealinform.getAccountid();
				Query query=session.createQuery("From Account where accountid ='"+Accountid+"'");
				List list=query.list();
				Iterator<Account> iterator=list.iterator();
				boolean b=false;
				while(iterator.hasNext()){
					if(b){
						throw new Exception("账户错误");
					}else{
						account=iterator.next();
						Integer integer=account.getAmount()+dealinform.getDeaamountl();
						account.setAmount(integer);
						session.saveOrUpdate(account);
						b=true;				
					}
				}
				if(!b){
					throw new Exception("找不到账户");
				}
				ts.commit();
			} catch (Exception e) {
				// TODO: handle exception
				session.getTransaction().rollback();
			}
			session.close();
			return true;
		}
		
		
		//zst
		public boolean addOrUpdatePaymentS(Dealinform dealinform) {
			// TODO Auto-generated method stub
			Session session1 = sessionFactory.openSession();
			session1.beginTransaction();
			try {
				session1.saveOrUpdate(dealinform);
				Account account = new Account();
				String Accountid=dealinform.getAccountid();
				Query query=session1.createQuery("From Account where accountid ='"+Accountid+"'");
				List list=query.list();
				Iterator<Account> iterator=list.iterator();
				while(iterator.hasNext()){
						account=iterator.next();
							Integer integer=account.getAmount()-dealinform.getDeaamountl();
							account.setAmount(integer);
				}
				
				session1.getTransaction().commit();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				session1.getTransaction().rollback();
				session1.close();
				return false;
			}
			session1.close();
			return true;
		}
		
		//修改dealinform并转入账户余额accountAmount增加
			public boolean addOrUpdatePaymentInS(Dealinform dealinform) {
				// TODO Auto-generated method stub
				Session session2 = sessionFactory.openSession();
				 session2.beginTransaction();
				try {
					session2.saveOrUpdate(dealinform);
					Account account = new Account();
					String Accountid=dealinform.getAccountid();
					Query query=session2.createQuery("From Account where accountid ='"+Accountid+"'");
					List list=query.list();
					Iterator<Account> iterator=list.iterator();
					while(iterator.hasNext()){
							account=iterator.next();
							Integer integer=account.getAmount()+dealinform.getDeaamountl();
							account.setAmount(integer);
							session2.saveOrUpdate(account);
									
						}
					session2.getTransaction().commit();
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					session2.getTransaction().rollback();
				}
				session2.close();
				return true;
			}
}
