package com.ob.service;

import java.util.ArrayList;

import com.ob.dao.AccountDAO;
import com.ob.dao.DealinformDAO;
import com.ob.model.Account;
import com.ob.model.Client;

public interface AccountService {
	//liuxinwei.
	public AccountDAO getDao();
	public DealinformDAO getDealinformDAO();
	public boolean setLoss(Account account);
	
	public boolean isActive(Account account);
	public boolean setActive(Account account);

	public ArrayList<String> getCdsOfClient(Account account);
	public ArrayList<String> getCdsOfClientByLoss(Account account);
	public ArrayList<String> getCdsOfClientByActive(Account account);
	public ArrayList<String> getCdsOfClientByNotActive(Account account);
	public ArrayList<String> getCdsOfClientByCancelDPWD(Account account);
	public boolean confirmSearchPassword(Client client);
	public boolean confirmCDSearchPassword(Account account);
	
	public Integer getIntegration(Account account);
	public Integer getLimit(Account account);
	public boolean setLimit(Account account);
	public boolean setDealPassword(Account account);
	public boolean setSearchPassword(Account account);
	public boolean changeDealPassword(Account account);
	public boolean cancelDealPassword(Account account);
	
	//zhangsiting.
	public Account findById(String id);
	public ArrayList<String> getAccountsOfClientByLoss(Account account);
	public ArrayList<String> getAccountsOfClientByAccount(Account account);
	public ArrayList<String> getAccountsOfClient(Account account);
	public ArrayList<String> getAccountsOfSignClient(Account account);
	public boolean setOthername(Account account);
	public ArrayList<Account> getAllAccount(Account account);
}
