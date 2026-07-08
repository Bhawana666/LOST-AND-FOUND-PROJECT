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
import org.bson.types.ObjectId;

import static com.mongodb.client.model.Filters.eq;

@WebServlet("/ViewItem")
public class ViewitemServlet extends HttpServlet{
    protected void doGet (HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {

        String id = request.getParameter("id");

        if (id == null || id.isEmpty()) {
            response.getWriter().println("Item ID is missing.");
            return;
        }

        MongoDatabase database = MongoDBConnection.getDatabase();

        MongoCollection<Document> Lostcollection = database.getCollection("lostItems");
        MongoCollection<Document> Foundcollection = database.getCollection("foundItems");

        ObjectId ObjId = new ObjectId(id);

        Document item = Lostcollection.find(eq("_id",ObjId)).first();
        if(item == null){
            item = Foundcollection.find(eq("_id",ObjId)).first();
        }

        if (item != null) {

            request.setAttribute("item", item);

            request.getRequestDispatcher("/ViewItem.jsp")
                    .forward(request, response);

        } else {

            response.getWriter().println("Item not found.");

        }
    }
}
