package com.ob.service.impl;

import java.util.List;

import com.ob.dao.AccountDAO;
import com.ob.dao.DealinformDAO;
import com.ob.model.Account;
import com.ob.model.Dealinform;
import com.ob.service.PaymentService;

public class PaymentServiceimpl implements PaymentService {
	
	private DealinformDAO dealinformDAO;
	private AccountDAO accountDAO;
	
	public AccountDAO getAccountDAO() {
		return accountDAO;
	}

	public void setAccountDAO(AccountDAO accountDAO) {
		this.accountDAO = accountDAO;
	}

	public DealinformDAO getDealinformDAO() {
		return dealinformDAO;
	}

	public void setDealinformDAO(DealinformDAO dealinformDAO) {
		this.dealinformDAO = dealinformDAO;
	}

	public boolean addOrUpdatePayment(Dealinform dealinform){
		return dealinformDAO.addOrUpdatePayment(dealinform);
	}

	@Override
	public List getDealinformInfo(String accountid){
		return dealinformDAO. getDealinformInfo(accountid);
	}

	
	public int getAccountDealpassword(String accountid){
		return dealinformDAO.getAccountDealpassword(accountid);
	}

	@Override
	public int getAccountAmount(String accountid) {
		// TODO Auto-generated method stub
		return dealinformDAO.getAccountAmount(accountid);
	}
	
	public boolean addOrUpdatePaymentIn(Dealinform dealinform){
		return dealinformDAO.addOrUpdatePaymentIn(dealinform);
	}

	@Override
	public List getTransferInfo(String accountid) {
		// TODO Auto-generated method stub
		return dealinformDAO.getTransferInfo(accountid);
	}
	
//	public List<Account> getAccountDeal(String accountid){
//		return accountDAO.getAccountDeal(accountid);
//	}
}
