package com.LostAndFound.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static final String URI = System.getenv("MONGODB_URI");

    public static MongoDatabase getDatabase() {

        MongoClient mongoClient = MongoClients.create(URI);

        return mongoClient.getDatabase("lostfoundDB");
    }
}