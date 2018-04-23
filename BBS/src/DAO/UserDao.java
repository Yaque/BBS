package DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

import model.User;

public class UserDao {
	public User register(User user) throws SQLException
	{
		DBConn db = new DBConn();
		String sql = "select name from user where name = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
		{
			rs.close();
			pstmt.close();
			db.close();
			return null;
		}
		sql = "insert into user(name, password, gender, email, " +
		"power, profile, bid, reg_date" + 
		") " + 
		"values(?,?,?,?,?,?,?,?)";
		pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setString(index++, user.getName());
		pstmt.setString(index++, user.getPassword());
		pstmt.setBoolean(index++, user.getGender());
		pstmt.setString(index++, user.getEmail());
		pstmt.setInt(index++, 1);
		pstmt.setString(index++, user.getProfile());
		pstmt.setInt(index++, 0);
		pstmt.setTimestamp(index++, new java.sql.Timestamp(user.getRegDate().getTime()));
		pstmt.execute();
		
		db.close();
		if (pstmt != null) pstmt.close();
		return user;		
	}
	
	public User login(User user) throws SQLException
	{
		User result = null;
		DBConn db = new DBConn();
		String sql = "select id, name, gender, profile, email, power, bid, reg_date," + 
		             " last_login_date from user where name = ? and password = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user.getName());
		pstmt.setString(2, user.getPassword());
		ResultSet rs = pstmt.executeQuery();
		if (rs.next())
		{
			int index = 1;	
			result = new User();
			result.setId(rs.getInt(index++));
			result.setName(rs.getString(index++));
			result.setGender(rs.getBoolean(index++));
			result.setProfile(rs.getString(index++));
			result.setEmail(rs.getString(index++));
			result.setPower(rs.getInt(index++));
			result.setBid(rs.getInt(index++));
			result.setRegDate(rs.getDate(index++));
			result.setLastLoginDate(rs.getDate(index++));
			pstmt = conn.prepareStatement("update user set last_login_date=? where id=?");
			Date now = new Date();
			result.setLastLoginDate(now);
			pstmt.setTimestamp(1, new java.sql.Timestamp(now.getTime()));
			pstmt.setInt(2, result.getId());
			pstmt.execute();
		}
		
		db.close();
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();	
		return result;
	}
	public void mod(User user) throws SQLException
	{
		DBConn db = new DBConn();
		String sql = "update user set password = ?, gender = ?, email = ?, profile = ? where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, user.getPassword());
		pstmt.setBoolean(index++, user.getGender());
		pstmt.setString(index++, user.getEmail());
		pstmt.setString(index++, user.getProfile());
		pstmt.setInt(index++, user.getId());
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();	
	}
	public ArrayList<User> list() throws SQLException
	{
		DBConn db = new DBConn();
		String sql = "select id, name from user";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<User> boardList = new ArrayList<User>();
		while (rs.next())
		{
			User user = new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			boardList.add(user);
		}
		db.close();
		if (pstmt != null) pstmt.close();	
		return boardList;
	}	
	public void del(User user) throws Exception{
		DBConn db = new DBConn();
		String sql = "delete from user where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, user.getId());
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();
	}		
}