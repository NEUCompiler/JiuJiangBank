<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>信用卡挂失</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">信用卡挂失</a></li>
					<li class="active">选择未挂失的信用卡</li>
					<li><a href="#">确认网银密码</a></li>
					<li><a href="#">挂失成功</a></li>
				</ul>
				<form action="<%=basePath%>CreditCard/CreditcardLoss_selectCard.action" id="form">
					请选择你需要挂失的信用卡: <select name="selectCd" class="form-control"
						class="form-control">
						<c:forEach items="${request.accountIdList}" var="li">
							<option>${li}</option>
						</c:forEach>
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
