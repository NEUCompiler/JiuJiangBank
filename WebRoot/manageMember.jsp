<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集团账户管理</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resource/css/login.css">
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
  </head>
  
  <body>
	
	<div id="showtable">
	<label for="exampleInputEmail1">集团：</label>
  	<input type="text" class="form-control" id="groupName"><br/> 
  	<label for="exampleInputEmail1">月利率：</label>
  	<input type="text" class="form-control" id="rate"><br/>
  	<label for="exampleInputEmail1">余额：</label>
  	<input type="text" class="form-control" id="money"><br/>
	<button id="correct" class="btn btn-default">提交修改</button>
  	</div>
  	<br/><p id="res"></p>
	<br/><a href="index.jsp">返回主页</a><br/>
	
	<script> 
		
		$(function(){ 
			var url = "<%=path%>/111/back.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
				},
				dataType: 'json', 
				success:function(data){ 
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					if(dd.length == 0){
						alert("未登录集团成员账户！");
						$("#showTable").prop("outerHTML","<label for=\"exampleInputEmail1\">集团：</label><input type=\"text\" class=\"form-control\" id=\"name\"><br/> <label for=\"exampleInputEmail1\">月利率：</label><input type=\"text\" class=\"form-control\" id=\"rate\"><br/><label for=\"exampleInputEmail1\">余额：</label><input type=\"text\" class=\"form-control\" id=\"money\"><br/><button id=\"correct\" class=\"btn btn-default\">提交修改</button>");
						return;
					}
					//alert(JSON.stringify(dd));
					for(var i = 0; i < dd.length; i++){
						$("#groupName").prop("value",dd[i].groupName);
						$("#rate").prop("value",dd[i].rate);
						$("#money").prop("value",dd[i].money);
					}
				} 
			});
		}); 
		
		$("#correct").click(function(){ 
			var url = "<%=path%>/111/correct.action"; 
			var v1=$("#groupName").val();
			var v2=$("#rate").val();
			var v3=$("#money").val();
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
					groupName:v1,
					rate:v2,
					money:v3
				},
				dataType: 'json', 
				success:function(data){ 
					$("#res").prop("innerHTML",data.jsonstr);
				} 
			});
		}); 
		
	</script> 
  	
  </body>
</html>

