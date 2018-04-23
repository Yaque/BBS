<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>

<form name="form2" method="post" action="addBoard.action">
  <div align="center">
    <table width="470" border="0" align="center">
      <tr>
        <td width="91" height="25">板块名：</td>
        <td width="363"><h4>
          <label>
            <input name="board.name" type="text" id="textfield" size="50">
          </label>
        </h4></td>
      </tr>
      <tr>
        <td height="111">板块描述：</td>
        <td><textarea name="board.content" id="textarea" cols="50" rows="8"></textarea></td>
      </tr>
      <tr>
        <td height="36">&nbsp;</td>
        <td><label>
          <input type="submit" name="button" id="button" value="增加">
          <input type="reset" name="button2" id="button2" value="重置">
        </label></td>
      </tr>
    </table>
  </div>
</form>


