package ManagerAction;

import ManagerService.ManagerDAO;
import ManagerService.impl.ManagerDAOimpl;

import com.manager.ManagerOperater;
import com.manager.ManagerOperaterDAO;
import com.opensymphony.xwork2.ModelDriven;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;



public class ManagerAction extends SuperAction implements ModelDriven<ManagerOperater> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static String LoginUserName;
	private static String Password;
	
	
	 ManagerOperater managerOperater = new ManagerOperater();
//	ManagerDAO udao = new ManagerDAOimpl();
	
	public String login()
	{	
        
		System.out.println(session.getAttribute("managerId"));
		ManagerDAO udao = new ManagerDAOimpl();
		if(udao.ManagerOperaterLogin(managerOperater))
		{
			session.setAttribute("loginUserName", managerOperater.getManagerName());
			LoginUserName=managerOperater.getManagerName();
			Password=managerOperater.getManagerPassW();
			return "ManagerLogin_success";
		}
		else
		{
			return "ManagerLogin_failure";
		}
	}
	
	@SkipValidation
	public String logout()
	{
		if(session.getAttribute("loginUserName")!=null)
		{
			session.removeAttribute("loginUserName");
		}
		return "logout_success";
	}
	
	
	@Override
	public void validate() {
		// TODO Auto-generated method stub
		//super.validate();
		
		if("".equals(managerOperater.getManagerName().trim()))
		{
			this.addFieldError("managernameError","用户名不能为空");
		}
		if(managerOperater.getManagerPassW().length()<6)
		{
			this.addFieldError("PasswordERROR","密码不能少于6位");
		}
	}

    @SkipValidation
	public ManagerOperater getModel(){
		
		return this.managerOperater;
		
	}
    
    @SkipValidation
    public String ChangePassWord()
    {
    
//    	managerOperater.setManagerId(Integer.parseInt(session.getAttribute("managerId").toString()));
    	String oldpassword=request.getParameter("managerPassW");
    	String newpassword = request.getParameter("managerQNPassW");
    	String newpassword1=request.getParameter("managerNPassW");
    
    	ManagerDAOimpl udao = new ManagerDAOimpl();
    	if(!oldpassword.equals(Password))
    	{
    		return "changePW_failure1";
    		
    	}
    	if(!newpassword.equals(newpassword1))
    	{
    		return "changePW_failure2";
    	}
    	if(udao.ChangePassWord(newpassword,LoginUserName))
    	{
    		return "changePW_success";
    	}
    	else{
    		return "changePW_failure";
    	}
    	
    }

}
