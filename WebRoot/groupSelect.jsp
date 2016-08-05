<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>集团账户查询</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="resource/css/bootstrap.min.css">
	<style type="text/css" media="all">@import "resource/css/master.css";</style>
	<script type="text/JavaScript" src="resource/js/jquery.js"></script>
	
  </head>
  
  <body>
  	<select id="o" name="option">
  		<option value="select" selected>请选择</option>
	</select><br/>
  	
  	<table id="showTable" border="1"> 
		<tr> 
			<td>集团</td> 
			<td>成员用户名</td> 
			<td>利率</td> 
			<td>余额</td> 
		</tr> 
	</table> 

	<br/><a href="index.jsp">返回主页</a><br/>
	<br/><br/><br/><br/><br/><br/>
  	
  	<script> 
		//显示菜单
		$(function(){ 
			var url = "<%=path%>/111/selectGroupPar.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
				},
				dataType: 'json', 
				success:function(data){ 
					//alert(JSON.stringify(data));
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;			
					var str="";
					for(var i = 0; i < dd.length; i++){
						str+="<option value=\""+dd[i].groupName+"\">"+dd[i].groupName+"</option>";
					}
					//$("#menu").prop("innerHTML",str);
					$("#o").append(str);
				} 
			});
		}); 
		
		$("#o").change(function(){ 
			var v=$("#o").val();
			if(v=="select"){
				$("#showTable").prop("outerHTML","<table id=\"showTable\" border=\"1\"> <tr> <td>集团</td> <td>成员用户名</td> <td>利率</td> <td>余额</td> </tr> </table> ");
				return;
			}
			var url = "<%=path%>/111/selectGroupChi.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
					option: v
				},
				dataType: 'json', 
				success:function(data){ 
					//alert(JSON.stringify(data));
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;			
					var str="";
					$("#showTable").prop("outerHTML","<table id=\"showTable\" border=\"1\"> <tr> <td>集团</td> <td>成员用户名</td> <td>利率</td> <td>余额</td> </tr> </table> ");
					for(var i = 0; i < dd.length; i++){
						str += "<tr><td>"+dd[i].groupName+"</td><td>"+ 
							dd[i].groupUsername+"</td><td>"+dd[i].rate+"</td><td>"+dd[i].money+"</td></tr>"; 
					}
					//$("#menu").prop("innerHTML",str);
					$("#showTable").append(str);
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

