<%-- 
    Document   : takeQuiz
    Created on : 21-Feb-2017, 13:24:04
    Author     : jimiwesterholm
--%>

<%@page import="Stores.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%
            User user = (User) session.getAttribute("person");
            if (user == null || user.getPosition().equals("staff")) {
                response.sendRedirect("index.jsp");
            }
            
            int i = 0;
            boolean done = false;
        %>
        <h1><%quiz.getTitle%></h1>
        <%
            while (!done) {
                //Get question + answers
                
        %>
        
        
        <%
            }
        %>
    </body>
</html>
