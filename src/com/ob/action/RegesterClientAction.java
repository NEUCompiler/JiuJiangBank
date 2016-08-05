package com.ob.action;

import com.ob.model.Client;
import com.ob.service.impl.ClientServiceImpl;

public class RegesterClientAction extends SuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Client client;
	private ClientServiceImpl serviceImpl;
	
	public String excute() {
		return SUCCESS;
	}
}
