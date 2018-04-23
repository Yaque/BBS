package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

import model.Board;
import model.User;
import DAO.BoardDao;
import DAO.UserDao;

public class userInfoAction implements Action {
	
	User user;
	UserDao userDao; 
	private ArrayList<User> userList;
	private String id;
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public UserDao getUserDao() {
		return userDao;
	}
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@SuppressWarnings("unchecked")
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		userDao = new UserDao();
		User sessionUser;
		sessionUser = (User)ActionContext.getContext().getSession().get("user");
		user.setId(sessionUser.getId());
		user.setName(sessionUser.getName());
		userDao.mod(user);
		ActionContext.getContext().getSession().put("user", user);
		return SUCCESS;
	}
	public String list() throws Exception{
		userDao = new UserDao();
		userList = userDao.list();
		return SUCCESS;		
	}
	public String del() throws Exception{
		userDao = new UserDao();
		if (id == null)
		{
			return ERROR;
		}
		user = new User();
		user.setId(Integer.parseInt(id));	
		userDao.del(user);
		return SUCCESS;
	}	
}
