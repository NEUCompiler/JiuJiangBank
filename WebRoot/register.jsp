<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>中国建设银行 个人网上银行</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
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
			}
		</style>
	
  </head>
  
  
  
  <body>
	<div id="div1">
		<form action="<%=path%>/register" method="get">		
		银行卡号<br>   
		<input name="accountid" type="text"> <br><br>
		身份证号<br>
		<input name="identity" type="text"> <br><br>		
		<input type="submit" value="提交" style="width: 80px;
			background:deepskyblue;"> <br>
		</form>
		${request.info}
	</div>
  </body>
</html>
