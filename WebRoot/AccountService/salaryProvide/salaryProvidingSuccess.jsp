<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'salaryProvidingSuccess.jsp' starting page</title>
    
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
 工资代发成功 <br>
 工资代发情况如下：
  <table class="table">
					<thead>
						<tr>
							<th>员工卡号</th>
							<th>金额</th>
							<th>代发工资卡号</th>
							<th>交易描述</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${request.dealInfoList2}" var="dealInfo">
							<tr>
								<td>${dealInfo.accountid}</td>
								<td>${dealInfo.deaamountl}</td>
								<td>${dealInfo.dealDesti}</td>
								<td>${dealInfo.dealinform}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
 
 
 
  </body>
</html>
