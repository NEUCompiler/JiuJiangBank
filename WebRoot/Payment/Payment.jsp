<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Payment.jsp' starting page</title>
    
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
    <h1>生活缴费</h1>
    <form action="paymentService.action" method="post">
    	<label for="serviceType">缴费业务：</label>
    	<br>
    	<select id="serviceType" name="dealinform.dealinform">
    		<option value="tv">广播电视费</option>
    		<option value="mobile">手机充值</option>
    		<option value="property">物业费</option>
    		<option value="charge">电费</option>
    		<option value="water">水费</option>
    	</select>
    	<br>
    	<label for="serviceNum">业务号码：</label>
    	<br>
    	<input type="text" id="serviceNum" name="dealinform.dealDesti" >
    	<br>
    	<label>缴费金额：</label>
    	<br>
    	<input type="text" id="serviceMoney" name="dealinform.deaamountl" >元
    	<br>
    	<label for="accountId">账户：</label>
    	<br>
    	<input type="text" id="accountId" name="dealinform.accountid">
    	<br>
    	<label for="DealPassord">支付密码：</label>
    	<br>
    	<input type="password" id="DealPassord" name="dealpassword">
    	<br>
    	<button type="submit">确认</button>
    	<button onclick="">取消</button>
    </form>
  </body>
</html>
