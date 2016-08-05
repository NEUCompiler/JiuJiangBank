<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>用户提交建议或投诉</title>
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
  	
  	<div class="loginBox">
  		
  	</div>
  	
  	<!-- 用户提交建议或投诉表单 -->
  	<form action="<%=path%>/111/addInfo" method="post">
		<select name="option">
			<option value="suggestion">建议</option>
			<option value="complaint">投诉</option>
		</select><br/>
		<label for="exampleInputEmail1">Content</label><br/> 
  		<input type="text" class="form-control" name="infoContent"><br/> 
  		<input type="submit" value="提交"> <br>
  	</form>
  	<br/><a href="index.jsp">返回主页</a><br/>
  </body>
</html>

