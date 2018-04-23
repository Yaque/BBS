<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form name="form2" method="post" action="modBoard.action">
  <div align="center">
    <table width="600" border="0" align="center">
      <tr>
        <td width="97" >板块名：</td>
        <td width="493"><h4>
        	<input name="board.id" type="hidden" value=<s:property value="board.id"/>></input>
          <label>
            <input name="board.name" type="text" value=<s:property value="board.name"/>>
          </label>
        </h4></td>
      </tr>
      <tr>
        <td>板块描述：</td>
        <td><textarea name="board.content" cols="50" rows="8"><s:property value="board.content"/></textarea></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td><label>
          <input type="submit" name="button" id="button" value="修改">
          <input type="reset" name="button2" id="button2" value="重置">
        </label></td>
      </tr>
    </table>
  </div>
</form>


