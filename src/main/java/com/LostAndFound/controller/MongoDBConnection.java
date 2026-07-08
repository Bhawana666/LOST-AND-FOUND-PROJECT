package com.LostAndFound.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnection {

    private static final String URI =
            "mongodb+srv://bhawanachaurasiya4_db_user:Bhawana77%40@cluster0.yhdkdb7.mongodb.net/?appName=Cluster0";

    public static MongoDatabase getDatabase() {

        MongoClient mongoClient = MongoClients.create(URI);

        return mongoClient.getDatabase("lostfoundDB");
    }
}