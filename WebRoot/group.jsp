<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集团账户登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<style type="text/css" media="all">@import "resource/css/master.css";</style>
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
	<script type="text/JavaScript" src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/ie10-viewport-bug-workaround.js"></script>
	
  </head>
  
  <body>
    
    <!-- 登录表单 -->
  		<div class="form-group"> 
  			<label for="exampleInputEmail1">用户名</label> 
  			<input id="username" type="text" class="form-control" name="username"> 
  		</div> 
  		<div class="form-group"> 
  			<label for="exampleInputPassword1">密码</label> 
  			<input id="password" type="password" class="form-control" name="password"/> 
  		</div> 
  		<div class="checkbox"> 
  			<label> <input type="checkbox">记住密码</label> 
  		</div> 
  		<div>
  			
  		</div>
  		<button id="submit" type="submit" class="btn btn-default">登录</button> 
  		<br/><br/><p id="res"></p>
  		<br/><a href="index.jsp">返回主页</a><br/>
		<br/><br/><br/><br/><br/><br/>
  	
  	<script> 
	
		//查看用户建议投诉
		$("#submit").click(function(){ 
			var u=$("#username").val();
			var v=$("#password").val();
			var url = "<%=path%>/111/groupLogin.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
					username : u,
					password : v
				},
				dataType: 'json', 
				success:function(data){ 
					//alert(JSON.stringify(data));
					var res=data.jsonstr;
					$("#res").prop("innerHTML", res); 
				} 
			});
		}); 
		
	</script> 
  </body>
</html>

