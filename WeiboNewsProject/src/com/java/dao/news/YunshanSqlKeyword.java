package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.java.dao.DBhelper;
import com.java.po.YunshanKeyword;

/**
 * yunshan_keyword表
 * @author iiip
 *
 */
public class YunshanSqlKeyword {
	
	private DBhelper dbHelper = new DBhelper();

	/**
	 * 根据 Map<Integer,Float>  wordIdWeightMap的关键词id获取关键词
	 * @param wordIdWeightMap
	 * @return YunshanKeyword
	 */
	public YunshanKeyword  getKwByKIdList(Map<Integer,Float> wordIdWeightMap) {
		YunshanKeyword yunshanKeyword = null;
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		StringBuffer sb = new StringBuffer();
		
		ArrayList<String> wordsList = new ArrayList<String>();
		ArrayList<Float> weightList = new ArrayList<Float>();
		
		for (int i = 1; i < wordIdWeightMap.size(); i++) {
			sb.append("?,");
		}
		sb.append("?");
		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT * FROM yunshan_keyword WHERE word_id in ("
					+ sb.toString() + ")";
			preStmt = conn.prepareStatement(sql);
			
            int i = 1;
			 for (Map.Entry<Integer, Float> m :wordIdWeightMap.entrySet())  {  
//		            System.out.println(m.getKey()+"\t"+m.getValue());  
		            preStmt.setInt(i++, m.getKey());
		            
		        }  
			
			rs = preStmt.executeQuery();
			while (rs.next()) {
				int wordId = rs.getInt("word_id");
				String word = rs.getString("word");
				float weight = wordIdWeightMap.get(wordId);
				System.out.println(wordId);
				System.out.println(word);
				System.out.println(weight);
				wordsList.add(word);
				weightList.add(weight);
			}
			System.out.println(wordsList);
			System.out.println(weightList);

			yunshanKeyword = new YunshanKeyword(wordsList, weightList);
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbHelper.closeAll(conn, preStmt, rs);
		}
	
		return yunshanKeyword;
	}

	public static void main(String[] args) {
		
		Map<Integer,Float> wordIdWeightMap = new HashMap<Integer,Float>();
		wordIdWeightMap.put(0, (float) 2.0);
		wordIdWeightMap.put(1, (float) 3.0);
		new YunshanSqlKeyword().getKwByKIdList(wordIdWeightMap);

		

	}
}
