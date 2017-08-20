package com.java.dao.news;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.java.dao.DBhelper;
import com.java.po.YunshanEvaluationObject;
/**
 * yunshan_evaluation_object表
 * @author iiip
 *
 */
public class YunshanSqlEvaluationObject {
	
	private DBhelper dbHelper = new DBhelper();

	/**
	 * 根据评价对象的id列表，获取对应的评价对象
	 * @param evaluObjIdList
	 * @return List<YunshanEvaluationObject>
	 */
	public List<YunshanEvaluationObject> getEvaluByEvaluIdList(List<Integer> evaluObjIdList){
		
		Connection conn = null;
		PreparedStatement preStmt = null;
		ResultSet rs = null;
		List<YunshanEvaluationObject> yunshanEvaluObList = new ArrayList<YunshanEvaluationObject>();

			StringBuffer sb = new StringBuffer();
			for (int i = 1; i < evaluObjIdList.size(); i++) {
				sb.append("?,");
			}
			sb.append("?");
			try {
				conn = dbHelper.getYunshanConnection();
				;
				String sql = "SELECT * FROM yunshan_evaluation_object WHERE evaluation_object_id in ("
						+ sb.toString() + ")";
				preStmt = conn.prepareStatement(sql);
				for (int i = 0; i < evaluObjIdList.size(); i++) {
					preStmt.setInt(i + 1, evaluObjIdList.get(i));
				}
				rs = preStmt.executeQuery();
			while (rs.next()){
			int evaluObjId = rs.getInt("evaluation_object_id");
			String objName= rs.getString("evaluation_object_name");
			int pNum = rs.getInt("positive_num");
			int nNum = rs.getInt("negative_num");
			System.out.println(evaluObjId);
			System.out.println(objName);
			System.out.println(pNum);
			System.out.println(nNum);
			float allSum = pNum + nNum;
			float po = (float)(Math.round(pNum/allSum*100))/100;
			float ne = (float)(Math.round(nNum/allSum*100))/100;

			yunshanEvaluObList.add(new YunshanEvaluationObject(evaluObjId,objName,po,ne));
			}
		} catch (SQLException se) {
			se.printStackTrace();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			dbHelper.closeAll(conn, preStmt, rs);
		}
		return yunshanEvaluObList;
	}
	public static void main(String[] args) {
		List<Integer> evaluObjIdList = new ArrayList<Integer>();
		evaluObjIdList.add(0);
		evaluObjIdList.add(1);
		new YunshanSqlEvaluationObject().getEvaluByEvaluIdList(evaluObjIdList);
	}
	
}
