<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>信用卡激活</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">信用卡激活</a></li>
					<li><a
						href="<%=basePath%>CreditCard/CreditcardActive_showCreditCard.action">选择未激活的信用卡</a></li>
					<li class="active">设置交易密码</li>
					<li><a href="#">设置查询密码</a></li>
					<li><a href="#">激活成功</a></li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action=CreditcardActive_setDealPassword.action>
					<div class="form-group">
						<label for="dealPassword" class="col-sm-2 control-label">请设置交易密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="dealPassword" type="password"
								name="dealPassword" />
						</div>
						<label for="confirmPassword" class="col-sm-2 control-label">请确认交易密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="confirmPassword" type="password"
								name="confirmPassword" />
						</div>
						<div class="col-md-12 column">${request.info}</div>
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
