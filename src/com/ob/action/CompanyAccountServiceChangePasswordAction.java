package com.ob.action;

import java.util.ArrayList;

import com.ob.model.Companyaccount;
import com.ob.model.Companyclient;
import com.ob.service.CompanyaccountService;
import com.ob.service.CompanyclientService;
import com.opensymphony.xwork2.ModelDriven;

public class CompanyAccountServiceChangePasswordAction extends SuperAction
		implements ModelDriven<Companyaccount> {
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
	 * ѡ�����롣
	 * 
	 * @return
	 */
	public String selectTypeOfPassword() {
		String typeOfPassword = request.getParameter("selectPassword");

		if ("loginPassword".equals(typeOfPassword)) {
			return "loginPassword";
		} else if ("searchPassword".equals(typeOfPassword)) {
			showAccount();
			return "searchPassword";
		} else if ("dealPassword".equals(typeOfPassword)) {
			showAccount();
			return "dealPassword";
		} else if ("addDealpassword".equals(typeOfPassword)) {
			return "addDealpassword";
		}
		return LOGIN;
	}

	/**
	 * �޸ĵ�¼���롣
	 * 
	 * @return
	 */
	public String changeLoginPassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		companyclient.setUserpassword(request.getParameter("loginPassword"));
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!companyclient.getUserpassword().equals(
				companyclientService
						.getCompanyclientDAO()
						.findById(
								Integer.parseInt(session.getAttribute(
										"clientId").toString()))
						.getUserpassword())) {
			request.setAttribute("info", "��ǰ�������벻��ȷ");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		} else if (chPassword.length() > 16) {
			request.setAttribute("info", "����������С��16�������ַ�");
		} else {
			companyclient = companyclientService.getCompanyclientDAO()
					.findById(
							Integer.parseInt(session.getAttribute("clientId")
									.toString()));
			companyclient.setUserpassword(chPassword);
			companyclientService.getCompanyclientDAO().merge(companyclient);
			return "loginPasswordChangeSuccess";
		}
		return "loginPasswordChangeFailed";
	}

	/**
	 * 
	 * @return
	 */
	public String changeAddDealpassword() {
		if (session.getAttribute("clientId") == null) {
			return "LoginYet";
		}
		companyclient.setAdddealpassword(request
				.getParameter("addDealpassword"));
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!companyclient.getAdddealpassword().equals(
				companyclientService
						.getCompanyclientDAO()
						.findById(
								Integer.parseInt(session.getAttribute(
										"clientId").toString()))
						.getAdddealpassword())) {
			request.setAttribute("info", "��ǰ�������벻��ȷ");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		} else if (chPassword.length() > 16) {
			request.setAttribute("info", "����������С��16�������ַ�");
		} else {
			companyclient = companyclientService.getCompanyclientDAO()
					.findById(
							Integer.parseInt(session.getAttribute("clientId")
									.toString()));
			companyclient.setAdddealpassword(chPassword);
			companyclientService.getCompanyclientDAO().merge(companyclient);
			return "addDealpasswordChangeSuccess";
		}
		return "addDealpasswordChangeFailed";
	}
	
	
	
	/**
	 * ��ѯ�������롣
	 * @return
	 */
	public String changeSearchPassword() {
		companyaccount.setAccountid(session.getAttribute("account").toString());
		companyaccount.setSearchpassword(request.getParameter("searchPassword"));
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!companyaccount.getSearchpassword().equals(
				companyaccountService.getCompanyaccountDAO().findById(companyaccount.getAccountid())
						.getSearchpassword())) {
			request.setAttribute("info", "��ǰ�������벻��ȷ");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		}  else if (chPassword.length() > 16) {
			request.setAttribute("info", "����������С��16�������ַ�");
		} else {
			companyaccount = companyaccountService.getCompanyaccountDAO().findById(companyaccount.getAccountid());
			companyaccount.setSearchpassword((chPassword));
			companyaccountService.getCompanyaccountDAO().merge(companyaccount);
			return "searchPasswordChangeSuccess";
		}
		return "searchPasswordChangeFailed";
	}
	
	/**
	 * �޸Ľ������롣
	 * @return
	 */
	public String changeDealPassword() {
		companyaccount.setAccountid(session.getAttribute("account").toString());
		companyaccount.setDealpassword(Integer.parseInt(request.getParameter("dealPassword")));
		String chPassword = request.getParameter("chPassword");
		String confirmPassword = request.getParameter("confirmPassword");

		if (!companyaccount.getDealpassword().equals(
				companyaccountService.getCompanyaccountDAO().findById(companyaccount.getAccountid())
						.getDealpassword())) {
			request.setAttribute("info", "��ǰ�������벻��ȷ");
		} else if (!chPassword.equals(confirmPassword)) {
			request.setAttribute("info", "�������벻һ�£����������룡");

		} else if (!chPassword.matches("^[0-9]{6}$")) {
			request.setAttribute("info", "����������6������");
		} else {
			companyaccount = companyaccountService.getCompanyaccountDAO().findById(companyaccount.getAccountid());
			companyaccount.setDealpassword(Integer.parseInt((chPassword)));
			companyaccountService.getCompanyaccountDAO().merge(companyaccount);
			return "dealPasswordChangeSuccess";
		}
		return "dealpasswordChangeFailed";
	}

	
	/**
	 * ��ʾ�˺š�
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
		return "OK";
	}
	
	/**
	 * ��������ѡ�񿨡�
	 * @return
	 */
	public String selectAccountDPWD() {
		session.setAttribute("account", request.getParameter("selectAccount"));
		return "selectAccountDPWD";
	}
	
	/**
	 * ��ѯ����ѡ�񿨡�
	 * @return
	 */
	public String selectAccountSPWD() {
		session.setAttribute("account", request.getParameter("selectAccount"));
		return "selectAccountSPWD";
	}
	
	@Override
	public Companyaccount getModel() {
		if (companyaccount == null) {
			companyaccount = new Companyaccount();
		}
		return companyaccount;
	}
}
