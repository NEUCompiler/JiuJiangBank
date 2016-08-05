package com.ob.action;

import javax.security.auth.login.LoginContext;

import com.ob.model.Companyclient;
import com.ob.service.CompanyclientService;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyClientLoginAction extends SuperAction implements
		ModelDriven<Companyclient> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Companyclient companyclient;
	private CompanyclientService companyclientService;
	
	public void setCompanyclientService(CompanyclientService companyclientService) {
		this.companyclientService = companyclientService;
	}
	
	public String login() {
		if (companyclientService.getCompanyclientDAO().findByUsername(companyclient.getUsername()).size()==0) {
			request.setAttribute("info", "用户不存在");
			return "loginFailed";
		} else {
			String userPassword = companyclient.getUserpassword();
			companyclient = (Companyclient)companyclientService.getCompanyclientDAO().findByUsername(companyclient.getUsername()).get(0);
			
			if (!userPassword.equals(companyclient.getUserpassword())) {
				request.setAttribute("info", "密码错误");
				return "loginFailed";
			}
			
			//session保存客户id。
			session.setAttribute("clientId", companyclient.getClientid());
			return "loginSuccess";
		}
	}

	@Override
	public Companyclient getModel() {
		if (companyclient == null) {
			companyclient = new Companyclient();
		}
		return companyclient;
	}
}
