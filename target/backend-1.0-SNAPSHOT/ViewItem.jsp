<%@ page import = "org.bson.Document" %>

<%
Document item = (Document) request.getAttribute("item");
%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>View Item</title>
    <link rel="stylesheet" href="ViewItem.css?v=1">
</head>
<body>

    <div class="navbar">
        <img src="L.png" alt="logo" width="80px">
        <ul>
            <li><button id="homeBtn-active">Home</button></li>
            <li><button id="SearchBtn">Search Item</button></li>

            <%-- comment
            <% if(user != null){ %>
                <li><button disabled>Welcome, <%= user %></button></li>
            <% } else { %>
                <li><button id="loginBtn">Login</button></li>
            <% } %>
            --%>

        </ul>
    </div>

<div class="container">

    <h1>Item Details</h1>

    <div class="item-card">

        <div class="image-section">
            <img src="uploads/<%= item.getString("ImagePath")%>" alt="Item Image">
        </div>

        <div class="details-section">

            <p><strong>Item Name:</strong> <%= item.getString("Itemname")%> </p>

            <p><strong>Description:</strong>
               <%= item.getString("Itemdetail")%>
            </p>

            <p><strong>Date:</strong> <%= item.getString("Lostdate")%></p>

            <p><strong>Time:</strong> <%= item.getString("Losttime")%></p>

            <p><strong>Posted By:</strong> <%= item.getString("Username")%></p>

            <p><strong>Contact:</strong> <%= item.getString("Usernumber")%></p>

            <p>
                <strong>Status:</strong>
                <span class="type">
                <%= item.getString("Type")%>
                </span>
            </p>

        </div>

        <div class="logo-img">
             <img src="L3.png">
        </div>

    </div>

</div>
 <script src="Script.js"></script>
</body>
</html>