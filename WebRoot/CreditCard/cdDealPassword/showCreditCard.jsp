<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡交易密码修改</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">交易密码修改</a></li>
					<li class="active">选择信用卡</li>
					<li><a href="#">密码设置</a></li>
					<li><a href="#">交易密码修改成功</a></li>
				</ul>
				<form action="<%=basePath%>CreditCard/CreditcardDealPasswordSet_selectCard.action" id="form">
					请选择信用卡: <select name="selectCd" class="form-control">
						<c:forEach items="${request.accountIdList}" var="li">
							<option>${li}</option>
						</c:forEach>
					</select> 请选择操作: <select name="dealPWDOperation" class="form-control">
						<option value="changeDPWD">交易密码修改</option>
						<option value="cancelDPWD">取消交易密码</option>
					</select>
				</form>
				<a class="btn btn-default" href="<%=basePath%>/CreditCard/creditCardHome.jsp" role="button">上一步</a> <input
					type="button" class="btn btn-default" value="下一步"
					onclick="document.getElementById('form').submit();" />
			</div>
		</div>
	</div>
</body>
</html>
