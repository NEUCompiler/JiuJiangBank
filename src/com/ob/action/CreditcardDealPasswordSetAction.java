package com.ob.action;

import com.ob.model.Account;
import com.ob.service.AccountService;
import com.opensymphony.xwork2.ModelDriven;

public class CreditcardDealPasswordSetAction extends SuperAction implements
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

		if (!account.getDealpassword().equals(
				accountService.getDao().findById(account.getAccountid())
						.getDealpassword())) {
			request.setAttribute("info", "当前密码输入不正确");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "两次密码不一致，请重新输入！");

		} else if (!chPassword.matches("^[0-9]{6}$")) {
			request.setAttribute("info", "密码请输入6个数字");
		} else {
			account.setDealpassword(Integer.parseInt((chPassword)));
			accountService.setDealPassword(account);
			return "dealPasswordSetSuccess";
		}
		return "dealPasswordSetFailed";
	}
	
	/**
	 * 密码确认。
	 * @return
	 */
	public String confirmPassword() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		
		if (!account.getDealpassword().equals(
				accountService.getDao().findById(account.getAccountid())
						.getDealpassword())) {
			request.setAttribute("info", "当前密码输入不正确");
			return "confirmFailedCancelDPWD";
		}
		
		cancelDealPassword(account);
		return "confirmSuccessCancelDPWD";
		
	}
	
	/**
	 * 取消交易密码。
	 * @param account
	 */
	public void cancelDealPassword(Account account) {
		accountService.cancelDealPassword(account);
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
		return "showCreditCardDealPasswordSet";
	}

	/**
	 * 选择卡。
	 * 
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		
		if ("changeDPWD".equals(request.getParameter("dealPWDOperation"))) {
			return "selectChangeDealPassword";
		} else if ("cancelDPWD".equals(request.getParameter("dealPWDOperation"))) {
			return "selectCancelDealPassword";
		} 
		
		return "selectFaildDealPassword";
	}

	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
