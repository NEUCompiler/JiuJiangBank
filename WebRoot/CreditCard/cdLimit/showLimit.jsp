<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡可用额度查询</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">信用卡可用额度查询</a></li>
					<li><a href="#">选择查询的信用卡</a></li>
					<li><a href="#">确认查询密码</a></li>
					<li class="active">可用额度查询成功</li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
			<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>信用卡</th>
							<th>可用额度</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td>${sessionScope.creditcard}</td>
							<td>${request.cdLimit}</td>
						</tr>
				</table>
			</div>
		</div>
	</div>
</body>
</html>