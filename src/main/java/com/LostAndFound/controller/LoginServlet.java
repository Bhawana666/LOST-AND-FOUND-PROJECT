package com.LostAndFound.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    // Opens Login Page
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("Login.jsp").forward(request, response);
    }

    // Handles Login Form Submission
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {

            String uri = System.getenv("MONGODB_URI");

            MongoClient client = MongoClients.create(uri);

            MongoDatabase database = client.getDatabase("lostfoundDB");

            MongoCollection<Document> collection =
                    database.getCollection("Signup-Users");

            Document user = collection.find(
                    new Document("Email", email)
                            .append("Password", password)
            ).first();

            if (user != null) {

                HttpSession session = request.getSession();
                session.setAttribute("userEmail", email);

                response.sendRedirect("Home");

            } else {

                response.sendRedirect("Login.jsp?error=invalid");
            }

            client.close();

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Error : " + e.getMessage());
        }
    }
}