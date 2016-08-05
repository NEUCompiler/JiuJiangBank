<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script src="<%=basePath%>resource/jquery/jquery.min.js"></script>
<link href="<%=basePath%>resource/css/bootstrap.min.css"
	rel="stylesheet">
<script src="<%=basePath%>resource/js/bootstrap.min.js"></script>
<script src="<%=basePath%>resource/ie10-viewport-bug-workaround.js"></script>
</head>

<body>
	<div class="container">
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="row clearfix">
					<div class="col-md-2 column">
						<img class="img-thumbnail" alt="140x140"
							src="<%=basePath%>image/logo.jpg" />
					</div>
					<div class="col-md-10 column">
						<!-- 导航栏 -->
						<nav class="navbar navbar-default" role="navigation">
						<div class="navbar-header">
							<button type="button" class="navbar-toggle"
								data-toggle="collapse"
								data-target="#bs-example-navbar-collapse-1">
								<span class="sr-only">Toggle navigation</span><span
									class="icon-bar"></span><span class="icon-bar"></span><span
									class="icon-bar"></span>
							</button>
							<a class="navbar-brand" href="<%=basePath%>index.jsp">主页</a>
						</div>
						<div class="collapse navbar-collapse"
							id="bs-example-navbar-collapse-1">
							<ul class="nav navbar-nav">
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">个人业务<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="#">网银注册</a></li>
										<li class="divider"></li>
										<li><a href="#">客户服务</a></li>
										<li><a href="<%=basePath%>AccountService/index.jsp">账户服务</a></li>
										<li><a href="<%=basePath%>Payment/index.jsp">转账汇款</a></li>
										<li><a href="#">第三方支付</a></li>
										<li><a href="#">行内理财</a></li>
										<li><a href="<%=basePath%>Payment/index.jsp">缴费业务</a></li>
										<li><a href="#">网银互联</a></li>
										<li><a href="<%=basePath%>CreditCard/creditCardHome.jsp">信用卡</a></li>
									</ul></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">公司业务<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="#">账户服务</a></li>
										<li><a href="#">客户服务</a></li>
										<li><a href="#">转账汇款</a></li>
										<li><a href="<%=basePath%>AccountService/SalaryProvidingAction_showAccountIsOpen.action">代付服务</a></li>
										<li><a href="#">集团服务</a></li>
										<li><a href="#">电子汇票</a></li>
										<li><a href="#">网银互联</a></li>
									</ul></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">公共服务<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="<%=basePath%>PublicService/index.jsp">公共服务</a></li>
										<li><a href="#">业务介绍</a></li>
										<li><a href="#">网点查询</a></li>
										<li><a href="#">网页风格</a></li>
										<li><a href="#">回单查询</a></li>
										<li><a href="#">菜单设置</a></li>
										<li><a href="#">帮助</a></li>
										<li><a href="#">投诉建议</a></li>
									</ul></li>
								<li class="dropdown"><a href="#" class="dropdown-toggle"
									data-toggle="dropdown">管理功能<strong class="caret"></strong></a>
									<ul class="dropdown-menu">
										<li><a href="<%=basePath%>ManagerOperaterLogin.jsp">管理员登陆</a></li>
										<li><a href="#">系统参数管理</a></li>
										<li><a href="#">报表</a></li>
										<li><a href="#">监控管理</a></li>
										<li><a href="#">银行操作员管理</a></li>
									</ul></li>
							</ul>
							<form class="navbar-form navbar-right" role="search">
								<div class="form-group">
									<input class="form-control" type="text" />
								</div>
								<button type="submit" class="btn btn-default">Submit</button>
							</form>
						</div>
						</nav>
					</div>
				</div>
			</div>
		</div>
		<!--  幻灯片  -->
		<div class="row clearfix">
			<div class="col-md-12 column">
				<div class="carousel slide" id="carousel-900370">
					<ol class="carousel-indicators">
						<li class="active" data-slide-to="0"
							data-target="#carousel-900370"></li>
						<li data-slide-to="1" data-target="#carousel-900370"></li>
						<li data-slide-to="2" data-target="#carousel-900370"></li>
					</ol>
					<div class="carousel-inner">
						<div class="item active">
							<img alt="" src="<%=basePath%>image/default.jpg" width="1500" />
						</div>
						<div class="item">
							<img alt="" src="<%=basePath%>image/default1.jpg" width="1500" />
							<div class="carousel-caption"></div>
						</div>
						<div class="item">
							<img alt="" src="<%=basePath%>image/default2.jpg" width="1500" />
						</div>
					</div>
					<a class="left carousel-control" href="#carousel-900370"
						data-slide="prev"><span
						class="glyphicon glyphicon-chevron-left"></span></a> <a
						class="right carousel-control" href="#carousel-900370"
						data-slide="next"><span
						class="glyphicon glyphicon-chevron-right"></span></a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
