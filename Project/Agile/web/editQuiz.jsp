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
            Quiz quiz = (Quiz) request.getAttribute("ID");
            Iterator<Question> iter;
            
            iter = quiz.getQuestions().iterator();
            while (iter.hasNext()) {
                Question q = (Question) iter.next();

        %>
        <p><%= q.getNumber()%> <%=q.getQuestion()%>> Worth <%=q.getPoints()%> points</p>
        <p>Edit Question</p>
         <%// change this%>
        <form method="POST" action="edit">
        <input type="tex" name="question<%=q.getNumber()%>">
        <p>Edit Image</p>
        <input type="file" name="image<%=q.getNumber()%>">
        <p>Edit points</p>
        <input type="number" name="points<%=q.getNumber()%>" min="1">
        <input type="submit" value="Submit">
        </form>
        <br/>
        <%// change this%>
        <img src="/Agile/Thumb/<%=q.getImage()%>"></a><br/><%
            Iterator<Answer> iterator;
            iterator = q.getAnswers().iterator();
            %>
    <ul>
        <li>Answer          Right?</li>
    
            <%
            while(iterator.hasNext()){
                Answer a = (Answer) iterator.next();
            
                %>
                <%// change this%>
                <form method="POST" action="edit">
                <li><%=a.getAnswer()%>      <input type=radio name="right<%=q.getNumber()%>" value="<%=a.getNumber()%>"></li>
                <p>Change Answer</p>
                <input type="text" name="answer<%=a.getNumber()%>">
                <input type="submit" value="Submit">
                </form>
                       
    <%
            }

            }
            
        %>
    </body>
</html>
