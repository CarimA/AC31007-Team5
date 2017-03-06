<%-- 
    Document   : index
    Created on : 22-Feb-2017, 12:18:09
    Author     : carimakeju
--%>
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

<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    <jsp:body>
        
        
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
        
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                AC31007
            </div>
            <div class="dynamic-column grow">
                Test quiz
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>
        </div>
    </jsp:body>
</t:wrapper>