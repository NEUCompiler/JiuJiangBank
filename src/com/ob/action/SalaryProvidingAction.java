package com.ob.action;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.management.loading.PrivateClassLoader;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import com.ob.model.Account;
import com.ob.model.Client;
import com.ob.model.Dealinform;
import com.ob.service.AccountService;
import com.ob.service.ClientService;
import com.ob.service.DealinformService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ModelDriven;

public class SalaryProvidingAction extends SuperAction implements
		ModelDriven<Account> {

	private Account account;
	Client client = new Client();
	private AccountService accountService;
	private DealinformService dealinformService;
	private Workbook workbook;
	private Sheet sheet;
	private File theFile;// 得到上传的文件
	private Dealinform dealinform;

	public File getTheFile() {
		return theFile;
	}

	public DealinformService getDealinformService() {
		return dealinformService;
	}

	public void setDealinformService(DealinformService dealinformService) {
		this.dealinformService = dealinformService;
	}

	public void setTheFile(File theFile) {
		this.theFile = theFile;
	}

	public String getTheFileContentType() {
		return theFileContentType;
	}

	public void setTheFileContentType(String theFileContentType) {
		this.theFileContentType = theFileContentType;
	}

	public String getTheFileFileName() {
		return theFileFileName;
	}

	public void setTheFileFileName(String theFileFileName) {
		this.theFileFileName = theFileFileName;
	}

	private String theFileContentType;// 得到文件的类型
	private String theFileFileName;// 得到文件的名称

	public AccountService getAccountService() {
		return accountService;
	}

	public void setAccountService(AccountService accountService) {
		this.accountService = accountService;
	}

	public String showAccountIsOpen() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId")
				.toString()));
		request.setAttribute("accountIdList",
				accountService.getAccountsOfSignClient(account));
		return "showCompanyAccount";
	}

	public String salaryProviding() {

		account = accountService.getDao().findById(
				request.getParameter("selectAccount"));
		session.setAttribute("account", account);
		return "success";

	}

	public String showExcel() throws BiffException, IOException {
		Map session1 = (Map) ActionContext.getContext().getSession();

		boolean password = false;
		boolean amount = false;
		// int dpw = 0;//通过accountid取出对应账户的dealpassword
		// int am = 0;//通过accountid取出对应账户的余额Amount
		// accountid = dealinform.getAccountid();
		// dpw = paymentService.getAccountDealpassword(accountid);
		// am = paymentService.getAccountAmount(accountid);
		// Date date= new Date();
		Date date = new java.sql.Date(new java.util.Date().getTime());
		ArrayList<Dealinform> dealInfoList1 = new ArrayList<Dealinform>();
		List<Dealinform> dealInfoList2 = new ArrayList<Dealinform>();
		account = (Account) session.getAttribute("account");
		workbook = Workbook.getWorkbook(theFile);
		sheet = workbook.getSheet(0);

		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		account.setClientid(Integer.parseInt(session.getAttribute("clientId")
				.toString()));
		request.setAttribute("accountIdList",
				accountService.getAccountsOfSignClient(account));
		int a = account.getAmount();
		int b = 0;
		for (int i = 1; i < sheet.getRows(); i++) {
			int j = 1;
			Cell cell = sheet.getCell(j, i);
			b += Integer.parseInt(cell.getContents());
		}

		System.out.println(b);
		if (a < b)
			return "SalaryProvidingFailed";
		else {

			for (int i = 1; i < sheet.getRows(); i++) {
				Dealinform dealinform1 = new Dealinform();// 转出交易信息
				Dealinform dealinform2 = new Dealinform();// 转入建议信息
				Cell cella = sheet.getCell(0, i);
				String desti = cella.getContents();
				Cell cellb = sheet.getCell(1, i);
				Cell cellc = sheet.getCell(2, i);
				String dealtype = cellc.getContents();
				int salaryamount = Integer.parseInt(cellb.getContents());
				String dealid1 = UUID.randomUUID().toString();
				String dealid2 = UUID.randomUUID().toString();
				dealinform1.setAccountid(account.getAccountid());
				dealinform1.setDeaamountl(salaryamount);
				dealinform1.setDealDesti(desti);
				dealinform1.setDealid(dealid1);
				dealinform1.setDealinform(dealtype);
				dealinform1.setDealstate(0);
				dealinform1.setDealtime(date);
				dealinform1.setDealtype(0);
				dealInfoList1.add(dealinform1);

				dealinform2.setAccountid(desti);
				dealinform2.setDeaamountl(salaryamount);
				dealinform2.setDealDesti(account.getAccountid());
				dealinform2.setDealid(dealid2);
				dealinform2.setDealinform(dealtype);
				dealinform2.setDealstate(0);
				dealinform2.setDealtime(date);
				dealinform2.setDealtype(1);
				dealInfoList2.add(dealinform2);
				password = dealinformService.addOrUpdatePayment(dealinform1)
						& dealinformService.addOrUpdatePaymentIn(dealinform2);
			}

			workbook.close();
		}
		// request.setAttribute("dealInfoList1",dealInfoList1) ;
		request.setAttribute("dealInfoList2", dealInfoList2);
		if (password == true)
			return "selectSalaryProviding";
		else {
			return "SalaryProvidingFailed";
		}

	}

	public Account getModel() {

		if (account == null) {
			account = new Account();
		}
		return account;
	}

}
