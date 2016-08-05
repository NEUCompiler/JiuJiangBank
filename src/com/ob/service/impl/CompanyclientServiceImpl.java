package com.ob.service.impl;

import com.ob.dao.CompanyclientDAO;
import com.ob.service.CompanyclientService;

public class CompanyclientServiceImpl implements CompanyclientService {
	private CompanyclientDAO companyclientDAO;

	public CompanyclientDAO getCompanyclientDAO() {
		return companyclientDAO;
	}

	public void setCompanyclientDAO(CompanyclientDAO companyclientDAO) {
		this.companyclientDAO = companyclientDAO;
	}
	
}
