<%-- 
    Document   : createQuiz
    Created on : 22-Feb-2017, 23:29:07
    Author     : Danstev
--%>

<%@page import="Stores.User"%>
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/skeleton.min.css" />
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/font-awesome.min.css"/>

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
                
                    How many questions do you want to start with? <input type="number" name="questions">
                
                <br>
                <input type="submit" value="Create Quiz"> 
            </form>
        </div>
    </body>
</html>
