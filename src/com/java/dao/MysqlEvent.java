package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.exception.CustomException;
import com.java.po.Event;

public class MysqlEvent {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 获取全部event信息
	 * 
	 * @return
	 */
	public List<Event> getEventInfo() {
		List<Event> eventList = new ArrayList<Event>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbHelper.getConnection();
			String sql = "SELECT * FROM event";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			System.out.println(rs);
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				String eventTitle  = rs.getString("event_title");
				String explosionTime = rs.getString("explosion_time");
				String keyWord = rs.getString("key_words");
				int totalLikeNum = rs.getInt("total_like_num");
				int totalCommentNum = rs.getInt("total_comment_num");
				int totalRepostNum = rs.getInt("total_repost_num");

				System.out.println("eventId: " + eventId);
				System.out.println("eventTitle: " + eventTitle);
				System.out.println("explosionTime: " + explosionTime);
				System.out.println("keyWord: " + keyWord);
				System.out.println("totalLikeNum:" + totalLikeNum);
				System.out.println("totalCommentNum:" + totalCommentNum);
				System.out.println("totalRepostNum:" + totalRepostNum);
				eventList.add(new Event(eventId,eventTitle,explosionTime,keyWord,totalLikeNum,totalCommentNum,totalRepostNum));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return eventList;
	}
	
	public List<Event> getEventInfoByKW(String content) {

		List<Event> eventList = new ArrayList<Event>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbHelper.getConnection();
			String sql = "SELECT * FROM event WHERE key_words LIKE ? LIMIT 0 , 10";
			 preStmt = conn.prepareStatement(sql);
			 
			 preStmt.setString(1, "%"+content+"%");
			 System.out.println(content);
			 rs = preStmt.executeQuery();
			 System.out.println(preStmt.toString());

			while (rs.next()) {

				int eventId = rs.getInt("event_id");
				String eventTitle  = rs.getString("event_title");
				String explosionTime = rs.getString("explosion_time");
				String keyWord = rs.getString("key_words");
				int totalLikeNum = rs.getInt("total_like_num");
				int totalCommentNum = rs.getInt("total_comment_num");
				int totalRepostNum = rs.getInt("total_repost_num");

				System.out.println("eventId: " + eventId);
				System.out.println("eventTitle: " + eventTitle);
				System.out.println("explosionTime: " + explosionTime);
				System.out.println("keyWord: " + keyWord);
				System.out.println("totalLikeNum:" + totalLikeNum);
				System.out.println("totalCommentNum:" + totalCommentNum);
				System.out.println("totalRepostNum:" + totalRepostNum);
				eventList.add(new Event(eventId,eventTitle,explosionTime,keyWord,totalLikeNum,totalCommentNum,totalRepostNum));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return eventList;
	}

	/**
	 * 根据id查找到事件
	 * @param eid 事件id
	 * @return
	 */
	public Event selectEventByEid(String eid) throws Exception{
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		Event event = null;
		System.out.println(eid);
		try {
			conn = dbHelper.getConnection();
			String sql = "SELECT * FROM event WHERE event_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, eid);
			rs = preStmt.executeQuery();
			
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				String eventTitle  = rs.getString("event_title");
				String explosionTime = rs.getString("explosion_time");
				String keyWord = rs.getString("key_words");
				int totalLikeNum = rs.getInt("total_like_num");
				int totalCommentNum = rs.getInt("total_comment_num");
				int totalRepostNum = rs.getInt("total_repost_num");

				System.out.println("eventId: " + eventId);
				System.out.println("eventTitle: " + eventTitle);
				System.out.println("explosionTime: " + explosionTime);
				System.out.println("keyWord: " + keyWord);
				System.out.println("totalLikeNum:" + totalLikeNum);
				System.out.println("totalCommentNum:" + totalCommentNum);
				System.out.println("totalRepostNum:" + totalRepostNum);
				event = new Event(eventId,eventTitle,explosionTime,keyWord,totalLikeNum,totalCommentNum,totalRepostNum);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		
		if(event == null){
			throw new CustomException("查询的事件id不存在");
		}
		
		return event;
	}

	public static void main(String[] args) {
		new MysqlEvent().getEventInfoByKW("林丹");
	}
}
