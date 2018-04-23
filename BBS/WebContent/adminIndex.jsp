<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<style TYPE="text/css">
<!--
A:link{text-decoration:none}
A:visited{text-decoration:none}
A:hover {color: #ff00ff;text-decoration:underline}
 -->
</style>
    
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Matrix论坛</title>
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
  <center>
  <table width="876" height="516" border="1">
    <tr>
      <td height="205" colspan="2"><img src="banner.JPG" width="788" height="201">
      <div align="right"><a href="index.jsp">HOME</a></div></td>
    </tr>
    <tr>
    	<td height="38" colspan="2">    	
 		<s:if test="#session.user != null && #session.user.power == 2">
   		    	<div align="right">
   		    		您好，
   		    	<a href="userInfo.jsp">
   		    		<s:property value="#session.user.name"/>
   		    	</a>
   		    	<a href="logout.action">退出</a>
 		  		</div> 			  		
 		</s:if>
 		<s:else><jsp:forward page="login.jsp"></jsp:forward></s:else> 		
        </td>
    </tr>
    <tr>
        <td width="192"><div align="center">
          <h2><strong><a href="adminIndex.jsp?action=addBoard">增加板块</a></strong></h2>
        </div></td>
        <td width="668" rowspan="4">
        <%String action = request.getParameter("action");
          if (action == null){}
          else if (action.equals("addBoard")) 
          {
          	%>
          		<%@ include file="addBoard.jsp" %>
			<%
          }
          else if (action.equals("addBoardSuccess"))
          {
          	%>添加成功<%
          }
          else if (action.equals("modBoard"))
          {
          	%>
          		<%@ include file="modBoard.jsp" %>
			<%
          }
          else if (action.equals("modBoardSuccess"))
          {
          	%>修改成功<%
          }       
          else if (action.equals("delBoardSuccess"))
          {
          	%>删除成功<%
          }  
          else if (action.equals("listUser"))
          {
          	%>
          		<%@ include file="userList.jsp" %>
			<%
          }   
          else if (action.equals("delUserSuccess"))
          {
          	%>删除成功<%
          }                     
         %>        
        </td>
    </tr>
    <tr>
      <td><div align="center">
        <h2><strong><a href="listBoard.action">修改/删除板块</a></strong></h2>
      </div></td>
    </tr>
    <tr>
      <td><div align="center">
        <h2><strong><a href="index.jsp">删除帖子/回复</a></strong></h2>
      </div></td>
    </tr>
    <tr>
      <td><div align="center">
        <h2><strong><a href="listUser.action">删除用户</a></strong></h2>
      </div></td>
    </tr>
  </table>
  </center>
  	
  </body>
</html>
