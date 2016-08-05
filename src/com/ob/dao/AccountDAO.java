package com.ob.dao;

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

import com.ob.model.Account;

/**
 * A data access object (DAO) providing persistence and search support for
 * Account entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.ob.model.Account
 * @author MyEclipse Persistence Tools
 */
@Transactional
public interface AccountDAO {
	
	public void save(Account transientInstance);

	public void delete(Account persistentInstance);

	public Account findById(java.lang.String id);

	public List findByExample(Account instance);

	public List findByProperty(String propertyName, Object value);

	public List findByDealpassword(Object dealpassword);

	public List findByAmount(Object amount);

	public List findByTerm(Object term);

	public List findByIsloss(Object isloss);

	public List findByCdlimit(Object cdlimit);

	public List findByIntegrate(Object integrate);

	public List findByIsactive(Object isactive);

	public List findByIsopenob(Object isopenob);

	public List findByClientid(Object clientid);

	public List findBySign(Object sign);

	public List findByIdentityid(Object identityid);

	public List findByOthername(Object othername);

	public List findBySearchpassword(Object searchpassword);

	public List findByDealwithoutpassword(Object dealwithoutpassword);

	public List findAll();

	public Account merge(Account detachedInstance);

	public void attachDirty(Account instance);

	public void attachClean(Account instance);
	
	public boolean addOrUpdateAccount(Account account);
	
	public List getAccountInfo(String clientid);

}