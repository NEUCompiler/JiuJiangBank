package com.ob.action;

import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class CreditcardActiveAction extends SuperAction implements
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
	 * 信用卡激活。
	 */
	public void active() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		accountService.setActive(account);
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
		request.setAttribute("accountIdList", accountService.getCdsOfClientByNotActive(account));
		return "showCreditCardActive";
	}
	
	/**
	 * 选择卡。
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		session.setAttribute("cdLimit", request.getParameter("cdLimit"));
		return "selectOkActive";
	}
	
	/**
	 * 设置交易密码。
	 * @return
	 */
	public String setDealPassword() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		String dealPassword = request.getParameter("dealPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!dealPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else if (!dealPassword.matches("^[0-9]{6}$")) {
			request.setAttribute("info", "密码请输入6个数字");
		} else {
			account.setDealpassword(Integer.parseInt((dealPassword)));
			accountService.setDealPassword(account);
			return "dealPasswordSetSuccessActive";
		}
		return "dealPasswordSetFailedActive";
	}
	
	/**
	 * 设置查询密码。
	 * @return
	 */
	public String setSearchPassword() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		String searchPassword = request.getParameter("searchPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!searchPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else if (searchPassword.length() > 16) {
			request.setAttribute("info", "密码请输入小于16个长度字符");
		} else {
			account.setSearchpassword(searchPassword);
			accountService.setSearchPassword(account);
			active();
			return "searchPasswordSetSuccessActive";
		}
		return "searchPasswordSetFailedActive";
	}
	
	
	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
