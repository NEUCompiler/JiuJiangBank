package com.ob.service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;


public interface ClientsubmitinfoService {
	public int getClientId() throws Exception;
	public void submitClientInfo(String str, int infoType, String submitTime, String info, int clientId);
	public List selectClientInfo(int infoType);
	public List selectWebsiteInfo();
	public String selectAddrInfo(String id) throws Exception;
	public List selectDealInfo(String option);
	public List selectMenuInfo(int parent);
	public List selectGroupMemberInfo(String username, String password);
	public List groupSelect(int type);
	public List groupSelect(String option);
	public List groupMemberSelect(String member);
	public void updateGroupMemberInfo(String groupName, String rate, String money)  throws Exception;
}
