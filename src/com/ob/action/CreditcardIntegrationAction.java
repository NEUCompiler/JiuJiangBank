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
	 * ���ֲ�ѯ��
	 * @return
	 */
	public String search() {
		account.setAccountid(session.getAttribute("creditcard").toString());
		request.setAttribute("integration", accountService.getIntegration(account));
		
		return "selectOkIntegration";
	}
	
	/**
	 * ����ȷ�ϡ�
	 * @return
	 */
	public String confirmPassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		String searchPassword = request.getParameter("searchPassword");
		account = accountService.getDao().findById(session.getAttribute("creditcard").toString());
			
		if (!searchPassword.equals(account.getSearchpassword())) {
			request.setAttribute("info", "��ѯ�������");
			return "confirmFailedIntegration";
		}
		
		return search();
	}
	
	/**
	 * ��ʾ���ÿ���
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
	 * ѡ�񿨡�
	 * @return
	 */
	public String selectCard() {
		session.setAttribute("creditcard", request.getParameter("selectCd"));
		
		return "selectCardSuccessIntegration";
	}
	
	
	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
