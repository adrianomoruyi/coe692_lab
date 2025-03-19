<%@ page import="java.util.List" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Virtual Wardrobe - Search Clothes</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #ffebde;
        }
        .search-bar {
            margin-bottom: 20px;
        }
        .clothing-item {
            border: 1px solid #ddd;
            padding: 10px;
            margin-bottom: 10px;
            border-radius: 5px;
        }
    </style>
</head>
<body>
    <h1>Search Clothes</h1>

    <%
        HttpSession sessionObj = request.getSession(false);
        String username = (sessionObj != null) ? (String) sessionObj.getAttribute("username") : null;
        
        if (username == null) {
            response.sendRedirect("login.jsp");
            return;
        }
    %>
    
    <p>Welcome, <%= username %>! <a href="logout.jsp">Logout</a></p>

    <form action="SearchClothesServer" method="GET">
        <label for="type">Type:</label>
        <select name="type">
            <option value="">All</option>
            <option value="hat">Hat</option>
            <option value="shirt">Shirt</option>
            <option value="pants">Pants</option>
            <option value="shoes">Shoes</option>
            <option value="jacket">Jacket</option>
            <option value="dress">Dress</option>
        </select>

        <label for="brand">Brand:</label>
        <select name="brand">
            <option value="">All</option>
            <option value="Nike">Nike</option>
            <option value="Adidas">Adidas</option>
            <option value="Zara">Zara</option>
            <option value="Uniqlo">Uniqlo</option>
            <option value="H&M">H&M</option>
            <option value="Gucci">Gucci</option>
        </select>

        <label for="color">Color:</label>
        <select name="color">
            <option value="">All</option>
            <option value="red">Red</option>
            <option value="blue">Blue</option>
            <option value="black">Black</option>
            <option value="white">White</option>
            <option value="green">Green</option>
            <option value="yellow">Yellow</option>
        </select>

        <button type="submit">Search</button>
    </form>

    <div id="clothing-list">
        <%
            List<String> clothingItems = (List<String>) request.getAttribute("clothingItems");
            if (clothingItems != null && !clothingItems.isEmpty()) {
                for (String item : clothingItems) {
                    out.println("<div class='clothing-item'>" + item + "</div>");
                }
            } else {
                out.println("<p>No clothes found.</p>");
            }
        %>
    </div>

</body>
</html>
