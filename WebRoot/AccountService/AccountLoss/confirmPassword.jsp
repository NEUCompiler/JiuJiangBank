<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>


<title>填写密码</title>

</head>

<body>
	<div class="container">
		<div class="row clearfix">

			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">储蓄卡挂失</a></li>
					<li><a href="<%=basePath%>AccountService/CreditcardLoss_showCreditCard.action">选择未挂失的储蓄卡</a></li>
					<li class="active">确认网银密码</li>
					<li><a href="#">挂失成功</a></li>
				</ul>
			</div>
		</div>
		<div class="row clearfix">
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>AccountService/AccountLossAction_confirmPassword.action" method="post">
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-3 control-label">请输入网银密码:
						</label>
						<div class="col-sm-3">
							<input class="form-control" id="accountPassword" type="password"
								name="accountPassword" />
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

