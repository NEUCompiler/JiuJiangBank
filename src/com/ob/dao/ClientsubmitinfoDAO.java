package com.ob.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import com.ob.model.Clientsubmitinfo;

/**
 * A data access object (DAO) providing persistence and search support for
 * Clientsubmitinfo entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.ob.model.Clientsubmitinfo
 * @author MyEclipse Persistence Tools
 */
@Transactional
public interface ClientsubmitinfoDAO {


	public void setSessionFactory(SessionFactory sessionFactory);

	public Session getCurrentSession();
	
	void initDao();

	public void save(Clientsubmitinfo transientInstance);

	public void delete(Clientsubmitinfo persistentInstance);

	public Clientsubmitinfo findById(java.lang.Integer id);

	public List findByExample(Clientsubmitinfo instance);

	public List findByProperty(String propertyName, Object value);

	public List findByInfoType(Object infoType);

	public List findByInfoContent(Object infoContent);

	public List findByClientId(Object clientId);

	public List findAll();
	
	public Clientsubmitinfo merge(Clientsubmitinfo detachedInstance);

	public void attachDirty(Clientsubmitinfo instance);

	public void attachClean(Clientsubmitinfo instance);

	public  ClientsubmitinfoDAO getFromApplicationContext(
			ApplicationContext ctx);
}