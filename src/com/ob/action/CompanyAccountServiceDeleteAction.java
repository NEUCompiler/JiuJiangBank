package com.ob.action;

import com.ob.model.Companyaccount;
import com.ob.model.Companyclient;
import com.ob.service.CompanyaccountService;
import com.ob.service.CompanyclientService;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyAccountServiceDeleteAction extends SuperAction implements
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
	public String deleteAccount() {
		String accountId = companyaccount.getAccountid();
		Integer dealPassword = companyaccount.getDealpassword();
		companyaccount = companyaccountService.getCompanyaccountDAO().findById(accountId);
		
		if (companyaccount == null) {
			request.setAttribute("info", "’À∫≈¥¢¥Ê≤ª¥Ê‘⁄");
			return "deleteAccountFailed";
		} else if(!dealPassword.equals(companyaccount.getDealpassword())) {
			request.setAttribute("info", "Ωª“◊√‹¬Î¥ÌŒÛ");
			return "deleteAccountFailed";
		}
		
		companyaccount.setClientid(0);
		companyaccount.setIsopenob(0);
		companyaccountService.getCompanyaccountDAO().merge(companyaccount);
		return "deleteAccountSuccess";
	}

	@Override
	public Companyaccount getModel() {
		if (companyaccount == null) {
			companyaccount = new Companyaccount();
		}
		return companyaccount;
	}
}
