package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.java.dao.DBhelper;
import com.java.po.YunshanReportPercent;
/**
 * yunshan_web_num
 * @author iiip
 *
 */
public class YunshanSqlWebNum {
	private DBhelper dbHelper = new DBhelper();

	/**
	 * 同一事件的各个topic的报道网站数量和
	 * 
	 * @param topicList
	 *            事件下的各个话题id列表
	 * @return  List<YunshanReportPercent>
	 */
	public List<YunshanReportPercent> getAllWebNumByTopicList(List<Integer> topicList) {
		float sum0 = 0;
		float sum1 = 0;
		float sum2 = 0;
		float sum3 = 0;
		float sum4 = 0;
		List<YunshanReportPercent> webNumList = new ArrayList<YunshanReportPercent>();
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
			String sql = "SELECT * FROM yunshan_web_num WHERE topic_id in ("
					+ sb.toString() + ")";
			preStmt = conn.prepareStatement(sql);
			for (int i = 0; i < topicList.size(); i++) {
				preStmt.setInt(i + 1, topicList.get(i));
			}
			rs = preStmt.executeQuery();
			while (rs.next()) {
				float num0 = rs.getInt("web_id0");
				float num1 = rs.getInt("web_id1");
				float num2 = rs.getInt("web_id2");
				float num3 = rs.getInt("web_id3");
				float num4 = rs.getInt("web_id4");
				
				sum0 += num0;
				sum1 += num1;
				sum2 += num2;
				sum3 += num3;
				sum4 += num4;
				

			}
			float allSum = sum0+sum1+sum2+sum3+sum4;

			webNumList.add(new YunshanReportPercent("腾讯新闻",(float)(Math.round(sum0/allSum*100))/100));
			webNumList.add(new YunshanReportPercent("网易新闻",(float)(Math.round(sum1/allSum*100))/100));
			webNumList.add(new YunshanReportPercent("搜狐新闻",(float)(Math.round(sum2/allSum*100))/100));
			webNumList.add(new YunshanReportPercent("新浪新闻",(float)(Math.round(sum3/allSum*100))/100));
			webNumList.add(new YunshanReportPercent("凤凰新闻",(float)(Math.round(sum4/allSum*100))/100));
//			System.out.println(JSON.toJSON(webNumList));

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);

		}
		return webNumList;

	}

	public static void main(String[] args) {
		List<Integer> topicIdList = new ArrayList<Integer>();

		topicIdList.add(1);
		topicIdList.add(0);
		new YunshanSqlWebNum().getAllWebNumByTopicList(topicIdList);
	}
}
