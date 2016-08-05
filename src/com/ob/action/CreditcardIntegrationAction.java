package com.ob.action;

import com.ob.model.Account;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class CreditcardIntegrationAction extends SuperAction implements
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

	/**
	 * 积分查询。
	 * @return
	 */
	public String search() {
		account.setAccountid(request.getParameter("selectCd").toString());
		request.setAttribute("integration", accountService.getIntegration(account));
		
		return "selectOkIntegration";
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
		return "showCreditCardIntegration";
	}
	
	/**
	 * 选择卡。
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		
		return search();
	}
	
	
	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
