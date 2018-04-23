package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import model.ReplyInfo;
import model.User;

import com.opensymphony.xwork2.Action;
import model.Reply;

public class ReplyDao implements Action {

	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public ArrayList<ReplyInfo> list(int aid) throws SQLException
	{
		DBConn db = new DBConn();
		String sql = "select id, uid, aid, content, publishtime from reply where aid = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, aid);
		ResultSet rs = pstmt.executeQuery();
		ArrayList<ReplyInfo> replyInfoList = new ArrayList<ReplyInfo>();
		while (rs.next())
		{
			ReplyInfo replyInfo = new ReplyInfo();
			Reply reply = new Reply();
			int index = 1;
			reply.setId(rs.getInt(index++));
			reply.setUid(rs.getInt(index++));
			reply.setAid(rs.getInt(index++));
			reply.setContent(rs.getString(index++));
			reply.setPublishtime(rs.getDate(index++));
			sql = "select id, name, gender, profile, email, power, bid, reg_date, last_login_date from user where id = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reply.getUid());
			ResultSet userrs = pstmt.executeQuery();
			User user = new User();
			if (userrs.next())
			{
				index = 1;
				user.setId(userrs.getInt(index++));
				user.setName(userrs.getString(index++));
				user.setGender(userrs.getBoolean(index++));
				user.setProfile(userrs.getString(index++));
				user.setEmail(userrs.getString(index++));
				user.setPower(userrs.getInt(index++));
				user.setBid(userrs.getInt(index++));
				user.setRegDate(userrs.getDate(index++));
				user.setLastLoginDate(userrs.getDate(index++));
				replyInfo.reply = reply;
				replyInfo.user = user;
				replyInfoList.add(replyInfo);
			}
		}
		db.close();
		if (pstmt != null) pstmt.close();	
		return replyInfoList;
	}
	public void add(Reply reply) throws Exception {		
		DBConn db = new DBConn();
		String sql = "insert into reply(uid, aid, content, publishtime) values(?, ?, ?, ?)";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, reply.getUid());
		pstmt.setInt(2, reply.getAid());
		pstmt.setString(3, reply.getContent());
		Date now = new Date();
		pstmt.setTimestamp(4,  new java.sql.Timestamp(now.getTime()));
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();	
	}
	public void del(int id) throws Exception{
		DBConn db = new DBConn();
		String sql = "delete from reply where id = ?";
		Connection conn = db.getCon();
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.execute();
		db.close();
		if (pstmt != null) pstmt.close();
	}
	
	public int queryAid(int id) throws Exception{
		    int aid = 0;;
			DBConn db = new DBConn();
			String sql = "select aid from reply where id = ?";
			Connection conn = db.getCon();
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next())
			{
				aid = rs.getInt(1);
			}
			db.close();
			if (pstmt != null) pstmt.close();
			return aid;
		}
}
