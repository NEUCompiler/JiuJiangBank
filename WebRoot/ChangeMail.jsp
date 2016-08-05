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
			var mail=ainput[1];
			
			var aP=document.getElementsByTagName("p");
			var mail_msg=aP[0];
			mail.onfocus=function (){
					mail_msg.style.display="block";
					mail_msg.innerHTML="<strong style='color: blue;'>不少于7个字符并超过20字符，例如：(eg.925781291@qq.com）</strong> "	
				}
				mail.onchange=function (){
				var reg=/^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
					if(this.value==""){
						alert("邮箱为空");
						return;
					}else if(!reg.test(this.value)){
						alert("邮箱格式不正确！");	
						return;
					}else if(this.value.length<7){
						alert("邮箱少于7字符");								
						return;	
					}
					else if(this.value.length>20){
						alert("邮箱超过20字符");								
						return;	
					}else{
						mail_msg.innerHTML="<strong style='color: blue;'>OK</strong> "
					}
				}
			}
		
		
		</script>

  </head>
  
  <body>
    <div id="div1">
		<form action="<%=path%>/changingM" method="get">	
		请输入旧邮箱<br>   
		<input name="oldmail" type="text"> <br><br>		
		请输入新邮箱<br>   
		<input name="changevariable" type="text"><p></p>
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
