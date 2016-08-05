<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loanupdaterequest_success.jsp' starting page</title>
    
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
    <form name="loginForm"
							action="<%=path%>/SystemParrateAction/sysParrate_bigdealupdateRP.action"
							method="post">
  <div id="aheadtime">
								<span class="item">新&nbsp;&nbsp;&nbsp;&nbsp;时&nbsp;&nbsp;&nbsp;间:</span> <span
									class="input"><input type="text" name="aheadtime"
									class="form-input"></span>
							</div>
							 <div id="amount">
								<span class="item">新&nbsp;&nbsp;&nbsp;&nbsp;金&nbsp;&nbsp;&nbsp;额:</span> <span
									class="input"><input type="text" name="amount"
									class="form-input"></span>
							</div>
							<div id="button-group">
								<input type="submit" class="btn" value="确认" /> 
							</div>
  </body>
</html>
