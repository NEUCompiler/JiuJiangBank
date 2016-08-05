package com.ob.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;

public class DealInfoAction extends SuperAction {

	private String jsonstr;
	private String option;
	
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

	public String selectDealInfo(){

		ClientsubmitinfoService infoSelect = new ClientsubmitinfoServiceImpl();
		List list = infoSelect.selectDealInfo(option);
		try{
			String str="{data:[ ";
			int temp=0;
			if(null==list){
				temp=0;
			}else{
				temp=list.size();
			}
			for(int i=0;i<temp;i++){
				
				Object[] info = (Object[])list.get(i);
				str+="{";
				str+="accountid:\""+info[0]+"\",";
				
				java.sql.Date date=new java.sql.Date(((Date)info[1]).getTime());
				java.util.Date d=new java.util.Date (date.getTime());
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
				//Date currentTime = new Date();
				//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
				String dateString = time.format(d);
				str+="dealtime:\""+dateString+"\",";
				
				str+="dealinform:\""+info[2]+"\",";
				if(info[3].equals("0"))
					str+="dealtype:\""+"转出"+"\",";
				else
					str+="dealtype:\""+"转入"+"\",";
				str+="dealDesti:\""+info[4]+"\",";
				if(info[5].equals("1"))
					str+="dealstate:\""+"交易成功"+"\",";
				else
					str+="dealstate:\""+"交易失败"+"\",";
				str+="dealamount:\""+info[6]+"\",";
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
