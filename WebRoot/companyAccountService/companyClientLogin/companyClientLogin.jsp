<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>公司账户登录</title>

  </head>
  
  <body>
  	<div class="container">
	<div class="row clearfix">
		<div class="col-md-12 column">
			<form class="form-horizontal" role="form" method="post" action="<%=basePath%>CompanyAccountService/CompanyClientLogin_login.action">
				<div class="form-group">
					 <label for="username" class="col-sm-2 control-label">公司账户名</label>
					<div class="col-sm-10">
						<input class="form-control" id="username" type="text" name="username"/>
					</div>
				</div>
				<div class="form-group">
					 <label for="userpassword" class="col-sm-2 control-label">账户密码</label>
					<div class="col-sm-10">
						<input class="form-control" id="userpassword" type="password" name="userpassword" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<div class="checkbox">
							 <label><input type="checkbox" />记住我</label>
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						 <button type="submit" class="btn btn-default">登录</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
  </body>
</html>
