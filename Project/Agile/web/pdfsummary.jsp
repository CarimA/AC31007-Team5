<%-- 
    Document   : pdfsummary
    Created on : Feb 19, 2017, 3:00:52 PM
    Author     : Aleksandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        Summary is ready... Download link...
        <%
            String[] explanation = request.getParameterValues("Explanation");
            if (explanation != null) {
        %>
        <ul>
            <li><%= explanation %></li>
        </ul>
        <%
            }
        %>
    </body>
</html>
