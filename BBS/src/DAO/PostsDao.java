package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.Board;
import model.Posts;

public class PostsDao {
	

	public ArrayList<Posts> list(Board board) throws SQLException
	{
		DBConn db = new DBConn();
		String sql = "select id, uid, bid, title, content, publishtime from article where bid = ? order by publishtime desc";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board.getId());
		ResultSet rs = pstmt.executeQuery();
		ArrayList<Posts> postsList = new ArrayList<Posts>();
		while (rs.next())
		{
			Posts posts = new Posts();
			int index = 1;
			posts.setId(rs.getInt(index++));
			posts.setUid(rs.getInt(index++));
			posts.setBid(rs.getInt(index++));
			posts.setTitle(rs.getString(index++));
			posts.setContent(rs.getString(index++));
			posts.setPublishtime(rs.getDate(index++));
			postsList.add(posts);
		}
		sql = "select id, name, content from board where id = ?";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, board.getId());
		rs = pstmt.executeQuery();
		if (rs.next())
		{
			int index = 1;
			board.setId(rs.getInt(index++));
			board.setName(rs.getString(index++));
		}
		db.close();
		if (pstmt != null) pstmt.close();	
		return postsList;
	}

	public Posts postsInfo(Posts posts, model.User user) throws SQLException {
		// TODO Auto-generated method stub
		DBConn db = new DBConn();
		String sql = "select uid, bid, title, content, publishtime from article where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, posts.getId());
		ResultSet rs = pstmt.executeQuery();		
		if (rs.next())
		{
			int index = 1;
			posts.setUid(rs.getInt(index++));
			posts.setBid(rs.getInt(index++));
			posts.setTitle(rs.getString(index++));
			posts.setContent(rs.getString(index++));
			posts.setPublishtime(rs.getDate(index++));
			sql = "select id, name, gender, profile, email, power, bid, reg_date, last_login_date from user where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, posts.getUid());
			rs = pstmt.executeQuery();
			if (rs.next())
			{
				index = 1;
				user.setId(rs.getInt(index++));
				user.setName(rs.getString(index++));
				user.setGender(rs.getBoolean(index++));
				user.setProfile(rs.getString(index++));
				user.setEmail(rs.getString(index++));
				user.setPower(rs.getInt(index++));
				user.setBid(rs.getInt(index++));
				user.setRegDate(rs.getDate(index++));
				user.setLastLoginDate(rs.getDate(index++));
			}
		}
		db.close();
		if (pstmt != null) pstmt.close();	
		return null;
	}
	public void add(Posts posts) throws SQLException
	{
		DBConn db = new DBConn();
		String sql = "insert into article(uid, bid, title, content, publishtime) values(?, ?, ?, ?, ?)";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, posts.getUid());
		pstmt.setInt(index++, posts.getBid());
		pstmt.setString(index++, posts.getTitle());
		pstmt.setString(index++, posts.getContent());
		Date now = new Date();
		pstmt.setTimestamp(index++,  new java.sql.Timestamp(now.getTime()));
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();	
	}

	public void del(int id) throws Exception{
		DBConn db = new DBConn();
		String sql = "delete from article where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();
	}	
}
