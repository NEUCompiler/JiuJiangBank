<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'showAllAccount.jsp' starting page</title>

</head>

<body>
	<table class="table">
		<thead>
			<tr>
				<th>类型</th>
				<th>账号</th>
				<th>余额</th>
				<th>额度</th>
				<th>别名</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${request.accountLista}" var="lia">
            <tr>
			<td>${request.cardTypea}</td>
			<td>${lia.accountid}</td>
			<td>${lia.amount}</td>
			<td>${lia.cdlimit}</td>
			<td>${lia.othername}</td>
	       </tr>
	       </c:forEach>
	       <c:forEach items="${request.accountListb}" var="lib">
            <tr>
			<td>${request.cardTypeb}</td>
			<td>${lib.accountid}</td>
			<td>${lib.amount}</td>
			<td>${lib.cdlimit}</td>
			<td>${lib.othername}</td>
	       </tr>
	       </c:forEach>
		</tbody>
	</table>
</body>
</html>
