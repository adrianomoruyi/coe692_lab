<%-- 
    Document   : logout
    Created on : Feb 6, 2025, 12:50:50 AM
    Author     : student
--%>

<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj != null) {
        sessionObj.invalidate(); // Destroy session
    }
    response.sendRedirect("login.jsp");
%>
