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
            if(q == null){
                %>
                <p>No question selected</p>
        <%
            }else{
        %>
        <p><%= q.getNumber()%> <%=q.getQuestion()%>> Worth <%=q.getPoints()%> points</p>
        <p>Edit Question</p>
         <%// change this%>
        <form method="POST" action="EditQuiz">
        <input type="text" name="question">
        <p>Edit Image</p><img src="/Agile/Thumb/<%//q.getImage()%>"></a><br/>
        <input type="file" name="image">
        <p>Edit points</p>
        <input type="number" name="points" min="1" max="100">
        <input type="submit" value="Submit">
        </form>
        <br/>
        <%// change this%>
        <%
            if(q.getAnswers().isEmpty()){
                %>
                <p>This Question has no answers</p>
        <%
            }
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

}
            
        %>
            </ul>
           
    </body>
</html>
