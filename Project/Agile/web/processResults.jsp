<%-- 
    Document   : processResults
    Created on : 06-Mar-2017, 18:03:22
    Author     : Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
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
        
        <t:quiz_results_tag>
            
        </t:quiz_results_tag>
    </jsp:body>
</t:wrapper>
</html>

