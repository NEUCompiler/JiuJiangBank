package com.ob.dao;

import java.util.List;
import org.springframework.transaction.annotation.Transactional;

import com.ob.model.Companyaccount;
@Transactional
public interface CompanyaccountDAO {
	
	public void save(Companyaccount transientInstance);

	public void delete(Companyaccount persistentInstance);

	public Companyaccount findById(java.lang.String id);

	public List findByExample(Companyaccount instance);

	public List findByProperty(String propertyName, Object value);

	public List findByAmount(Object amount);

	public List findByAlimit(Object alimit);

	public List findByIsloss(Object isloss);

	public List findByIsopenob(Object isopenob);

	public List findBySearchpassword(Object searchpassword);

	public List findByDealpassword(Object dealpassword);

	public List findByClientid(Object clientid);

	public List findByTerm(Object term);

	public List findAll();

	public Companyaccount merge(Companyaccount detachedInstance);

	public void attachDirty(Companyaccount instance);

	public void attachClean(Companyaccount instance);

}