<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>中国建设银行 个人网上银行</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
		<script type="text/JavaScript" src="jquery.js"></script>
	<style>
			#div1{
				text-align: center;
				margin-top: 100px;
				border-color: blue;
			}
			input{
				width: 200px;
				height: 30px;
				border:blue solid 2px;
			}
		</style>
		<script>
		
				function test1(username){
				var url = "<%=path%>/changingN2";	
				$.ajax({ 
					type:'post', 
					url:url, 
					data : {
						username:username,
					},
					dataType: 'json', 
					success:function(data){			
						var aa = data.remind;
						if(aa=="用户名已存在"){
						alert("用户名已存在");
						return;
						}else{
						$("#remind1").prop("innerHTML", aa);
						}		 
					}	
			});
		};
		
			window.onload=function (){
				var ainput=document.getElementsByTagName("input");
				var username=ainput[1];
				
				var aP=document.getElementsByTagName("p");
				var username_msg=aP[0];			
				
				username.onfocus=function (){
					username_msg.style.display="block";
					username_msg.innerHTML="3-20个字符,(汉字字母均表示一个字符)";		
				}
				username.onchange=function (){
					var  re=/[^\w\u4e00-\u9fa5]/g;		
					if(this.value==""){
						alert("用户名为空");
						return;
					}
					
					else if(re.test(this.value)){
						alert("含有非法字符！");
						return;
					}
					
					else if(this.value.length>20){
						alert("超过20个字符");
						return;
					}
					else if(this.value.length<3){
						alert("少于3个字符");
						return;
					}
					else{
						test1(this.value);
					}
				}
			}
		</script>		
		
  </head>
  
  <body>
		
		<div id="div1">
			<form action="<%=path%>/changingN" method="get">
			请输入旧用户名<br>
			<input name="oldname" type="text"> <br><br>			
			请输入新用户名<br>   
			<input name="changevariable" type="text"> <p id="remind1"></p>	
			<input type="submit" value="提交" style="width: 80px;
				background:deepskyblue;"> <br>
			</form>
				${request.info}
		</div>
	 <form action="<%=path%>/logout" method="get">
	 <div style="position: absolute;right: 50;top: 30;">
	 <input type="submit" style="float: right;margin-top: 10px;width: 100px;height: 30px;background: deepskyblue;" type="button" value="安全退出"></input>	
	 </div>
	 </form>
  </body>
</html>
