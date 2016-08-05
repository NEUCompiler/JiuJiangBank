package com.ob.action;

import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class AccountLossAction extends SuperAction implements
		ModelDriven<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	private AccountService accountService;
	private Client client = new Client();

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void loss() {
		account.setAccountid(session.getAttribute("account").toString());
		accountService.setLoss(account);
	}
	

	public String showAccount() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		request.setAttribute("accountIdList",
				accountService.getAccountsOfClientByLoss(account));
		return "zhangdabenshowAccount";
	}


	public String confirmPassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		client.setUserPassword(request.getParameter("accountPassword"));
		client.setClientId(Integer.parseInt(session.getAttribute("clientId")
				.toString()));

		if (!accountService.confirmSearchPassword(client)) {
			return "zhangdabenconfirmFailedLoss";
		}
		loss();
		return "zhangdabenconfirmSuccessLoss";
	}

	public String selectCard() {
		session.setAttribute("account", request.getParameter("selectAccount"));
		return "zhangdabenselectOkLoss";
	}

	@Override
	public Account getModel() {

		if (account == null) {
			account = new Account();
		}
		return account;
	}
}