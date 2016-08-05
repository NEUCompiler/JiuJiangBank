<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>My JSP 'documentUploading.jsp' starting page</title>
  </head>

<script type="text/javascript">
  function download() {
   window.location.href = "zsta.xls";
  }
</script>
  
  <body>
  
        请先下载模板，填写成功后导入文件   <button onclick="download();" >下载</button>
   <form enctype="multipart/form-data" action="<%=basePath%>AccountService/SalaryProvidingAction_showExcel.action" method="post">  
    <table>  
        <tr>  
            <td>上传Excel文件：</td>  
            <td>  
                <input type="file" name="theFile" />  
            </td>  
            <td>  
                <input type="submit" value="导入" />  
            </td>  
        </tr>  
    </table>  
   </form>
  </body>
</html>
