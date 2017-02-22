<%-- 
    Document   : wrapper
    Created on : 22-Feb-2017, 12:08:22
    Author     : carimakeju
--%>

<%@tag description="Consistency Wrapper Tag" pageEncoding="UTF-8"%>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
    <head>
        <title>Quiz</title>
        
        <link rel="stylesheet" href="assets/css/skeleton.min.css" />
        <link rel="stylesheet" href="assets/css/style.css" />
    </head>
    <body>
        <header class="container">
            <jsp:invoke fragment="header"/>
        </header>
        <section class="container">
            <jsp:doBody/>    
        </section>
        <footer class="container">
            <jsp:invoke fragment="footer"/>
        </footer>
    </body>
</html>