<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="/bootstrap.jsp"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>

  </head>
  
  <body>
  <div class="col-md-15 column">
			<ul class="breadcrumb">
				<li><a href="#">网上交易查询</a></li>
				<li><a href="#">选择账户</a></li>
				<li><a href="#">选择时间</a></li>
				<li class="active">显示网上交易</li>
			</ul>
  <table class="table">
					<thead>
						<tr>
							<th>交易日</th>
							<th>交易金额</th>
							<th>卡号</th>
							<th>交易描述</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${request.result}" var="dealInfo">
							<tr>
								<td>${dealInfo.dealtime.getYear()+1900}年${dealInfo.dealtime.getMonth()+1}月${dealInfo.dealtime.getDate()}日</td>
								<td>${dealInfo.deaamountl}</td>
								<td>${dealInfo.accountid}</td>
								<td>${dealInfo.dealinform}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
  </body>
</html>
