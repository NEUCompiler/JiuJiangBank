<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集团成员账户利息查询</title>
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
	

	<label for="exampleInputEmail1">集团成员账户：</label>
  	<input type="text" class="form-control" id="interest"><br/> 
	<button id="select" class="btn btn-default">利息查询</button>
  	
  	<table id="showTable" border="1"> 
		<tr> 
			<td>所属集团</td>
			<td>成员账户</td>  
			<td>账户余额</td> 
			<td>月利率</td> 
			<td>利息</td>
		</tr> 
	</table> 
	
	<br/><a href="index.jsp">返回主页</a><br/>
	
	<script> 
		
		//根据电子回单号查询单条交易记录
		$("#select").click(function(){ 
			var v=$("#interest").val();
			if(""==v){
				alert("请输入集团成员账户！");
				$("#showTable").prop("<table id=\"showTable\" border=\"1\"> <tr> <td>所属集团</td><td>成员账户</td>  <td>账户余额</td> <td>月利率</td> <td>利息</td></tr> </table>");
				return;
			}
			var url = "<%=path%>/111/interest.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
					member : v
				},
				dataType: 'json', 
				success:function(data){ 
					$("#showTable").prop("<table id=\"showTable\" border=\"1\"> <tr> <td>所属集团</td><td>成员账户</td>  <td>账户余额</td> <td>月利率</td> <td>利息</td></tr> </table>");
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					//alert(typeof(dd.length));
					if(dd.length == 0){
						alert("不存在的账户，请重新输入！");
						return;
					}
					for(var i = 0; i < dd.length; i++){
						var _tr = $("<tr><td>"+dd[i].groupName+"</td><td>"+ 
								dd[i].groupUsername+"</td><td>"+dd[i].money+"</td><td>"+dd[i].rate+"</td><td>"+dd[i].interest+"</td></tr>"); 
						$("#showTable").append(_tr); 
					}
				} 
			});
		}); 
		
	</script> 
  	
  </body>
</html>

