package Operater.serviceimpl;



import java.util.Iterator;
import java.util.List;

import Operater.db.Operater;
import Operater.db.OperaterDAO;
import Operater.service.OperaterService;
import Operater.db.*;

public class Operaterserviceimpl implements OperaterService{
	
	OperaterDAO operDao = new OperaterDAO();

	@Override
	public List<Operater> showall() throws Exception{
		// TODO Auto-generated method stub
		List list = (List) operDao.findAll();
		try{
			if(list.size()>0)
			{
				return list;
			}
		}catch(Exception e)
		{
			
			e.printStackTrace();
			throw e;
		}
		return null;
	}

	@Override
	public boolean querylog() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean resetOperPassW() {
		// TODO Auto-generated method stub
		
		return false;
	}

	@Override
	public boolean updateOperPassW() {
		// TODO Auto-generated method stub
		return false;
	}
    
	@Override
	public boolean delete(Integer operaterName)
	{
		if(operDao.delete(operaterName))
		{
			return true;
		}else
		{
		return false;
		}
	}
	
	public boolean add(Operater O){
		
		
		if(operDao.save(O))
			return true;
		return false;
		
	}
	
	public Integer getnewID()
	{
		List list = (List) operDao.findAll();
		Integer j=0;
		for(Iterator i = list.iterator();i.hasNext();)
		{
			Operater o = (Operater)i.next();
			if(o.getOperaterId()>j)
			{
				j=o.getOperaterId();
			}
	    }
		return j+1;
	}



	public boolean resetPW(Integer operaterID) {
		Operater O= operDao.findById(operaterID);
		O.setOperaterPassW("111111");
		operDao.update(O);
		return true;
	}

	public Operater findById(Integer operaterID) {
		// TODO Auto-generated method stub
		
		Operater O=  operDao.findById(operaterID);
		if(O!=null)
		{
			return O;
		}
		else{
		return null;
	}}



}
