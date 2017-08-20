package com.java.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;


/**
 * 测试类
 * @author iiip
 *
 */
public class MainMonHelperImpl {
    public static void main(String[] args) {
		MongoHelper mongoHelper = new MongoHelper();
		MongoClient mongoClient = mongoHelper.getMongoClient();
		MongoDatabase mongoDataBase = mongoHelper.getMongoDataBase(mongoClient);

   
//		Document document = new Document();
//		document.append("description", "databases");
//		document.append("likes",100);
//		document.append("by","gu11");
//		document.append("event_id","55");
		
		
		
		String table = "javaCreateCol111";
		String areaTable = "area";
		String sexTable = "sex";
		String ageTable = "age";
		String wbbTable = "wbb";
		
		
//	    Map<String, Object> areaMap = new HashMap<String,Object>();
//	    areaMap.put("_id", 1);
//	    areaMap.put("北京", 5);
//	    areaMap.put("上海", 4);
//	    areaMap.put("广州",8);
		
	    
		
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();

		/**
		 *  直接用BasicDBObject进行CRUD
		 * 
//		mongoDaoImpl.insert(mongoDataBase, table, new Document(areaMap));//插入document
		
//		mongoDaoImpl.queryByID(mongoDataBase, table, 1);//检索event_id,注意id类型是字符串还是int
//		BasicDBObject document2 = new BasicDBObject("likes",1000);
//		document2.append("event_id", "55");
//		mongoDaoImpl.queryByDoc(mongoDataBase, table, document2);//检索doc,可以根据doc(key,value)来查找,当doc是空的时候，检索全部
//		mongoDaoImpl.queryAll(mongoDataBase, table); //查询全部

//		BasicDBObject document3 = new BasicDBObject("likes",200);
//		mongoDaoImpl.delete(mongoDataBase, table, document3);//删除doc 的全部信息，当doc 是空，则删除全部
//		BasicDBObject document3 = new BasicDBObject("likes", 1000);
//		mongoDaoImpl.deleteOne(mongoDataBase, table, document3);//删除doc 的一个信息
		
//		更新文档   将文档中likes=100的文档修改为likes=200   
//		BasicDBObject whereDoc = new BasicDBObject("likes",1000);
//		BasicDBObject updateDoc = new BasicDBObject("likes",255);
//		mongoDaoImpl.update(mongoDataBase, table, whereDoc, updateDoc);//更新全部,查找到oldDoc的数据，更新newDoc的数据
//		BasicDBObject whereDoc = new BasicDBObject("likes",255);
//		BasicDBObject updateDoc = new BasicDBObject("event_id",205);
//		mongoDaoImpl.updateOne(mongoDataBase, table, whereDoc, updateDoc);//更新全部,查找到oldDoc的数据，更新newDoc的数据

		 */
		

		//		String table1 = "javaCreateCol";
//		mongoDaoImpl.createCol(mongoDataBase, "area"); //创建集合

//		mongoDaoImpl.dropCol(mongoDataBase, table1);//删除集合

		Document ageDocument = new Document();
		Document sexDocument = new Document();
		Document areaDocument = new Document();
		ageDocument.append("_id", 3);
		ageDocument.append("a70", 0.5);
		ageDocument.append("a80", 0.1);
		ageDocument.append("a90", 0.1);
		
		sexDocument.append("_id", 3);
		sexDocument.append("girl", 0.62);
		sexDocument.append("boy", 0.38);
//		
		areaDocument.append("_id", 2);
		areaDocument.append("深圳", 555);
		areaDocument.append("广州", 2221);
		areaDocument.append("北京", 211);
		areaDocument.append("上海", 112);
		areaDocument.append("哈尔滨", 81);
		
		//插入
//		mongoDaoImpl.insert(mongoDataBase, ageTable, ageDocument);
//		mongoDaoImpl.insert(mongoDataBase, sexTable, sexDocument);
		mongoDaoImpl.insert(mongoDataBase, areaTable, areaDocument);
		
		//查询
//		mongoDaoImpl.queryAll(mongoDataBase, ageTable);
//		mongoDaoImpl.queryAll(mongoDataBase, sexTable);
//		mongoDaoImpl.queryAll(mongoDataBase, areaTable);

	    //JSON 对象转换          
//	    System.out.println("serialize: " + JSON.serialize(areaDocument));  
		
//	    反序列化  
//	    System.out.println("parse: " + JSON.parse("{ \"name\" : \"hoojo\" , \"age\" : 24}"));  
		
	    //把document反序列化
//	    System.out.println("doc parse: " + JSON.parse(JSON.serialize(areaDocument)));  

//		System.out.println("map serialize: " + JSON.serialize(areaMap));  

		
		/**
		 * 使用map 进行CRUD操作
		 */
		
//	    System.out.println("测试map");
//	    Map<String, Object> areaMap1 = new HashMap<String,Object>();
//	    areaMap1.put("_id", 2);
//	    areaMap1.put("北京", 5);
//	    areaMap1.put("上海", 14);
//	    areaMap1.put("广州",8);
//	    areaMap1.put("深圳",0.5);


	     //把map反序列化
//	    System.out.println("map parse: " + JSON.parse(JSON.serialize(areaMap)));  

	    // 根据map 到mongodb查询
//	   FindIterable<Document> queryByDocResult = mongoDaoImpl.queryByDoc(mongoDataBase, areaTable, new BasicDBObject(areaMap1));
//	   mongoDaoImpl.printFindIterable(queryByDocResult);
	   
	    
	    //   插入map 到mongodb
//	    mongoDaoImpl.insert(mongoDataBase, areaTable, new Document(areaMap1));
	  
//	    Map<String, Object> areaMap2 = new HashMap<String,Object>();
//	    Map<String, Object> areaMap3 = new HashMap<String,Object>();
//	    areaMap2.put("_id", 10);
//	    areaMap2.put("北京", 5);
//
//	    areaMap3.put("_id", 11);
//	    areaMap3.put("北京", 5);
//	    List<Document> docList = new ArrayList<Document>();
//	    docList.add(new Document(areaMap2));
//	    docList.add(new Document(areaMap3));
//	    mongoDaoImpl.insertMany(mongoDataBase, areaTable, docList);
	    
	    //   根据map 删除mongodb
//	    mongoDaoImpl.delete(mongoDataBase, areaTable, new BasicDBObject(areaMap1));
//	    mongoDaoImpl.deleteOne(mongoDataBase, areaTable, new BasicDBObject(areaMap1));

	    //根据map 更新mongodb
//	    Map<String, Object> updateDoc = new HashMap<String,Object>();
//	    Map<String, Object> wehereDoc = new HashMap<String,Object>();
//	    wehereDoc.put("_id", 4);
//	    updateDoc.put("上海",25);
//	    mongoDaoImpl.update(mongoDataBase, areaTable, new BasicDBObject(wehereDoc), new BasicDBObject(updateDoc));
//	    mongoDaoImpl.updateOne(mongoDataBase, areaTable, new BasicDBObject(wehereDoc), new BasicDBObject(updateDoc));

	    
	    //检索全部
//		FindIterable<Document> queryAllResult = mongoDaoImpl.queryAll(mongoDataBase, areaTable);
//		mongoDaoImpl.printFindIterable(queryAllResult);
//		mongoHelper.closeMongoClient(mongoDataBase,mongoClient);
		
		/**
		 * 取出结果进行转换
		 */
//	    Map<String, Object> areaMap2 = new HashMap<String,Object>();
//	    areaMap2.put("_id", 4);
	    
//	    List<Map<String, Integer>> result = mongoDaoImpl.queryAll(mongoDataBase, areaTable);
//	    List<Map<String, Integer>> result = mongoDaoImpl.queryByDoc(mongoDataBase, areaTable, new BasicDBObject(areaMap2));

//	    System.out.println(result); 
//	    for(Map m :result){
//	    	System.out.println(m.get("_id"));
//	    }

//	    Map<String, Integer> queryByID = mongoDaoImpl.queryByID(mongoDataBase, areaTable, 4);
//	    System.out.println(queryByID);

		
		
	}
   
}
