<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'accloss.jsp' starting page</title>

  </head>
  
  <body>
     a: ${request.account.accountid}
     a: ${request.account.clientid}
     a: ${request.account.dealpassword}
     a: ${request.account.amount}
     a: ${request.account.integrate}
     a: ${request.account.isactive}
     a: ${request.account.isloss}
     a: ${request.account.isopenob}
     a: ${request.account.limit}
     a: ${request.account.term}
  </body>
</html>
