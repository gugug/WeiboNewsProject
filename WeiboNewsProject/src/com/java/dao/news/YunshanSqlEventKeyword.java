package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.java.dao.DBhelper;
/**
 * yunshan_event_keyword_relative 表
 * @author iiip
 *
 */
public class YunshanSqlEventKeyword {
	private DBhelper dbHelper = new DBhelper();

	/**
	 * 根据事件id获取关键词的id和关键词的词重
	 * @param eid
	 * @return  Map<Integer,Float> wordIdWeightMap
	 */
	public Map<Integer,Float>  getEventKwIdByEid(String eid) {

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
//		List<EventKeyword> eventKeywordList = new ArrayList<EventKeyword>();
		Map<Integer,Float> wordIdWeightMap = new HashMap<Integer,Float>();
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_event_keyword_relative WHERE event_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, eid);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int wordId = rs.getInt("word_id");
				float weight = rs.getFloat("weight");
				System.out.println(wordId);
				System.out.println(weight);
				wordIdWeightMap.put(wordId, weight);
//				eventKeywordList.add(new EventKeyword(wordId, weight));
			}
//			System.out.println(wordIdWeightMap);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
	
		return wordIdWeightMap;
	}
	
	public static void main(String[] args) {
		Map<Integer, Float> eventKwId = new YunshanSqlEventKeyword().getEventKwIdByEid("0");
		 for (Map.Entry<Integer, Float> m :eventKwId.entrySet())  {  
	            System.out.println(m.getKey()+"\t"+m.getValue());  
	        }  
	}
}
