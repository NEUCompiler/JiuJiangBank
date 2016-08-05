addDealpassword<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>上挂账户</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">账号录入</a></li>
					<li><a href="#">上挂账户成功</a></li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>CompanyAccountService/CompanyAccountServiceAdd_addAccount.action">
					<div class="form-group">
						<label for="accountid" class="col-sm-2 control-label">请输入你上挂的账户:</label>
						<div class="col-sm-10">
							<input class="form-control" id="accountid" type="text"
								name="accountid" />
						</div>
					</div>
					<div class="form-group">
						<label for="dealpassword" class="col-sm-2 control-label">请输入交易密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="dealpassword" type="password"
								name="dealpassword" />
						</div>
					</div>
					<div class="col-md-12 column">${request.info}</div>
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
