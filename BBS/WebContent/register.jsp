<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<jsp:include page="bbs_head.jsp"></jsp:include>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script language="javascript">
		function show(f)
		{
			f.showface.src=f.profile.value;
		}
	</script>
    <title>注册</title>
    
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
    <form name="form1" method="post" action="register.action">
      <table width="443" border="1" align="center">
        <tr>
          <td width="85">昵称</td>
          <td width="342"><label>
            <input name="user.name" type="text"/>
          </label></td>
        </tr>
        <tr>
          <td>密码：</td>
          <td><label>
            <input type="password" name="user.password">
          </label></td>
        </tr>
        <tr>
          <td>性别</td>
          <td><label>
            <input name="user.gender" type="radio" value="true" checked="checked" />
            帅哥
            <input type="radio" name="user.gender" value="false" />
            美女 </label></td>
        </tr>
        <tr>
          <td>头像</td>
          <td><label>
            <select name="user.profile" id="profile" onChange="show(this.form)">
              <option value="profile/1.jpg" selected="selected">头像1</option>
              <option value="profile/2.jpg">头像2</option>
              <option value="profile/3.jpg">头像3</option>
              <option value="profile/4.jpg">头像4</option>
              <option value="profile/5.jpg">头像5</option>
              <option value="profile/6.jpg">头像6</option>
              <option value="profile/7.jpg">头像7</option>
              <option value="profile/8.jpg">头像8</option>
              <option value="profile/9.jpg">头像9</option>
              <option value="profile/10.jpg">头像10</option>
              <option value="profile/11.jpg">头像11</option>
              <option value="profile/12.jpg">头像12</option>
              <option value="profile/13.jpg">头像13</option>
              <option value="profile/14.jpg">头像14</option>
              <option value="profile/15.jpg">头像15</option>
              <option value="profile/16.jpg">头像16</option>
              <option value="profile/17.jpg">头像17</option>
              <option value="profile/18.jpg">头像18</option>
              <option value="profile/19.jpg">头像19</option>
              <option value="profile/20.jpg">头像20</option>
            </select>
            <img name="showface" src="profile/1.jpg" width="40" height="40" /></label></td>
        </tr>
        <tr>
          <td>电子邮件：</td>
          <td><label>
            <input name="user.email" type="text" id="title" size="45" />
          </label></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><label>
            <input type="submit" name="button" id="button" value="提交" />
          </label></td>
        </tr>
      </table>
    </form>
  </center>
  </body>
</html>
