<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中国建设银行 个人网上银行</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

		<style>
			#div1{
				text-align: center;
				margin-top: 100px;
				border-color: blue;
			}
			input{
				width: 200px;
				height: 30px;
				border:blue solid 2px;
				position:relative;
			}
		</style>
		
  </head>
  
  <body>
  		<div id="div1">
	     	<h1>注册成功，请登陆</h1>
	     	<form action="<%=path%>/login">
	     	用户名<br>
			<input name="username" type="text"> <br><br>	
			密码<br><br>
			<input name="userpassword" type="password">	<br><br>
			<input type="submit" value="登陆"  style="width: 80px;background:deepskyblue;"> 
			
		    <input name="registe" type="button" style="width: 80px;
			background:deepskyblue;" value="注册" onclick="window.location='begin.jsp'"/>
	     	</form>
	     	${request.info}
	     	
     	</div>
  </body>
</html>
