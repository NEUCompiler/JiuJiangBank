<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>九江银行</title>

</head>
<body>
	<div class="container">
		<!--手风琴切换， 缩略图-->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="btn-group">
					<button class="btn btn-default">公司账户服务</button>
					<button data-toggle="dropdown"
						class="btn btn-default dropdown-toggle">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu">
						<li><a
							href="<%=basePath%>companyAccountService/companyClientLogin/companyClientLogin.jsp">登陆</a>
						</li>
						<li><a
							href="<%=basePath%>companyAccountService/changePassword/selectTypeOfPassword.jsp">密码修改</a>
						</li>
						<li><a
							href="<%=basePath%>CompanyAccountService/CompanyAccountServiceLoss_showAccount.action">账号挂失</a>
						</li>
						<li><a
							href="<%=basePath%>companyAccountService/addAccount/addAccount.jsp">上挂账户</a>
						<li><a
							href="<%=basePath%>companyAccountService/deleteAccount/deleteAccount.jsp">删除上挂账户</a>
						</li>
						<li><a
							href="<%=basePath%>CompanyAccountService/CompanyAccountServiceShowAccountInfo_showAccount.action">查询名下上挂账号信息</a>
						</li>
						<li class="disabled"><a href="#">票据挂失</a></li>
						<li class="disabled"><a href="#">账户明细查询</a></li>
						<li class="disabled"><a href="#">网银交易查询</a></li>
						<li class="disabled"><a href="#">对账单查询</a></li>
					</ul>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
