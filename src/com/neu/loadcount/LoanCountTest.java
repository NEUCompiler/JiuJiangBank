package com.neu.loadcount;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import System.Par.rate.Loan;

import com.opensymphony.xwork2.ActionSupport;

public class LoanCountTest extends ActionSupport{
	private int amount;
	private String type;
	private int time;
//	private int exectlytime;
	private float interest;
	private float average;
	private float backmoney;
	private String jsonstr;
	private int intDays;

	// HttpServletRequest request=ServletActionContext.getRequest();

	
/*	public int getExectlytime() {
		return exectlytime;
	}*/

	public String getJsonstr() {
		return jsonstr;
	}

	public int getIntDays() {
		return intDays;
	}

	public void setIntDays(int intDays) {
		this.intDays = intDays;
	}

	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}

/*	public void setExectlytime(int exectlytime) {
		this.exectlytime = exectlytime;
	}*/

	public float getBackmoney() {
		return backmoney;
	}

	public void setBackmoney(float backmoney) {
		this.backmoney = backmoney;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}
	

	public float getInterest() {
		return interest;
	}

	public void setInterest(float interest) {
		this.interest = interest;
	}

	public float getAverage() {
		return average;
	}

	public void setAverage(float average) {
		this.average = average;
	}

	public String LoadCount() {
		
		try{
//		System.out.println("11111111111111");
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();
		Query query = session
				.createQuery("from System.Par.rate.Loan WHERE type = ? and time = ?");
		query.setString(0, type + "");
		query.setInteger(1, time);
		System.out.println(type);
		List loan = null;
		System.out.println(time);
		try {
			loan = query.list();
		} catch (Exception e) {
			e.printStackTrace();
			return "fail";
		}
		String str = "";
		if (loan.isEmpty()) {

		} else {

			Iterator iter = loan.iterator();
			Loan cn = (Loan) iter.next();
			
			System.out.println(cn.getRate());
			System.out.println(intDays);
			System.out.println(amount);
			
			
			interest=cn.getRate() * intDays * amount/12;
			backmoney =interest  + amount;
			average=backmoney/intDays;
			

			try {
				str = "{data:[{interest:" + interest + "\"}{backmoney:" + backmoney + "\"}{average:" + average + "\"}]}";
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
