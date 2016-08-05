<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'showAccountInform.jsp' starting page</title>

<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.4.5/themes/default/easyui.css">
<link rel="stylesheet" type="text/css"
	href="<%=basePath%>jquery-easyui-1.4.5/themes/icon.css">
<script type="text/javascript" src="<%=basePath%>jquery-easyui-1.4.5/jquery.min.js"></script>
<script type="text/javascript"
	src="<%=basePath%>jquery-easyui-1.4.5/jquery.easyui.min.js"></script>
<script>
	function getdate() {
		var d = $('#ddd').datebox('getValue');
		var e = $('#ddb').datebox('getValue');
		alert(d);
		alert(e);
		//ation="AccountInformationAction_searchDealInform.action"
	}
</script>


</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 主页  -->
			</div>
		</div>
		<div class="col-md-15 column">
			<ul class="breadcrumb">
				<li><a href="#">账户明细查询</a></li>
				<li><a href="#">选择账户</a></li>
				<li class="active">选择时间</li>
				<li><a href="#">显示账户明细</a></li>
			</ul>
			<table class="table">

				<tr>

					<th>类型</th>
					<th>卡号</th>
					<th>余额</th>
					<th>额度</th>
					<th>是否开通网银</th>
					<th>别名</th>
				<tr />
				<tr>

					<td>${request.cardType}</td>
					<td>${sessionScope.account.accountid}</td>
					<td>${sessionScope.account.amount}</td>
					<td>${sessionScope.account.cdlimit}</td>
					<td>${request.obType}</td>
					<td>${sessionScope.account.othername}</td>
				<tr />
			</table>
			<form action="<%=basePath%>AccountService/AccountInformationAction_searchDealInform.action">
				<div style="margin:20px 0;"></div>
				开始日期<input id="ddda" name="ddda" class="easyui-datebox"></input>
				------结束日期<input id="dddb" name="dddb" class="easyui-datebox"></input>
				<input type="submit" value="查询"></input>
			</form>
		</div>
</div>
</body>
</html>
