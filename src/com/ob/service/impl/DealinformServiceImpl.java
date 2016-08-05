package com.ob.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import com.ob.dao.DealinformDAO;
import com.ob.model.Dealinform;
import com.ob.service.DealinformService;

public class DealinformServiceImpl implements DealinformService {
	private DealinformDAO dealinformDAO;
	
	public DealinformDAO getDealinformDAO() {
		return dealinformDAO;
	}
	
	public void setDealinformDAO(DealinformDAO dealinformDAO) {
		this.dealinformDAO = dealinformDAO;
	}

	/**
	 * 返回未出账单集合。
	 */
	@Override
	public ArrayList<Dealinform> getBillYetDealInfo(String accountId) {
		ArrayList<Dealinform> dealinforms = new ArrayList<Dealinform>();
		ArrayList<Dealinform> dealInfoList = (ArrayList<Dealinform>)dealinformDAO.findByAccountid(accountId);
		//账单日期期限为一个月。
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		date = calendar.getTime();
		for (Dealinform dealinform : dealInfoList) {
			if ((dealinform.getDealtime().compareTo(date) > 0)) {
				//截取卡后四位。
				int index = dealinform.getAccountid().length();
				dealinform.setAccountid(dealinform.getAccountid().substring(index-4, index));
				dealinforms.add(dealinform);
			}
		}
		
		return dealinforms;
	}

	/**
	 * 未出账单查询。
	 */
	@Override
	public ArrayList<Dealinform> getBillHaveDealInfo(String accountId) {
		ArrayList<Dealinform> dealinforms = new ArrayList<Dealinform>();
		ArrayList<Dealinform> dealInfoList = (ArrayList<Dealinform>)dealinformDAO.findByAccountid(accountId);
		//账单日期期限为一个月。
		Date date = new Date();
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(Calendar.MONTH, -1);
		date = calendar.getTime();
		for (Dealinform dealinform : dealInfoList) {
			if (!(dealinform.getDealtime().compareTo(date) > 0)) {
				//截取卡后四位。
				int index = dealinform.getAccountid().length();
				dealinform.setAccountid(dealinform.getAccountid().substring(index-4, index));
				dealinforms.add(dealinform);
			}
		}
		
		return dealinforms;
	}
	
	@Override
	public boolean addOrUpdatePayment(Dealinform dealinform) {
		// TODO Auto-generated method stub
		return dealinformDAO.addOrUpdatePayment(dealinform);
	}
	@Override
	public boolean addOrUpdatePaymentIn(Dealinform dealinform) {
		// TODO Auto-generated method stub
		return dealinformDAO.addOrUpdatePaymentIn(dealinform);
	}

}
