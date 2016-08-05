package com.ob.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ob.model.Companyclient;

@Transactional
public interface CompanyclientDAO {

	public void save(Companyclient transientInstance);

	public void delete(Companyclient persistentInstance);

	public Companyclient findById(java.lang.Integer id);

	public List findByExample(Companyclient instance);

	public List findByProperty(String propertyName, Object value);

	public List findByUsername(Object username);

	public List findByUserpassword(Object userpassword);

	public List findByAdddealpassword(Object adddealpassword);

	public List findByPhone(Object phone);

	public List findAll();

	public Companyclient merge(Companyclient detachedInstance);

	public void attachDirty(Companyclient instance);

	public void attachClean(Companyclient instance);
}