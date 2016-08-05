<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡可用额度设置</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">信用卡可用额度设置</a></li>
					<li class="active">选择设置的信用卡</li>
					<li><a href="#">确认网银密码</a></li>
					<li><a href="#">可用额度设置成功</a></li>
				</ul>
				<form action="<%=basePath%>CreditCard/CreditcardLimitSet_selectCard.action" id="form">
					请选择你所要设置可用额度的信用卡: <select name="selectCd" class="form-control">
						<c:forEach items="${request.accountIdList}" var="li">
							<option>${li}</option>
						</c:forEach>
					</select> 请输入你要修改的金额：<input class="form-control" type="text" name="cdLimit" />
				</form>
				<a class="btn btn-default" href="<%=basePath%>/CreditCard/creditCardHome.jsp" role="button">上一步</a> <input
					type="button" class="btn btn-default" value="下一步"
					onclick="document.getElementById('form').submit();" />
			</div>
		</div>
	</div>
</body>