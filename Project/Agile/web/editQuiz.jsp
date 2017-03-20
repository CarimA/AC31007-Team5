<%-- 
    Document   : editQuiz
    Created on : 20-Feb-2017, 12:21:57
    Author     : finlaybrooker
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Stores.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="content">
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Quiz</title>
        <link rel="stylesheet" type="text/css" href="/Agile/assets/css/skeleton.min.css" />
        <link rel="stylesheet" type="text/css" href="/Agile/assets/css/style.css" />
        <link rel="stylesheet" type="text/css" href="/Agile/assets/css/font-awesome.min.css"/>
        
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user.getPosition().equals("student")) {
                response.sendRedirect("index.jsp");
            }
            
            // get the quiz
            // change this
            Quiz quiz = (Quiz) request.getAttribute("Quiz");
            int lastNum = 1;
            if(quiz == null){
                %>
                <p>No quiz selected</p>
        <%
            }else{
            %>
            <form method="POST" action="EditQuiz">
            <h1>Quiz: <%=quiz.getTitle()%></h1>
            <p>Edit title</p>
            <input type="text" name="title">
            <h2>Module: <%=quiz.getModule()%></h2>
            <p>Edit module</p>
            <input type="text" name="module">
            <h2>Created: <%=quiz.getDateCreated()%></h2>
            <h2>Available: <%=quiz.isAvailable()%></h2>
            <p>Edit Availability</p>
            <p>Make available?</p> <input type="checkbox" name="available" <%if(quiz.isAvailable()){%>checked="checked"<%}%>>
            <input type="hidden" name="QuizID" value="<%=quiz.getId()%>">
            <input type ="submit" name="submit" value="Submit">
            </form>
            <ul> Questions
        <%
            
            if(quiz.getQuestions() == null || quiz.getQuestions().isEmpty()){
                %>
                <p>This Quiz has no questions</p>
        <%
            }else{
            Iterator<Question> iter;
            
            iter = quiz.getQuestions().iterator();
            while (iter.hasNext()) {
                Question q = (Question) iter.next();

        %>
        <li><a href="/Agile/EditQuestion/<%=quiz.getId()%>/<%=q.getId()%>">Edit question <%=q.getNumber()%></a></li>
        
        <%lastNum = q.getNumber() + 1; }}}
%>
    </ul>
    <p>Add a question</p>
    <form method="POST" action="EditQuiz">
        <p>Question</p>
        <input type="text" name="question">
        <p>Image</p>
        <input type="file" name="image">
        <p>Points</p>
        <input type="number" name="points" min="1" max="100" value="0">
        <input type="hidden" name="number" value="<%=lastNum%>">
        <input type="hidden" name="QuizID" value="<%=quiz.getId()%>">
        <input type="submit" name="submit" value="Add">
    </form>
        
        
        <form method="POST" action="EditQuiz">
            <input type="hidden" name="QuizID" value="<%=quiz.getId()%>">
            Delete Quiz (Do not click by accident) <input type="submit" name="submit" value="Delete">
        </form>
              
    </body></c:set>
<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    <jsp:body>
        ${content}
    </jsp:body>
</t:wrapper>

