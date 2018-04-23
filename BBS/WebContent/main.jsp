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
  <table width="876" height="546" border="1">
    <tr>
      <td height="205" colspan="2"><img src="banner.JPG" width="788" height="201">
      <div align="right">
      <s:if test="#session.user.power == 2">
      <a href="adminIndex.jsp">管理论坛</a>
      </s:if>
      <s:else>
      <a href="index.jsp">HOME</a>
      </s:else>
      </div></td>
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
    <tr>
	    <td height="27" ><a href="index.jsp">首页</a>
	    <s:if test="#session.board != null">
	    &nbsp;->&nbsp;<a href=<s:url action="postsList"><s:param name="id" value="#session.board.id"/></s:url>><s:property value="#session.board.name"/></a>
	    </s:if>
	    </td>
    </tr>
    <tr>    	
    <td>
        <%String action = request.getParameter("action");
          if (action == null)
          {
          }
          else if (action.equals("boardList"))
          {
          	%>
			    <s:iterator value="boardList" status="status">
			    <tr>  
			    <td>
			      <H4><a href=<s:url action="postsList"><s:param name="id" value="id"/></s:url>><s:property value="name"/></a></H4>
				  <s:property value="content"/>
				</td>
			    </tr>
			    </s:iterator>  
          	<%
          }
          else if (action.equals("postsList"))
          {
          	%>
          		<center>
          		<form action="addPosts" method="post">
          		<table>
			    <s:iterator value="postsList" status="status">
			    <tr>  
			    <td height="25" width="500">
			      <a href=<s:url action="postsInfo"><s:param name="id" value="id"/></s:url>><s:property value="title"/></a>				  
				</td>
				<td>
				  <s:property value="publishtime"/>
				</td>
			    </tr>
			    </s:iterator>  
			    <tr>
			    <td><center>
			    <s:if test="#session.user != null">
			    <a href="main.jsp?action=addPosts&bid="<s:property value="#session.board.id"/>>发表新的帖子</a>
			    </s:if>
			    </center></td>
			    <td>&nbsp;</td>
			    </tr>
			    </table>
			    </form>
			    </center>
          	<%
          }
          else if (action.equals("postsInfo"))
          {
          	%>
          		<%@ include file="/postsInfo.jsp" %>
			<%
          }       
          else if (action.equals("addPosts"))
          {
          	%>
          		<%@ include file="/addPosts.jsp" %>
			<%
          }   
          else if (action.equals("addPostsSuccess"))
          {
          	%>
          		发表成功
			<%
          } 
          else if (action.equals("delPostsSuccess"))
          {
          	%>
          		删除成功
			<%
          }           
         %>
         </td>
    </tr>
  </table>
  </center>
  	
  </body>
</html>
