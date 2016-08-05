<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>填写更改信息</title>

</head>

<body>
    	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<!-- 主页  -->
			</div>
		</div>
		<div class="row clearfix">
			<div class="row clearfix">
				<div class="col-md-12 column">
					<ul class="breadcrumb">
						<li><a href="#">交易密码修改</a></li>
						<li><a href="#">选择储蓄卡</a></li>
						<li class="active">密码设置</li>
						<li><a href="#">交易密码修改成功</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-12 column">
				<form class="form-horizontal" role="form"
					action="<%=basePath%>AccountService/AccountDealPasswordSetAction_setPassword.action" method="post">
					<div class="form-group">
						<label for="searchpassword" class="col-sm-2 control-label">输入旧密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="searchpassword" type="password"
								name="dealpassword" />
						</div>
					</div>
					<div class="form-group">
						<label for="chPassword" class="col-sm-2 control-label">输入新密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="chPassword" type="password"
								name="chPassword" />
						</div>
					</div>
					<div class="form-group">
						<label for="confirmPassword" class="col-sm-2 control-label">请确认密码:</label>
						<div class="col-sm-10">
							<input class="form-control" id="confirmPassword" type="password"
								name="confirmPassword" />
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
