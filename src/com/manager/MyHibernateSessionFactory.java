package com.manager;

import org.hibernate.SessionFactory;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.config.Configuration;

public class MyHibernateSessionFactory {
	private static SessionFactory sessionFactory;
	
	private MyHibernateSessionFactory()
	{
		
	}
	
	public static SessionFactory getSessionFactory()
	{
		if(sessionFactory==null)
		{
//			 Configuration config = new Configuration().configure();
//			 ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySetting(config.getProperties()).buildServiceRegistry();
//			 sessionFactory = config.buildSessionFactory(serviceRegistry);
			System.out.println("get sessionfactory");
			ApplicationContext c=new ClassPathXmlApplicationContext("applicationContext.xml");
			sessionFactory = (SessionFactory) c.getBean("sessionFactory");
			return sessionFactory;
		  
		}
		else
		{
		   return sessionFactory;
		}
	}

}
