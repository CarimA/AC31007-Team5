<%-- 
    Document   : index
    Created on : 20-Feb-2017, 13:44:11
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
        <title>Quiz thing</title>
    </head>
    <%@include file="header.jsp"%>
    <body>
        <h1>Quiz thing</h1>
        <div>
            <h3>Testing buttons, shhh</h3>
            <a href = "QuizOverview.jsp" class = "btn btn-primary btn-lg" role = "button"> Quiz Overview </a>
            <a href = "editQuiz.jsp" class = "btn btn-primary btn-lg" role = "button"> Quiz Edit </a>
            <a href = "login.jsp" class = "btn btn-primary btn-lg" role = "button"> Login </a>
            <a href = "pdfsummary.jsp" class = "btn btn-primary btn-lg" role = "button"> PDF Summary </a>
            <a href = "summary.jsp" class = "btn btn-primary btn-lg" role = "button"> Summary </a>
            <a href = "register.jsp" class = "btn btn-primary btn-lg" role = "button"> Summary </a>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>
