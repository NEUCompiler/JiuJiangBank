package com.ob.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.ob.model.Clientsubmitinfo;
import com.ob.model.ClientsubmitinfoDate;
import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;
import com.opensymphony.xwork2.ActionContext;

public class SubmitInfoAction extends SuperAction {
	private String infoContent;
	private String option;
	private String jsonstr;
	public String getJsonstr() {
		return jsonstr;
	}
	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	public String getInfoContent() {
		return infoContent;
	}
	public void setInfoContent(String infoContent) {
		this.infoContent = infoContent;
	}
	
	public String addInfo() throws Exception {
		int infoType;
		if(option.equals("suggestion"))
			infoType = 1;
		else if(option.equals("complaint"))
			infoType = 0;
		else
			return "FAIL";
		Date d = new Date();
		// 给定模式
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/YYYY");
		// public final String format(Date date)
		String submitTime = sdf.format(d);
		String str = UUID.randomUUID().toString();
		//java.util.Date utilDate=new Date();
		//java.sql.Date submitTime=new java.sql.Date(utilDate.getTime());
		//Timestamp time = new Timestamp(new Date().getTime());
		ClientsubmitinfoService infoSubmit = new ClientsubmitinfoServiceImpl();
		int clientId = infoSubmit.getClientId();
		//int clientId = 1;
		infoSubmit.submitClientInfo(str, infoType, submitTime, infoContent, clientId);
		return "SUCCESS";
	}
	
	public String selectInfo() throws IOException{
		int infoType = 0;
		if(option.equals("suggestion"))
			infoType = 1;
		else if(option.equals("complaint"))
			infoType = 0;
		ClientsubmitinfoService infoSelect = new ClientsubmitinfoServiceImpl();
		List list = infoSelect.selectClientInfo(infoType);
		try{
			String str="{data:[";
			for(int i=0;i<list.size();i++){
				
				Object[] info = (Object[])list.get(i);
				str+="{";
				str+="clientId:\""+info[0]+"\",";
				str+="infoContent:\""+info[1]+"\",";
				
				java.sql.Date date=new java.sql.Date(((Date)info[2]).getTime());
				java.util.Date d=new java.util.Date (date.getTime());
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
				//Date currentTime = new Date();
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = time.format(d);
				
				str+="submitTime:\""+dateString+"\"";
				str+="},";
			}
			str=str.substring(0, str.length()-1)+"]}";
			jsonstr= str;
			System.out.println(jsonstr);
		} catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS; 
	}
}
