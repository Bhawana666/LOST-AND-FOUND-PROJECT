package com.LostAndFound.controller;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import java.io.File;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.annotation.WebServlet;

@MultipartConfig
@WebServlet("/foundform")
public class FoundformServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Foundform.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        String ItemName = request.getParameter("itemname");
        String ItemDisc = request.getParameter("itemdetail");
        String FoundDate = request.getParameter("date");
        String FoundTime = request.getParameter("time");
        String UserName = request.getParameter("username");
        String UserNumber = request.getParameter("usernumber");
        String Type = request.getParameter("type");

        Part filePart = request.getPart("itemImage");
        String fileName = filePart.getSubmittedFileName();

        // Folder path (server ke andar save hoga)
        String uploadPath = getServletContext().getRealPath("/uploads");
        // Folder create (agar nahi hai)
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // File save karo
        filePart.write(uploadPath + File.separator + fileName);

        String imagePath = fileName;

        String uri = System.getenv("MONGODB_URI");

        try {
            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("lostfoundDB");

            MongoCollection<Document> collection = database.getCollection("foundItems");

            Document doc = new Document("Itemname",ItemName)
                    .append("Itemdetail", ItemDisc)
                    .append("Founddate", FoundDate)
                    .append("Foundtime", FoundTime)
                    .append("Username",UserName)
                    .append("Usernumber",UserNumber)
                    .append("ImagePath",imagePath)
                    .append("Type",Type)
                    .append("createdAt", new Date());;

            collection.insertOne(doc);

            System.out.println("Data inserted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("Foundform.jsp");
    }
}
