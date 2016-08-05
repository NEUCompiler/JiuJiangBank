package com.ob.action;

import com.ob.model.Account;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class AccountSignAction  extends SuperAction implements
ModelDriven<Account> {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
		
	}
	
	public String showAccount() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		request.setAttribute("accountIdList", accountService.getAccountsOfSignClient(account));
		return "showSignAccount";
	}
	
	public String selectCard() {
		session.setAttribute("account", request.getParameter("selectAccount"));
		return "selectOkSignAccount";
	}
	public String setOtherName(){
		account.setAccountid(session.getAttribute("account").toString());
		String othername = request.getParameter("othername");
		account.setOthername(othername);
		accountService.setOthername(account);
		return "issuccess";
	}
	
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}

	
}