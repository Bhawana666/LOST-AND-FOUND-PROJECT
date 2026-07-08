<%@ page import="com.mongodb.client.FindIterable" %>
<%@ page import="org.bson.Document" %>

<%
    String user = (String) session.getAttribute("userEmail");

    if(user == null){
        response.sendRedirect("login.jsp");
    }
%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Home | Lost & Found</title>
    <link rel="stylesheet" href="home.css?v=4">
</head>

<body>

    <div class="navbar">
        <img src="L.png" alt="logo" width="80px">
        <ul>
            <li><button id="homeBtn-active">Home</button></li>
            <li><button id="SearchBtn">Search Item</button></li>

            <% if(user != null){ %>
                <li><button disabled>Welcome, <%= user %></button></li>
            <% } else { %>
                <li><button id="loginBtn">Login</button></li>
            <% } %>

        </ul>
    </div>

    <div class="home-box">
        <div class="lost">
            <h1>LOST SOMETHING?</h1>
            <h5>Report here for Lost Item</h5>
            <button id="lostBtn">Report Here</button>
        </div>
        <div class="found">
            <h1>FOUND SOMETHING?</h1>
            <h5>Report here for Found Item</h5>
            <button id="foundBtn">Report Here</button>
        </div>
    </div>

    <div class="heading">
        <h1>Recently Listed Item</h1>
    </div>

    <div class="Recently-listed-item">

    <%
    FindIterable<Document> recentItems =
    (FindIterable<Document>)request.getAttribute("recentItems");

    if(recentItems != null){

        for(Document item : recentItems){
    %>

        <div class="recent-card">

            <img src="uploads/<%= item.getString("ImagePath") %>" alt="image">

            <h3><%= item.getString("Itemname") %></h3>

            <p><%= item.getString("Lostdate") %></p>

            <a class="view-btn"
               href="ViewItem?id=<%= item.getObjectId("_id").toHexString() %>">
                View Details
            </a>

        </div>

    <%
        }
    }
    %>

    </div>

    <script src="Script.js"></script>
</body>

</html>