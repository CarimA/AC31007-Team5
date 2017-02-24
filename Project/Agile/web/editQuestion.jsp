<%-- 
    Document   : editQuestion
    Created on : 20-Feb-2017, 14:12:58
    Author     : finlaybrooker
--%>

<%@page import="java.util.Iterator"%>
<%@page import="Stores.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Question</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user.getPosition().equals("student")) {
                response.sendRedirect("index.jsp");
            }
            
            Question q = (Question) request.getAttribute("Question");
            int QuizID = (int) request.getAttribute("QuizID");
            if(q == null){
                %>
                <p>No question selected</p>
        <%
            }else{
        %>
        <p><%= q.getNumber()%> <%=q.getQuestion()%> Worth <%=q.getPoints()%> points</p>
        <p>Edit Question</p>
         <%// change this%>
        <form method="POST" action="EditQuiz">
        <input type="text" name="question">
        <p>Edit Image</p><img src="/Agile/Thumb/<%//q.getImage()%>"></a><br/>
        <input type="file" name="image">
        <p>Edit points</p>
        <input type="number" name="points" min="1" max="100" value="<%=q.getPoints()%>">
        <input type="hidden" name="QuestionID" value="<%=q.getId()%>">
        
        <input type="submit" value="Submit">
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
                <li><a href="/Agile/EditAnswer/<%=a.getId()%>">Edit Answer <%=q.getNumber()%></a></li>
                       
    <%
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
                <input type="submit" value="Submit">
                </form>
        <h3>Go back to <a href="/Agile/EditQuiz/<%=QuizID%>">Quiz</a></h3>
           
    </body>
</html>
