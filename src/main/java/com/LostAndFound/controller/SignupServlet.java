package com.LostAndFound.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import org.bson.Document;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.sendRedirect("Signup.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String Name = request.getParameter("name");
        String Email = request.getParameter("email");
        String UserNumber = request.getParameter("phone");
        String StudentID = request.getParameter("studentId");
        String Password = request.getParameter("password");
        String Con_Password = request.getParameter("confirmPassword");

        try {

            String uri = "mongodb+srv://bhawanachaurasiya4_db_user:Bhawana77%40@cluster0.yhdkdb7.mongodb.net/?appName=Cluster0";

            MongoClient mongoClient = MongoClients.create(uri);
            MongoDatabase database = mongoClient.getDatabase("lostfoundDB");
            MongoCollection<Document> collection = database.getCollection("Signup-Users");

            Document doc = new Document("Name", Name)
                    .append("Email", Email)
                    .append("Phone-Number", UserNumber)
                    .append("Student-ID", StudentID)
                    .append("Password", Password)
                    .append("Confirm-password", Con_Password);

            collection.insertOne(doc);

            mongoClient.close();

            response.sendRedirect("Login.jsp");

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error : " + e.getMessage());

        }
    }
}