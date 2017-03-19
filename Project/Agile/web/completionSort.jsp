<%-- 
    Document   : completionSort
    Created on : 06-Mar-2017, 17:58:06
    Author     : aleksandrstarasovs
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Stores.QuizModel"%>
<%@page import="Misc.Helpers"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<t:wrapper>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
       <t:sorting_by_completion>
            
        </t:sorting_by_completion>
    </jsp:body>
</t:wrapper>
</html>
