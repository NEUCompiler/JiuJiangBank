<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resource/css/login.css">
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
  </head>
  
  <body>
  	
  	<!-- 登录表单 -->
  	<form action="<%=path%>/111/login" method="post"> 
  		<div class="form-group"> 
  			<label for="exampleInputEmail1">用户名</label> 
  			<input type="text" class="form-control" name="username"> 
  		</div> 
  		<div class="form-group"> 
  			<label for="exampleInputPassword1">密码</label> 
  			<input type="password" class="form-control" name="password"/> 
  		</div> 
  		<div class="checkbox"> 
  			<label> <input type="checkbox">记住密码</label> 
  		</div> 
  		<div>
  			
  		</div>
  		<button type="submit" class="btn btn-default">登录</button> 
  		<button class="btn btn-default">注册</button>
  	</form>	
  	<br/><a href="index.jsp">返回主页</a><br/>
  </body>
</html>

