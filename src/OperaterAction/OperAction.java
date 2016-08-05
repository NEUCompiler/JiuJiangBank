package OperaterAction;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import Operater.db.Operater;
import Operater.serviceimpl.Operaterserviceimpl;

public class OperAction extends OperaterSuperAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Operaterserviceimpl OperS = new Operaterserviceimpl();

	public String showall() throws Exception {

		List<Operater> list = OperS.showall();

		if (list == null) {
			return "showall_failure";
		}
		if (list.size() > 0) {
			session.setAttribute("Oper_lsit", list);
			return "showall_success";
		} else {
			return "showall_failure";
		}

	}

	public String add() throws ParseException {
		String operaterSex = request.getParameter("operaterSex");
		String operaterName = request.getParameter("operaterName");
		String operaterType = request.getParameter("operaterType");
		String operaterPassW = request.getParameter("operaterPassW");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date operaterBirthday = sdf.parse(request.getParameter("birthday"));

		Operater O = new Operater(operaterName, operaterPassW, operaterType, operaterSex,operaterBirthday);
		O.setOperaterId(OperS.getnewID());
		if (OperS.add(O)) {
			return "add_success";
		} else {
			return "add_failure";
		}
	}

	public String delete() throws Exception {
		String OID = request.getParameter("stu.operaterId");
		Integer operaterName = Integer.valueOf(OID);
		System.out.println(operaterName);
		// Operater O = (Operater)(session).get(Operater.class,operaterName);
		if (OperS.delete(operaterName)) {
			List<Operater> list = OperS.showall();
			session.setAttribute("Oper_lsit", list);
			return "delete_success";
		} else {
			return "delete_failure";
		}
	}
	
	public String resetPW()
	{
		String OID = request.getParameter("operaterId");
		session.setAttribute("operaterId", OID);
		Integer operaterID = Integer.valueOf(OID);
		if(OperS.resetPW(operaterID))
		{
			return "OresetPW_success";
		}
		else
		{
			return "OresetPW_failure";
		}
	}
	
	public String select()
	{
		String OID = request.getParameter("operaterId");
		Integer operaterID = Integer.valueOf(OID);
		Operater O=OperS.findById(operaterID);
		List<Operater> list =new LinkedList<Operater>();
		list.add(O);
		if(O!=null)
		{
			session.setAttribute("Oper_lsit", list);
			return "Oselect_success";
		}
		else
		{
			return "Oselect_failure";
		}
	}
}
