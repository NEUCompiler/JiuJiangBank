<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'ChangePassword.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
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
		<script type="text/javascript">
		window.onload=function (){
				var ainput=document.getElementsByTagName("input");
				var phone=ainput[1];			
				
				var aP=document.getElementsByTagName("p");
				var phone_msg=aP[0];

				phone.onfocus=function (){
					phone_msg.style.display="block";
					phone_msg.innerHTML="11位由数字组成";		
				}
				phone.onchange=function (){
					var re_n=/[^\d]/g;
					if(this.value==""){
						alert("手机号号为空!"); 	
						return;					
					}
					else if(this.value.length!=11){
						alert("手机号位数不对！");
						return;
					}
					else if(re_n.test(this.value))
					{
						alert("含有非法字符!");
						return;
					}
					else{
						phone_msg.innerHTML="<strong style='color:blue'>OK！</strong>";
					}	
				}	
		}
		</script>


  </head>
  
  <body>
    <div id="div1">
		<form action="<%=path%>/changingPh" method="get">
		请输入旧手机号<br>   
		<input name="oldphone" type="text"><br><br>				
		请输入新手机号<br>   
		<input name="changevariable" type="text"> <p></p> 	
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
