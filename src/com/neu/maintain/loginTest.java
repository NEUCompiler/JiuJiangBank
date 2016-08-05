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

public class loginTest {
	private int clientid;
	private int identityid;
	private String truename;
	private int sex;
	private int phone;
	private String mail;
	private String accounttype;
	private String username;
	private String userpassword;
	
	HttpServletRequest request=ServletActionContext.getRequest();	
	
	public int getClientid() {
		return clientid;
	}
	public void setClientid(int clientid) {
		this.clientid = clientid;
	}
	public int getIdentityid() {
		return identityid;
	}
	public void setIdentityid(int identityid) {
		this.identityid = identityid;
	}
	public String getTruename() {
		return truename;
	}
	public void setTruename(String truename) {
		this.truename = truename;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
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
	
	public String login(){
		
		ApplicationContext c2 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf2 = (SessionFactory) c2.getBean("sessionFactory");
		Session session2 = sf2.openSession();
		
		Query query =  session2.createQuery("from Client WHERE username = ?");
		query.setString(0, username+"");
		java.util.List client;
		try{
			client = query.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	
    	Iterator iter = client.iterator();

    	if(client.isEmpty()){
    		request.setAttribute("info", "用户名或密码错误");
    		return "fail";
    	}else{
    			Client pw = (Client)iter.next();
	    		if(pw.getUserPassword().equals(userpassword)){
	    			
	    		ActionContext.getContext().getSession().put("user", getUsername());
	    		ActionContext.getContext().getSession().put("password",getUserpassword());	
	    			return "success";
	    		}
	    		else{
	    			request.setAttribute("info","用户名或密码错误");
	    	    	return "fail";
	    		}
    	}
	}
	
	
	public String logout(){
		ActionContext.getContext().getSession().put("user", "");
		ActionContext.getContext().getSession().put("password","");
		request.setAttribute("info","安全退出成功");
		return "success";
		
	}
	
	
}
