<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form name="form2" method="post" action="">
  <table width="650" border="0" align="center">
    <tr>
      <td >板块名：</td>
      <td >板块描述</td>
      <td >&nbsp;</td>
      <td >&nbsp;</td>
    </tr>
    <s:iterator value="boardList" status="status">
    <tr>  
      <td><s:property value="name"/></td>
      <td><s:property value="content"/></td>
      <td><a href=<s:url action="boardInfo"><s:param name="id" value="id"/></s:url>>修改</a></td>
      <td><a href=<s:url action="delBoard"><s:param name="id" value="id"/></s:url>>删除</a></td>
    </tr>
    </s:iterator>    
  </table>
</form>


