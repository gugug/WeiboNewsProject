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
import com.java.po.YunshanNews;
/**
 * yunshan_news表
 * @author iiip
 *
 */
public class YunshanSqlNews {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 获取yunshan_news表的全部数据
	 * @return  List<YunshanNews>
	 */
	public List<YunshanNews> getYunshanNewsInfo() {
		List<YunshanNews> newsList = new ArrayList<YunshanNews>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_news";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int newsId = rs.getInt("news_id");
				int newsWebId = rs.getInt("news_web_id");
				String newsWebType = rs.getString("news_web_type");
				String newsUrl = rs.getString("news_url");
				String newsTitle = rs.getString("news_title");
				String newsContent = rs.getString("news_content");
				String newsDatetime = rs.getString("news_datetime");
				String newsSource = rs.getString("news_source");
				String newsSourceUrl = rs.getString("news_source_url");
				String newsImageUrl = rs.getString("news_image_url");
				String newsAuthor = rs.getString("news_author");
				String newsArgs = rs.getString("news_args");

				System.out.println("newsId: " + newsId);
				System.out.println("newsWebId: " + newsWebId);
				System.out.println("newsWebType: " + newsWebType);
				System.out.println("newsUrl: " + newsUrl);
				System.out.println("newsTitle: " + newsTitle);
				System.out.println("newsContent: " + newsContent);
				System.out.println("newsDatetime: " + newsDatetime);
				System.out.println("newsSource: " + newsSource);
				System.out.println("newsSourceUrl: " + newsSourceUrl);
				System.out.println("newsImageUrl: " + newsImageUrl);
				System.out.println("newsAuthor: " + newsAuthor);
				System.out.println("newsArgs: " + newsArgs);
				newsList.add(new YunshanNews(newsId, newsWebId, newsWebType,
						newsUrl, newsTitle, newsContent, newsDatetime,
						newsSource, newsSourceUrl, newsImageUrl, newsAuthor,
						newsArgs));
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);

		}
		return newsList;
	}

	/**
	 * 根据新闻的id列表，获取对应新闻对象列表
	 * @param newsIdList
	 * @return  List<YunshanNews>
	 * @throws CustomException
	 */
	public List<YunshanNews> selectNewsByNidList(List<Integer> newsIdList)
			throws CustomException {
		List<YunshanNews> yunshanNewsList = new ArrayList<YunshanNews>();

		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		StringBuffer sb = new StringBuffer();
		for (int i = 1; i < newsIdList.size(); i++) {
			sb.append("?,");
		}
		sb.append("?");
		try {
			conn = dbHelper.getYunshanConnection();
			;
			String sql = "SELECT * FROM yunshan_news WHERE news_id in ("
					+ sb.toString() + ")";
			preStmt = conn.prepareStatement(sql);
			for (int i = 0; i < newsIdList.size(); i++) {
				preStmt.setInt(i + 1, newsIdList.get(i));
			}
			rs = preStmt.executeQuery();

			while (rs.next()) {
				int newsId = rs.getInt("news_id");
				int newsWebId = rs.getInt("news_web_id");
				String newsWebType = rs.getString("news_web_type");
				String newsUrl = rs.getString("news_url");
				String newsTitle = rs.getString("news_title");
				String newsContent = rs.getString("news_content");
				String newsDatetime = rs.getString("news_datetime");
				String newsSource = rs.getString("news_source");
				String newsSourceUrl = rs.getString("news_source_url");
				String newsImageUrl = rs.getString("news_image_url");
				String newsAuthor = rs.getString("news_author");
				String newsArgs = rs.getString("news_args");

				System.out.println("newsId: " + newsId);
				System.out.println("newsWebId: " + newsWebId);
				System.out.println("newsWebType: " + newsWebType);
				System.out.println("newsUrl: " + newsUrl);
				System.out.println("newsTitle: " + newsTitle);
				System.out.println("newsContent: " + newsContent);
				System.out.println("newsDatetime: " + newsDatetime);
				System.out.println("newsSource: " + newsSource);
				System.out.println("newsSourceUrl: " + newsSourceUrl);
				System.out.println("newsImageUrl: " + newsImageUrl);
				System.out.println("newsAuthor: " + newsAuthor);
				System.out.println("newsArgs: " + newsArgs);

				yunshanNewsList.add(new YunshanNews(newsId, newsWebId, newsWebType,
						newsUrl, newsTitle, newsContent, newsDatetime,
						newsSource, newsSourceUrl, newsImageUrl, newsAuthor,
						newsArgs));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return yunshanNewsList;
	}

	/**
	 * 根据新闻的id获取新闻对象
	 * @param nid
	 * @return YunshanNews
	 * @throws CustomException
	 */
	public YunshanNews selectNewsByNid(String nid) throws CustomException {
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		YunshanNews yunshanNews = null;
		Connection conn = null;

		try {
			conn = dbHelper.getYunshanConnection();
			;
			String sql = "SELECT * FROM yunshan_news WHERE news_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setString(1, nid);
			rs = preStmt.executeQuery();

			while (rs.next()) {
				int newsId = rs.getInt("news_id");
				int newsWebId = rs.getInt("news_web_id");
				String newsWebType = rs.getString("news_web_type");
				String newsUrl = rs.getString("news_url");
				String newsTitle = rs.getString("news_title");
				String newsContent = rs.getString("news_content");
				String newsDatetime = rs.getString("news_datetime");
				String newsSource = rs.getString("news_source");
				String newsSourceUrl = rs.getString("news_source_url");
				String newsImageUrl = rs.getString("news_image_url");
				String newsAuthor = rs.getString("news_author");
				String newsArgs = rs.getString("news_args");

				System.out.println("newsId: " + newsId);
				System.out.println("newsWebId: " + newsWebId);
				System.out.println("newsWebType: " + newsWebType);
				System.out.println("newsUrl: " + newsUrl);
				System.out.println("newsTitle: " + newsTitle);
				System.out.println("newsContent: " + newsContent);
				System.out.println("newsDatetime: " + newsDatetime);
				System.out.println("newsSource: " + newsSource);
				System.out.println("newsSourceUrl: " + newsSourceUrl);
				System.out.println("newsImageUrl: " + newsImageUrl);
				System.out.println("newsAuthor: " + newsAuthor);
				System.out.println("newsArgs: " + newsArgs);

				yunshanNews = new YunshanNews(newsId, newsWebId, newsWebType,
						newsUrl, newsTitle, newsContent, newsDatetime,
						newsSource, newsSourceUrl, newsImageUrl, newsAuthor,
						newsArgs);
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		if (yunshanNews == null) {
			throw new CustomException("查询的新闻id不存在");
		}
		return yunshanNews;
	}

	public static void main(String[] args) throws CustomException {
		// new YunshanSqlNews().getYunshanNewsInfo();
		// new YunshanSqlNews().selectNewsByNid("153903");
		List<Integer> newsIdList = new ArrayList<Integer>();
		newsIdList.add(153903);
		newsIdList.add(168942);
		newsIdList.add(171464);

		new YunshanSqlNews().selectNewsByNidList(newsIdList);

	}
}
