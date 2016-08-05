package com.ob.action;

import com.ob.dao.AccountDAO;
import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.service.AccountService;
import com.ob.service.ClientService;
import com.opensymphony.xwork2.ModelDriven;

public class AccountAddAccountAction extends SuperAction implements
		ModelDriven<Account> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account = new Account();
	private Client client = new Client();
	private AccountService accountService;
	private ClientService clientService;

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setClientService(ClientService clientService) {
		this.clientService = clientService;
	}

	/**
	 * �Ϲ��˻���
	 * 
	 * @return
	 */
	public String addAccount() {
		String accountId = account.getAccountid();
		Integer dealPassword = account.getDealpassword();
		account = accountService.getDao().findById(accountId);
		client = clientService.getClientDAO().findById(
				Integer.parseInt(session.getAttribute("clientId").toString()));

		if (account == null) {
			request.setAttribute("info", "�˺Ų�����");
			return "addAccountFailed";
		} else if (!account.getIdentityid().equals(client.getIdentityId())) {
			request.setAttribute("info", "���˺Ų�������");
			return "addAccountFailed";
		} else if (!dealPassword.equals(account.getDealpassword())) {
			request.setAttribute("info", "�����������");
			return "addAccountFailed";
		}

		account.setClientid(client.getClientId());
		accountService.getDao().merge(account);
		return "addAccountSuccess";
	}

	@Override
	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}
}
