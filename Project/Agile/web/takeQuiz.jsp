
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="Stores.QuizModel"%>
<%@page import="Misc.Helpers"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@page session="true" %>
<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>
<t:wrapper>
    <jsp:attribute name="header">

    </jsp:attribute>
    <jsp:attribute name="footer">

    </jsp:attribute>

    <jsp:body>
        <t:quiz_taking_tag>
            
        </t:quiz_taking_tag>
    </jsp:body>
</t:wrapper>