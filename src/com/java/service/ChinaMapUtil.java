package com.java.service;

import java.util.Map;

import org.bson.Document;

import com.java.dao.MongoDaoImpl;
import com.java.dao.MongoHelper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ChinaMapUtil {
	public static void main(String[] args) {
		String areapath = "./Documents/result/美联航暴力拖拽华人乘客下机/area.txt";
		String eid = "311";
		insertArea(areapath, eid);
	}
	
	
	/**
	 * 插入mongodb中的area表
	 * @param areapath  map.txt的路径
	 * @param eid 对应的事件id
	 */
	public static void insertArea(String areapath,String eid){
		MongoHelper mongoHelper = new MongoHelper();
		MongoClient mongoClient = mongoHelper.getMongoClient();
		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
		Map<String, Object> areaMap = FileUtil.readAreaTxt(areapath);
		areaMap.put("_id", eid);
	    mongoDaoImpl.insert(mongoDataBase, "area", new Document(areaMap));

	}
	
//	//整合全部地点的坐标，result是全部的坐标，已更新到location.js中
//	public void editAllMapXY(){
//		Map<String, String> map = FileUtil.bufferReadTxt("./Documents/map.txt");
//		Map<String,List<String>> map2= FileUtil.bufferReadTxt2("./Documents/mapexcel.txt");
//		System.out.println(map.size());
//
//		Set<String> map2keySet = map2.keySet();
//		for(String m2key:map2keySet){
//			if(!map.containsKey(m2key)){
//				System.out.println(m2key);
//				map.put(m2key, map2.get(m2key).toString());
//			}
//		}
//		System.out.println(map);
//		System.out.println(map.size());
//		for(String kk : map.keySet()){
//			System.out.println(kk+":"+map.get(kk)+",");
//		}
//	}

}
