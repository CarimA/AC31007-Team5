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
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    <jsp:body>
        <t:view_results>
        </t:view_results>
    </jsp:body>
</t:wrapper>

