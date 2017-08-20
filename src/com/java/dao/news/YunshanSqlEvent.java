package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.DBhelper;
import com.java.exception.CustomException;
import com.java.po.YunshanEvent;
/**
 * yunshanevent表
 * @author iiip
 *
 */
public class YunshanSqlEvent {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 获取全部yunshan_event信息
	 * 
	 * @return List<YunshanEvent>
	 */
	public List<YunshanEvent> getYunEventInfo() {
		List<YunshanEvent> eventList = new ArrayList<YunshanEvent>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_event";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
//			System.out.println(rs);
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				String eventName  = rs.getString("event_name");
				String eventDatetime = rs.getString("event_datetime");
				String eventSummary = rs.getString("event_summary");
				String eventImageUrl = rs.getString("event_img_url");

				System.out.println("eventId: " + eventId);
				System.out.println("eventName: " + eventName);
				System.out.println("eventDatetime: " + eventDatetime);
				System.out.println("evenSummary: " + eventSummary);
				System.out.println("eventImageUrl: " + eventImageUrl);

				int generalNameId = new YunshanSqlEventGeneral().getEventGeneralByEid(eventId);
				String generalName = YunshanSqlEventGeneral.generalMap.get(generalNameId);
				eventList.add(new YunshanEvent(eventId, eventName, eventDatetime, eventSummary,generalName,eventImageUrl));
				
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
	 * @return YunshanEvent
	 */
	public YunshanEvent selectYunEventByEid(String eid) throws Exception{
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		YunshanEvent event = null;
		System.out.println(eid);
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_event WHERE event_id = ?";
			
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, eid);
			rs = preStmt.executeQuery();
			while(rs.next()){
				int eventId = rs.getInt("event_id");
				String eventName = rs.getString("event_name");
				String eventDatetime = rs.getString("event_datetime");
				String eventSummary = rs.getString("event_summary");
				String eventImageUrl = rs.getString("event_img_url");

				System.out.println(eventId);
				System.out.println(eventName);
				System.out.println(eventDatetime);
				System.out.println(eventSummary);
				System.out.println("eventImageUrl: " + eventImageUrl);

				int generalNameId = new YunshanSqlEventGeneral().getEventGeneralByEid(eventId);
				String generalName = YunshanSqlEventGeneral.generalMap.get(generalNameId);
				
				event = new YunshanEvent(eventId, eventName, eventDatetime, eventSummary,generalName,eventImageUrl);

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
	
	/**
	 * 根据搜索的关键内容，找到 yunshan_event信息
	 * 
	 * @return List<YunshanEvent>
	 */
	public List<YunshanEvent> getYunEventListByKw(String content) {
		List<YunshanEvent> eventList = new ArrayList<YunshanEvent>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbHelper.getYunshanConnection();
//			 String sql = "SELECT * FROM yunshan_event WHERE event_summary LIKE ?";
			String sql = "SELECT * FROM yunshan_event WHERE event_summary LIKE ? LIMIT 0 , 10";
			 preStmt = conn.prepareStatement(sql);
			 
			 preStmt.setString(1, "%"+content+"%");
			 System.out.println(content);
			 rs = preStmt.executeQuery();
			 System.out.println(preStmt.toString());

			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				String eventName  = rs.getString("event_name");
				String eventDatetime = rs.getString("event_datetime");
				String eventSummary = rs.getString("event_summary");
				String eventImageUrl = rs.getString("event_img_url");

				System.out.println("eventId: " + eventId);
				System.out.println("eventName: " + eventName);
				System.out.println("eventDatetime: " + eventDatetime);
				System.out.println("evenSummary: " + eventSummary);
				System.out.println("eventImageUrl: " + eventImageUrl);

				int generalNameId = new YunshanSqlEventGeneral().getEventGeneralByEid(eventId);
				String generalName = YunshanSqlEventGeneral.generalMap.get(generalNameId);
				eventList.add(new YunshanEvent(eventId, eventName, eventDatetime, eventSummary,generalName,eventImageUrl));
				
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
	

	public static void main(String[] args) throws Exception {
//		new YunshanSqlEvent().getYunEventInfo();
//		new YunshanSqlEvent().selectYunEventByEid("0");
		
		new YunshanSqlEvent().getYunEventListByKw("林丹");
	}
}

