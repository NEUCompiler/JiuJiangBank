package com.neu.appointment;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import jxl.tablemaker.db.Appointment;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import System.Par.bigdeal.Bigdeal;

import com.ob.model.Client;
import com.opensymphony.xwork2.ActionContext;

public class getMoneyTest {

	
private int money;
private String date;
private String website;
private int variable;
private String money1;
private Date now;
	
HttpServletRequest request=ServletActionContext.getRequest();


public Date getNow() {
	return now;
}

public void setNow(Date now) {
	this.now = now;
}

public String getMoney1() {
	return money1;
}

public void setMoney1(String money1) {
	this.money1 = money1;
}

public int getVariable() {
	return variable;
}

public void setVariable(int variable) {
	this.variable = variable;
}

public int getMoney() {
	return money;
}

public void setMoney(int money) {
	this.money = money;
}




public String getDate() {
	return date;
}




public void setDate(String date) {
	this.date = date;
}




public String getWebsite() {
	return website;
}




public void setWebsite(String website) {
	this.website = website;
}

	public String GetMoney(){
		ApplicationContext c1 = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf1 = (SessionFactory) c1.getBean("sessionFactory");
		Session session1 = sf1.openSession();
		
		String user = ActionContext.getContext().getSession().get("user")+"";
		
		Query query =  session1.createQuery("from Client WHERE username = ?");
		query.setString(0, user+"");
		java.util.List client;
		try{
			client = query.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
		
		
		
		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();
		
		Query query1 =  session.createQuery("from System.Par.bigdeal.Bigdeal");
		java.util.List bigdeal;
		try{
			bigdeal = query1.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
	
    	Iterator iter = client.iterator();
    	Iterator iter1 = bigdeal.iterator();
    	while(iter1.hasNext()){
    		Bigdeal bd = (Bigdeal)iter1.next();
    		if(money > bd.getAmount()) 
    			variable=bd.getAheadtime();
    		else
    			break;
    	}
    	
    	  Date now=new Date();
    	  SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    	  Calendar cal = Calendar.getInstance();
    	  cal.add(Calendar.DATE, variable);
    	  
    	  date= dateFormat.format(cal.getTime());

	    Appointment s= new Appointment();
	    if(client.isEmpty()){
    		return "fail";
    	}else{
    		Client cn = (Client)iter.next();
    		String str = UUID.randomUUID().toString();
			
			String sql = "insert into onlinebanking.appointment (appointid, clientid, amount, date, websiteid) values (?,?,?,str_to_date(?, '%Y/%m/%d'),?)";

  			    Query q=session1.createSQLQuery(sql);
				q.setString(0,str);
				q.setInteger(1, cn.getClientId());
				money1=Integer.toString(money);
				q.setString(2,money1);
				q.setString(3,date);
				q.setString(4,website);
			    session1.beginTransaction();
				q.executeUpdate();
				session1.getTransaction().commit();	
				request.setAttribute("info", date);
				return "success"; 
    	}
	}
}
