<%@ page language="java" import="java.util.*" pageEncoding="GB2312"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="bbs_head.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆论坛</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

  </head>
  
  <body>
  <center>
    <form action="login.action" method="post">
    	<table>
    		<tr>
    			<td>用户名：</td>
    			<td><input type="text" name="user.name"></td>
    		</tr>
    		<tr>
    			<td>密码：</td>
    			<td><input type="password" name="user.password"></td>
    		</tr>
    		<tr>
    			<td><input type="submit" value="登录"></td>    		
    			<td><input type="reset" value="重填"></td>
    		</tr>
    	</table>
    </form>
    </center>
  </body>
</html>
