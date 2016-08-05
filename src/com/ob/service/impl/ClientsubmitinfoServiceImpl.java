package com.ob.service.impl;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import com.ob.dao.impl.ClientsubmitinfoDAOImpl;
import com.ob.model.Clientsubmitinfo;
import com.ob.service.ClientsubmitinfoService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ClientsubmitinfoServiceImpl extends ActionSupport implements ClientsubmitinfoService {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public int getClientId() throws Exception{
		String username = ActionContext.getContext().getSession().get("username")+"";
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		int clientId = dao.getClientId(username);
		//int clientId = Integer.valueOf(ActionContext.getContext().getSession().get("username")+"");
		//ActionContext.getContext().getSession().put("user", getUsername());
		return clientId;
	}
	
	public void submitClientInfo(String str, int infoType, String submitTime, String info, int clientId){
		Clientsubmitinfo submitinfo = new Clientsubmitinfo();
		submitinfo.setInfoId(str);
		submitinfo.setClientId(clientId);
		submitinfo.setSubmitTime(submitTime);
		submitinfo.setInfoContent(info);
		submitinfo.setInfoType(infoType);
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		dao.sqlsave(submitinfo);
	}
	
	public List selectClientInfo(int infoType){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		//System.out.println("infoType:"+infoType);
		List list = null;
		try {
			list = dao.sqlselect(infoType);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public List selectWebsiteInfo(){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectWebsite();
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public String selectAddrInfo(String id) throws Exception{
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		return dao.selectAddr(id);
	}
	
	public List selectDealInfo(String option){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectDealInfo(option);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List selectMenuInfo(int parent){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectMenuInfo(parent);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List selectGroupMemberInfo(String username, String password){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectGroupUser(username, password);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List groupSelect(int type){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectGroup(type);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List groupSelect(String option){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectGroup(option);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public List groupMemberSelect(String member){
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		List list = null;
		try{
			list = dao.sqlSelectGroupMember(member);
		} catch (Exception e){
			e.printStackTrace();
		}
		return list;
	}
	
	public void updateGroupMemberInfo(String groupName, String rate, String money) throws Exception{
		ClientsubmitinfoDAOImpl dao = new ClientsubmitinfoDAOImpl();
		dao.sqlUpdateGroupMemberInfo(groupName, rate, money);
	}
}
