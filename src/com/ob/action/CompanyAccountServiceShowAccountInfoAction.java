package com.ob.action;

import java.util.ArrayList;

import antlr.collections.List;

import com.ob.model.Companyaccount;
import com.ob.model.Companyclient;
import com.ob.service.CompanyaccountService;
import com.ob.service.CompanyclientService;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyAccountServiceShowAccountInfoAction extends SuperAction implements
		ModelDriven<Companyaccount> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Companyaccount companyaccount = new Companyaccount();
	private Companyclient companyclient = new Companyclient();
	private CompanyclientService companyclientService;
	private CompanyaccountService companyaccountService;

	public void setCompanyclientService(
			CompanyclientService companyclientService) {
		this.companyclientService = companyclientService;
	}

	public void setCompanyaccountService(
			CompanyaccountService companyaccountService) {
		this.companyaccountService = companyaccountService;
	}
	
	/**
	 * √‹¬Î»∑»œ°£
	 * 
	 * @return
	 */
	public String confirmPassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		
		String accountId = session.getAttribute("account").toString();
		String searchPassword = companyaccount.getSearchpassword();
		companyaccount = companyaccountService.getCompanyaccountDAO().findById(accountId);
		
		if (!searchPassword.equals(companyaccount.getSearchpassword())) {
			request.setAttribute("info", "≤È—Ø√‹¬Î¥ÌŒÛ");
			return "confirmFailedShowAccountInfo";
		}
		
		ArrayList<Companyaccount> accountList = (ArrayList<Companyaccount>) companyaccountService
				.getCompanyaccountDAO().findByClientid(
						Integer.parseInt(session.getAttribute("clientId")
								.toString()));
		
		ArrayList<Companyaccount> accounts = new ArrayList<Companyaccount>();
		
		for (Companyaccount companyaccount : accountList) {
			String accountid = companyaccount.getAccountid();
			companyaccount.setAccountid(accountid.substring(accountid.length()-4, accountid.length()));
			accounts.add(companyaccount);
		}
		
		request.setAttribute("accounts", accounts);
		
		return "confirmSuccessShowAccountInfo";
	}

	/**
	 * œ‘ æ’À∫≈°£
	 * 
	 * @return
	 */
	public String showAccount() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		
		ArrayList<Companyaccount> companyaccounts = (ArrayList<Companyaccount>)companyaccountService.getCompanyaccountDAO().findByClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		ArrayList<String> accountIds = new ArrayList<String>();
		for (Companyaccount companyaccount : companyaccounts) {
			accountIds.add(companyaccount.getAccountid());
		}
		
		request.setAttribute("accountIdList", accountIds);
		return "showAccountOk";
	}
	
	/**
	 * —°‘Òø®°£
	 * @return
	 */
	public String selectAccount() {
		session.setAttribute("account", request.getParameter("selectAccount"));
		return "selectAccountShowAccountInfo";
	}
	

	@Override
	public Companyaccount getModel() {
		if (companyaccount == null) {
			companyaccount = new Companyaccount();
		}
		return companyaccount;
	}
}
