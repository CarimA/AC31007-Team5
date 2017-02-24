<%-- 
    Document   : editAnswer
    Created on : 20-Feb-2017, 14:13:10
    Author     : finlaybrooker
--%>

<%@page import="Stores.User"%>
<%@page import="Stores.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Answer</title>
    </head>
    <body>
        <%
                User user = (User) session.getAttribute("user");
                if (user.getPosition().equals("student")) {
                    response.sendRedirect("index.jsp");
                }
            
                Answer a = (Answer) request.getAttribute("Answer");
                int QuizID = (int) request.getAttribute("QuizID");
                int QuestionID = (int) request.getAttribute("QuestionID");
                if(a == null){
                    %>
                    <p>No answer selected</p>
                    <%
                }else{
                %>
                
                <form method="POST" action="edit">
                <li><%=a.getAnswer()%></li>
                <p>Change Answer</p>
                <input type="text" name="answer">
                <br/>
                <li><%=a.getExplanation()%></li>
                <p>Change Explanation</p>
                <input type="text" name="explanation">
                <br/>
                <p>Answer is <%=a.isRight()%></p>
                <p>Set right answer</p>
                <input type=checkbox name="right" <%if(a.isRight()){%> checked="checked" <%}%>> This is the correct answer.
                <br/>
                <input type="hidden" name="AnswerID" value="<%=a.getId()%>">
                <input type="submit" value="Submit">
                </form>
                       <%}
                       %>
                       <h3>Go back to <a href="/Agile/EditQuestion/<%=QuestionID%>">Question</a></h3>
    </body>
</html>
