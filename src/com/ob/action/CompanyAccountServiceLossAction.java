package com.ob.action;

import java.util.ArrayList;

import com.ob.model.Companyaccount;
import com.ob.model.Companyclient;
import com.ob.service.CompanyaccountService;
import com.ob.service.CompanyclientService;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyAccountServiceLossAction extends SuperAction implements
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
	 * –≈”√ø®π“ ß…Ë÷√°£
	 * 
	 * @return
	 */
	public void loss() {
		companyaccount.setAccountid(session.getAttribute("account").toString());
		companyaccount = companyaccountService.getCompanyaccountDAO().findById(companyaccount.getAccountid());
		companyaccount.setIsloss(1);
		companyaccountService.getCompanyaccountDAO().merge(companyaccount);
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

		companyclient.setUserpassword(request.getParameter("accountPassword"));
		if (!companyclient.getUserpassword().equals(
				companyclientService
				.getCompanyclientDAO()
				.findById(
						Integer.parseInt(session.getAttribute(
								"clientId").toString()))
				.getUserpassword())) {
			return "confirmFailedLoss";
		}
		loss();
		return "confirmSuccessLoss";
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
			
			if (companyaccount.getIsloss() == 0) {
				accountIds.add(companyaccount.getAccountid());
			}
		}
		
		request.setAttribute("accountIdList", accountIds);
		return "showAccountLoss";
	}
	
	/**
	 * π“ ß—°‘Òø®°£
	 * @return
	 */
	public String selectAccount() {
		session.setAttribute("account", request.getParameter("selectAccount"));
		return "selectOkLoss";
	}
	
	@Override
	public Companyaccount getModel() {
		if (companyaccount == null) {
			companyaccount = new Companyaccount();
		}
		return companyaccount;
	}
}
