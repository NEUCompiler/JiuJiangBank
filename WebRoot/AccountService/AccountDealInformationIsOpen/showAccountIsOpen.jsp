<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'showCreditCard.jsp' starting page</title>

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
				<li><a href="#">网上查询</a></li>
				<li class="active">选择账户</li>
				<li><a href="#">选择时间</a></li>
				<li><a href="#">显示网上交易明细</a></li>
			</ul>
			<form action="<%=basePath%>AccountService/AccountInformationAction_selectCard.action">

				<select name="selectAccount">
					<c:forEach items="${request.accountIdList}" var="li">

						<option value=${li}>${li}</option>

					</c:forEach>
				</select>
				<button>下一步</button>
			</form>
			<button onclick="location.href('index.jsp')">上一步</button>
		</div>
	</div>
</body>
</html>