<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>主页面</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="resource/css/login.css">
	<style type="text/css" media="all">@import "resource/css/master.css";</style>
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
	
  </head>
  
  <body>
  	<div class="menuDiv" id="menu">
    </div>
  	
  	<script> 
		//显示菜单
		$(function(){ 
			var url = "<%=path%>/111/menuInfo.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
				},
				dataType: 'json', 
				success:function(data){ 
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					for(var i = 0; i < dd.length; i++){
						if(dd[i].menuPar == -1){
							var str=$("<p>"+dd[i].menuName+"</p>");
						} else{
							var str=$("<a href=\""+dd[i].menuSrc+"\">"+"&nbsp;&nbsp;-&nbsp;&nbsp;"+dd[i].menuName+"</a><br/>");
						}
						$("#menu").append(str); 
					}
					//$("#menu").prop("innerHTML",str);
				} 
			});
		}); 
		
	</script> 
  	
  	
  </body>
</html>

