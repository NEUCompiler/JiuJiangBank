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
	 * 上挂账户。
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
			request.setAttribute("info", "账号不存在");
			return "addAccountFailed";
		} else if (!account.getIdentityid().equals(client.getIdentityId())) {
			request.setAttribute("info", "此账号不属于你");
			return "addAccountFailed";
		} else if (!dealPassword.equals(account.getDealpassword())) {
			request.setAttribute("info", "交易密码错误");
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
