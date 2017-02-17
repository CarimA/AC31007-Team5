<%-- 
    Document   : page
    Created on : 17-Feb-2017, 13:22:11
    Author     : jimiwesterholm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String user = (String) session.getAttribute("username");
            String pos = (String) session.getAttribute("position");
            if (false) {
                response.sendRedirect("login.jsp");
            }
        %>
        <h1>Hello World!</h1>
    </body>
</html>
