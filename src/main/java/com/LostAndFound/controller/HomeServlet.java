package com.LostAndFound.controller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

import org.bson.Document;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@WebServlet("/Home")
public class HomeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("Homeservlet calling:");
        // MongoDB Database Connection
        MongoDatabase database = MongoDBConnection.getDatabase();

        // Collection Name
        MongoCollection<Document> lostcollection = database.getCollection("lostItems");
        MongoCollection<Document> foundcollection = database.getCollection("foundItems");

        System.out.println("Total Items = " + lostcollection.countDocuments());
        // Fetch latest 5 items
        FindIterable<Document> recentItems = lostcollection.find()
                .sort(new Document("createdAt", -1))
                .limit(5);

        System.out.println("recentItems = " + recentItems);

        request.setAttribute("recentItems", recentItems);

        System.out.println("Forwarding to Home.jsp");

        request.getRequestDispatcher("Home.jsp").forward(request, response);
    }
}
