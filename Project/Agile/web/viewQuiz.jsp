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
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="content">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Quiz</title>
    </head>
    <body>
        <%
            /*User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().toLowerCase().equals("student")) {
                response.sendRedirect("index.jsp");
            }*/
            Quiz quiz = (Quiz) session.getAttribute("quiz");
            
            ResultModel result = new ResultModel();
            List<ResultModel> results = (List<ResultModel>) session.getAttribute("results");
        %>
        <h1><%=quiz.getTitle()%></h1>
        
        <ul>
        <%
        for (int i = 0; i < results.size(); i++) {
            result = results.get(i);
            %>
                
                    <li><%=result.getPersonId()%> - <%=User.getNameFromID(result.getPersonId())%> got <%=result.getScore()%> points on <%=result.getDate()%>.<br>
                    </li>
                
        <% } %>
        </ul>
    </body>
</c:set>
<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    <jsp:body>
        ${content}
    </jsp:body>
</t:wrapper>

