<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form name="form2" method="post" action="">
  <table width="577" border="0" align="center">
    <s:iterator value="userList" status="status">
    <tr>  
      <td><s:property value="name"/></td>
      <td><a href=<s:url action="delUser"><s:param name="id" value="id"/></s:url>>删除</a></td>
    </tr>
    </s:iterator>    
  </table>
</form>


