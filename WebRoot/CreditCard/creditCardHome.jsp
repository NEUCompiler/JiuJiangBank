<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="/resource/jquery/jquery.min.js"></script>
<link href="/resource/css/bootstrap.min.css" rel="stylesheet">
<script src="/resource/js/bootstrap.min.js"></script>
<script src="/resource/ie10-viewport-bug-workaround.js"></script>
</head>

<body>

	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="btn-group">
					<button class="btn btn-default">信用卡</button>
					<button data-toggle="dropdown"
						class="btn btn-default dropdown-toggle">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a href="<%=basePath%>CreditCard/CreditcardLoss_showCreditCard.action">信用卡挂失</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditcardActive_showCreditCard.action">信用卡激活</a>
						</li>
						<li><a
							href="<%=basePath%>CreditCard/CreditcardSearchPasswordSet_showCreditCard.action">信用卡查询密码设置</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditcardDealPasswordSet_showCreditCard.action">信用卡交易密码设置</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditcardLimitSet_showCreditCard.action">信用卡额度设置</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditcardLimitSearch_showCreditCard.action">信用额度查询</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditCardBillHave_showCreditCard.action">已出账单查询</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditCardBillYet_showCreditCard.action">未出账单查询</a>
						</li>
						<li><a href="<%=basePath%>CreditCard/CreditcardIntegration_showCreditCard.action">积分查询</a>
						</li>
						<li class="disabled"><a
							href="credicard_searchIntegratel.action">申请进度查询</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
