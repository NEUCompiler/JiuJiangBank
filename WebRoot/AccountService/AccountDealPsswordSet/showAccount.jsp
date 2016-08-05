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
				<li><a href="#">交易密码修改</a></li>
				<li class="active">选择储蓄卡</li>
				<li><a href="#">密码设置</a></li>
				<li><a href="#">交易密码修改成功</a></li>
			</ul>
			<form action="<%=basePath%>AccountService/AccountDealPasswordSetAction_selectCard.action"
				id="form">
				<select name="selectAccount" class="form-control">
					<c:forEach items="${request.accountIdList}" var="li">
						<option value=${li}>${li}</option>
					</c:forEach>
				</select>
			</form>
			<a class="btn btn-default" href="index.jsp" role="button">上一步</a>
			&nbsp; &nbsp; <input type="button" class="btn btn-default"
				value="下一步" onclick="document.getElementById('form').submit();" /></br>
		</div>
	</div>
</body>
</html>
