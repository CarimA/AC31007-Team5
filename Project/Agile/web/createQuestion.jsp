<%-- 
    Document   : createAnswer
    Created on : 22-Feb-2017, 23:32:13
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
        <title>Create Answer</title>
    </head>
    <%@include file="header.jsp"%>
    <body>
        <h1>Quiz thing</h1>
        <div>
            <h3>Add an question to a quiz</h3>
            <form method="POST"  action="Register">
                <ul>
                    <li>Quiz ID <input type="text" name="questionId"></li>
                    <li>Question <input type="text" name="Question"></li>
                    <li>Image <input type="file" name="image"></li>
                    <li>Points <input type="text" name="points"></li>
                </ul>
                <br/>
                <input type="submit" value="createAnswer"> 
            </form>
        </div>
    </body>
    <%@include file="footer.jsp"%>
</html>