package action;

import model.User;
import DAO.UserDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class LoginAction implements Action{

	private User user;
	private UserDao userDao;
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		userDao = new UserDao();
		user = userDao.login(user);
		if (user != null) {
			ActionContext.getContext().getSession().put("user", user);
			return SUCCESS;
		}
		else {
			return ERROR;
		}
	}
	
	@SuppressWarnings("unchecked")
	public String logout() throws Exception {
		ActionContext.getContext().getSession().put("user", null);
		return SUCCESS;
	}
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
}
