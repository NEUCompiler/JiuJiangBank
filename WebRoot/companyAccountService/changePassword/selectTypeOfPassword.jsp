<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>修改密码</title>

</head>
<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">选择修改密码的类型</a></li>
					<li class="active">选择信用卡</li>
					<li><a href="#">确认查询密码</a></li>
					<li><a href="#">查询成功</a></li>
				</ul>
				<form action="<%=basePath%>CompanyAccountService/CompanyAccountServiceChangePassword_selectTypeOfPassword.action" id="form">
					请选择你要修改的密码: <select name="selectPassword" class="form-control">
							<option value="loginPassword">网银登录密码</option>
							<option value="searchPassword">查询密码</option>
							<option value="dealPassword">交易密码</option>
							<option value="addDealpassword">上挂账户交易密码</option>
					</select>
				</form>
				<a class="btn btn-default" href="<%=basePath%>companyAccountService/index.jsp" role="button">上一步</a> <input
					type="button" class="btn btn-default" value="下一步"
					onclick="document.getElementById('form').submit();" />
			</div>
		</div>
	</div>
</body>
</html>
