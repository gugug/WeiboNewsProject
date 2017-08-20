package com.java.dao;

import java.util.Map;


import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;

/**
 * Dao 层接口
 * 
 */
public interface MongoDao {
	/**
	 * Get Data BY ID
	 * 
	 * @param db
	 * @param table
	 * @param Id
	 * @throws Exception 
	 */
	public Map<String,Integer> queryByID(MongoDatabase db, String table, Object Id) throws Exception;

	/**
	 * Insert Data
	 * 
	 * @param db
	 * @param table
	 * @param document
	 */
	public boolean insert(MongoDatabase db, String table, Document doc);

	/**
	 * Delete Many Data.if doc is empty will delete all Data
	 * 
	 * @param db
	 * @param table
	 * @param document
	 */
	public boolean delete(MongoDatabase db, String table, BasicDBObject doc);

	/**
	 * Update All Data
	 * 
	 * @param db
	 * @param table
	 * @param oldDoc
	 * @param newDoc
	 */
	public boolean update(MongoDatabase db, String table, BasicDBObject oldDoc,
			BasicDBObject newDoc);

}
