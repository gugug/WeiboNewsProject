package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.java.dao.DBhelper;

public class YunshanSqlEventGeneral {

	private DBhelper dbHelper = new DBhelper();
	
	public static final Map<Integer,String> generalMap = new HashMap<Integer,String>(); 
	
	public YunshanSqlEventGeneral() {
		super();
		generalMap.put(1, "社会");
		generalMap.put(2, "国际");
		generalMap.put(3, "财经");
		generalMap.put(4, "体育");
		generalMap.put(5, "娱乐");
		generalMap.put(6, "汽车");
		generalMap.put(7, "科技");
		generalMap.put(8, "军事");
		generalMap.put(9, "综合");
		generalMap.put(10, "其他");
		
	}
	
	public int getEventGeneralByEid(int eid) {

		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		int generalId = -1;

		try {
			conn = dbHelper.getYunshanConnection();
			String sql = "SELECT general_event_id FROM  yunshan_event_general_relative WHERE event_id = ?";
			preStmt = conn.prepareStatement(sql);
			preStmt.setInt(1, eid);
			rs = preStmt.executeQuery();
			while (rs.next()) {
				generalId = rs.getInt("general_event_id");
//				System.out.println(generalId);
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return generalId;
	}

	public static void main(String[] args) {
		new YunshanSqlEventGeneral().getEventGeneralByEid(0);
		System.out.println(YunshanSqlEventGeneral.generalMap.size());
	}

}
