<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'SysPar_Loanshow.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    贷款利率 <br>
    <table class="default" width="100%" >
			<col width="10%">
			<col width="20%">
			<col width="5%">
			<col width="20%">
			<col width="30%">
			<col width="15%">
			<tr class="title">
				<td>键值</td>
				<td>金额</td>
			    <td>时间</td>  
				<td>操作</td>
			</tr>

			<!-- 遍历开始 -->
			<s:iterator value="#session.bigdeallist" var="stu">
				<tr class="list">
					<td><s:property value="#stu.bigdealId" /></td>
					<td><s:property value="#stu.amount" /></td>
					<td><s:property value="#stu.aheadtime" /></td>
					<td><a href="<%=path%>/SystemParrateAction/sysParrate_bigdealupdateRQ.action?stu.bigdealId=<s:property value="#stu.bigdealId"/>" onclick="javascript: return confirm('真的要修改吗？');">修改</a></td>
					
					
				</tr>
			</s:iterator>
			<!-- 遍历结束 -->
		</table>
  </body>
</html>
