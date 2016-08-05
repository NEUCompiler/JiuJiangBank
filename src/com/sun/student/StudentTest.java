package com.sun.student;
 
import java.util.Iterator;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

 
public class StudentTest{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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


	public String dataBase(){
    
    		Students s = new Students();
    		s.setId(5);
    		s.setName("s1");
    		s.setAge(12);
         
    		//Configuration cfg = new Configuration();
    		//SessionFactory sf = cfg.configure().buildSessionFactory();
         
    		ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
    		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
    		Session session = sf.openSession();
    		
    		session.beginTransaction();
    		session.save(s);
    		session.getTransaction().commit();
    		session.close();
    		sf.close(); 
    		return "SUCCESS";
    	}
    	
    		
//    	Configuration cfg = new Configuration();
//		SessionFactory sf = cfg.configure().buildSessionFactory();
		
		/*ApplicationContext c = new ClassPathXmlApplicationContext("applicationContext.xml");  
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session = sf.openSession();
		
		Query query =  session.createQuery("from Students");
    	java.util.List students = query.list();
    	Iterator ir= students.iterator();
    	while (ir.hasNext()) {
    		Students student = (Students) ir.next();
    		System.out.print("学生ID：" + student.getId());
    		System.out.print("; 学生姓名：" + student.getName());
    		System.out.print("; 学生姓名：" + student.getAge());
    		System.out.println();
    	}
		session.close();
		sf.close(); 
		return "input";
    }*/
}