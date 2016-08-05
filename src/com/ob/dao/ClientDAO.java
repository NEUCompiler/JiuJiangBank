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

import com.ob.model.Client;
@Transactional
public interface ClientDAO {

	public void save(Client transientInstance);

	public void delete(Client persistentInstance);

	public Client findById(java.lang.Integer id);

	public List findByExample(Client instance);

	public List findByProperty(String propertyName, Object value);

	public List findByIdentityid(Object identityid);

	public List findByTruename(Object truename);

	public List findBySex(Object sex);

	public List findByPhone(Object phone);

	public List findByMail(Object mail);

	public List findByAccounttype(Object accounttype);

	public List findByUsername(Object username);

	public List findByUserpassword(Object userpassword);

	public List findAll();

	public Client merge(Client detachedInstance);

	public void attachDirty(Client instance);

	public void attachClean(Client instance);
}