package com.ob.action;

import java.util.List;

import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class GroupManageAction extends SuperAction {
	private String jsonstr;
	private String groupName;
	private String rate;
	private String money;

	public String getJsonstr() {
		return jsonstr;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getRate() {
		return rate;
	}

	public void setRate(String rate) {
		this.rate = rate;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	
	public String groupMemberBack(){
		jsonstr="";
		String username = ActionContext.getContext().getSession().get("username")+"";
		String password = ActionContext.getContext().getSession().get("password")+"";
		ClientsubmitinfoService select = new ClientsubmitinfoServiceImpl();
		List list = select.selectGroupMemberInfo(username, password);
		try{
			String str="{data:[ ";
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i).getClass().getTypeName());
				Object[] info = (Object[])list.get(i);
				str+="{";
				str+="groupName:\""+info[0]+"\",";
				str+="rate:\""+info[1]+"\",";
				str+="money:\""+info[2]+"\",";
				str+="},";	
			}
			str=str.substring(0, str.length()-1)+"]}";
			jsonstr= str;
			//System.out.println(jsonstr);
		} catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS; 
	}
	
	public String groupMemberCorrect() throws Exception{
		jsonstr="";
		ClientsubmitinfoService select = new ClientsubmitinfoServiceImpl();
		select.updateGroupMemberInfo(groupName, rate, money);
		try{
			String str="\"ÐÞ¸Ä³É¹¦£¡\"";
			jsonstr= str;
		} catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS; 
	}
}
