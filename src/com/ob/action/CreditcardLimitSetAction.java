package com.ob.action;

import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class CreditcardLimitSetAction extends SuperAction implements
			ModelDriven<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	private Client client = new Client();
	private AccountService accountService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}
	
	
	/**
	 * 积分查询。
	 * @return
	 */
	public void set() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		account.setCdlimit(Integer.parseInt(session.getAttribute("cdLimit").toString()));
		accountService.setLimit(account);
		request.setAttribute("cdLimit", accountService.getLimit(account));
	}
	
	/**
	 * 显示信用卡。
	 * @return
	 */
	public String showCreditCard() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		request.setAttribute("accountIdList", accountService.getCdsOfClient(account));
		return "showCreditCardSetLimit";
	}
	
	/**
	 * 选择卡。
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		session.setAttribute("cdLimit", request.getParameter("cdLimit"));
		return "selectOkLimitSet";
	}
	
	/**
	 * 密码确认。
	 * @return
	 */
	public String confirmPassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		client.setUserPassword(request.getParameter("accountPassword"));
		client.setClientId(Integer.parseInt(session.getAttribute("clientId").toString()));
			
		if (!accountService.confirmSearchPassword(client)) {
			return "confirmFailedLimit";
		}
		
		set();
		return "confirmSuccessLimit";
	}
	
	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
