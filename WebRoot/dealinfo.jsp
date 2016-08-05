<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>查询交易信息</title>
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
	
	<!-- 根据电子回单号查询单条交易记录 -->
	<label for="exampleInputEmail1">电子回单号：</label>
  	<input type="text" class="form-control" id="dealId"><br/> 
	<button id="dealInfo" class="btn btn-default">查询交易信息</button>
  	
  	<table id="showTable3" border="1"> 
		<tr> 
			<td>银行卡号</td> 
			<td>交易时间</td> 
			<td>交易类型</td> 
			<td>转入转出</td> 
			<td>交易对象卡号</td> 
			<td>交易状态</td> 
			<td>交易金额（元）</td> 
		</tr> 
	</table> 
	
	<br/><a href="index.jsp">返回主页</a><br/>
	
	<script> 
		
		//根据电子回单号查询单条交易记录
		$("#dealInfo").click(function(){ 
			var v=$("#dealId").val();
			if(""==v){
				alert("请输入电子回单号！");
				$("#showTable3").prop("outerHTML","<table id=\"showTable3\" border=\"1\"> <tr> <td>银行卡号</td> <td>交易时间</td> <td>交易类型</td> <td>转入转出</td> <td>交易对象卡号</td> <td>交易状态</td> <td>交易金额（元）</td>  </tr> </table> ");
				return;
			}
			var url = "<%=path%>/111/dealInfo.action"; 
			$.ajax({ 
				type:'post', 
				url:url, 
				data : {
					option : v
				},
				dataType: 'json', 
				success:function(data){ 
					$("#showTable3").prop("outerHTML","<table id=\"showTable3\" border=\"1\"> <tr> <td>银行卡号</td> <td>交易时间</td> <td>交易类型</td> <td>转入转出</td> <td>交易对象卡号</td> <td>交易状态</td> <td>交易金额（元）</td>  </tr> </table> ");
					var d=eval('('+data.jsonstr+')');
					var dd = d.data;
					//alert(typeof(dd.length));
					if(dd.length == 0){
						alert("不存在的回单号，请重新输入！");
						$("#showTable3").prop("outerHTML","<table id=\"showTable3\" border=\"1\"> <tr> <td>银行卡号</td> <td>交易时间</td> <td>交易类型</td> <td>转入转出</td> <td>交易对象卡号</td> <td>交易状态</td> <td>交易金额（元）</td>  </tr> </table> ");
						return;
					}
					for(var i = 0; i < dd.length; i++){
						var _tr = $("<tr><td>"+dd[i].accountid+"</td><td>"+ 
								dd[i].dealtime+"</td><td>"+dd[i].dealinform+"</td><td>"+dd[i].dealtype+"</td><td>"+dd[i].dealDesti+"</td><td>"+dd[i].dealstate+"</td><td>"+dd[i].dealamount+"</td></tr>"); 
						$("#showTable3").append(_tr); 
					}
				} 
			});
		}); 
		
	</script> 
  	
  </body>
</html>

