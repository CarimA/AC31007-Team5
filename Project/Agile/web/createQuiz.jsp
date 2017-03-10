<%-- 
    Document   : createQuiz
    Created on : 22-Feb-2017, 23:29:07
    Author     : Danstev
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
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Quiz</title>
    </head>
    <%@include file="header.jsp"%>
    <body>
        <h1>Quiz thing</h1>
        <div>
            <h3>Create a Quiz</h3>
            <form method="POST"  action="createQuiz">
                <ul>
                    <li>How many questions do you want to start with? <input type="number" name="questions"></li>
                </ul>
                <br/>
                <input type="submit" value="Create Quiz"> 
            </form>
        </div>
    </body>
</html>
