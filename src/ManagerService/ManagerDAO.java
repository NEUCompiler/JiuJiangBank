package ManagerService;

import com.manager.ManagerOperater;

public interface ManagerDAO {
	public boolean ManagerOperaterLogin(ManagerOperater m);
	public boolean ChangePassWord(String NewPassWord,int Mid);

}
