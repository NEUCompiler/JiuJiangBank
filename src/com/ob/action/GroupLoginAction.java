package com.ob.action;

import java.util.List;

import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class GroupLoginAction extends SuperAction {
	
	private String username;
	private String password;
	private String jsonstr;
	
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String groupLogin(){

		ClientsubmitinfoService group = new ClientsubmitinfoServiceImpl();
		List list = group.selectGroupMemberInfo(username, password);
		String str="";
		if(list.isEmpty()){
			str="\"不存在的用户名或密码不正确！\"";
		}
		else{
			str="\"登录成功！\"";
			ActionContext.getContext().getSession().put("username", getUsername());
			ActionContext.getContext().getSession().put("password", getPassword());
			ActionContext.getContext().getSession().put("type", 1);
		}
		jsonstr=str;
		return SUCCESS;
	}
}
