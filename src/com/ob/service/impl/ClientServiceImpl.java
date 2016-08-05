package com.ob.service.impl;

import com.ob.dao.AccountDAO;
import com.ob.dao.ClientDAO;
import com.ob.service.ClientService;

public class ClientServiceImpl implements ClientService {
	private ClientDAO clientDAO;
	private AccountDAO dao;
	public void setClientDAO(ClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}
	public AccountDAO getAccountDao() {
		return dao;
	}
	
	public void setDao(AccountDAO dao) {
		this.dao = dao;
	}
}
