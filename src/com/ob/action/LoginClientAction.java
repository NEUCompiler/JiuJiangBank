package com.ob.action;
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ob.dao.ClientDAO;
import com.ob.dao.impl.ClientDAOImpl;
import com.ob.model.Client;
import com.opensymphony.xwork2.ActionContext;

public class LoginClientAction extends SuperAction {
	private String username;
	private String password;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login(){
		
		//ClientDAO dao = new ClientDaoImpl();
		//java.util.List user = dao.findByUserName(username);
		//Iterator iter = user.iterator();
		
		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session1 = sf.openSession();
		Query query =  session1.createQuery("from Client WHERE userName = ?");
		query.setString(0, username+"");
    	java.util.List user = query.list();
    	Iterator iter = user.iterator();
		
		if(user.isEmpty()){
			return "FAIL";
		} else {
			Client client = (Client)iter.next();
			if(client.getUserName().equals(username) && client.getUserPassword().equals(password)){
				session.setAttribute("clientId", client.getClientId());
				ActionContext.getContext().getSession().put("username", getUsername());
				ActionContext.getContext().getSession().put("password", getPassword());
				return "SUCCESS";
			} else {
				return "FAIL";
			}
		}
	}
}
