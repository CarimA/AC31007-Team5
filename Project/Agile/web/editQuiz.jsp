<%-- 
    Document   : editQuiz
    Created on : 20-Feb-2017, 12:21:57
    Author     : finlaybrooker
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Stores.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Quiz</title>
    </head>
    <body>
        <%
            // get the quiz
            // change this
            Quiz quiz = (Quiz) request.getAttribute("Quiz");
            
            %>
            <h1>Quiz <%=quiz.getTitle()%></h1>
            <h2>Module <%=quiz.getModule()%></h2>
            <h2>Created <%=quiz.getDateCreated()%></h2>
            <h2>Avaliable <%=quiz.isAvaliable()%></h2>
            
            <ul> Questions
        <%
            Iterator<Question> iter;
            
            iter = quiz.getQuestions().iterator();
            while (iter.hasNext()) {
                Question q = (Question) iter.next();

        %>
        <li><a href="/EditQuestion/<%=q.getId()%>">Edit question <%=q.getNumber()%></a></li>
        <% }
%>
    </ul>
        
            
    </body>
</html>
