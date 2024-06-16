package com.dhy.util;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDB {
	private static final String CONNECTION = "mongodb://localhost:27017";
	private static final String DB_NAME = "test";
	private static MongoClient moncl;
	
	static {
		connect();
	}
	
	private static void connect() {
		if (moncl == null) {
			CodecProvider pojoProvider = PojoCodecProvider.builder().automatic(true).build();
			CodecRegistry pojoRegistry = CodecRegistries.fromRegistries(MongoClientSettings.getDefaultCodecRegistry(), CodecRegistries.fromProviders(pojoProvider));
			MongoClientSettings monclSettings = MongoClientSettings.builder().applyConnectionString(new com.mongodb.ConnectionString(CONNECTION)).codecRegistry(pojoRegistry).build();
			moncl = MongoClients.create(monclSettings);
		}
	}
	
	public static MongoDatabase getConnection() {
		if (moncl == null) {
			throw new IllegalStateException("moncl is not started");
		}
		return moncl.getDatabase(DB_NAME);
	}
	
	public static void close() {
		moncl.close();
		moncl = null;
	}
}
