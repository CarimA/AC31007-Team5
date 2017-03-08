<%-- 
    Document   : takeQuiz
    Created on : 21-Feb-2017, 13:24:04
    Author     : jimiwesterholm
--%>

<%@page import="Models.QuizModel"%>
<%@page import="Stores.Answer"%>
<%@page import="Stores.Question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Stores.Quiz"%>
<%@page import="Stores.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <%/*
            User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().equals("staff")) {
                response.sendRedirect("index.jsp");
            }*/
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            Question q;
            Answer a;
            List<Question> questions = quiz.getQuestions();
        %>
        <h1><%=quiz.getTitle()%></h1>
        
        <form method="POST" action="takeQuiz">
            <%
            for (int i = 0; i < questions.size(); i++) {
                q = questions.get(i);
                %>
                    <ul>
                        <li><%=q.getQuestion()%> Worth <%=q.getPoints()%> points.<br>
                        <%
                        List<Answer> answers = q.getAnswers();
                        for (int j = 0; j < answers.size(); j++) {
                            a = answers.get(j);
                            %>
                            <input type="radio" name=<%=q.getId()%> value=<%=a.getId()%>><%=a.getAnswer()%><br>
                            <%
                        }
                        %>
                        </li>
                    </ul>
                    
            <%
            }
            %>
        <input type="submit" value="Submit">
        </form>
    </body>
</html>