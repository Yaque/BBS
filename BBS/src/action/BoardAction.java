package action;

import java.util.ArrayList;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import java.util.Map;
import model.Board;
import DAO.BoardDao;
import tools.MyTools;

public class BoardAction implements Action {

	private BoardDao boardDao;
	private Board board;
	private ArrayList<Board> boardList;
	private String id;
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String add() throws Exception {
		// TODO Auto-generated method stub
		boardDao = new BoardDao();
		boardDao.add(board);
		return SUCCESS;
	}
	
	public String list() throws Exception {
		
		boardDao = new BoardDao();
		boardList = boardDao.list();
		return SUCCESS;
	}
	
	public String info() throws Exception
	{
		boardDao = new BoardDao();
		if (id == null)
		{
			return ERROR;
		}
		board = new Board();
		board.setId(Integer.parseInt(id));	
		board = boardDao.info(board);
		return SUCCESS;
	}
	
	public String mod() throws Exception{
		boardDao = new BoardDao();
		boardDao.mod(board);
		return SUCCESS;
	}
	
	public String del() throws Exception{
		boardDao = new BoardDao();
		if (id == null)
		{
			return ERROR;
		}
		board = new Board();
		board.setId(Integer.parseInt(id));	
		boardDao.del(board);
		return SUCCESS;
	}
}
