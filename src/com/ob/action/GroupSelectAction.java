package com.ob.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;

public class GroupSelectAction extends SuperAction {
	private String jsonstr;
	private String option;
	private String member;

	public String getOption() {
		return option;
	}

	public String getMember() {
		return member;
	}

	public void setMember(String member) {
		this.member = member;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getJsonstr() {
		return jsonstr;
	}

	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}
	public String groupParSelect(){
		jsonstr="";
		ClientsubmitinfoService groupSelect = new ClientsubmitinfoServiceImpl();
		List list = groupSelect.groupSelect(0);
		try{
			String str="{data:[ ";
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i).getClass().getTypeName());
				String info = (String)list.get(i);
				str+="{";
				str+="groupName:\""+info+"\"},";
				
			}
			str=str.substring(0, str.length()-1)+"]}";
			jsonstr= str;
			//System.out.println(jsonstr);
		} catch(Exception e){
			e.printStackTrace();
		}
		return SUCCESS; 
	}
	
	public String groupMemberSelect(){
		jsonstr="";
		ClientsubmitinfoService groupMemberSelect = new ClientsubmitinfoServiceImpl();
		List list = groupMemberSelect.groupMemberSelect(member);
		try{
			String str="{data:[ ";
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i).getClass().getTypeName());
				Object[] info = (Object[])list.get(i);
				str+="{";
				str+="groupName:\""+info[0]+"\",";
				str+="groupUsername:\""+info[1]+"\",";
				str+="money:\""+info[2]+"\",";
				str+="rate:\""+info[3]+"\",";
				float tmp1=(Float) info[2];
				float tmp2=(Float) info[3];
				float tmp=tmp1*tmp2;
				str+="interest:\""+tmp+"\",";
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
	
	public String groupChiSelect(){
		jsonstr="";
		ClientsubmitinfoService groupSelect = new ClientsubmitinfoServiceImpl();
		List list = groupSelect.groupSelect(option);
		try{
			String str="{data:[ ";
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i).getClass().getTypeName());
				Object[] info = (Object[])list.get(i);
				str+="{";
				str+="groupName:\""+info[0]+"\",";
				str+="groupUsername:\""+info[1]+"\",";
				str+="rate:\""+info[2]+"\",";
				str+="money:\""+info[3]+"\",";
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
}
