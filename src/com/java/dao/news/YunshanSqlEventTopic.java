package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.DBhelper;
import com.java.exception.CustomException;
/**
 * yunshan_event_topic_relative 表
 * @author iiip
 *
 */
public class YunshanSqlEventTopic {
	
	private DBhelper dbHelper = new DBhelper();
	
	/**
	 * 根据事件的id获取对应话题的id列表
	 * @param eid 事件id
	 * @return  List<Integer> 
	 * @throws CustomException
	 */
	public List<Integer> getTopicIdByEid(String eid) throws CustomException{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		List<Integer> topicIdLIst = new ArrayList<Integer>();
		try{
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT topic_id FROM yunshan_event_topic_relative WHERE event_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, eid);
			rs = preStmt.executeQuery();
			while(rs.next()){
				int topicId = rs.getInt("topic_id");
				System.out.println(topicId);
				topicIdLIst.add(topicId);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbHelper.closeAll(conn, preStmt, rs);
		}
		if (topicIdLIst.size()==0){
			throw new CustomException("根据事件id找不到话题id");
		}
		return topicIdLIst;
	}
	/**
	 * 根据话题id，找到对应的时间Id列表
	 * @param tid 话题id
	 * @return  List<Integer>
	 * @throws CustomException
	 */
	public List<Integer> getEventIdByTid(String tid) throws CustomException{
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		List<Integer> eventIdList = new ArrayList<Integer>();
		try{
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT event_id FROM yunshan_event_topic_relative WHERE topic_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, tid);
			rs = preStmt.executeQuery();
			while(rs.next()){
				int eventId = rs.getInt("event_id");
				System.out.println(eventId);
				eventIdList.add(eventId);
			}
		}catch(SQLException se){
			se.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			dbHelper.closeAll(conn, preStmt, rs);
		}
		if (eventIdList.size() == 0){
			throw new CustomException("根据话题id找不到事件id");
		}
		return eventIdList;
	}
	
	
	public static void main(String[] args) throws CustomException {
//		new YunshanSqlEventTopic().getTopicIdByEid("0");
		new YunshanSqlEventTopic().getEventIdByTid("0");

	}

}
