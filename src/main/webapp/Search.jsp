<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Items | Lost & Found</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/search.css">
</head>
<body>

    <div class="navbar">
        <img src="L.png" alt="logo" width="80px">
        <ul>
            <li><button id="homeBtn-active">Home</button></li>
            <li><button id="SearchBtn">Search Item</button></li>
        </ul>
    </div>

    <div class="search-container">
        <div class="search-header">
            <h1>Search for <span class="highlight">Lost & Found</span> Items</h1>
            <form action="search" method="post" class="search-box">
                <input type="text" name="keyword" placeholder="Search item...">
                <button type="submit">Search</button>
            </form>
        </div>


        <%@ page import="java.util.*, org.bson.Document" %>

        <div class="items-grid" id="itemsGrid">

        <%
            List<Document> items = (List<Document>) request.getAttribute("items");

            if(items != null && !items.isEmpty()){
                for(Document item : items){
        %>

            <div class="item-card">
                <img src="<%= request.getContextPath() + "/uploads/" + item.getString("ImagePath") %>" class="item-img">

                <h3><%= item.getString("Itemname") %></h3>

                <p><strong>Date:</strong> <%= item.getString("Lostdate") %></p>

                <%
                    String type = item.getString("Type");
                    if(type == null){
                        type = "LOST";
                    }
                %>

                <div class="status <%= type.toLowerCase() %>">
                    <%= type %>
                </div>

                <a class="view-btn"
                    href="ViewItem?id=<%= item.getObjectId("_id").toHexString() %>">
                    View Details
                </a>

            </div>

        <%
                }
            } else {
        %>

            <p class="no-items">No items found</p>

        <%
            }
        %>

        </div>
   </div>
    <script src="Script.js"></script>
</body>
</html>

