<%-- 
    Document   : QuizOverview
    Created on : 20-Feb-2017, 13:51:04
    Author     : danielward
--%>

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
        <title>Quiz Overview</title>
    </head>
    <%@include file="header.jsp"%>
    <body>
        <h1>Quiz Overview</h1>
        <div>
            <a href = "viewQuiz.jsp" class = "btn btn-primary btn-lg" role = "button"> View Quiz </a>
            <%
                user = (User) session.getAttribute("user");
                if (user.getPosition().equals("Staff")) {
                    //response.sendRedirect("login.jsp");
            %>
                <a href = "newQuiz.jsp" class = "btn btn-primary btn-lg" role = "button"> New Quiz </a>
                <a href = "editQuiz.jsp" class = "btn btn-primary btn-lg" role = "button"> Edit Quiz </a>
            <% } %>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
