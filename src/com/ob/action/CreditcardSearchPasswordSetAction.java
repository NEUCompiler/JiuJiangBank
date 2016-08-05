package com.ob.action;

import com.ob.model.Account;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class CreditcardSearchPasswordSetAction extends SuperAction implements
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
	 * 交易密码设置。
	 * 
	 * @return
	 */
	public String setPassword() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!account.getSearchpassword().equals(
				accountService.getDao().findById(account.getAccountid())
						.getSearchpassword())) {
			request.setAttribute("info", "当前密码输入不正确");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else if (chPassword.length() > 16) {
			request.setAttribute("info", "密码请输入小于16个长度字符");
		} else {
			account.setSearchpassword(chPassword);
			accountService.setSearchPassword(account);
			return "changeSearchPasswordSuccess";
		}
		return "changeSearchPasswordFailed";
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
		//
		request.setAttribute("accountIdList",
				accountService.getCdsOfClientByActive(account));
		return "showCreditCardSearchPasswordSet";
	}
	
	/**
	 * 选择卡。
	 * 
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		return "selectSearchPassword";
	}
	
	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
