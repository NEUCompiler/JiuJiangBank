package ManagerService.impl;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.manager.ManagerOperater;
import com.manager.ManagerOperaterDAO;
import com.manager.MyHibernateSessionFactory;

import ManagerService.ManagerDAO;

@Service
public class ManagerDAOimpl implements ManagerDAO{
	@Transactional
	public boolean ManagerOperaterLogin(ManagerOperater m){
	Transaction tx = null;
	String hql = " ";
	try
	{
		SessionFactory sf = MyHibernateSessionFactory.getSessionFactory();
		Session session = sf.openSession();
		tx = session.beginTransaction();
		hql = "from ManagerOperater where managerName = ? and managerPassW=?";
		Query query = session.createQuery(hql);
		query.setParameter(0, m.getManagerName());
		query.setParameter(1, m.getManagerPassW());
	    List list = query.list();
		tx.commit();
		if(list.size()>0)
		{
			return true;
		}
		else{
			return false;
		}
	}catch(Exception ex){
		ex.printStackTrace();
		return false;
		
	}finally
	{
		if(tx!=null){
			tx=null;
		}
	}
	}
	
	public boolean ChangePassWord(String NewPassWord,String mname)
	{
		ManagerOperaterDAO mdo = new ManagerOperaterDAO();
		List list=  mdo.findByManagerName(mname);
		ManagerOperater m=(ManagerOperater) list.get(0);
		m.setManagerPassW(NewPassWord);
		mdo.update(m);
		return true;
	}

	@Override
	public boolean ChangePassWord(String NewPassWord, int Mid) {
		// TODO Auto-generated method stub
		return false;
	}


}
