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
            if(quiz == null){
                %>
                <p>No quiz selected</p>
        <%
            }else{
            %>
            <form method="POST" action="EditQuiz">
            <h1>Quiz <%=quiz.getTitle()%></h1>
            <p>Edit title</p>
            <input type="text" name="title">
            <h2>Module <%=quiz.getModule()%></h2>
            <p>Edit module</p>
            <input type="text" name="module">
            <h2>Created <%=quiz.getDateCreated()%></h2>
            <h2>Avaliable <%=quiz.isAvaliable()%></h2>
            <p>Edit Avaliablity</p>
            <input type="checkbox" name="avaliable">
            
            </form>
            <ul> Questions
        <%
            Iterator<Question> iter;
            
            iter = quiz.getQuestions().iterator();
            while (iter.hasNext()) {
                Question q = (Question) iter.next();

        %>
        <li><a href="/EditQuestion/<%=q.getId()%>">Edit question <%=q.getNumber()%></a></li>
        <% }}
%>
    </ul>
        
            
    </body>
</html>
