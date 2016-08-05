<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>挂失成功</title>
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
				    <li><a href="#">密码设置</a></li>
				    <li class="active">交易密码修改成功</a></li>
					</ul>
				</div>
			</div>
			<div class="col-md-12 column">
				<p>储蓄卡:${sessionScope.account}交易密码更改成功。</p>
			</div>
		</div>
	</div>
</body>
</html>

