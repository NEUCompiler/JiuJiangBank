package com.ob.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.jms.Session;

import com.ob.model.Account;
import com.ob.model.Dealinform;
import com.ob.service.PaymentService;
import com.ob.service.TransferService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class TransferAction extends SuperAction {
	
	private TransferService transferService;
	private PaymentService paymentService;
	private Dealinform dealinform;
	private String accountid;
	private String clientid;
	private Account account;
	private int dealpassword;
	
	public TransferService getTransferService() {
		return transferService;
	}
	public void setTransferService(TransferService transferService) {
		this.transferService = transferService;
	}
	public Dealinform getDealinform() {
		return dealinform;
	}
	public void setDealinform(Dealinform dealinform) {
		this.dealinform = dealinform;
	}

	public String getClientid() {
		return clientid;
	}
	public void setClientid(String clientid) {
		this.clientid = clientid;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
		
	
	public String showTransferInfo() throws Exception{
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		clientid = session.getAttribute("clientId").toString();
		List accountInfo = transferService.getAccountInfo(clientid);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("accountInfo",accountInfo);
		return SUCCESS;
	}
}
