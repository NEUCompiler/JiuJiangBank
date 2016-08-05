package com.ob.action;

import com.ob.model.Companyaccount;
import com.ob.model.Companyclient;
import com.ob.service.CompanyaccountService;
import com.ob.service.CompanyclientService;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyAccountServiceAddAction extends SuperAction implements
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
	 * …œπ“’Àªß°£
	 * 
	 * @return
	 */
	public String addAccount() {
		String accountId = companyaccount.getAccountid();
		Integer dealPassword = companyaccount.getDealpassword();
		companyaccount = companyaccountService.getCompanyaccountDAO().findById(accountId);
		
		if (companyaccount == null) {
			request.setAttribute("info", "’À∫≈¥¢¥Ê≤ª¥Ê‘⁄");
			return "addAccountFailed";
		} else if(!dealPassword.equals(companyaccount.getDealpassword())) {
			request.setAttribute("info", "Ωª“◊√‹¬Î¥ÌŒÛ");
			return "addAccountFailed";
		}
		
		companyaccount.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		companyaccount.setIsopenob(1);
		companyaccountService.getCompanyaccountDAO().merge(companyaccount);
		return "addAccountSuccess";
	}

	@Override
	public Companyaccount getModel() {
		if (companyaccount == null) {
			companyaccount = new Companyaccount();
		}
		return companyaccount;
	}
}
