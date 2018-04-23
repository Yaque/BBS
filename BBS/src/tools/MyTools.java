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
}
