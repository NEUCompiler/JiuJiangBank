package com.ob.service;

import java.util.List;

import com.ob.dao.DealinformDAO;
import com.ob.model.Account;
import com.ob.model.Dealinform;

public interface PaymentService {
	
	public DealinformDAO getDealinformDAO();

	public void setDealinformDAO(DealinformDAO dealinformDAO);
	
	public boolean addOrUpdatePayment(Dealinform dealinform);
	
	public List getDealinformInfo(String accountid);
	
	public int getAccountDealpassword(String accountid);

	public int getAccountAmount(String accountid);
	
	public boolean addOrUpdatePaymentIn(Dealinform dealinform);

	public List getTransferInfo(String accountid);
}
