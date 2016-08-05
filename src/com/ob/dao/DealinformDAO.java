package com.ob.dao;

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
import org.springframework.transaction.annotation.Transactional;

import com.ob.model.Dealinform;

/**
 * A data access object (DAO) providing persistence and search support for
 * Dealinform entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ob.model.Dealinform
 * @author MyEclipse Persistence Tools
 */
@Transactional
public interface DealinformDAO {

	public void save(Dealinform transientInstance);

	public void delete(Dealinform persistentInstance);

	public Dealinform findById(java.lang.String id);

	public List findByExample(Dealinform instance);

	public List findByProperty(String propertyName, Object value);

	public List findByAccountid(Object accountid);

	public List findByDealinform(Object dealinform);

	public List findByDealtype(Object dealtype);

	public List findByDealDesti(Object dealDesti);

	public List findByDealstate(Object dealstate);

	public List findByDeaamountl(Object deaamountl);

	public List findAll();

	public Dealinform merge(Dealinform detachedInstance);

	public void attachDirty(Dealinform instance);

	public void attachClean(Dealinform instance);
	
	
	//WZJ
	public boolean addOrUpdatePayment(Dealinform dealinform);

	public List getDealinformInfo(String accountid);
	
	public List getAccountDeal(String accountid);
	
	public int getAccountDealpassword(String accountid);
	
	public int getAccountAmount(String accountid);
	
	public boolean addOrUpdatePaymentIn(Dealinform dealinform);

	public List getTransferInfo(String accountid);

	//zst
	public boolean addOrUpdatePaymentInS(Dealinform dealinform);

	public boolean addOrUpdatePaymentS(Dealinform dealinform);
}