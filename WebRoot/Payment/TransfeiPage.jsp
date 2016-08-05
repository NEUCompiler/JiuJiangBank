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
    
    <title>My JSP 'TransfeiPage.jsp' starting page</title>
    
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
    <h4>行内转账</h4>
    <table>
    		<tr>
    			<th>以下是您的账号</th>
    		</tr>
    		<s:iterator value="#request.accountInfo" var="acc">
			<tr>
				<td><s:property value="#acc.accountid" /></td>
			</tr>
			</s:iterator>
	</table>
    <form action="transferService.action">
    	<label>请输入转账账号</label>
    	<br>
    	<input type="text" name="dealinform.accountid">
    	<br>
    	<label>请填写收款人账号</label>
    	<br>
    	<input type="text" name="dealinform.dealDesti">
    	<br>
    	<label>汇款金额</label>
    	<br>
    	<input type="text" name="dealinform.deaamountl">
    	<br>
    	<label>请输入支付密码</label>
    	<br>
    	<input type="password" name="dealpassword">
    	<br>
    	<input type="submit" value="确认支付">
    	<a href="Transfer.jsp">返回上一页</a>
    	<br>
    </form>
  </body>
</html>
