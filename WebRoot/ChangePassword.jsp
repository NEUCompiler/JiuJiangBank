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
		function findStr(str,n){
			var temp;
			for (var i=0;i<str.length;i++) {
				if(str.charAt(i)==n){
					temp++;
				}
			}
			return temp;
		}		
		
		window.onload=function (){
				var ainput=document.getElementsByTagName("input");
				var newpassword=ainput[1];
				var newpassword1=ainput[2];
				
				var aP=document.getElementsByTagName("p");
				var newpassword_msg=aP[0];
				var newpassword1_msg=aP[1];

				newpassword.onfocus=function (){
					newpassword_msg.style.display="block";
					newpassword_msg.innerHTML="6-16个字符，字母数字或者符号的组合，不能单独使用字母数字或者符号"		
				}
				newpassword.onchange=function(){
					var m=findStr(newpassword.value,newpassword.value[0]);
					var re_n=/[^\d]/g;
					var re_t=/[^a-zA-Z]/g;
					if(this.value==""){
						alert("不能为空");
						return;
					}
					else if(this.value.length==m){
						alert("字符不能都相同");
						return;
					}
					else if(this.value.length<6||this.value.length>26){
						alert("字符长度应为6——16");
						return;					
					}
					else if(!re_n.test(this.value)){
						alert("不能全为数字");
						return;						
					}
					
					else if(!re_t.test(this.value)){
						alert("不能全为字母");
						return;						
					}
					else{				
						newpassword_msg.innerHTML="<strong style='color: blue;'>OK</strong>";
					}
				}
				newpassword1.onchange=function (){
					if(this.value!=newpassword.value){
//						alert(this.value);
//						alert(newpassword.value);
						alert("两次输入的密码不一致！！");
					}else{
						newpassword1_msg.innerHTML="<strong style='color: blue;'>OK</strong>";
					}
				}		
		}		
		</script>


  </head>
  
  <body>
    <div id="div1">
		<form action="<%=path%>/changingP" method="get">		
		请输入旧密码<br>
		<input name="oldpassword" type="password"> <br><br>	
		请输入新密码<br>   
		<input name="changevariable" type="password"> <p> </p>	
		验证新密码<br>
		<input name="changevariable1" type="password"> <p> </p>
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
