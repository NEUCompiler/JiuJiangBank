package com.ob.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
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

import com.ob.dao.ClientsubmitinfoDAO;
import com.ob.model.Clientsubmitinfo;
import com.ob.model.ClientsubmitinfoDate;
import com.opensymphony.xwork2.ActionContext;

public class ClientsubmitinfoDAOImpl implements ClientsubmitinfoDAO {
	private static final Logger log = LoggerFactory
			.getLogger(ClientsubmitinfoDAO.class);
	// property constants
	public static final String INFO_TYPE = "infoType";
	public static final String INFO_CONTENT = "infoContent";
	public static final String CLIENT_ID = "clientId";
	
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Session getCurrentSession() {
		if(null==sessionFactory){
			ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionFactory=(SessionFactory) a.getBean("sessionFactory");
		}
		Session s= null;
		try{
			s=sessionFactory.getCurrentSession();
		}catch(Exception e){
			s=sessionFactory.openSession();
		}
		return s;
	}

	public void initDao() {
		// do nothing
		if(null==sessionFactory){
			ApplicationContext a = new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionFactory=(SessionFactory) a.getBean("sessionFactory");
		}
	}
	public void sqlsave(Clientsubmitinfo transientInstance){
		//String sql = "insert into onlinebanking.clientsubmitinfo (infoType, infoContent, clientId, submitTime, infoId) values (?,?,?,str_to_date(?, '%m/%d/%Y'),?)";
		
		String sql = "insert into onlinebanking.clientsubmitinfo (infoType, infoContent, clientId, submitTime, infoId) values (?,?,?,str_to_date(?, '%m/%d/%Y'),?)";
		Session s=null;
		try{
			s=getCurrentSession();
			Query q=s.createSQLQuery(sql);
			q.setInteger(0, transientInstance.getInfoType());
			q.setString(1, transientInstance.getInfoContent());
			q.setInteger(2, transientInstance.getClientId());
			q.setString(3, transientInstance.getSubmitTime());
			q.setString(4, transientInstance.getInfoId());
			s.beginTransaction();
			q.executeUpdate();
			s.getTransaction().commit();	
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(s!=null){
				s.close();
			}
		}	
	}
	public void save(Clientsubmitinfo transientInstance) {
		log.debug("saving Clientsubmitinfo instance");
		Session s=null;
		try {
			s=getCurrentSession();
			s.beginTransaction();
			s.save(transientInstance);
			s.getTransaction().commit();
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			re.printStackTrace();
			throw re;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}

	public void delete(Clientsubmitinfo persistentInstance) {
		log.debug("deleting Clientsubmitinfo instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Clientsubmitinfo findById(java.lang.Integer id) {
		log.debug("getting Clientsubmitinfo instance with id: " + id);
		try {
			Clientsubmitinfo instance = (Clientsubmitinfo) getCurrentSession()
					.get("com.ob.model.Clientsubmitinfo", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Clientsubmitinfo instance) {
		log.debug("finding Clientsubmitinfo instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("com.ob.model.Clientsubmitinfo")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}
	
	public List sqlselect(int infoType) throws Exception{
		//String sql = "insert into onlinebanking.clientsubmitinfo (infoType, infoContent, clientId, submitTime, infoId) values (?,?,?,str_to_date(?, '%m/%d/%Y'),?)";
		
		/*ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();
		Query query =  session.createQuery("from Client WHERE userName = ?");
		query.setString(0, username+"");
    	java.util.List user = query.list();
    	Iterator iter = user.iterator();*/
		
		Session s=null;
		String sql = "select clientId,infoContent,submitTime from onlinebanking.clientsubmitinfo where infoType=? order by clientId asc";
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			q.setInteger(0, infoType);
			s.getTransaction().commit();	
			List list = q.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	public List sqlSelectMenuInfo(int parent) throws Exception{
		Session s = null;
		String sql = "select menuId,menuName,menuSrc,menuPar from onlinebanking.menu where menuPar=?";
		try {
			s = getCurrentSession();
			s.beginTransaction();
			Query q = s.createSQLQuery(sql);
			q.setInteger(0, parent);
			s.getTransaction().commit();
			List list = q.list();

			Iterator iter = list.iterator();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public int getClientId(String username) throws Exception{
		
		Session s = null;
		String sql = "select clientId from onlinebanking.client where username=?";
		try {
			s = getCurrentSession();
			s.beginTransaction();
			Query q = s.createSQLQuery(sql);
			q.setString(0, username);
			s.getTransaction().commit();
			List list = q.list();

			Iterator iter = list.iterator();
			if(list.isEmpty()){
				return -1;
			}
			else{
				//System.out.println(list.get(0).getClass().getTypeName());
				int info = (Integer) list.get(0);
				return info;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public List sqlSelectDealInfo(String option) throws Exception{
		Session s = null;
		String sql = "select accountid,dealtime,dealinform,dealtype,dealDesti,dealstate,dealamount from onlinebanking.dealinform where dealid=?";
		try {
			s = getCurrentSession();
			s.beginTransaction();
			Query q = s.createSQLQuery(sql);
			q.setString(0, option);
			s.getTransaction().commit();
			List list = q.list();

			Iterator iter = list.iterator();
			if(list.isEmpty()){
				return null;
			}
			else{
				return list;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public String selectAddr(String id) throws Exception{

		Session s = null;
		String sql = "select areaname from onlinebanking.t_prov_city_area where areano=?";
		try {
			s = getCurrentSession();
			s.beginTransaction();
			Query q = s.createSQLQuery(sql);
			q.setString(0, id);
			s.getTransaction().commit();
			List list = q.list();

			Iterator iter = list.iterator();
			if(list.isEmpty()){
				return "";
			}
			else{
				//System.out.println(list.get(0).getClass().getTypeName());
				String info = (String)list.get(0);
				return info;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (s != null) {
				s.close();
			}
		}
	}
	
	public List sqlSelectWebsite() throws Exception{
		
		Session s=null;
		String sql = "select * from onlinebanking.websiteInfo order by websiteId asc";
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			s.getTransaction().commit();	
			List list = q.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Clientsubmitinfo instance with property: "
				+ propertyName + ", value: " + value);
		try {
			String queryString = "from Clientsubmitinfo as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByInfoType(Object infoType) {
		return findByProperty(INFO_TYPE, infoType);
	}

	public List findByInfoContent(Object infoContent) {
		return findByProperty(INFO_CONTENT, infoContent);
	}

	public List findByClientId(Object clientId) {
		return findByProperty(CLIENT_ID, clientId);
	}

	public List findAll() {
		log.debug("finding all Clientsubmitinfo instances");
		try {
			String queryString = "from Clientsubmitinfo";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Clientsubmitinfo merge(Clientsubmitinfo detachedInstance) {
		log.debug("merging Clientsubmitinfo instance");
		try {
			Clientsubmitinfo result = (Clientsubmitinfo) getCurrentSession()
					.merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Clientsubmitinfo instance) {
		log.debug("attaching dirty Clientsubmitinfo instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Clientsubmitinfo instance) {
		log.debug("attaching clean Clientsubmitinfo instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public ClientsubmitinfoDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (ClientsubmitinfoDAO) ctx.getBean("ClientsubmitinfoDAO");
	}
	
	public List sqlSelectGroupUser(String username, String password) throws Exception{
		Session s=null;
		String sql = "select groupName,rate,money from onlinebanking.groupaccount where groupUsername=? and groupPassword=?";
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			q.setString(0, username);
			q.setString(1, password);
			s.getTransaction().commit();	
			List list = q.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	public List sqlSelectGroup(int type) throws Exception{
		Session s=null;
		String sql="";
		if(type==0)
			sql = "select groupName from onlinebanking.groupaccount where type=?";
		else
			sql = "select groupName,groupUsername,rate,money from onlinebanking.groupaccount where type=?";
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			q.setInteger(0, type);
			s.getTransaction().commit();	
			List list = q.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	public List sqlSelectGroup(String option) throws Exception{
		Session s=null;
		String sql="";
		sql = "select groupName,groupUsername,rate,money from onlinebanking.groupaccount where groupName=? and type=1";
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			q.setString(0, option);
			s.getTransaction().commit();	
			List list = q.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	public List sqlSelectGroupMember(String member) throws Exception{
		Session s=null;
		String sql="";
		sql = "select groupName,groupUsername,money,rate from onlinebanking.groupaccount where groupUsername=? and type=1";
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			q.setString(0, member);
			s.getTransaction().commit();	
			List list = q.list();
			
			return list;
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
	
	public void sqlUpdateGroupMemberInfo(String groupName, String rate, String money) throws Exception{
		String username = ActionContext.getContext().getSession().get("username")+"";
		String sql="update onlinebanking.groupaccount SET groupName=?, rate=?, money=? where groupUsername=?";
		float ratefloat= Float.parseFloat(rate);
		float moneyfloat=Float.parseFloat(money);
		Session s=null;
		try{
			s=getCurrentSession();
			s.beginTransaction();
			Query q=s.createSQLQuery(sql);
			q.setString(0, groupName);
			q.setFloat(1, ratefloat);
			q.setFloat(2, moneyfloat);
			q.setString(3, username);
			q.executeUpdate();
			s.getTransaction().commit();	
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			if(s!=null){
				s.close();
			}
		}
	}
}
