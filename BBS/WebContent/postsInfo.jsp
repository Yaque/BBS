<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

  <form name="form1" method="post" action="addReply.action">
  <table width="844" border="1" align="center">
    <tr>
    	<td colspan="2">
    	<center><H3><s:property value="posts.title"/></H3></center>
        </td>
    </tr>
    <tr>
      <td width="181">
      <center>
      <img name="showface" src=<s:property value="user.profile"/> width="40" height="40" /><br>
       昵称：<s:property value="user.name"/><br>
       性别：
      <s:if test="user.gender">帅哥</s:if>
      <s:else>美女</s:else><br>
      <s:if test="user.power < 2">会员</s:if>
      <s:else>管理员</s:else><br>
      Email：<s:property value="user.email"/><br>
       注册日期：<s:property value="user.regDate"/><br>
       最后登录日期：<s:property value="user.lastLoginDate"/>
      </center>
      </td>
      <td width="647">
      <div id="postmessage_39197" class="t_msgfont"><s:property value="posts.content"/></div>
      </td>
    </tr>
      <s:if test="#session.user.power == 2">
      <tr><td>&nbsp;</td><td>
        <a href=<s:url action="delPosts"><s:param name="id" value="posts.id"/></s:url>>删除该帖子</a>
      </td></tr>        
      </s:if>    
    <s:iterator value="replyInfoList">
    <tr>      
      <td width="181">
      <center>
	      <img name="showface" src=<s:property value="user.profile"/> width="40" height="40" /><br>
	       昵称：<s:property value="user.name"/><br>
	       性别：
	      <s:if test="user.gender">帅哥</s:if>
	      <s:else>美女</s:else><br>
	      <s:if test="user.power < 2">会员</s:if>
	      <s:else>管理员</s:else><br>
	      Email：<s:property value="user.email"/><br>
	       注册日期：<s:property value="user.regDate"/><br>
	       最后登录日期：<s:property value="user.lastLoginDate"/>
      </center>
      </td>
      <td width="647">
      <div><s:property value="reply.content"/></div>     
      </td>
    </tr>
       <s:if test="#session.user.power == 2">
      <tr><td>&nbsp;</td><td>
        <a href=<s:url action="delReply"><s:param name="id" value="reply.id"/></s:url>>删除该回复</a>
      </td></tr>        
      </s:if> 
    </s:iterator>
    <s:if test="#session.user.id != null">
    <tr>
    <td rowspan="2">&nbsp;</td>
    <td>
    <center>
    	<input type="hidden" name="reply.uid" value=<s:property value="#session.user.id"/>>
    	<input type="hidden" name="reply.aid" value=<s:property value="posts.id"/>>
        <textarea name="reply.content" id="textarea" cols="50" rows="8"></textarea>
    </center>
    </td>
    </tr>
    <tr>
      <td>
      <center>
        <input type="submit" name="button" id="button" value="回复" />
      </center>
      </td>
    </tr>   
    </s:if> 
  </table>
  </form>


