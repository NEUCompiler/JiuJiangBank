<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Operater_select.jsp' starting page</title>
    
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
		action="<%=path%>/OperaterAction/Oper_select.action" method="post">
		<div id="operaterId">
			<span class="item">操&nbsp;&nbsp;&nbsp;&nbsp;作&nbsp;&nbsp;&nbsp;员&nbsp;&nbsp;&nbsp;号:</span>
			<span class="input"><input type="text" name="operaterId"
				class="form-input"></span>
		</div>
		<div id="button-group">
			<input type="submit" class="btn" value="确认" />
		
		</div>
	
				
	</form>
	<br>
  </body>
</html>
