<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'TransferQuery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  		<label>请输入您需要查询的账号</label>
  		<br>
  		<form action="browseTranfer.action">
  			<input type="text" name="dealinform.accountid">
  			<br>
  			<input type="submit" value="确认" onclick="">
  			<br>
  			<a href="index.jsp">返回主页</a>
  		</form>
  		<table>
    			<tr>
    				<th>转账时间</th>
    				<th>转账类型</th>
    				<th>网银账号</th>
    				<th>转账金额</th>
    				<th>转账类型</th>
    				<th>交易号</th>
    				<th>转账状态</th>
    			</tr>
    			<s:iterator value="#request.transferInfoList" var="transfer">
				<tr>
					<td><s:property value="#transfer.dealtime" /></td>
					<td><s:property value="#transfer.dealinform" /></td>
					<td><s:property value="#transfer.dealDesti" /></td>
					<td><s:property value="#transfer.deaamountl" /></td>
					<td><s:property value="#transfer.dealtype" /></td>
					<td><s:property value="#transfer.dealid" /></td>
					<td><s:property value="#transfer.dealstate" /></td>
				</tr>
				</s:iterator>
		</table>
  </body>
</html>
