package com.ob.action;

import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class CreditcardLossAction extends SuperAction implements
		ModelDriven<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	private Client client = new Client();
	private AccountService accountService;

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	/**
	 * 信用卡挂失设置。
	 * 
	 * @return
	 */
	public void loss() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		accountService.setLoss(account);
	}

	/**
	 * 显示信用卡。
	 * 
	 * @return
	 */
	public String showCreditCard() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		request.setAttribute("accountIdList",
				accountService.getCdsOfClientByLoss(account));
		return "showCreditCardLoss";
	}

	/**
	 * 密码确认。
	 * 
	 * @return
	 */
	public String confirmPassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		client.setUserPassword(request.getParameter("accountPassword"));
		client.setClientId(Integer.parseInt(session.getAttribute("clientId")
				.toString()));

		if (!accountService.confirmSearchPassword(client)) {
			return "confirmFailedLoss";
		}
		loss();
		return "confirmSuccessLoss";
	}

	/**
	 * 选择卡。
	 * 
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		return "selectOkLoss";
	}

	@Override
	public Account getModel() {

		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
