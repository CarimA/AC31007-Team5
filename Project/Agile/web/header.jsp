<%-- 
    Document   : header
    Created on : 20-Feb-2017, 22:00:08
    Author     : Danstev
--%>

<%@page import="Stores.User"%>
<div class="header">
    <a href = "index.jsp" class = "btn btn-primary btn-lg" role = "button"> Home </a>
    <a href = "QuizOverview.jsp" class = "btn btn-primary btn-lg" role = "button"> Quiz Overview </a>
    <%
        User user = (User) session.getAttribute("person");
        if (user != null) {
            //response.sendRedirect("login.jsp");
    %>
    <a href = "logout" class = "btn btn-primary btn-lg" role = "button"> Log out </a>
    <% } else { %>
    <a href = "login.jsp" class = "btn btn-primary btn-lg" role = "button"> Login </a>
    <% } %>
</div>