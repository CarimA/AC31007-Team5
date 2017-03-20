<%-- 
    Document   : editAnswer
    Created on : 20-Feb-2017, 14:13:10
    Author     : finlaybrooker
--%>

<%@page import="Stores.User"%>
<%@page import="Stores.Answer"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="content">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Answer</title>
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
            
                Answer a = (Answer) request.getAttribute("Answer");
                int QuizID = (int) request.getAttribute("QuizID");
                int QuestionID = (int) request.getAttribute("QuestionID");
                if(a == null){
                    %>
                    <p>No answer selected</p>
                    <%
                }else{
                %>
                
                <form method="POST" action="EditQuiz">
                <h1><%=a.getAnswer()%></h1>
                <p>Change Answer</p>
                <input type="text" name="answer">
                <br/>
                <h1><%=a.getExplanation()%></h1>
                <p>Change Explanation</p>
                <input type="text" name="explanation">
                <br/>
                <p>Answer is <%=a.isRight()%></p>
                <p>Set right answer</p>
                <input type=checkbox name="right" <%if(a.isRight()){%> checked="checked" <%}%>> This is the correct answer.
                <br/>
                <input type="hidden" name="AnswerID" value="<%=a.getId()%>">
                <input type="submit" name="submit" value="Submit">
                </form>
                       <%}
                       %>
                       
                       
                <form method="POST" action="EditQuiz">
                    <input type="hidden" name="AnswerID" value="<%=a.getId()%>">
                Delete Answer (Do not click by accident) <input type="submit" name="submit" value="Delete">
                </form>
                       <h3>Go back to <a href="/Agile/EditQuestion/<%=QuizID%>/<%=QuestionID%>">Question</a></h3>
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

