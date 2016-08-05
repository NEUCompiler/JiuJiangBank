package com.ob.service;

import java.util.List;

import com.ob.dao.AccountDAO;

public interface TransferService {
	
	public AccountDAO getAccountDAO();

	public void setAccountDAO(AccountDAO accountDAO);
	
	public List getAccountInfo(String clientid);
	
	public int getAccountAmount(String clientid);
}
