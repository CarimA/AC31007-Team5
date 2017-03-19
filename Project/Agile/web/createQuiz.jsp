<%-- 
    Document   : createQuiz
    Created on : 22-Feb-2017, 23:29:07
    Author     : Danstev
--%>

<%@page import="Stores.User"%>
<link rel="stylesheet" href="assets/css/style.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <title>Create Quiz</title>
    </head>
    <body>
        <h1>Quiz Creation</h1>
        <div>
            <h3>Create a Quiz</h3>
            <%
                User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().equals("student")) {
                response.sendRedirect("QuizOverview");
            }
            
                %>
            <form method="POST"  action="createQuiz">
                <ul>
                    <li>How many questions do you want to start with? <input type="number" name="questions"></li>
                </ul>
                <br>
>                <input type="submit" value="Create Quiz"> 
            </form>
        </div>
    </body>
</html>
