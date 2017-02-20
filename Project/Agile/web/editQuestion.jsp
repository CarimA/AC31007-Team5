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
            
            Question q = (Question) request.getAttribute("Question");
        %>
        <p><%= q.getNumber()%> <%=q.getQuestion()%>> Worth <%=q.getPoints()%> points</p>
        <p>Edit Question</p>
         <%// change this%>
        <form method="POST" action="EditQuiz">
        <input type="text" name="question<%=q.getNumber()%>">
        <p>Edit Image</p>
        <input type="file" name="image<%=q.getNumber()%>">
        <p>Edit points</p>
        <input type="number" name="points<%=q.getNumber()%>" min="1" max="100">
        <input type="submit" value="Submit">
        </form>
        <br/>
        <%// change this%>
        <img src="/Agile/Thumb/<%=q.getImage()%>"></a><br/><%
            Iterator<Answer> iterator;
            iterator = q.getAnswers().iterator();%>
            <ul>Answers
    
            <%
            while(iterator.hasNext()){
                Answer a = (Answer) iterator.next();
            
                %>
                <%// change this%>
                <li><a href="/EditAnswer/<%=a.getId()%>">Edit Question <%=q.getNumber()%></a></li>
                       
    <%
            }

            
            
        %>
            </ul>
           
    </body>
</html>
