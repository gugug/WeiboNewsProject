package com.java.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.po.Weibo;

public class MysqlWeibo {

	private DBhelper dbHelper = new DBhelper();

	/**
	 * 获取全部weibo信息
	 * 
	 * @return
	 */
	public List<Weibo> getWeiboInfo() {
		List<Weibo> weiboList = new ArrayList<Weibo>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbHelper.getConnection();
			String sql = "SELECT * FROM weibo";
			preStmt = conn.prepareStatement(sql);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				String newsId = rs.getString("news_id");
				String newsTitle = rs.getString("news_title");
				String origin = rs.getString("origin");
				String releaseTime = rs.getString("release_time");
				String content = rs.getString("content");
				int likeNum = rs.getInt("like_num");
				int commentNum = rs.getInt("comment_num");
				int repostNum = rs.getInt("repost_num");
				String commentPath = rs.getString("comment_path");
				String repostPath = rs.getString("repost_path");

				System.out.println("eventId: " + eventId);
				System.out.println("newId: " + newsId);
				System.out.println("origin: " + origin);
				System.out.println("release_time:" + releaseTime);
				System.out.println("content:" + content);

				System.out.println("likeNum:" + likeNum);
				System.out.println("commentNum:" + commentNum);
				System.out.println("repostNum:" + repostNum);
				System.out.println("commentPath:" + commentPath);
				System.out.println("repostPath:" + repostPath);
				weiboList.add(new Weibo(eventId, newsId, newsTitle, origin, content, releaseTime, likeNum, commentNum, repostNum, commentPath, repostPath));
				
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return weiboList;
	}
	
	/**
	 * 查找微博根据事件id
	 * @param eid
	 * @return
	 */
	public List<Weibo> selectWeiboByEid(String eid) {
		List<Weibo> weiboList = new ArrayList<Weibo>();
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = dbHelper.getConnection();
			String sql = "SELECT * FROM weibo WHERE event_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, Integer.parseInt(eid));
			rs = preStmt.executeQuery();
			
			while (rs.next()) {
				int eventId = rs.getInt("event_id");
				String newsId = rs.getString("news_id");
				String newsTitle = rs.getString("news_title");
				String origin = rs.getString("origin");
				String releaseTime = rs.getString("release_time");
				String content = rs.getString("content");
				int likeNum = rs.getInt("like_num");
				int commentNum = rs.getInt("comment_num");
				int repostNum = rs.getInt("repost_num");
				String commentPath = rs.getString("comment_path");
				String repostPath = rs.getString("repost_path");
				
				System.out.println("eventId: " + eventId);
				System.out.println("newId: " + newsId);
				System.out.println("origin: " + origin);
				System.out.println("release_time:" + releaseTime);
				System.out.println("content:" + content);

				System.out.println("likeNum:" + likeNum);
				System.out.println("commentNum:" + commentNum);
				System.out.println("repostNum:" + repostNum);
				System.out.println("commentPath:" + commentPath);
				System.out.println("repostPath:" + repostPath);
				weiboList.add(new Weibo(eventId, newsId, newsTitle, origin, content, releaseTime, likeNum, commentNum, repostNum, commentPath, repostPath));

			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return weiboList;
	}

	// public int updateAlbum(String album_id, News news) {
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// int rs = 0;
	// try {
	// conn = dbHelper.getConnection();
	// String sql =
	// "update album set  album_name=?,singer=?,album_url=? where id=?";//
	// preStmt = conn.prepareStatement(sql);
	//
	// rs = preStmt.executeUpdate();
	//
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbHelper.closeAll(conn, preStmt, null);
	// }
	// return rs;
	// }
	//
	// public int insertAlbum(Album album) {
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// int rs = 0;
	// try {
	// conn = dbhelper.getConnection();
	// String sql =
	// "insert into album (album_name,singer,album_url) values(?,?,?)";
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, album.getAlbum_name());
	// preStmt.setString(2, album.getSinger());
	// preStmt.setString(3, album.getAlbum_url());
	// rs = preStmt.executeUpdate();
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbhelper.closeAll(conn, preStmt, null);
	// }
	// return rs;
	// }
	//
	// public int insertAlbum(List<Album> listAlbum) {
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// int rs = 0;
	// try {
	// conn = dbhelper.getConnection();
	// for (Album album : listAlbum){
	// String sql =
	// "insert into album (album_name,singer,album_url) values(?,?,?)";
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, album.getAlbum_name());
	// preStmt.setString(2, album.getSinger());
	// preStmt.setString(3, album.getAlbum_url());
	// rs = preStmt.executeUpdate();
	// if(rs!=0){
	// System.out.println("");
	// }
	// }
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbHelper.closeAll(conn, preStmt, null);
	// }
	// return rs;
	// }
	//
	//
	// public int deleteAlbum(String album_id) {
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// int rs = 0;
	// try {
	// conn = dbHelper.getConnection();
	// String sql = "delete from album where id = ?";
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, album_id);
	// rs = preStmt.executeUpdate();
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbHelper.closeAll(conn, preStmt, null);
	// }
	// return rs;
	// }
	//
	// public List<News> searchNews(String searchContent) {
	// List<News> newsList = new ArrayList<News>();
	// Connection conn = null;
	// PreparedStatement preStmt = null;
	// ResultSet rs = null;
	// try {
	//
	// conn = dbHelper.getConnection();
	// String sql;
	// sql = "SELECT * FROM news WHERE news_content LIKE ?";
	// preStmt = conn.prepareStatement(sql);
	// preStmt.setString(1, "%" + searchContent + "%");
	// rs = preStmt.executeQuery();
	// while (rs.next()) {
	// String id = rs.getString("news_id");
	// String type = rs.getString("news_website_type");
	// String title = rs.getString("news_title");
	// String content = rs.getString("news_content");
	// System.out.println("ID: " + id);
	// System.out.println("类型: " + type);
	// System.out.println("标题: " + title);
	// System.out.println("内容:" + content);
	// newsList.add(new News(id, type, title, content));
	// }
	//
	// } catch (SQLException se) {
	// se.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// } finally {
	// dbHelper.closeAll(conn, preStmt, rs);
	// }
	// return newsList;
	// }

	public static void main(String[] args) {
		new MysqlWeibo().selectWeiboByEid("1");
	}
}
