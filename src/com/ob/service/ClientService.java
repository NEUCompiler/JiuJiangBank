package com.ob.service;

import com.ob.dao.AccountDAO;
import com.ob.dao.ClientDAO;

public interface ClientService {
	public ClientDAO getClientDAO();
	public AccountDAO getAccountDao();
}
