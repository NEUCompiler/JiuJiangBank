<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'M_ChangePassword.jsp' starting page</title>
    
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
							action="<%=path%>/ManagerAction/Manager_ChangePassWord.action"
							method="post">
  <div id="user-password">
								<span class="item">原&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:</span> <span
									class="input"><input type="password" name="managerPassW"
									class="form-input"></span>
							</div>
							  <div id="user-Newpassword">
								<span class="item">新&nbsp;&nbsp;&nbsp;&nbsp;密&nbsp;&nbsp;&nbsp;码:</span> <span
									class="input"><input type="password" name="managerNPassW"
									class="form-input"></span>
							</div>
														  <div id="user-Newpassword">
								<span class="item">确认新密码:</span> <span
									class="input"><input type="password" name="managerQNPassW"
									class="form-input"></span>
							</div>
							<div id="button-group">
								<input type="submit" class="btn" value="确认" />
							</div>
							</form>
     <br>
  </body>
</html>
