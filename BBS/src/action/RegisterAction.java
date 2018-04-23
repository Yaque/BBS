package action;

import java.util.Date;

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

	public String doDefault() throws Exception
	{
		return INPUT;
	}
	
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		user.setRegDate(new Date());
		if (userDao.register(user) == null)
		{
			errmsg = "该昵称已被使用，请换一个昵称";
			return NONE;
		}
		return SUCCESS;
	}

}
