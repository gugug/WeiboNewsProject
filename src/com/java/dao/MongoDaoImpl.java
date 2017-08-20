package com.java.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.java.exception.CustomException;
import com.java.service.JsonStrToMap;
import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

/**
 * 实现接口
 * @author iiip
 *
 */
public class MongoDaoImpl implements MongoDao {
	
	@Override
	public Map<String,Integer> queryByID(MongoDatabase db, String table, Object Id) throws Exception{
		MongoCollection<Document> collection = db.getCollection(table);
		BasicDBObject query = new BasicDBObject("_id", Id);
		//  DBObject接口和BasicDBObject对象：表示一个具体的记录，BasicDBObject实现了DBObject，是key-value的数据结构，用起来和HashMap是基本一致的。
		FindIterable<Document> iterable = collection.find(query);

//		for (Document dd : iterable) {
//		    int dudu = dd.getInteger("上海"); // 读取响应的数据
//		    System.out.println("dudududu:"+dudu);
//		}
		
		Map<String,Integer> jsonStrToMap = null;
		MongoCursor<Document> cursor = iterable.iterator();
		while (cursor.hasNext()) {
			Document user = cursor.next();
			String jsonString = user.toJson();
			jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
		}
		System.out.println("检索ID完毕");
		if(jsonStrToMap == null){
				throw new CustomException("对应id属性不存在");
		}
		return jsonStrToMap;
	}

	/**
	 * 根据一个doc，来检索，当doc是空的时候检索全部
	 * @param db
	 * @param table
	 * @param doc
	 */
	public List<Map<String,Integer>>  queryByDoc(MongoDatabase db, String table, BasicDBObject doc) {
		MongoCollection<Document> collection = db.getCollection(table);
		FindIterable<Document> iterable = collection.find(doc);
	     /** 
         * 1. 获取迭代器FindIterable<Document> 
         * 2. 获取游标MongoCursor<Document> 
         * 3. 通过游标遍历检索出的文档集合 
         * */  
		
		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		MongoCursor<Document> cursor = iterable.iterator();
		while (cursor.hasNext()) {
			Document user = cursor.next();
			String jsonString = user.toJson();
			Map<String, Integer> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
		    list.add(jsonStrToMap);
		}
		System.out.println("检索doc完毕");
		return list;
	}
	
	/**
	 *  检索全部并返回迭代器
	 * @param db
	 * @param table
	 */
	public List<Map<String,Integer>> queryAll(MongoDatabase db, String table) {
		MongoCollection<Document> collection = db.getCollection(table);
		FindIterable<Document> iterable = collection.find();

		List<Map<String,Integer>> list = new ArrayList<Map<String,Integer>>();
		MongoCursor<Document> cursor = iterable.iterator();
		while (cursor.hasNext()) {
			Document user = cursor.next();
			String jsonString = user.toJson();
			Map<String, Integer> jsonStrToMap = JsonStrToMap.jsonStrToMap(jsonString);
		    list.add(jsonStrToMap);
		}
		System.out.println("检索全部完毕");
		return list;
	}
	
	/**
	 * 便利迭代器FindIterable<Document> 
	 */
	public void printFindIterable(FindIterable<Document> iterable){
		MongoCursor<Document> cursor = iterable.iterator();
		while (cursor.hasNext()) {
			Document user = cursor.next();
			System.out.println(user.toJson());
		}
		cursor.close();
	}
	
	
	@Override
	public boolean insert(MongoDatabase db, String table, Document document) {
		MongoCollection<Document> collection = db.getCollection(table);
		collection.insertOne(document);
		long count = collection.count(document);
//		System.out.println(collection.getNamespace());//weibo.area
//		System.out.println(collection.getClass());//class com.mongodb.MongoCollectionImpl
//		System.out.println(collection.getDocumentClass());//class org.bson.Document
//		System.out.println(collection.getWriteConcern());//WriteConcern{w=1, wtimeout=0, fsync=false, j=false
//		System.out.println(collection.getWriteConcern().getW());//1
		
		System.out.println("count: "+count);
		if(count == 1){
			System.out.println("文档插入成功");
			return true;
		}else{
			System.out.println("文档插入成功");
			return false;
		}

	}

