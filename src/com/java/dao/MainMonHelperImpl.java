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
		
		MongoDaoImpl mongoDaoImpl = new MongoDaoImpl();

   
//		Document document = new Document();
//		document.append("description", "databases");
//		document.append("likes",100);
//		document.append("by","gu11");
//		document.append("event_id","55");
		
		
		
		String areaTable = "area";
		String sexTable = "sex";
		String ageTable = "age";
		
		
//	    Map<String, Object> areaMap = new HashMap<String,Object>();
//	    areaMap.put("_id", 1);
//	    areaMap.put("北京", 5);
//	    areaMap.put("上海", 4);
//	    areaMap.put("广州",8);
		
	    
		

		/**
		 *  直接用BasicDBObject进行CRUD
		 * 	
		 */
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



//		String table1 = "javaCreateCol";
//		mongoDaoImpl.createCol(mongoDataBase, "area"); //创建集合
//		mongoDaoImpl.dropCol(mongoDataBase, table1);//删除集合

		Document ageDocument = new Document();
		Document sexDocument = new Document();
		Document areaDocument = new Document();
		
		ageDocument.append("_id", 311);
		ageDocument.append("a79", 1283);
		ageDocument.append("a80",  728);
		ageDocument.append("a90",1502);
		ageDocument.append("a95", 2303);
		ageDocument.append("anull", 4181);

		
		sexDocument.append("_id", 311);
		sexDocument.append("girl",  4363);
		sexDocument.append("boy", 5323);

	
		
		//插入
//		mongoDaoImpl.insert(mongoDataBase, ageTable, ageDocument);
//		mongoDaoImpl.insert(mongoDataBase, sexTable, sexDocument);
//		mongoDaoImpl.insert(mongoDataBase, areaTable, areaDocument);
		
		//查询
//		mongoDaoImpl.queryAll(mongoDataBase, ageTable);
//		mongoDaoImpl.queryAll(mongoDataBase, sexTable);
//		mongoDaoImpl.queryAll(mongoDataBase, areaTable);

		
		/**
		 * 使用map 进行CRUD操作 ,因为可以new BasicDBObject(map)进行包装
		 */
////	    System.out.println("测试map");
//	    Map<String, Object> ageMap = new HashMap<String,Object>();
//	    ageMap.put("_id", 311);
//	    ageMap.put("a79", 1283);
//	    ageMap.put("a80",  728);
//	    ageMap.put("a90",1502);
//	    ageMap.put("a95", 2303);
//	    ageMap.put("anull", 4181);
//	    
//	       插入单个map 到mongodb
//	    mongoDaoImpl.insert(mongoDataBase, areaTable,areaDocument);
	    
		//   插入多个map 到mongodb
//	    Map<String, Object> areaMap2 = new HashMap<String,Object>();
//	    Map<String, Object> areaMap3 = new HashMap<String,Object>();
//	    areaMap2.put("_id", 10);
//	    areaMap2.put("北京", 5);
//	    areaMap3.put("_id", 11);
//	    areaMap3.put("北京", 5);
//	    List<Document> docList = new ArrayList<Document>();
//	    docList.add(new Document(areaMap2));
//	    docList.add(new Document(areaMap3));
//	    mongoDaoImpl.insertMany(mongoDataBase, areaTable, docList);
	    
	    //   根据map 删除mongodb里找到的第一个
//	    mongoDaoImpl.delete(mongoDataBase, ageTable, new BasicDBObject(ageMap));
//	       根据map 删除mongodb里找到的全部
//	    mongoDaoImpl.deleteOne(mongoDataBase, areaTable, new BasicDBObject(areaMap1));

//	    Map<String, Object> updateDoc = new HashMap<String,Object>();
//	    Map<String, Object> wehereDoc = new HashMap<String,Object>();
//	    wehereDoc.put("_id", 4);
//	    updateDoc.put("上海",25);
	    //根据map 更新mongodb找到的多个
//	    mongoDaoImpl.update(mongoDataBase, areaTable, new BasicDBObject(wehereDoc), new BasicDBObject(updateDoc));
	    //根据map 更新mongodb的第一个
//	    mongoDaoImpl.updateOne(mongoDataBase, areaTable, new BasicDBObject(wehereDoc), new BasicDBObject(updateDoc));

	    
	    //检索对应的table的全部
		List<Map<String, Integer>> queryAllResult = mongoDaoImpl.queryAll(mongoDataBase, areaTable);
		mongoDaoImpl.printList(queryAllResult);
		
		//在对应的table下根据map查找
//	    Map<String, Object> areaMap2 = new HashMap<String,Object>();
//	    areaMap2.put("_id", 2);
//	    List<Map<String, Integer>> result = mongoDaoImpl.queryByDoc(mongoDataBase, areaTable, new BasicDBObject(areaMap2));
//	    mongoDaoImpl.printList(result);
	    
		//在对应的table下根据id来查询
//	    Map<String, Integer> queryByID = mongoDaoImpl.queryByID(mongoDataBase, areaTable, 4);
//	    System.out.println(queryByID);

		//关闭
		mongoHelper.closeMongoClient(mongoDataBase,mongoClient);

	}
   
}
