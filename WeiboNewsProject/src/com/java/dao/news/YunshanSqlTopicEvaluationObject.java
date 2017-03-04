package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.DBhelper;
/**
 * yunshan_topic_evaluation_object_relative表
 * @author iiip
 *
 */
public class YunshanSqlTopicEvaluationObject {
	
	private DBhelper dbHelper = new DBhelper();

	/**
	 * 根据话题的id，获取对应评价对象的id列表
	 * @param tid
	 * @return  List<Integer>
	 */
	public List<Integer> getEvaluationObjIdByTid(String tid){
		
		List<Integer> evaluObjIdList = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT evaluation_object_id FROM yunshan_topic_evaluation_object_relative WHERE topic_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, tid);
			rs = preStmt.executeQuery();
			while (rs.next()){
			int evaluObjId = rs.getInt("evaluation_object_id");
			System.out.println(evaluObjId);
			evaluObjIdList.add(evaluObjId);
			}
//			System.out.println(evaluObjIdList);
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return evaluObjIdList;
	}
	
	public static void main(String[] args) {
		new YunshanSqlTopicEvaluationObject().getEvaluationObjIdByTid("0");
	}

}
