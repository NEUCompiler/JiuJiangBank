<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>CompanyAccountService/CompanyAccountServiceShowAccountInfo_confirmPassword.action">
					<div class="form-group">
						<label for="searchpassword" class="col-sm-2 control-label">请输入查询密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="searchpassword" type="password"
								name="searchpassword" />
						</div>
					</div>
					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<button type="submit" class="btn btn-default">确认</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
