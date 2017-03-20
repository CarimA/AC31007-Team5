<%-- 
    Document   : editQuestion
    Created on : 20-Feb-2017, 14:12:58
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
        <title>Edit Question</title>
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
            
            Question q = (Question) request.getAttribute("Question");
            int QuizID = (int) request.getAttribute("QuizID");
            int lastNum = 1;
            if(q == null){
                %>
                <p>No question selected</p>
        <%
            }else{
        %>
        <h1><%= q.getNumber()%>: <%=q.getQuestion()%></h1>
        <h2>Worth <%=q.getPoints()%> points</h2>
      
        <form method="POST" action="EditQuiz">
            <label for="question"><p>Edit Question</p></label>
        <input type="text" name="question">
        <label for="image"><p>Edit Image</p></label><img src="/Agile/Thumb/<%//q.getImage()%>"></a><br/>
        <input type="file" name="image">
        <label for="points"><p>Edit points</p></label>
        <input type="number" name="points" min="1" max="100" value="<%=q.getPoints()%>">
        <input type="hidden" name="QuestionID" value="<%=q.getId()%>">
        <input type="hidden" name="quizID" value="<%=QuizID%>">
        <input type="submit" name="submit" value="Submit">
        </form>
        <br/>
        <%// change this%>
        <%
            if(q.getAnswers() == null || q.getAnswers().isEmpty()){
                %>
                <p>This Question has no answers</p>
        <%
            }else{
            Iterator<Answer> iterator;
            iterator = q.getAnswers().iterator();%>
            <ul>Answers
    
            <%
            while(iterator.hasNext()){
                Answer a = (Answer) iterator.next();
            
                %>
                <%// change this%>
                <li><a href="/Agile/EditAnswer/<%=QuizID%>/<%=q.getId()%>/<%=a.getId()%>">Edit Answer <%=a.getNumber()%></a></li>
                       
    <%          lastNum = q.getNumber() + 1;
            }}

}
            
        %>
            </ul>
            <p>Add an answer</p>
            <form method="POST" action="EditQuiz">
                
                <p>Answer</p>
                <input type="text" name="answer">
                <br/>
                
                <p>Explanation</p>
                <input type="text" name="explanation">
                <br/>
                
                <p>Set right answer</p>
                <input type=checkbox name="right"> 
                <br/>
                <input type="hidden" name="QuestionID" value="<%=q.getId()%>">
                <input type="hidden" name="quizID" value="<%=QuizID%>">
                <input type="hidden" name="number" value="<%=lastNum%>">
                <input type="submit" name="submit" value="Add">
                </form>
                
                <form method="POST" action="EditQuiz">
                    <input type="hidden" name="QuestionID" value="<%=q.getId()%>">
                    <input type="hidden" name="quizID" value="<%=QuizID%>">
                Delete Question (Do not click by accident) <input type="submit" name="submit" value="Delete">
                </form>
                
                
        <h3>Go back to <a href="/Agile/EditQuiz/<%=QuizID%>">Quiz</a></h3>
           
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
