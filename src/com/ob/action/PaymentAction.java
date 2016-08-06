package com.ob.action;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.struts2.ServletActionContext;

import com.ob.model.Account;
import com.ob.model.Dealinform;
import com.ob.service.PaymentService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class PaymentAction extends ActionSupport {
	
	private PaymentService paymentService;
	private Dealinform dealinform;
	private Account account;
	private String accountid;
	private int dealpassword;
	
	public int getDealpassword() {
		return dealpassword;
	}

	public void setDealpassword(int dealpassword) {
		this.dealpassword = dealpassword;
	}

	public String getAccountid() {
		return accountid;
	}

	public void setAccountid(String accountid) {
		this.accountid = accountid;
	}

	public Dealinform getDealinform() {
		return dealinform;
	}

	public void setDealinform(Dealinform dealinform) {
		this.dealinform = dealinform;
	}

	protected String getParam(String key){
		return ServletActionContext.getRequest().getParameter(key);
	}

	public PaymentService getPaymentService() {
		return paymentService;
	}
	public void setPaymentService(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	
	//�ɷ�ҵ��action
	public String doPayment() throws Exception{
		Map session=(Map) ActionContext.getContext().getSession();
		Dealinform dealinform1 = new Dealinform();
		boolean password = false;
		boolean amount = false;
		int dpw = 0;//ͨ��accountidȡ����Ӧ�˻���dealpassword
		int am = 0;//ͨ��accountidȡ����Ӧ�˻������Amount
		accountid = dealinform.getAccountid();
		dpw = paymentService.getAccountDealpassword(accountid);
		am = paymentService.getAccountAmount(accountid);
		Date date = new Date();
		String dealid = UUID.randomUUID().toString();
		
		if(dpw == dealpassword){
			if(dealinform.getDeaamountl() <= am){
				dealinform1.setAccountid(dealinform.getAccountid());
				dealinform1.setDeaamountl(dealinform.getDeaamountl());
				dealinform1.setDealDesti(dealinform.getDealDesti());
				dealinform1.setDealid(dealid);
				dealinform1.setDealinform(dealinform.getDealinform());
				dealinform1.setDealstate(1);
				dealinform1.setDealtime(date);
				dealinform1.setDealtype(1);
				
				password = paymentService.addOrUpdatePayment(dealinform1);
				amount = true;
			}
			else {
				password = true;
				amount = false;
			}
		}
		else {
			password = false;
		}
		
		if(password & amount){
			return "paymentSuccess";
		}
		else if (password & !amount) {
			return "transferAmountLess";
		}
		else {
			return "transferPasswordError";
		}
		
		

//		if(dpw == dealpassword){
//			dealinform1.setAccountid(dealinform.getAccountid());
//			dealinform1.setDeaamountl(dealinform.getDeaamountl());
//			dealinform1.setDealDesti(dealinform.getDealDesti());
//			dealinform1.setDealid(dealid);
//			dealinform1.setDealinform(dealinform.getDealinform());
//			dealinform1.setDealstate(1);
//			dealinform1.setDealtime(date);
//			dealinform1.setDealtype(1);
//			password = paymentService.addOrUpdatePayment(dealinform1);
//		}
//		else {
//			password = false;
//		}
		
		
	}
	
	//����ת��
	public String doTransferIn() throws Exception{
		Map session=(Map) ActionContext.getContext().getSession();
		Dealinform dealinform1 = new Dealinform();//ת��������Ϣ
		Dealinform dealinform2 = new Dealinform();//ת�뽻����Ϣ
		boolean password = false;
		boolean amount = false;
		int dpw = 0;//ͨ��accountidȡ����Ӧ�˻���dealpassword
		int am = 0;//ͨ��accountidȡ����Ӧ�˻������Amount
		accountid = dealinform.getAccountid();
		dpw = paymentService.getAccountDealpassword(accountid);
		am = paymentService.getAccountAmount(accountid);
		Date date = new Date();
		String dealid1 = UUID.randomUUID().toString();
		String dealid2 = UUID.randomUUID().toString();
		
		if(dpw == dealpassword){
			if(dealinform.getDeaamountl() <= am){
				dealinform1.setAccountid(dealinform.getAccountid());
				dealinform1.setDeaamountl(dealinform.getDeaamountl());
				dealinform1.setDealDesti(dealinform.getDealDesti());
				dealinform1.setDealid(dealid1);
				dealinform1.setDealinform("Transfer");
				dealinform1.setDealstate(0);
				dealinform1.setDealtime(date);
				dealinform1.setDealtype(0);
				
				dealinform2.setAccountid(dealinform.getDealDesti());
				dealinform2.setDeaamountl(dealinform.getDeaamountl());
				dealinform2.setDealDesti(dealinform.getAccountid());
				dealinform2.setDealid(dealid2);
				dealinform2.setDealinform("Receive");
				dealinform2.setDealstate(0);
				dealinform2.setDealtime(date);
				dealinform2.setDealtype(0);
				
				password = paymentService.addOrUpdatePayment(dealinform1)&
						paymentService.addOrUpdatePaymentIn(dealinform2);
				amount = true;
			}
			else {
				password = true;
				amount = false;
			}
		}
		else {
			password = false;
		}
		
		if(password & amount){
			return "transferSuccess";
		}
		else if (password & !amount) {
			return "transferAmountLess";
		}
		else {
			return "transferPasswordError";
		}
	}
	
	//����ת��action
	public String doPaymentTransferOut() throws Exception{
		Map session=(Map) ActionContext.getContext().getSession();
		Dealinform dealinform1 = new Dealinform();
		boolean password = false;
		boolean amount = false;
		int dpw = 0;//ͨ��accountidȡ����Ӧ�˻���dealpassword
		int am = 0;//ͨ��accountidȡ����Ӧ�˻������Amount
		accountid = dealinform.getAccountid();
		dpw = paymentService.getAccountDealpassword(accountid);
		am = paymentService.getAccountAmount(accountid);
		Date date = new Date();
		String dealid = UUID.randomUUID().toString();
		
		if(dpw == dealpassword){
			if(dealinform.getDeaamountl() <= am){
				dealinform1.setAccountid(dealinform.getAccountid());
				dealinform1.setDeaamountl(dealinform.getDeaamountl());
				dealinform1.setDealDesti(dealinform.getDealDesti());
				dealinform1.setDealid(dealid);
				dealinform1.setDealinform("TransferOut");
				dealinform1.setDealstate(0);
				dealinform1.setDealtime(date);
				dealinform1.setDealtype(0);
				
				password = paymentService.addOrUpdatePayment(dealinform1);
				amount = true;
			}
			else {
				password = true;
				amount = false;
			}
		}
		else {
			password = false;
		}
		
		if(password & amount){
			return "paymentSuccess";
		}
		else if (password & !amount) {
			return "transferAmountLess";
		}
		else {
			return "transferPasswordError";
		}
	}
	//ת����Ϣ��ѯ
	public String showTransferInfo() throws Exception{
		accountid = dealinform.getAccountid();
		List transferInfoList = paymentService.getTransferInfo(accountid);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("transferInfoList",transferInfoList);
		return SUCCESS;
	}
	//�ɷ���Ϣ��ѯ
	public String browseDealinform() throws Exception{
		accountid = dealinform.getAccountid();
		List dealinformInfo = paymentService.getDealinformInfo(accountid);
		Map request=(Map) ActionContext.getContext().get("request");
		request.put("dealinformInfo",dealinformInfo);
		return SUCCESS;
	}
}
