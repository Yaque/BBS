package action;

import java.util.ArrayList;

import model.Board;
import model.Posts;
import model.Reply;
import model.ReplyInfo;
import model.User;

import DAO.BoardDao;
import DAO.ReplyDao;

import DAO.PostsDao;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;

public class MainAction implements Action {

	private ArrayList<Board> boardList;
	private BoardDao boardDao; 
	private PostsDao postsDao; 
	private ArrayList<Posts> postsList;
	private ArrayList<ReplyInfo> replyInfoList;
	private ArrayList<User> userList;
	private String id;
	private Posts posts;
	private User user;
	private ReplyDao replyDao;
	private Reply reply;
	private Board board;
		
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}
	public Reply getReply() {
		return reply;
	}
	public void setReply(Reply reply) {
		this.reply = reply;
	}
	public ArrayList<Board> getBoardList() {
		return boardList;
	}
	public void setBoardList(ArrayList<Board> boardList) {
		this.boardList = boardList;
	}
	public BoardDao getBoardDao() {
		return boardDao;
	}
	public void setBoardDao(BoardDao boardDao) {
		this.boardDao = boardDao;
	}
	public PostsDao getPostsDao() {
		return postsDao;
	}
	public void setPostsDao(PostsDao postsDao) {
		this.postsDao = postsDao;
	}
	public ArrayList<Posts> getPostsList() {
		return postsList;
	}
	public void setPostsList(ArrayList<Posts> postsList) {
		this.postsList = postsList;
	}
	public ArrayList<ReplyInfo> getReplyInfoList() {
		return replyInfoList;
	}
	public void setReplyInfoList(ArrayList<ReplyInfo> replyInfoList) {
		this.replyInfoList = replyInfoList;
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
	public Posts getPosts() {
		return posts;
	}
	public void setPosts(Posts posts) {
		this.posts = posts;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public ReplyDao getReplyDao() {
		return replyDao;
	}
	public void setReplyDao(ReplyDao replyDao) {
		this.replyDao = replyDao;
	}
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	@SuppressWarnings("unchecked")
	public String boardList() throws Exception{
		boardDao = new BoardDao();
		boardList = boardDao.list();
		ActionContext.getContext().getSession().put("board", null);
		return SUCCESS;
	}
	@SuppressWarnings("unchecked")
	public String postsList() throws Exception{
		postsDao = new PostsDao();
		board = new Board();
		board.setId(Integer.parseInt(id));
		postsList = postsDao.list(board);
		if (board.getName() != null)
		{
			ActionContext.getContext().getSession().put("board", board);
		}
		return SUCCESS;
	}
	public String postsInfo() throws Exception{
		postsDao = new PostsDao();
		posts = new Posts();
		user = new User();
		userList = new ArrayList<User>();
		posts.setId(Integer.parseInt(id));
		postsDao.postsInfo(posts, user);
		replyDao = new ReplyDao();
		replyInfoList = replyDao.list(posts.getId());
		return SUCCESS;
	}
	public String addReply() throws Exception{
		replyDao = new ReplyDao();
		replyDao.add(reply);		
		id = String.valueOf(reply.getAid());
		postsInfo();
		return SUCCESS;
	}
	public String addPosts() throws Exception{
		postsDao = new PostsDao();
		postsDao.add(posts);	
		return SUCCESS;
	}
	public String delPosts() throws Exception{
		postsDao = new PostsDao();
		if (id != null)
		{
			postsDao.del(Integer.parseInt(id));
		}
		return SUCCESS;
	}
	public String delReply() throws Exception{
		replyDao = new ReplyDao();
		int aid = replyDao.queryAid(Integer.parseInt(id));
		if (id != null)
		{
			replyDao.del(Integer.parseInt(id));
		}
		id = String.valueOf(aid);
		postsInfo();
		return SUCCESS;
	}	
}
