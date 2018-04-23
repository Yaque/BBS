package action;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.opensymphony.xwork2.ActionSupport;

import DAO.UserDao;
import model.User;

public class RegisterAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private User user;
	private UserDao userDao;
	private String errmsg;

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RegisterAction() {
		userDao = new UserDao();
	}

	public String doDefault() throws Exception {
		return INPUT;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user.setRegDate(new Date());
		if (this.hasFieldErrors()) {
			return "input";
		}
		if (userDao.register(user) == null) {
			errmsg = "���ǳ��ѱ�ʹ�ã��뻻һ���ǳ�";
			return NONE;
		}
		return SUCCESS;
	}

	@Override
	public void validate() {
		if (user != null) {
			if (!dataPass(user.getName(), "^[A-Za-z][A-Za-z1-9_-]+$")) {
				addFieldError("user.name", "�û�������ĸ��ͷ + ����/��ĸ/�»��ߣ�");

			}

			if (!dataPass(user.getPassword(), "^[A-Za-z][A-Za-z1-9_-]+$")) {
				addFieldError("user.password", "���루��ĸ��ͷ + ����/��ĸ/�»��ߣ�");
			}

			if (!dataPass(user.getEmail(), "^[a-zA-Z_]{1,}[0-9]{0,}@(([a-zA-z0-9]-*){1,}\\.){1,3}[a-zA-z\\-]{1,}$")) {
				addFieldError("user.email", "�����ʽ������");
			}
		}
	}

	private boolean dataPass(String str, String regEx) {
		Pattern pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}

}
