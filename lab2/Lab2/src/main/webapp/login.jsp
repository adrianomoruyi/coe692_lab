<%-- 
    Document   : login
    Created on : Feb 6, 2025, 12:32:54 AM
    Author     : student
--%>

<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Virtual Wardrobe</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            text-align: center;
        }
        .login-container {
            max-width: 300px;
            margin: auto;
            padding: 20px;
            border-radius: 5px;
            background-color: #ffe0cc;
        }
        input[type="text"], input[type="password"] {
            width: 90%;
            padding: 8px;
            margin: 10px 0;
        }
        button {
            width: 100%;
            padding: 10px;
            border: none;
            background-color: #422818;
            color: white;
            border-radius: 4px;
        }
        .error {
            color: red;
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

    <div class="login-container">
        <h2>Login to Virtual Wardrobe</h2>

        <%-- Display error if login fails --%>
        <%
            String error = request.getParameter("error");
            if (error != null) {
        %>
            <p class="error"><%= error %></p>
        <%
            }
        %>

        <form action="LoginServer" method="POST">
            <input type="text" name="username" placeholder="Username" required>
            <input type="password" name="password" placeholder="Password" required>
            <button type="submit">Login</button>
        </form>
    </div>

</body>
</html>
