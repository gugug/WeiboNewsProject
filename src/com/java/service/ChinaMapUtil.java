package com.java.service;

import java.util.Map;

import org.bson.Document;

import com.java.dao.MongoDaoImpl;
import com.java.dao.MongoHelper;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

public class ChinaMapUtil {
	public static void main(String[] args) {
//		Map<String, String> map = FileUtil.bufferReadTxt("./Documents/map.txt");
//		Map<String,List<String>> map2= FileUtil.bufferReadTxt2("./Documents/mapexcel.txt");
//		System.out.println(map.size());
//
////
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
		
		Map<String, Object> areaMap = FileUtil.readAreaTxt("./Documents/result/裸贷/area.txt");

		MongoHelper mongoHelper = new MongoHelper();
		MongoClient mongoClient = mongoHelper.getMongoClient();
		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();
		areaMap.put("_id", 3);
	    mongoDaoImpl.insert(mongoDataBase, "area", new Document(areaMap));

		
	}

}
