<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡查询已出账单</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">

			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">信用卡已出账单查询</a></li>
					<li><a href="<%=basePath%>CreditCard/CreditCardBillHave_showCreditCard.action">选择信用卡</a></li>
					<li class="active">确认查询密码</li>
					<li><a href="#">查询成功</a></li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>CreditCard/CreditCardBillHave_confirmPassword.action">
					<div class="form-group">
						<label for="searchPassword" class="col-sm-2 control-label">请输入查询密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="searchPassword" type="password"
								name="searchPassword" />
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
