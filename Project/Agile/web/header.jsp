<%-- 
    Document   : header
    Created on : 20-Feb-2017, 22:00:08
    Author     : Danstev
--%>

<%@page import="Stores.User"%>
<div class="header">
    <a href = "/Agile/index.jsp" class = "btn btn-primary btn-lg" role = "button"> Home </a>
    <a href = "/Agile/QuizOverview.jsp" class = "btn btn-primary btn-lg" role = "button"> Quiz Overview </a>
    <%
        User user = (User) session.getAttribute("user");
        if (user != null) { %>
        <a href = "/Agile/Logout" class = "btn btn-primary btn-lg" role = "button"> Log out </a>
    <% } else { %>
        <a href = "/Agile/login.jsp" class = "btn btn-primary btn-lg" role = "button"> Login </a>
    <% } %>
</div>