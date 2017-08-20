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
 * yunshan_topic_news_relative表
 * @author iiip
 *
 */
public class YunshanSqlTopicNews {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 根据话题的id获取到该话题的新闻id列表
	 * 
	 * @param tid
	 * @return List<Integer>
	 * @throws CustomException
	 */
	public List<Integer> getNewsIdByTid(String tid) throws CustomException {
		List<Integer> newsIdList = new ArrayList<Integer>();
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT news_id FROM yunshan_topic_news_relative WHERE topic_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, tid);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int newsId = rs.getInt("news_id");
				// System.out.println(newsId);
				newsIdList.add(newsId);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		if (newsIdList.size() == 0) {
			throw new CustomException("根据话题id找不到新闻id");
		}
		return newsIdList;
	}

	/**
	 * 根据事件的话题的id列表获取到该事件的所有新闻id列表
	 * 
	 * @param tid
	 * @return List<Integer>
	 * @throws CustomException
	 */
	public List<Integer> getAllNewsIdByTidList(List<Integer> tidList)
			throws CustomException {
		List<Integer> allNewsIdList = new ArrayList<Integer>();

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < tidList.size(); i++) {
			sb.append("?,");
		}
		sb.append("?");
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT news_id FROM yunshan_topic_news_relative WHERE topic_id in ("
					+ sb.toString() + ")";
			preStmt = conn.prepareStatement(sql);
			for (int i = 0; i < tidList.size(); i++) {
				preStmt.setInt(i + 1, tidList.get(i));
			}
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int newsId = rs.getInt("news_id");
				allNewsIdList.add(newsId);
			}
			System.out.println(allNewsIdList.size());
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		if (allNewsIdList.size() == 0) {
			throw new CustomException("根据话题id列表找不到事件的全部新闻id列表");
		}
		return allNewsIdList;
	}

	public static void main(String[] args) throws CustomException {
//		new YunshanSqlTopicNews().getNewsIdByTid("1");
		
		List<Integer> newsIdList = new ArrayList<Integer>();
		newsIdList.add(0);
		newsIdList.add(1);
		new YunshanSqlTopicNews().getAllNewsIdByTidList(newsIdList);
	}

}
