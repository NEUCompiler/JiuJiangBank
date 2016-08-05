<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>上挂账户信息查询</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">

			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">上挂账户信息查询</a></li>
					<li><a href="#">选择账号</a></li>
					<li><a href="#">确认查询密码</a></li>
					<li class="active">上挂账户信息查询成功</li>
				</ul>
				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>账号后四位</th>
							<th>当前余额</th>
							<th>可用余额</th>
							<th>存期</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${request.accounts}" var="accountInfo">
							<tr>
								<td>****${accountInfo.accountid}</td>
								<td>${accountInfo.amount}元</td>
								<td>${accountInfo.alimit}元</td>
								<td>${accountInfo.term}年</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>