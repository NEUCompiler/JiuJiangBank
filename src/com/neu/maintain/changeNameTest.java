package com.neu.maintain;

import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ob.model.Client;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class changeNameTest extends ActionSupport{
	private String changevariable;
	private String oldname;
	private String jsonstr;
	private String remind;
	private String username;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public String getRemind() {
		return remind;
	}
	public void setRemind(String remind) {
		this.remind = remind;
	}
	HttpServletRequest request=ServletActionContext.getRequest();	

	public String getChangevariable() {
		return changevariable;
	}
	public void setChangevariable(String changevariable) {
		this.changevariable = changevariable;
	}

	public String getOldname() {
		return oldname;
	}
	public void setOldname(String oldname) {
		this.oldname = oldname;
	}
	public String change(){
		
		ApplicationContext c2 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf2 = (SessionFactory) c2.getBean("sessionFactory");
		Session session2 = sf2.openSession();

		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();		

		String user = ActionContext.getContext().getSession().get("user")+"";
		System.out.println(oldname);    
		System.out.println(user);
		System.out.println(oldname.equals(user));
		if(oldname.equals(user)){
			Query query =  session2.createQuery("from Client WHERE username = ?");
			query.setString(0, user+"");
			System.out.println(user);    
			System.out.println(changevariable);
			java.util.List client;
			try{
				client = query.list();
			}catch(Exception e){
				e.printStackTrace();
				return "fail";
			}	
			Query query1 =  session2.createQuery("from Client WHERE username = ?");
			query1.setString(0, changevariable+"");
			System.out.println(changevariable);    
			System.out.println(changevariable);
			java.util.List client1;
			try{
				client1 = query1.list();
			}catch(Exception e){
				e.printStackTrace();
				return "fail";
			}
			
			
	    	Iterator iter = client.iterator();
	    	
	    	if(client1.isEmpty()){
	        	if(client.isEmpty()){

	        		return "fail";
	        	}else{
	        			Client cn = (Client)iter.next();
	    				session2.beginTransaction();
	    				cn.setUserName(changevariable);
	    				session2.update(cn);	
	    				
	    				ActionContext.getContext().getSession().put("user", changevariable);
	    				
	    				session2.getTransaction().commit();							
	    	    		return "success";
	    	    	}
		    }else{
		    	return "fail";
		    }	
		}
		else{
			request.setAttribute("info", "旧用户名有误！");
			return "fail";
		}
     }
	
	public String username1(){
		System.out.println("11111111111111111111111111");
		ApplicationContext c1 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf1 = (SessionFactory) c1.getBean("sessionFactory");
		Session session1 = sf1.openSession();
		
		Query query =  session1.createQuery("from Client WHERE username = ?");
		query.setString(0, username+"");
		System.out.println(username);
		
		java.util.List Client;
		try{
			Client = query.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
			
		
    	Iterator iter = Client.iterator();
    	
   // 	account client = (account)iter.next();
    	String str = "";
		if(Client.isEmpty())
		{
			remind="OK";
			try {
				str = "{data:[{remind:" + remind + "\"}   ]}";
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsonstr=str;
			System.out.println(jsonstr);
			return SUCCESS;
		}
		else
		{
			
			remind="用户名已存在";
			try {
				str = "{data:[{remind:" + remind + "\"}   ]}";
			} catch (Exception e) {
				e.printStackTrace();
			}
			jsonstr=str;
			System.out.println(jsonstr);
			return SUCCESS;
		}
	}
}