	/**
	 * insert many
	 * @param db
	 * @param table
	 * @param document
	 */
	public boolean insertMany(MongoDatabase db, String table, List<Document> documents ) {

		MongoCollection<Document> collection = db.getCollection(table);
		long preCount = collection.count();
		collection.insertMany(documents);
		long nowCount = collection.count();
		System.out.println("插入的数量: "+(nowCount-preCount));
		if((nowCount-preCount) == documents.size() ){
			System.out.println("文档插入多个成功");
			return true;
		}else{
			System.out.println("文档插入多个失败");
			return false;
		}
	
	}
	
	@Override
	public boolean delete(MongoDatabase db, String table, BasicDBObject document) {
		MongoCollection<Document> collection = db.getCollection(table);
		DeleteResult deleteManyResult = collection.deleteMany(document);
		long deletedCount = deleteManyResult.getDeletedCount();
		System.out.println("删除的数量: "+deletedCount);
		if(deletedCount > 0){
			System.out.println("文档删除多个成功");
			return true;
		}else{
			System.out.println("文档删除多个失败");
			return false;
		}
	}
	
	/**
	 * 删除一个
	 * @param db
	 * @param table
	 * @param document
	 */
	public boolean deleteOne(MongoDatabase db, String table, BasicDBObject document) {
		MongoCollection<Document> collection = db.getCollection(table);
		DeleteResult deleteOneResult = collection.deleteOne(document);
		long deletedCount = deleteOneResult.getDeletedCount();
		System.out.println("删除的数量: "+deletedCount);
		if(deletedCount == 1){
			System.out.println("文档删除一个成功");
			return true;
		}else{
			System.out.println("文档删除一个失败");
			return false;
		}
	}
	

	@Override
	public boolean update(MongoDatabase db, String table, BasicDBObject whereDoc,BasicDBObject updateDoc) {
		 	MongoCollection<Document> collection = db.getCollection(table);  
	         UpdateResult updateManyResult = collection.updateMany(whereDoc, new Document("$set",updateDoc)); 
	         long modifiedCount = updateManyResult.getModifiedCount();
	         System.out.println("修改的数量: "+modifiedCount);
	         
	        if (modifiedCount > 0){
		        System.out.println("文档更新多个成功");
	        	return true;
	        }else{
		        System.out.println("文档更新失败");
	        	return false;
	        }
	}
	
	
	/**
	 * update one Data
	 * @param db
	 * @param table
	 * @param whereDoc
	 * @param updateDoc
	 */
	public boolean updateOne(MongoDatabase db, String table, BasicDBObject whereDoc,BasicDBObject updateDoc) {
		 	MongoCollection<Document> collection = db.getCollection(table);  
	         UpdateResult updateOneResult = collection.updateOne(whereDoc, new Document("$set",updateDoc)); 
	         long modifiedCount = updateOneResult.getModifiedCount();
	         System.out.println("修改的数量: "+modifiedCount);
	         if(modifiedCount == 1){
	 	        System.out.println("文档更新一个成功");
	        	 return true;
	         }else{
	 	        System.out.println("文档更新失败");
	        	 return false;
	         }
	}
	/**
	 * create collection
	 * @param db
	 * @param table
	 */
	public void createCol(MongoDatabase db, String table) {
		 db.createCollection(table);
		System.out.println("集合创建成功");
	}
	
	/**
	 * drop a collection
	 * @param db
	 * @param table
	 */
	public void dropCol(MongoDatabase db, String table) {
		db.getCollection(table).drop();
		System.out.println("集合删除成功");

	}

}
