<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
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
					<li><a href="#">选择信用卡</a></li>
					<li class="active">密码设置</li>
					<li><a href="#">交易密码修改成功</a></li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>CreditCard/CreditcardDealPasswordSet_confirmPassword.action">
					<div class="form-group">
						<label for="dealpassword" class="col-sm-2 control-label">请输入交易密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="dealpassword" type="password"
								name="dealpassword" />
						</div>
					</div>
					<div class="row clearfix">
						<div class="col-md-12 column">${request.info}</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default">确认</button>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
