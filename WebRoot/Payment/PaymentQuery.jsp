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
    
    <title>My JSP 'PaymentQuery.jsp' starting page</title>
    
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
  		<form action="browseDealinform.action">
  			<input type="text" name="dealinform.accountid">
  			<br>
  			<input type="submit" value="确认" onclick="">
  			<br>
  			<a href="index.jsp">返回主页</a>
  		</form>
    	<table>
    			<tr>
    				<th>缴费时间</th>
    				<th>缴费信息</th>
    				<th>缴费号码</th>
    				<th>缴费金额</th>
    				<th>缴费类型</th>
    				<th>交易号</th>
    				<th>缴费状态</th>
    			</tr>
    			<s:iterator value="#request.dealinformInfo" var="pay">
				<tr>
					<td><s:property value="#pay.dealtime" /></td>
					<td><s:property value="#pay.dealinform" /></td>
					<td><s:property value="#pay.dealDesti" /></td>
					<td><s:property value="#pay.deaamountl" /></td>
					<td><s:property value="#pay.dealtype" /></td>
					<td><s:property value="#pay.dealid" /></td>
					<td><s:property value="#pay.dealstate" /></td>
				</tr>
				</s:iterator>
		</table>
	

  </body>
</html>
