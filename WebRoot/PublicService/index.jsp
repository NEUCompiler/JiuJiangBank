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
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<style type="text/css" media="all">@import "resource/css/master.css";</style>
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
	<script type="text/JavaScript" src="resource/js/bootstrap.min.js"></script>
	<script src="resource/js/ie10-viewport-bug-workaround.js"></script>
	
  </head>
  
  <body>
    
    <div class="row clearfix">
		<div class="col-md-12 column">
			<div class="row clearfix">
				<div class="col-md-2 column">
					<div class="panel-group" id="panel-780934">
					</div>
				</div>
  			</div>
  		</div>
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
					var pos=0;
					var str="";
					for(var i = 0; i < dd.length; i++){
						if(dd[i].menuPar == -1){
							//var str=$("<p>"+dd[i].menuName+"</p>");
							pos=i;
							if(i != 0){
								str+="</div></div> </div> <div class=\"panel panel-default\"> <div class=\"panel-heading\">"+
									"<a class=\"panel-title\" data-toggle=\"collapse\" data-parent=\"#panel-780934\" href=\"#panel-element-"+pos+"\">"+dd[i].menuName+"</a> </div>"
									+"<div id=\"panel-element-"+pos+"\" class=\"panel-collapse collapse in\"> <div class=\"panel-body\">";
							}
							else{
								str+="<div class=\"panel panel-default\"> <div class=\"panel-heading\">"+
									"<a class=\"panel-title\" data-toggle=\"collapse\" data-parent=\"#panel-780934\" href=\"#panel-element-"+pos+"\">"+dd[i].menuName+"</a> </div>"
									+"<div id=\"panel-element-"+pos+"\" class=\"panel-collapse collapse in\"> <div class=\"panel-body\">";
							}
						} else{
							str+="<a href=\""+dd[i].menuSrc+"\">&nbsp;&nbsp;&nbsp;&nbsp;-"+dd[i].menuName+"</a><br/>";
						}
						//$("#panel-780934").append(str); 
					}
					str+="</div> </div> </div><br/>";
					$("#panel-780934").append(str);
				}, 
				error:function(a,b,c,d){
					alert(a);
					alert(b);
					alert(c);
					alert(d);
				} 
			});
		}); 
		
	</script> 
  	
  	
  </body>
</html>

