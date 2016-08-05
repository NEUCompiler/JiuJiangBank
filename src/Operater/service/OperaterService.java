package Operater.service;





import java.util.List;

import Operater.db.*;

public interface OperaterService {
	
	public List<Operater> showall() throws Exception;
	
	public boolean querylog();
	
	public boolean resetOperPassW();
	
	public boolean updateOperPassW();
	
	public boolean delete(Integer operaterID);
	
	public boolean add(Operater O);
	
	public Integer getnewID();

}
