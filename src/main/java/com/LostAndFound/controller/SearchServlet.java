package com.LostAndFound.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mongodb.client.*;
import org.bson.Document;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Search.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String keyword = request.getParameter("keyword");

        String uri = "mongodb+srv://bhawanachaurasiya4_db_user:Bhawana77%40@cluster0.yhdkdb7.mongodb.net/?appName=Cluster0";

        List<Document> itemList = new ArrayList<>();

        MongoClient mongoClient = MongoClients.create(uri);
        try {

            MongoDatabase database = mongoClient.getDatabase("lostfoundDB");
            MongoCollection<Document> collection = database.getCollection("lostItems");

            FindIterable<Document> docs;

            if (keyword != null && !keyword.isEmpty()) {
                keyword = keyword.trim();
                docs = collection.find(new Document("Itemname",
                        new Document("$regex", keyword).append("$options", "i")));
            } else {
                docs = collection.find();
            }

            for (Document doc : docs) {
                itemList.add(doc);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            mongoClient.close();   // ✅ VERY IMPORTANT
        }

        request.setAttribute("items", itemList);

        RequestDispatcher rd = request.getRequestDispatcher("/Search.jsp");
        rd.forward(request, response);
    }
}