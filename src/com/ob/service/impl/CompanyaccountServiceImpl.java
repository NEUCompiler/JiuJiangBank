package com.ob.service.impl;

import com.ob.dao.CompanyaccountDAO;
import com.ob.service.CompanyaccountService;

public class CompanyaccountServiceImpl implements CompanyaccountService {
	private CompanyaccountDAO companyaccountDAO;

	public CompanyaccountDAO getCompanyaccountDAO() {
		return companyaccountDAO;
	}

	public void setCompanyaccountDAO(CompanyaccountDAO companyaccountDAO) {
		this.companyaccountDAO = companyaccountDAO;
	}
	
	
}
