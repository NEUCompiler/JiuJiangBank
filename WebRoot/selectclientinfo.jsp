<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询用户建议或投诉</title>
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
  	
  	<!-- 查看用户建议投诉 -->
  	
  	<select id="o" name="option">
  		<option value="" selected>请选择</option>
		<option value="suggestion">建议</option>
		<option value="complaint">投诉</option>
	</select><br/>
  	
  	<table id="showTable" border="1"> 
		<tr> 
			<td>用户id</td> 
			<td>提交时间</td> 
			<td>内容</td> 
		</tr> 
	</table> 
	<br/><a href="index.jsp">返回主页</a><br/>
	<br/><br/><br/><br/><br/><br/>
	
	<script> 
	
		//查看用户建议投诉
		$("#o").change(function(){ 
			var v=$("#o").val();
			if(""==v){
				$("#showTable").prop("outerHTML","<table id=\"showTable\" border=\"1\"> <tr><td>用户id</td><td>提交时间</td><td>内容</td></tr></table> ");
				return;
			}
			var url = "<%=path%>/111/selectInfo.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
					option : v
				},
				dataType: 'json', 
				success:function(data){ 
					$("#showTable").prop("outerHTML","<table id=\"showTable\" border=\"1\"> <tr><td>用户id</td><td>提交时间</td><td>内容</td></tr></table> ");
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					for(var i = 0; i < dd.length; i++){
						var _tr = $("<tr><td>"+dd[i].clientId+"</td><td>"+ 
								dd[i].submitTime+"</td><td>"+dd[i].infoContent+"</td></tr>"); 
						$("#showTable").append(_tr); 
					}
				} 
			});
		}); 
		
	</script> 
  	
  </body>
</html>

