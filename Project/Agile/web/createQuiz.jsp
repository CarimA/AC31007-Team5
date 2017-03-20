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
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="content">

        <title>Create Quiz</title>
    </head>
    <body>
        <h1>Quiz Creation</h1>
        <div>
            <h3>Create a Quiz</h3>
            <%
                User user = (User) session.getAttribute("user");
            if (user == null)
            {
                response.sendRedirect("Home");
            }
            else if(user.getPosition().equals("student"))
            {
                response.sendRedirect("QuizOverview");   
            }
            
                %>
            <form method="POST"  action="createQuiz">                
                How many questions do you want to start with? <input type="number" name="questions" value="1">
                    <input type="submit" name="submit" value="Submit">
                <br>
            </form>
        </div>
    </body>

</c:set>
<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    <jsp:body>
        ${content}
    </jsp:body>
</t:wrapper>
