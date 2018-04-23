package tools;

import java.io.UnsupportedEncodingException;

public class MyTools {
	public static String toGB(String s) {
		try {
			byte[] b = s.getBytes("ISO-8859-1");
			s = new String(b, "GB2312");
			return s;
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * public void validateAddUser(User user) { if (user != null) { if
	 * (!dataPass(user.getName(), "^[A-Za-z][A-Za-z1-9_-]+$")) {
	 * addFieldError("user.name", "用户名（字母开头 + 数字/字母/下划线）");
	 * 
	 * } if (!dataPass(String.format("%d", user.getAge()),
	 * "(?:[1-9][0-9]?|1[01][0-9]|120)")) { addFieldError("user.name", "年龄0-120之间");
	 * 
	 * } Date startDate = strToDate("1900-01-01"); Date endDate =
	 * strToDate("2017-01-01"); if (user.getBirthDay().before(startDate) ||
	 * user.getBirthDay().after(endDate)) { addFieldError("birthDay",
	 * "出生日期在1900-01-01至2017-01-01之间。");
	 * 
	 * }
	 * 
	 * if (!dataPass(user.getEmail(),
	 * "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$")) {
	 * addFieldError("email", "邮箱格式不符合");
	 * 
	 * } } }
	 * 
	 * private boolean dataPass(String str, String regEx) { Pattern pattern =
	 * Pattern.compile(regEx, Pattern.CASE_INSENSITIVE); Matcher matcher =
	 * pattern.matcher(str); return matcher.matches(); }
	 */
}
