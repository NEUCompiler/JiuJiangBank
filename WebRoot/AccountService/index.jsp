<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
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
	<a
		href="<%=basePath%>AccountService/AccountLossAction_showAccount.action">账户口头挂失</a>
	</br>
	<a
		href="<%=basePath%>AccountService/AccountDealPasswordSetAction_showAccount.action">密码修改</a>
	<br>
	<a
		href="<%=basePath%>AccountService/AccountInformationAction_showAccount.action">账户明细查询</a>
	</br>
	<a
		href="<%=basePath%>AccountService/AccountInformationAction_showAccountIsOpen.action">网上交易查询</a>
	</br>
	<a
		href="<%=basePath%>AccountService/AccountSignAction_showAccount.action">关联账户管理</a>
	<br>
	<a
		href="<%=basePath%>AccountService/AccountInformationAction_showAllAccount.action">账户信息查询</a>
	<br>

	<a href="<%=basePath%>AccountService/addAccount/addAccount.jsp">上挂账户</a>
	<br>
	<a
		href="<%=basePath%>AccountService/deleteAccount/deleteAccount.jsp">删除上挂账户</a>
	<br>
</body>
</html>
