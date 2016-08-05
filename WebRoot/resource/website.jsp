<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询网点信息</title>
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

	<!-- 查询网点信息 -->
	<button id="website" class="btn btn-default">查询网点信息</button>
  	
  	<table id="showTable2" border="1"> 
		<tr> 
			<td>网点id</td> 
			<td>网点名</td> 
			<td>网点地址</td> 
			<td>建立时间</td> 
		</tr> 
	</table> 
	<br/><a href="index.jsp">返回主页</a><br/>
	<br/><br/><br/><br/><br/><br/>
	
	<script> 
		
		//查询网点信息
		$("#website").click(function(){ 
			var url = "<%=path%>/111/websiteInfo.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
				},
				dataType: 'json', 
				success:function(data){ 
					$("#showTable2").prop("outerHTML","<table id=\"showTable2\" border=\"1\"> <tr> <td>网点id</td> <td>网点名</td> <td>网点地址</td> <td>建立时间</td> </tr> </table>  ");
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					for(var i = 0; i < dd.length; i++){
						var _tr = $("<tr><td>"+dd[i].websiteId+"</td><td>"+ 
								dd[i].websiteName+"</td><td>"+dd[i].websiteAddr+"</td><td>"+dd[i].buildTime+"</td></tr>"); 
						$("#showTable2").append(_tr); 
					}
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

