<%-- 
    Document   : page
    Created on : 17-Feb-2017, 13:22:11
    Author     : jimiwesterholm
--%>

<%@page import="Stores.Person"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            Person user = (Person) session.getAttribute("person");
            if (!user.getPosition().equals("staff")) {
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
