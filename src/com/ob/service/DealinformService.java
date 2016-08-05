package com.ob.service;

import java.util.ArrayList;

import com.ob.model.Dealinform;

public interface DealinformService {
	public ArrayList<Dealinform> getBillYetDealInfo(String accountId);
	public ArrayList<Dealinform> getBillHaveDealInfo(String accountId);
	public boolean addOrUpdatePayment(Dealinform dealinform);
	public boolean addOrUpdatePaymentIn(Dealinform dealinform);
}
