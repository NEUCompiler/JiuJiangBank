<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡已出账单查询</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">信用卡已出账单查询</a></li>
					<li><a href="#">选择信用卡</a></li>
					<li><a href="#">确认查询密码</a></li>
					<li class="active">查询成功</li>
				</ul>

				<table class="table table-striped table-bordered">
					<thead>
						<tr>
							<th>交易时间</th>
							<th>交易金额</th>
							<th>卡号后四位</th>
							<th>交易描述</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${request.dealInfoList}" var="dealInfo">
							<tr>
								<td>${dealInfo.dealtime.toString().substring(0,10)}</td>
								<td>${dealInfo.deaamountl}元</td>
								<td>****${dealInfo.accountid}</td>
								<td>${dealInfo.dealinform}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
