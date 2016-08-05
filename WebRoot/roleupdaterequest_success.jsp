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
							action="<%=path%>/SystemParrateAction/sysParrate_roleupdateRP.action"
							method="post">
  <div id="aheadtime">
								<span class="item">新&nbsp;&nbsp;&nbsp;&nbsp;权&nbsp;&nbsp;&nbsp;限:</span> <span
									class="input"><input type="text" name="auId"
									class="form-input"></span>
							</div>

							<div id="button-group">
								<input type="submit" class="btn" value="确认" /> 
							</div>
  </body>
</html>
