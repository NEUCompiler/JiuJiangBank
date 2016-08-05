package systemPar.service;

import java.util.List;

import System.Par.bigdeal.Bigdeal;
import System.Par.bigdeal.BigdealDAO;
import System.Par.rate.Deposit;
import System.Par.rate.DepositDAO;
import System.Par.rate.Loan;
import System.Par.rate.LoanDAO;
import System.Par.rate.MAuDAO;
import System.Par.rate.MRole;
import System.Par.rate.MRoleDAO;

public class SystemParService {
	
	LoanDAO landao = new LoanDAO();
	
	DepositDAO depositdao =new DepositDAO();
	
	BigdealDAO bigdealdao = new BigdealDAO();
	
	MRoleDAO  mroledao = new MRoleDAO();
	
	MAuDAO maudao =new MAuDAO();
	
	public List loanshow()
	{
		List loanlist = landao.findAll();
		return loanlist;
		
	}
	
	public List depositshow()
	{

		List depositlist = depositdao.findAll();
		return depositlist;
		
	}
	
	public List bigdealshow()
	{
		List bigdealist = bigdealdao.findAll();
		return bigdealist;
	}
	
	public List roleshow() {
		List rolelist = mroledao.findAll();
		return rolelist;
	}

	public boolean update(String loanid,float rate) {
		// TODO Auto-generated method stub
		Loan L=landao.findById(loanid);
		L.setRate(rate);
		landao.update(L);
//		L.setTime(time);
//		L.setType(type);
		return true;
	}

	public List authshow() {
		List authlist = maudao.findAll();
		return authlist;
	}

	public boolean bigdealupdate(Integer bigdealid, Integer amount, Integer time) {
		
		Bigdeal B=bigdealdao.findById(bigdealid);
		B.setAheadtime(time);
		B.setAmount(amount);
		bigdealdao.update(B);
		
		return true;
		
	}



	public boolean depositupdate(Integer depositid, float rate, float interest,
			Integer time) {
		Deposit D=depositdao.findById(depositid);
		D.setInterest(interest);
		D.setRate(rate);
		D.setTime(time);
		depositdao.udate(D);
		
		return true;

	}

	public boolean roleupdate(Integer roleid, String auid) {
		MRole m=mroledao.findById(roleid);
		m.setAuId(auid);
		mroledao.update(m);
		return true;
	}






}
