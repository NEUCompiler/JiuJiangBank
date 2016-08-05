package com.ob.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.SharedSessionContract;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.ob.dao.AccountDAO;
import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.model.Dealinform;
import com.ob.service.AccountService;
import com.ob.service.ClientService;
import com.opensymphony.xwork2.ModelDriven;

public class AccountInformationAction extends SuperAction implements
		ModelDriven<Account> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Account account;
	Client client = new Client();
	private AccountService accountService;
	private ClientService clientService;

	public AccountService getAccountService() {
		return accountService;
	}

	public ClientService getClientService() {
		return clientService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public void setClientService(ClientService clienttService) {
		this.clientService = clienttService;
	}

	public String showAccount() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		request.setAttribute("accountIdList",
				accountService.getAccountsOfClientByAccount(account));
		return "showAccountInform";
	}
	
	public String showAccountIsOpen() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId").toString()));
		request.setAttribute("accountIdList",
				accountService.getAccountsOfSignClient(account));
		return "showAccountIsOpenInform";
	}

	public String showAllAccount() {
		client.setClientId(111);
		ArrayList<Account> accountList = new ArrayList<Account>();
		ArrayList<Account> accountLista = new ArrayList<Account>();
		ArrayList<Account> accountListb = new ArrayList<Account>();
		accountList = (ArrayList<Account>) clientService.getAccountDao().findByClientid(client.getClientId());
		for (com.ob.model.Account item : accountList) {
			if (item.getCdlimit() > 0) {
				accountLista.add(item);

			} else {
				accountListb.add(item);

			}
		}
		request.setAttribute("cardTypea", "信用卡");
		request.setAttribute("cardTypeb", "储蓄卡");
		request.setAttribute("accountLista", accountLista);
		request.setAttribute("accountListb", accountListb);
		return "showAllAccountInform";
	}

	public String selectCard() {
		account = accountService.getDao().findById(
				request.getParameter("selectAccount"));

		if (account.getCdlimit() > 0) {
			request.setAttribute("cardType", "信用卡");
		} else {
			request.setAttribute("cardType", "储蓄卡");
		}
		
		if (account.getIsopenob()==0) {
			request.setAttribute("obType", "未开通网银");
		} else {
			request.setAttribute("obType", "已开通网银");
		}

		session.setAttribute("account", account);
		return "selectOkAccount";
	}
	
	public String selectCardIsOpen() {
		account = accountService.getDao().findById(
				request.getParameter("selectAccount"));

		if (account.getCdlimit() > 0) {
			request.setAttribute("cardType", "信用卡");
		} else {
			request.setAttribute("cardType", "储蓄卡");
		}
		
		if (account.getIsopenob()==0) {
			request.setAttribute("obType", "未开通网银");
		} else {
			request.setAttribute("obType", "已开通网银");
		}

		session.setAttribute("account", account);
		return "selectOkAccountIsopen";
	}
	

	public String searchDealInform() throws ParseException {
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session1 = sf.openSession();
		account = (Account) session.getAttribute("account");
		account.setAccountid(account.getAccountid());
		ArrayList<Dealinform> dealInfoList = new ArrayList<Dealinform>();
		session.getAttribute("account");
		String accountid=account.getAccountid();
		String sql = "from com.ob.model.Dealinform where accountid=?";
		String a = request.getParameter("ddda");
		String b = request.getParameter("dddb");
		if (null != a && a != "") {
			sql += " and dealtime > str_to_date('" + a + "','%m/%d/%Y')";
		}
		if (null != b && b != "") {
			sql += " and dealtime < str_to_date('" + b + "','%m/%d/%Y')";
		}
		Query queryObject = session1.createQuery(sql);
		queryObject.setString(0, accountid);
		List result = queryObject.list();
		request.setAttribute("result", result);
		return "showDealInform";

	}
	
	
	public String searchDealInformIsOpen() throws ParseException {
		ApplicationContext c = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SessionFactory sf = (SessionFactory) c.getBean("sessionFactory");
		Session session1 = sf.openSession();
		account = (Account) session.getAttribute("account");
		account.setAccountid(account.getAccountid());
		ArrayList<Dealinform> dealInfoList = new ArrayList<Dealinform>();
		session.getAttribute("account");
		String accountid=account.getAccountid();
		String sql = "from com.ob.model.Dealinform where accountid=? ";
		String a = request.getParameter("ddda");
		String b = request.getParameter("dddb");
		if (null != a && a != "") {
			sql += " and dealtime > str_to_date('" + a + "','%m/%d/%Y')";
			
		}
		if (null != b && b != "") {
			sql += " and dealtime < str_to_date('" + b + "','%m/%d/%Y')";
		}
		Query queryObject = session1.createQuery(sql);
		queryObject.setString(0, accountid);
		List result = queryObject.list();
		
		request.setAttribute("result", result);
		return "showDealInformIsOpen";
	
		
	}


	public Account getModel() {
		if (account == null) {
			account = new Account();
		}
		return account;
	}

}
