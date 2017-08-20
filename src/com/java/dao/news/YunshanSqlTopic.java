package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.DBhelper;
import com.java.exception.CustomException;
import com.java.po.YunshanTopic;
/**
 * yunshan_topic表
 * @author iiip
 *
 */
public class YunshanSqlTopic {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 获取全部topic列表
	 * @return List<YunshanTopic> YunshanTopic
	 */
	public List<YunshanTopic> getTopicInfo() {

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		ArrayList<YunshanTopic> yunshanTopicList = new ArrayList<YunshanTopic>();

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_topic";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int topicId = rs.getInt("topic_id");
				String topicSummary = rs.getString("topic_summary");
				float topicHotWeight = rs.getFloat("topic_hot_weight");
				String topicName = rs.getString("topic_name");
				boolean isHot = (rs.getInt("is_hot") > 0);
				String topicDatetime = rs.getString("topic_datetime");
				String topicImageUrl = rs.getString("topic_img_url");


				System.out.println("topicId: " + topicId);
				System.out.println("topicSummary: " + topicSummary);
				System.out.println("topicHotWeight: " + topicHotWeight);
				System.out.println("isHot: " + isHot);
				System.out.println("topicDatetime: " + topicDatetime);
				System.out.println("topicImageUrl: " +topicImageUrl);

				yunshanTopicList.add(new YunshanTopic(topicId, topicSummary,
						topicHotWeight, topicName, isHot, topicDatetime,topicImageUrl));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return yunshanTopicList;
	}

	/**
	 * 根据话题id 找到话题
	 * @param tid 话题id
	 * @return YunshanTopic
	 * @throws CustomException
	 */
	public YunshanTopic selectTopicByTid(String tid) throws CustomException {
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		YunshanTopic topic = null;

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_topic WHERE topic_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, tid);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int topicId = rs.getInt("topic_id");
				String topicSummary = rs.getString("topic_summary");
				float topicHotWeight = rs.getFloat("topic_hot_weight");
				String topicName = rs.getString("topic_name");
				boolean isHot = (rs.getInt("is_hot") > 0);
				String topicDatetime = rs.getString("topic_datetime");
				String topicImageUrl = rs.getString("topic_img_url");

				System.out.println("topicId: " + topicId);
				System.out.println("topicSummary: " + topicSummary);
				System.out.println("topicHotWeight: " + topicHotWeight);
				System.out.println("topicName: " + topicName);
				System.out.println("isHot: " + isHot);
				System.out.println("topicDatetime: " + topicDatetime);
				System.out.println("topicImageUrl: " +topicImageUrl);

				topic = new YunshanTopic(topicId, topicSummary, topicHotWeight,
						topicName, isHot, topicDatetime,topicImageUrl);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		if (topic == null) {
			throw new CustomException("查询的话题id不存在");
		}
		return topic;

	}
	
	/**
	 * 根据话题id列表 返回话题列表
	 * @param topicList
	 * @return List<YunshanTopic>
	 */
	public List<YunshanTopic> selectTopicByTidList(List<Integer> topicList){
		
		List<YunshanTopic> yunshanTopicList = new ArrayList<YunshanTopic>();
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < topicList.size(); i++) {
			sb.append("?,");
		}
		sb.append("?");
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_topic WHERE topic_id in ("+sb.toString()+") ORDER BY topic_datetime ASC";
			preStmt = conn.prepareStatement(sql);
			for (int i = 0; i < topicList.size(); i++){
				preStmt.setInt(i+1, topicList.get(i));
			}
			rs = preStmt.executeQuery();
			while(rs.next()){
				int topicId = rs.getInt("topic_id");
				String topicSummary = rs.getString("topic_summary");
				float topicHotWeight = rs.getFloat("topic_hot_weight");
				String topicName = rs.getString("topic_name");
				boolean isHot = (rs.getInt("is_hot") > 0);
				String topicDatetime = rs.getDate("topic_datetime").toString();
				String topicImageUrl = rs.getString("topic_img_url");

				System.out.println("topicId: " + topicId);
				System.out.println("topicSummary: " + topicSummary);
				System.out.println("topicHotWeight: " + topicHotWeight);
				System.out.println("topicName: " + topicName);
				System.out.println("isHot: " + isHot);
//				System.out.println("topicDatetime: " +  rs.getDate("topic_datetime"));
				System.out.println("topicDatetime: " + topicDatetime);

				System.out.println("topicImageUrl: " +topicImageUrl);

				yunshanTopicList.add(new YunshanTopic(topicId, topicSummary, topicHotWeight, topicName, isHot, topicDatetime,topicImageUrl));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			dbHelper.closeAll(conn, preStmt, rs);
			
		}
		return yunshanTopicList;
		
	}
	

	public static void main(String[] args) throws CustomException {
//		new YunshanSqlTopic().getTopicInfo();
//		 new YunshanSqlTopic().selectTopicByTid("0");
		List<Integer> topicIdList = new ArrayList<Integer>();
		topicIdList.add(153903);
		topicIdList.add(168942);
		topicIdList.add(171464);
		topicIdList.add(0);

		 new YunshanSqlTopic().selectTopicByTidList(topicIdList);

		
		 
	}
}
