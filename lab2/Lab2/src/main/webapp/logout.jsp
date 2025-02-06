<%-- 
    Document   : logout
    Created on : Feb 6, 2025, 12:50:50 AM
    Author     : student
--%>

<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page contentType="text/html" pageEncoding="UTF-8" %>

<%
    //Ends session and sneds user back to login
    HttpSession sessionObj = request.getSession(false);
    if (sessionObj != null) {
        sessionObj.invalidate();
    }
    response.sendRedirect("login.jsp");
%>
