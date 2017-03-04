package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java.dao.DBhelper;
import com.java.po.YunshanTopComment;
/**
 * yunshan_top_comment表
 * @author iiip
 *
 */
public class YunshanSqlTopComment {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 根据话题id和情感emoid，获取该话题对应的情感下的评论
	 * @param tid
	 * @param emoid
	 * @return
	 */
	public List<YunshanTopComment>  getTopCommByTid(String tid, String emoid) {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
//		Map<Integer,List<YunshanTopComment>> emoTopCommMap = new HashMap<Integer,List<YunshanTopComment>>();
		List<YunshanTopComment> topCommList = new ArrayList<YunshanTopComment>();

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_top_comment WHERE topic_id = ? AND emotion_id = ? LIMIT 0, 5";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, tid);
			preStmt.setString(2, emoid);
			rs = preStmt.executeQuery();
			while (rs.next()) {
//				List<YunshanTopComment> topCommList = new ArrayList<YunshanTopComment>();
				int commentId = rs.getInt("comment_id");
				int newsId = rs.getInt("news_id");
				String commentContent = rs.getString("comment_content");
				String commentDatetime = rs.getString("comment_datetime");
				int commenGoodNum = rs.getInt("comment_good_number");
				int emotionId = rs.getInt("emotion_id");

				System.out.println("commentId: "+commentId);
				System.out.println("newsId: "+newsId);
				System.out.println("commentContent: "+commentContent);
				System.out.println("commentDatetime: "+commentDatetime);
				System.out.println("commenGoodNum: "+commenGoodNum);
				System.out.println("emotionId: "+emotionId);
				System.out.println();
				YunshanTopComment yunshanTopComment = new YunshanTopComment(commentId, newsId, commentContent, commentDatetime, commenGoodNum, emotionId, Integer.parseInt(tid));
				
				topCommList.add(yunshanTopComment);
//				if(emoTopCommMap.containsKey(emotionId)){
//					emoTopCommMap.get(emotionId).add(yunshanTopComment);
//				}else{
//					emoTopCommMap.put(emotionId, topCommList);
//				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return topCommList;
	}
	
	public static void main(String[] args) {
		new YunshanSqlTopComment().getTopCommByTid("0","0");
	}

}
