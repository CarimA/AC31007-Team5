<%-- 
    Document   : viewQuiz
    Created on : 20-Feb-2017, 14:05:36
    Author     : danielward
--%>

<%@page import="Stores.ResultModel"%>
<%@page import="java.util.List"%>
<%@page import="Misc.ResultController"%>
<%@page import="Stores.Quiz"%>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="style.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Quiz</title>
    </head>
        <%@include file="header.jsp"%>
    <body>
        <%/*
            User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().equals("staff")) {
                response.sendRedirect("index.jsp");
            }*/
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            ResultController rc = new ResultController();
            ResultModel result = new ResultModel();
            List<ResultModel> results = rc.fetchResultOverview(quiz.getId());
        %>
        <h1><%=quiz.getTitle()%></h1>
        
        
        <%
        for (int i = 0; i < results.size(); i++) {
            result = results.get(i);
            %>
                <ul>
                    <li><%=result.getPersonId()%><%=User.getNameFromID(result.getPersonId())%> got <%=result.getScore()%> points on <%=result.getDate()%>.<br>
                    </li>
                </ul>
        <% } %>
    </body>
    <%@include file="footer.jsp"%>
</html>
