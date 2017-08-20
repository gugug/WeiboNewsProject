package com.java.dao.news;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;
import com.java.dao.DBhelper;
import com.java.po.YunshanEmoCommNumWithTime;
import com.java.po.YunshanEmotionPercent;
import com.java.po.YunshanTopicCommNum;

/**
 * yunshan_comment_num表
 * @author iiip
 *
 */
public class YunshanSqlCommentNum {
	private DBhelper dbHelper = new DBhelper();


	/**
	 * 根据事件对应的全部话题id，获取该事件对应的情感的比例
	 * @param topicIdList
	 * @return List<YunshanEmotionPercent>
	 */
	public List<YunshanEmotionPercent> getAllCommentNumByTopicList(List<Integer> topicIdList){
			float emo0 = 0;
			float emo1 = 0;
			float emo2 = 0;
			float emo3 = 0;
			float emo4 = 0;
			float emo5 = 0;
			float emo6 = 0;
			float emo7 = 0;

			List<YunshanEmotionPercent> commentNumList = new ArrayList<YunshanEmotionPercent>();

			Connection conn = null;
			PreparedStatement preStmt = null;
			ResultSet rs = null;
			StringBuffer sb = new StringBuffer();
			for (int i = 1; i < topicIdList.size(); i++) {
				sb.append("?,");
			}
			sb.append("?");
			try {
				conn = dbHelper.getYunshanConnection();
				String sql = "SELECT * FROM yunshan_comment_num WHERE topic_id in ("
						+ sb.toString() + ")";
				preStmt = conn.prepareStatement(sql);
				for (int i = 0; i < topicIdList.size(); i++) {
					preStmt.setInt(i + 1, topicIdList.get(i));
				}
				rs = preStmt.executeQuery();
				while (rs.next()) {
					float num0 = rs.getInt("emotion0");
					float num1 = rs.getInt("emotion1");
					float num2 = rs.getInt("emotion2");
					float num3 = rs.getInt("emotion3");
					float num4 = rs.getInt("emotion4");
					float num5 = rs.getInt("emotion5");
					float num6 = rs.getInt("emotion6");
					float num7 = rs.getInt("emotion7");

					emo0 += num0;
					emo1 += num1;
					emo2 += num2;
					emo3 += num3;
					emo4 += num4;
					emo5 += num5;
					emo6 += num6;
					emo7 += num7;
				}
				
				//情绪比例
				float allSum = emo0+emo1+emo2+emo3+emo4+emo5+emo6+emo7;
				commentNumList.add(new YunshanEmotionPercent(0, "愉快",(float)(Math.round(emo0/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(1, "悲伤",(float)(Math.round(emo1/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(2, "愤怒",(float)(Math.round(emo2/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(3, "焦虑",(float)(Math.round(emo3/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(4, "同情",(float)(Math.round(emo4/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(5, "喜欢",(float)(Math.round(emo5/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(6, "厌恶",(float)(Math.round(emo6/allSum*100))/100 ));
				commentNumList.add(new YunshanEmotionPercent(7, "怨恨",(float)(Math.round(emo7/allSum*100))/100 ));

				System.out.println("情绪总数: " + JSON.toJSONString(commentNumList));
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				dbHelper.closeAll(conn, preStmt, rs);

			}
			return commentNumList;

		}
	
	/**
	 * 根据话题id ， 获取该话题每个时间段的评论数量
	 * @param topicId
	 * @return YunshanTopicCommNum
	 */
	public YunshanTopicCommNum getCommentNumByTid(String topicId){
	

		YunshanTopicCommNum commentNum = null;
		List<String> date = new ArrayList<String>();
		List<Integer> number = new ArrayList<Integer>();
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_comment_num WHERE topic_id = ?";//ORDER BY trend_id ASC
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1,topicId);
			rs = preStmt.executeQuery();
			
			while (rs.next()) {
				int num0 = rs.getInt("emotion0");
				int num1 = rs.getInt("emotion1");
				int num2 = rs.getInt("emotion2");
				int num3 = rs.getInt("emotion3");
				int num4 = rs.getInt("emotion4");
				int num5 = rs.getInt("emotion5");
				int num6 = rs.getInt("emotion6");
				int num7 = rs.getInt("emotion7");
				String startTime = rs.getDate("start_time").toString();
				System.out.println("startTime"+startTime);
				
				
				int allNum = num0+num1+num2+num3+num4+num5+num6+num7;
				number.add(allNum);
				date.add(startTime);
			}
			commentNum = new YunshanTopicCommNum(date, number);
//			System.out.println(JSON.toJSON(commentNum));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);

		}
		return commentNum;

	}
	
	/**
	 * 根据话题id，获取该话题的情感的评论量变化，根据时间划分，共8个情感
	 * @param tid
	 * @return YunshanEmoCommNumWithTime
	 */
	public YunshanEmoCommNumWithTime getEmoCommNumWithTimeByTid(String tid){
		List<Integer> commList0 = new ArrayList<Integer>();
		List<Integer> commList1 = new ArrayList<Integer>();
		List<Integer> commList2 = new ArrayList<Integer>();
		List<Integer> commList3 = new ArrayList<Integer>();
		List<Integer> commList4 = new ArrayList<Integer>();
		List<Integer> commList5 = new ArrayList<Integer>();
		List<Integer> commList6 = new ArrayList<Integer>();
		List<Integer> commList7 = new ArrayList<Integer>();
		List<String> dateList = new ArrayList<String>();

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		YunshanEmoCommNumWithTime yunshanReportNum  = null;
	
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_comment_num WHERE topic_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1,tid);
			rs = preStmt.executeQuery();
			
			while (rs.next()) {
				int num0 = rs.getInt("emotion0");
				int num1 = rs.getInt("emotion1");
				int num2 = rs.getInt("emotion2");
				int num3 = rs.getInt("emotion3");
				int num4 = rs.getInt("emotion4");
				int num5 = rs.getInt("emotion5");
				int num6 = rs.getInt("emotion6");
				int num7 = rs.getInt("emotion7");
				String date = rs.getDate("start_time").toString();

				commList0.add(num0);
				commList1.add(num1);
				commList2.add(num2);
				commList3.add(num3);
				commList4.add(num4);
				commList5.add(num5);
				commList6.add(num6);
				commList7.add(num7);
				dateList.add(date);
				
			}

			List<YunshanEmoCommNumWithTime.Report>  reportList = new ArrayList<YunshanEmoCommNumWithTime.Report>();
			 reportList.add(new YunshanEmoCommNumWithTime.Report("愉快",commList0));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("悲伤",commList1));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("愤怒",commList2));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("焦虑",commList3));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("同情",commList4));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("喜欢",commList5));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("厌恶",commList6));
			 reportList.add(new YunshanEmoCommNumWithTime.Report("怨恨",commList7));

			 yunshanReportNum = new YunshanEmoCommNumWithTime(dateList,reportList);
			System.out.println(JSON.toJSON(yunshanReportNum));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);

		}
		return yunshanReportNum;
	}
	
	
	
	public static void main(String[] args) {
//		List<Integer> topicIdList = new ArrayList<Integer>();
//		topicIdList.add(1);
//		topicIdList.add(0);
//		new YunshanSqlCommentNum().getAllCommentNumByTopicList(topicIdList);
		
//		new YunshanSqlCommentNum().getCommentNumByTid("0");
		new YunshanSqlCommentNum().getEmoCommNumWithTimeByTid("0");
	}
}
