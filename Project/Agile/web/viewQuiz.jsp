<%-- 
    Document   : viewQuiz
    Created on : 20-Feb-2017, 14:05:36
    Author     : danielward
--%>

<%@page import="Stores.User"%>
<%@page import="Stores.ResultModel"%>
<%@page import="java.util.List"%>
<%@page import="Misc.ResultController"%>
<%@page import="Stores.Quiz"%>

<link rel="stylesheet" href="assets/css/style.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Quiz</title>
    </head>
    <body>
        <%
            User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().equals("staff")) {
                response.sendRedirect("index.jsp");
            }
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            ResultController rc = new ResultController();
            ResultModel result = new ResultModel();
            List<ResultModel> results = rc.fetchResultOverview(quiz.getId());
        %>
        <h1><%=quiz.getTitle()%></h1>
        
        
        <%
        for (int i = 0; i < results.size(); i++) {
            result = results.get(i);
            %>
                <ul>
                    <li><%=result.getPersonId()%><%=User.getNameFromID(result.getPersonId())%> got <%=result.getScore()%> points on <%=result.getDate()%>.<br>
                    </li>
                </ul>
        <% } %>
    </body>
</html>
