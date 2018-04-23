<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<s:if test="#session.board == null">
	非法的请求
</s:if>
<s:else>
  <form name="form1" method="post" action="addPosts.action">
 	<input type="hidden" name="posts.uid" value=<s:property value="#session.user.id"/>>
 	<input type="hidden" name="posts.bid" value=<s:property value="#session.board.id"/>>  
  <table width="844" border="1" align="center">
    <tr>
      <td> 
      标题：         
      </td>      
      <td>
      <input type="text" name="posts.title" size="64">
      </td>
    </tr>
    <tr>
      <td>
      内容
      </td>
      <td>
      <textarea name="posts.content" id="textarea" cols="50" rows="8"></textarea>
      </td>
    </tr>
    <tr>
    <td></td><td>
     <input type="submit" name="button" id="button" value="发表" /></td>
    </tr>
  </table>
  </form>
</s:else>

