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
				<form action="<%=basePath%>CompanyAccountService/CompanyAccountServiceShowAccountInfo_selectAccount.action" id="form">
					请选择你需要查询的上挂账户: <select name="selectAccount" class="form-control"
						class="form-control">
						<c:forEach items="${request.accountIdList}" var="li">
							<option>${li}</option>
						</c:forEach>
					</select>
				</form>
				<a class="btn btn-default" href="<%=basePath%>/companyAccountService/index.jsp" role="button">上一步</a> <input
					type="button" class="btn btn-default" value="下一步"
					onclick="document.getElementById('form').submit();" />
			</div>
		</div>
	</div>
</body>
</html>
