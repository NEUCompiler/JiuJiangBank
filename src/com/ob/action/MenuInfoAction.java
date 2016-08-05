package com.ob.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.metamodel.domain.Superclass;
import com.ob.service.ClientsubmitinfoService;
import com.ob.service.impl.ClientsubmitinfoServiceImpl;

public class MenuInfoAction extends SuperAction {
	private String jsonstr;

	public String getJsonstr() {
		return jsonstr;
	}

	public void setJsonstr(String jsonstr) {
		this.jsonstr = jsonstr;
	}

	public String selectMenuInfo() {

		ClientsubmitinfoService infoSelect = new ClientsubmitinfoServiceImpl();
		List list = infoSelect.selectMenuInfo(-1);
		try {
			String str = "{data:[ ";
			int temp = 0;
			if (null == list) {
				temp = 0;
			} else {
				temp = list.size();
			}
			for (int i = 0; i < temp; i++) {

				Object[] info = (Object[]) list.get(i);
				str += "{";
				int par = (Integer) info[0];
				str += "menuName:\"" + info[1] + "\",";
				str += "menuSrc:\"" + info[2] + "\",";
				str += "menuPar:\"" + info[3] + "\",";
				str += "},";

				List childList = infoSelect.selectMenuInfo(par);
				int temp1 = 0;
				if (null == childList) {
					temp1 = 0;
				} else {
					temp1 = childList.size();
				}
				for (int j = 0; j < temp1; j++) {
					Object[] info1 = (Object[]) childList.get(j);
					str += "{";
					str += "menuName:\"" + info1[1] + "\",";
					str += "menuSrc:\"" + info1[2] + "\",";
					str += "menuPar:\"" + info1[3] + "\",";
					str += "},";
				}
			}
			str = str.substring(0, str.length() - 1) + "]}";
			jsonstr = str;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
