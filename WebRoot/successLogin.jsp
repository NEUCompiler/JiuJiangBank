<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中国建设银行 个人网上银行</title>
      
    		<style>
				#div1{
					text-align: center;
					border-color: blue;
				}
				input{
					width: 100px;
					height: 30px;
					border:blue solid 2px;
					background: deepskyblue;
					margin: 20px;
				}				
		</style>

  </head>
  <%    String name=(String)request.getAttribute("username");
  %>
  <body>
		<div id="div1">
			<h3>登陆成功，你可以进行如下操作！</h3><br />
			<h4>信息维护</h4>
			<input name="TrueName" type="button" value="更改用户名" onclick="window.location='ChangeName.jsp'" />
			<input name="password" type="button" value="更改密码" onclick="window.location='ChangePassword.jsp'" />
			<input name="phone" type="button" value="更改手机号" onclick="window.location='ChangePhone.jsp'"/>
			<input name="mail" type="button" value="更改邮箱" onclick="window.location='ChangeMail.jsp'"/>
			<h4>大额取款预约服务(小于五万不用预约)</h4>
			<input name="appointment" type="button" value="取款预约" onclick="window.location='Appointment.jsp'" />
			<h4>贷款计算器</h4>
			<input name="load" type="button" value="贷款计算器" onclick="window.location='loan.jsp'" />
			<h4>存款计算器</h4>
			<input name="fixdeposit" type="button" value="定期存款" onclick="window.location='fixdeposit.jsp'" />
			<input name="currentdeposit" type="button" value="活期存款" onclick="window.location='currentdeposit.jsp'" />
		</div>
		
				<form action="<%=path%>/logout" method="get">
	<div style="position: absolute;right: 50;top: 30;">
	 <input type="submit" style="float: right;margin-top: 10px;width: 100px;height: 30px;background: deepskyblue;" type="button" value="安全退出"></input>	
	 </div>
	 </form>
  </body>
</html>