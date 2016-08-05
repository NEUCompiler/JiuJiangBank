package com.neu.register;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ob.model.Account;
import com.ob.model.Client;
import com.sun.student.Students;

public class clientTest{
	private String accountid;
	private int dealpassword;
	private int amount;
	private int term;
	private int isloss;
	private int limit;
	private int integrate;
	private int isactive;
	private int isopenob;
	private String identity;
	private int sign;

	HttpServletRequest request=ServletActionContext.getRequest();


	public String getAccountid() {
		return accountid;
	}





	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}





	public String getIdentity() {
		return identity;
	}





	public void setIdentity(String identity) {
		this.identity = identity;
	}





	public int getDealpassword() {
		return dealpassword;
	}





	public void setDealpassword(int dealpassword) {
		this.dealpassword = dealpassword;
	}





	public int getAmount() {
		return amount;
	}





	public void setAmount(int amount) {
		this.amount = amount;
	}





	public int getTerm() {
		return term;
	}





	public void setTerm(int term) {
		this.term = term;
	}





	public int getIsloss() {
		return isloss;
	}





	public void setIsloss(int isloss) {
		this.isloss = isloss;
	}





	public int getLimit() {
		return limit;
	}





	public void setLimit(int limit) {
		this.limit = limit;
	}





	public int getIntegrate() {
		return integrate;
	}





	public void setIntegrate(int integrate) {
		this.integrate = integrate;
	}





	public int getIsactive() {
		return isactive;
	}





	public void setIsactive(int isactive) {
		this.isactive = isactive;
	}





	public int getIsopenob() {
		return isopenob;
	}





	public void setIsopenob(int isopenob) {
		this.isopenob = isopenob;
	}

	public int getSign() {
		return sign;
	}





	public void setSign(int sign) {
		this.sign = sign;
	}





	public String registerBase(){
		
		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();
		
		Query query =  session.createQuery("from Account WHERE accountid = ? and isopenob=0");
		query.setString(0, accountid+"");
		java.util.List account;
		try{
			account = query.list();
		}catch(Exception e){
			e.printStackTrace();
			return "fail";
		}
    	
    	Iterator iter = account.iterator();
		
		if(account.isEmpty()){
			request.setAttribute("info", "此卡已开通或者输入有误");
			
//			System.out.println("account.isEmpty");
			return "fail";
		} else {

			Account client = (Account)iter.next();

			if(client.getAccountid().equals(accountid)&&client.getIdentityid().equals(identity) ){
				
			if(client.getSign()==0)
				{	
//					System.out.println("222");
					
/*					Query query1 = session.createSQLQuery("update account set sign= 1 where identityid = ?");  
					query1.setString(0,identity);
					session.beginTransaction();
					query1.executeUpdate();
					session.getTransaction().commit();
					
    				session.beginTransaction();
					client.setIsopenob(1);
					client.setSign(1);
					session.update(client);	
					session.getTransaction().commit();
//					System.out.println("111111111111111111");*/
					request.setAttribute("info", accountid);
					request.setAttribute("info1", identity);
					System.out.println(accountid);
					return "success";				
				}
					
			else{
						
					Query query1 =  session.createQuery("from Client WHERE identityid=?");
					query1.setString(0, identity+"");
					
					System.out.println(identity);
					java.util.List account1;
					try{
						account1 = query1.list();
					}catch(Exception e){
						e.printStackTrace();
						return "fail";
					}
			    	
			    	Iterator iter1 = account1.iterator();
			    	
			    	
					Client client2;
					try{
			    		client2 = (Client)iter1.next();
			    	}catch(Exception e){
			    		e.printStackTrace();
			    		return "fail";
			    	}
					
					session.beginTransaction();
					client.setIsopenob(1);
					client.setClientid(client2.getClientId());
					session.update(client);	
					session.getTransaction().commit();	
		//			request.setAttribute("info", "开通成功");
					return "success1";
				}		
			} else {
				request.setAttribute("info", "卡或身份证号输入错误");
				return "fail";
			}	
		}
	}
	
}
