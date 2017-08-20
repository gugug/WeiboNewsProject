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
import com.java.po.YunshanEventReportNum;

/**
 * 获取事件报道量，是根据事件下的全部新闻id列表,按时间划分出不同时间断的报道量。
 * @author iiip
 *
 */
public class YunshanSqlEventReportNum {
	private DBhelper dbHelper = new DBhelper();
	
	/**
	 * 传入全部新闻id，查找该事件下的全部新闻，然后按时间划分，输出不同时间断的报道量
	 * 
	 * @param allNewsIdList
	 */
	public YunshanEventReportNum eventReportNumWithTimeByAllNewsId(List<Integer> allNewsIdList){
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		YunshanEventReportNum yunshanEventReportNum = null;
		 List<String> dateList = new ArrayList<String>();
		List<Integer> commList = new ArrayList<Integer>();
		Map<String,Integer> dateCommMap = new HashMap<String,Integer>();//key是日期，value是评论量
		StringBuffer sb = new StringBuffer();
		for (int i =1; i < allNewsIdList.size(); i++){
			sb.append("?,");
		}
		sb.append("?");
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_news WHERE news_id in ("
					+ sb.toString() + ")";
			preStmt = conn.prepareStatement(sql);
			for (int i = 0; i < allNewsIdList.size(); i++){
				preStmt.setInt(i+1, allNewsIdList.get(i));
			}
			
			rs = preStmt.executeQuery();
			while (rs.next()) {
				
				String newsId = rs.getString("news_id");
//				System.out.println(newsId);
				
				String newsDatetime = rs.getDate("news_datetime").toString();
//				System.out.println("newsDatetime: " + newsDatetime);

				if(dateCommMap.containsKey(newsDatetime)){
					int addNum = dateCommMap.get(newsDatetime)+1;
					dateCommMap.put(newsDatetime, addNum);
				}else{
					dateCommMap.put(newsDatetime, 1);
					if (newsDatetime != "0001-01-01"){
						dateList.add(newsDatetime);
					}
				}
			}
			
			for (String dd : dateList){
				commList.add(dateCommMap.get(dd));
			}
			yunshanEventReportNum = new YunshanEventReportNum(dateList,commList);
			System.out.println(JSON.toJSON(yunshanEventReportNum));
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return yunshanEventReportNum;
	}
	
	
	public static void main(String[] args) {
		List<Integer> allNewsIdList = new ArrayList<Integer>();
		allNewsIdList.add(153903);
		allNewsIdList.add(168942);
		new YunshanSqlEventReportNum().eventReportNumWithTimeByAllNewsId(allNewsIdList);
	}
}
