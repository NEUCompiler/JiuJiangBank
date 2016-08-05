<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ include file="/bootstrap.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'selectAccountIsOpen.jsp' starting page</title>
   

  </head>
  
  <body>
   <form action="SalaryProvidingAction_salaryProviding.action">

				<select name="selectAccount"  class="form-control">
					<c:forEach items="${request.accountIdList}" var="li">

						<option >${li}</option>

					</c:forEach>
				</select>
				<button>下一步</button>
			</form>
			<button onclick="location.href('index.jsp')">上一步</button>
  </body>
</html>
