<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
					<li><a href="#">密码设置</a></li>
					<li class="active">交易密码修改成功</li>
				</ul>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<p>信用卡:${sessionScope.creditcard}交易密码修改成功。</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>