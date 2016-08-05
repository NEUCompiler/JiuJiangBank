package com.ob.service.impl;

import com.ob.dao.AccountDAO;
import com.ob.dao.ClientDAO;
import com.ob.service.ClientService;

public class ClientServiceImpl implements ClientService {
	private ClientDAO clientDAO;
	private AccountDAO accountDAO;
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	
	public ClientDAO getClientDAO() {
		return clientDAO;
	}

	public AccountDAO getAccountDao() {
		return accountDAO;
	}
	
	public void setDao(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
}
