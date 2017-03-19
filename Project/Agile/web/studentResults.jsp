<%-- 
    Document   : studentResults
    Created on : 17-Mar-2017, 16:41:02
    Author     : jimiwesterholm
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Stores.Question"%>
<%@page import="Stores.Answer"%>
<%@page import="java.util.List"%>
<%@page import="Stores.Quiz"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Results</title>
    </head>
    <body>
        <%
            /*User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().toLowerCase().equals("student")) {
                response.sendRedirect("index.jsp");
            }
            */
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            List<Question> questions = quiz.getQuestions();
            List<Answer> answers = new ArrayList();
            Question q = new Question();
            Answer a = new Answer();
            //ResultModel result = new ResultModel();
            List<Answer> studentAns = (List<Answer>) session.getAttribute("studentAns");
        %>
        <h1><%=quiz.getTitle()%></h1>
        
        
        <%
        for (int i = 0; i < questions.size(); i++) {
            q = questions.get(i);
            answers = q.getAnswers();
            %>
            Print question + points
                <ul>
                    <%
                        for (int j = 0; j < answers.size(); j++) {
                            a = answers.get(j);
                            
                    %>
                            <li> <%=a.getAnswer()%> </li>
                    <%
                        }
                    %>
                </ul>
        <% } %>
    </body>
</html>
