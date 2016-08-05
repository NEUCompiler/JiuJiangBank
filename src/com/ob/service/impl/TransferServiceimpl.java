package com.ob.service.impl;

import java.util.List;

import com.ob.dao.AccountDAO;
import com.ob.model.Account;
import com.ob.service.TransferService;

public class TransferServiceimpl implements TransferService {
	private AccountDAO accountDAO;

	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}
	
	public List getAccountInfo(String clientid){
		return accountDAO.getAccountInfo(clientid);
	}

	@Override
	public int getAccountAmount(String clientid) {
		// TODO Auto-generated method stub
		return 0;
	}
}
