package com.ob.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.LockOptions;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;

import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;

public class WebsiteAction extends SuperAction {
	
	private String jsonstr;
	
	public String getJsonstr() {
		return jsonstr;
	}

	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}

	public String selectInfo() throws IOException{
		Date dateb = new Date();
		
		ClientsubmitinfoService infoSelect = new ClientsubmitinfoServiceImpl();
		List list = infoSelect.selectWebsiteInfo();
		try{
			String str="{data:[";
			for(int i=0;i<list.size();i++){
				
				Object[] info = (Object[])list.get(i);
				str+="{";
				str+="websiteId:\""+info[0]+"\",";
				
				java.sql.Date date=new java.sql.Date(((Date)info[1]).getTime());
				java.util.Date d=new java.util.Date (date.getTime());
				SimpleDateFormat time=new SimpleDateFormat("yyyy-MM-dd"); 
				String dateString = time.format(d);
				str+="buildTime:\""+dateString+"\",";
				
				String addrString = "";
				int addr = (Integer) info[2];
				int firstFloor = addr/10000*10000;
				String tmp = firstFloor+"";
				addrString += infoSelect.selectAddrInfo(tmp);
				int secFloor = addr/100*100;
				tmp = secFloor+"";
				addrString += infoSelect.selectAddrInfo(tmp);
				tmp = addr+"";
				addrString += infoSelect.selectAddrInfo(tmp);
				str+="websiteAddr:\""+addrString+"\",";
				
				str+="websiteName:\""+info[3]+"\",";
				str+="},";
			}
			str=str.substring(0, str.length()-1)+"]}";
			jsonstr = str;
			//System.out.println(jsonstr);
		} catch(Exception e){
			e.printStackTrace();
		}
		
		Date date1 = new Date();
		Long d=date1.getTime()-dateb.getTime();
		System.out.println(d);
		return SUCCESS; 
	}
}
