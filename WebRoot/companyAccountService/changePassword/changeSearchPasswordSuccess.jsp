<!-- 信用卡挂失 -->
			<result>/CreditCard/cdloss/cdloss.jsp</result>
			<result name="showCreditCardLoss">/CreditCard/cdloss/showCreditCard.jsp</result>
			<result name="selectOkLoss">/CreditCard/cdloss/confirmPassword.jsp</result>
			<result name="confirmFailedLoss">/CreditCard/cdloss/confirmPassword.jsp</result>
			<result name="confirmSuccessLoss">/CreditCard/cdloss/lossSuccess.jsp</result><%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>查询密码修改</title>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<ul class="breadcrumb">
					<li><a href="#">查询密码修改</a></li>
					<li><a href="#">选择要修改的密码</a></li>
					<li><a href="#">密码修改</a></li>
					<li class="active">查询密码修改成功</li>
				</ul>
				<div class="row clearfix">
					<div class="col-md-12 column">
						<p>查询密码修改成功。</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>