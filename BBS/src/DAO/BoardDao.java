package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Board;

public class BoardDao {

	public void add(Board board) throws SQLException {
		DBConn db = new DBConn();
		String sql = "insert into board(name, content) values(?, ?)";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getName());
		pstmt.setString(2, board.getContent());
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();	
	}
	
	public ArrayList<Board> list() throws SQLException {
		DBConn db = new DBConn();
		String sql = "select id, name, content from board";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Board> boardList = new ArrayList<Board>();
		while (rs.next()) {
			Board board = new Board();
			board.setId(rs.getInt(1));
			board.setName(rs.getString(2));
			board.setContent(rs.getString(3));
			boardList.add(board);
		}
		db.close();
		if (pstmt != null) pstmt.close();	
		return boardList;
	}
	public Board info(Board board) throws Exception {
		DBConn db = new DBConn();
		String sql = "select id, name, content from board where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board.getId());
		ResultSet rs = pstmt.executeQuery();
		Board result = null;
		if (rs.next())
		{
			result = new Board();
			result.setId(rs.getInt(1));
			result.setName(rs.getString(2));
			result.setContent(rs.getString(3));
		}
		db.close();
		if (pstmt != null) pstmt.close();
		return result;
	}

	public void mod(Board board) throws Exception {
		DBConn db = new DBConn();
		String sql = "update board set name = ?, content = ? where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, board.getName());
		pstmt.setString(2, board.getContent());
		pstmt.setInt(3, board.getId());
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();
	}
	public void del(Board board) throws Exception {
		DBConn db = new DBConn();
		String sql = "delete from board where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board.getId());
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();
	}	
}
