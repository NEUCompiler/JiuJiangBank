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

public class changeMailTest {

private String oldmail;
private String changevariable;
HttpServletRequest request=ServletActionContext.getRequest();
	
	


	public String getOldmail() {
		return oldmail;
	}




	public void setOldmail(String oldmail) {
		this.oldmail = oldmail;
	}




	public String getChangevariable() {
		return changevariable;
	}




	public void setChangevariable(String changevariable) {
		this.changevariable = changevariable;
	}




	public String change(){
		
		ApplicationContext c2 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf2 = (SessionFactory) c2.getBean("sessionFactory");
		Session session2 = sf2.openSession();
		
		
		String user = ActionContext.getContext().getSession().get("user")+"";
//		int password = Integer.valueOf(ActionContext.getContext().getSession().get("password")+"");

		
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
	
    	Iterator iter = client.iterator();

    	if(client.isEmpty()){
    		return "fail";
    	}else{
    		
    			Client cn = (Client)iter.next();
    			if(cn.getMail().equals(oldmail)){
    				session2.beginTransaction();
    				cn.setMail(changevariable);
    				session2.update(cn);	
    				session2.getTransaction().commit();							
    	    		return "success";
    			}else{
    				request.setAttribute("info", "æ…” œ‰¥ÌŒÛ");
    	    		return "fail";		
    				}
				
	    		}
    }
}
