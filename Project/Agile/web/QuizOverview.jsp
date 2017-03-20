<%--
    Document   : QuizOverview
    Created on : 20-Feb-2017, 13:51:04
    Author     : danielward
--%>

<%@page import="Stores.User"%>
<%@page import="Stores.Quiz"%>

<link rel="stylesheet" href="assets/style.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Overview</title>
    </head>

    <body>
        <h1>Quiz Overview</h1>
        <div>
            <div>
                <%
                    User user = (User) session.getAttribute("user");
                    String pos = user.getPosition();
                    if(pos == "staff") {
                    %>
                <a href = "createQuiz.jsp" role = "button"> New Quiz </a>
                <%
                    }
                    java.util.Vector<Quiz> quizzes = (java.util.Vector<Quiz>) request.getAttribute("quizzes");
                    for(Quiz q : quizzes)
                    {
                %>
                <div>
                   <h3><%=q.getTitle()%> : <%=q.getModule()%></h3> <br>
                   <%
                       if(pos == "staff")
                       {
                   %>
                       <a href="EditQuiz/<%=q.getId()%>">Edit Quiz: <%=q.getTitle()%></a>
                       <a href="takeQuiz/<%=q.getId()%>">View Quiz results: <%=q.getTitle()%></a>
                       <a href="ViewQuiz/<%=q.getId()%>">View Quiz: <%=q.getTitle()%></a><br>
                   <%
                       }
                        else if(pos == "student")
                       {
                   %>
                    <a href="takeQuiz/<%=q.getId()%>">View Quiz results: <%=q.getTitle()%></a>
                    <a href="StudentResults/<%=q.getId()%>">Student Results Quiz: <%=q.getTitle()%></a> <br>
                   <%
                       }
                   %>
                </div>

            </div>
            
            
        </div>
    </body>
    
</html>
