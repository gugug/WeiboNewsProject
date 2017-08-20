package com.java.dao;

import java.util.ArrayList;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;


public class TestMongodbCon {
	public static void main(String[] args) {
	try {
//		MongoClient mongoClient = new MongoClient("1**1",27017);
//		MongoDatabase database = mongoClient.getDatabase("**");
//		database.createCollection("**");
//		System.out.println("ok");
		
		
		//密码
		ServerAddress serverAddress = new ServerAddress("1**1",27017);
		ArrayList<ServerAddress> addrs = new ArrayList<ServerAddress>();
		addrs.add(serverAddress);
		
		MongoCredential createScramSha1Credential = MongoCredential.createScramSha1Credential("**", "**", "**".toCharArray());
		
		ArrayList<MongoCredential> credential = new ArrayList<MongoCredential>();
		credential.add(createScramSha1Credential);
		
		MongoClient mongoClient = new MongoClient(addrs, credential);
		MongoDatabase database = mongoClient.getDatabase("test");
		database.createCollection("yyy");
//		collection.insertOne(new Document().append("1", 1));
		System.out.println("ok");
		
		
	}catch (Exception e){
		e.printStackTrace();
	}

	}
	
	
	

}
