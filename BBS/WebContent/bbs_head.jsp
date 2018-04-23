<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
    
<html>
  <head>
    <base href="<%=basePath%>">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="css/main.css">
  </head>
  <body class = "center">
  <form action="" method="post">
  <table border="1">
    <tr>
      <td height="205" colspan="2"><img src="banner.JPG" width="788" height="201">
      <div align="right"><a href="index.jsp">HOME</a></div></td>
    </tr>
    <tr>
    	<td height="38" colspan="2">    		
            <s:if test="#session.user != null">
        		<s:push value="#session.user">
        		  <div align="right">
        		    您好，
        		    <a href="userInfo.jsp">
        		    <s:property value="name"/>
        		    </a>
        		    <a href="logout.action">退出</a>
      		    </div>
        		</s:push>
        	</s:if>
        	<s:else>
        	  <div align="right">您是现在是游客，请<a href="login.jsp">登陆</a>&nbsp;&nbsp;
        	  <a href="register!default.action">注册</a></div>
        	</s:else>
        </td>
    </tr>
  </table>
  </form>
  </body>
</html>
