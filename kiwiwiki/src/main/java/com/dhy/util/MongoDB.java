package com.dhy.util;

import org.bson.Document;

import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	String ip = "192.168.219.107";
	int port  = 27017;
	String db = "test";
	String col = "test";
	
	public MongoDatabase getConnection() {
		ServerAddress addr = new ServerAddress(ip, port);
		MongoClient moncl = MongoClients.create("mongodb://localhost:27017");
		MongoDatabase mongoDB =  moncl.getDatabase(db);
		MongoCollection<Document> mongoColl = mongoDB.getCollection(col);
		return mongoDB;
	}
	
	
	//FindIterable<Document> doc = mongoColl.find());
}
