package com.neu.deposit;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import System.Par.rate.Deposit;

import com.opensymphony.xwork2.ActionSupport;

public class depositTest extends ActionSupport {
	private int amount;
	private int time;
//	private int exectlytime;
	private String jsonstr;
	private float interest;
	private float revenue;
	private float total;
	private float average;
	private int intDays;
	
	
	public int getIntDays() {
		return intDays;
	}
	public void setIntDays(int intDays) {
		this.intDays = intDays;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
/*	public int getExectlytime() {
		return exectlytime;
	}
	public void setExectlytime(int exectlytime) {
		this.exectlytime = exectlytime;
	}*/
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public float getInterest() {
		return interest;
	}
	public void setInterest(float interest) {
		this.interest = interest;
	}
	public float getRevenue() {
		return revenue;
	}
	public void setRevenue(float revenue) {
		this.revenue = revenue;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public float getAverage() {
			return average;
		}
		public void setAverage(float average) {
			this.average = average;
		}
		
public String DepositCount() {
		
		try{
		System.out.println("11111111111111");
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();
		Query query = session
				.createQuery("from System.Par.rate.Deposit WHERE time = ? and sign=0");
		query.setInteger(0, time);
		List deposit = null;
		
		
		Query query1 = session
				.createQuery("from System.Par.rate.Deposit WHERE sign=1");
		List deposit1=null;
		
		

		
		try {
			deposit = query.list();
			deposit1 = query1.list();
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		String str = "";
		if (deposit.isEmpty()) {

		} else {

			Iterator iter = deposit.iterator();
			Deposit cn = (Deposit) iter.next();
			
			
			Iterator iter1 = deposit1.iterator();
			Deposit cn1 = (Deposit) iter1.next();			
			
			
			System.out.println(cn.getRate());
			System.out.println(intDays);
			System.out.println(amount);
			System.out.println(cn1.getRate());
			System.out.println(cn1.getRate());
			
			
			if(cn.getTime()<13){
				if(intDays<13){
					interest=cn.getRate()*intDays*amount/12;
					revenue=interest*cn.getInterest();
					total=interest-revenue+amount;
					average=total/intDays;
				}else{
					interest=cn.getRate()*amount + cn1.getRate()*(intDays-12)*amount/12;
					revenue=interest*cn.getInterest();
					total=interest-revenue+amount;	
					average=total/intDays;
				}
			}else if(cn.getTime()<25){
				if(intDays<25){
					interest=cn.getRate()*intDays*amount/12;
					revenue=interest*cn.getInterest();
					total=interest-revenue+amount;
					average=total/intDays;
				}else{
					interest=cn.getRate()*amount*2 + cn1.getRate()*(intDays-24)*amount/12;
					revenue=interest*cn.getInterest();
					total=interest-revenue+amount;	
					average=total/intDays;
				}
			}else{
				if(intDays<37){
					interest=cn.getRate()*intDays*amount/12;
					revenue=interest*cn.getInterest();
					total=interest-revenue+amount;
					average=total/intDays;
				}else{
					interest=cn.getRate()*amount*3 + cn1.getRate()*(intDays-36)*amount/12;
					revenue=interest*cn.getInterest();
					total=interest-revenue+amount;	
					average=total/intDays;
				}	
			}
			
			try {
				str = "{data:[{interest:" + interest + "\"} {revenue:" + revenue + "\"} {total:" + total + "\"} {average:" + average + "\"}] }";
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		jsonstr = str;

		System.out.println(jsonstr);
		}catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS;
	}

}
