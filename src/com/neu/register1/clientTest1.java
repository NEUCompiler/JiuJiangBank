package com.neu.register1;

import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ob.model.Account;
import com.ob.model.Client;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.student.Students;


public class clientTest1 extends ActionSupport{
	private String clientid;
	private String identityid;
	private String truename;
	private String sex;
	private String phone;
	private String mail;
	private String accounttype;
	private String username;
	private String userpassword;
	private String jsonstr;
	private String remind;
	private int variable;
	private String accounti;
	
	
	public String getAccounti() {
		return accounti;
	}

	public void setAccounti(String accounti) {
		this.accounti = accounti;
	}

	public int getVariable() {
		return variable;
	}

	public void setVariable(int variable) {
		this.variable = variable;
	}

	public String getClientid() {
		return clientid;
	}

	public void setClientid(String clientid) {
		this.clientid = clientid;
	}

	public String getIdentityid() {
		return identityid;
	}

	public void setIdentityid(String identityid) {
		this.identityid = identityid;
	}

	public String getTruename() {
		return truename;
	}



	public void setTruename(String truename) {
		this.truename = truename;
	}




	public String getSex() {
		return sex;
	}



	public void setSex(String sex) {
		this.sex = sex;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getMail() {
		return mail;
	}



	public void setMail(String mail) {
		this.mail = mail;
	}



	public String getAccounttype() {
		return accounttype;
	}



	public void setAccounttype(String accounttype) {
		this.accounttype = accounttype;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getUserpassword() {
		return userpassword;
	}



	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
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



	public String registerBase1(){
		jsonstr="";
		ApplicationContext c1 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf1 = (SessionFactory) c1.getBean("sessionFactory");
		Session session1 = sf1.openSession();
		
/*		Query query =  session1.createQuery("from Client WHERE username = ?");
		query.setString(0, username+"");
		java.util.List Client;*/
		
		
		Query query1=session1.createQuery("from Client");
		
		java.util.List Client1;
		try{
			Client1 = query1.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	
    	Iterator iter1 = Client1.iterator();
    	while(iter1.hasNext()){
    		Client bd = (Client)iter1.next();
    		variable=bd.getClientId();
    	}
		
/*		try{
			Client = query.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
			
		
		
    	Iterator iter = Client.iterator();*/
    	
	    	    Client s= new Client();	    
				s.setClientId(variable+1);	
				s.setIdentityId(identityid);
				s.setTrueName(truename);
				if(sex =="男"){
					s.setSex(1);									
				}else{
					s.setSex(0);
				}

				s.setPhone(phone);
				s.setMail(mail);
				s.setAccountType("0");
				s.setUserName(username);
				s.setUserPassword(userpassword);
				
				session1.beginTransaction();
				session1.save(s);
				session1.getTransaction().commit();
								
				Query query2 = session1.createSQLQuery("update Account set sign= 1 where identityid = ?");  
				query2.setString(0,identityid);
				session1.beginTransaction();
				query2.executeUpdate();
				session1.getTransaction().commit();

				Query query3 =  session1.createQuery("from Account WHERE accountid = ? and identityid = ?");
				query3.setString(0, accounti+"");
				query3.setString(1, identityid+"");
				java.util.List client;
				try{
					client = query3.list();
				}catch(Exception e){
					e.printStackTrace();
					session1.close();
					sf1.close(); 
					return "fail";
				}

		    	Iterator iter = client.iterator();
		    	Account client1;
		    	try{
		    		client1 = (Account)iter.next();
		    	}catch(Exception e){
		    		e.printStackTrace();
		    		session1.close();
					sf1.close(); 
					String str="GoSuccess.jsp";
					jsonstr=str;
					return SUCCESS;
		    	}
		    	
				
				client1.setIsopenob(1);
				client1.setSign(1);
				client1.setClientid(variable+1);
				session1.beginTransaction();
				session1.update(client1);	
				session1.getTransaction().commit();
				
				session1.close();
				sf1.close(); 
				String str="login1.jsp";
				jsonstr=str;
				return SUCCESS;
		
}
		
	
	public String username(){

		ApplicationContext c1 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf1 = (SessionFactory) c1.getBean("sessionFactory");
		Session session1 = sf1.openSession();
		
		Query query =  session1.createQuery("from Client WHERE username = ?");
		query.setString(0, username+"");
		java.util.List Client;
		try{
			Client = query.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
			
		
    	Iterator iter = Client.iterator();
    	
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
			return SUCCESS;
		}
	}
}
