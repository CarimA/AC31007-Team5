<%-- 
    Document   : wrapper
    Created on : 22-Feb-2017, 12:08:22
    Author     : carimakeju
--%>

<%@tag description="Consistency Wrapper Tag" pageEncoding="UTF-8" import="Stores.*" %>
<%@attribute name="header" fragment="true" %>
<%@attribute name="footer" fragment="true" %>

<html>
    <head>
        <title>Quiz</title>
        
        <link rel="stylesheet" href="../assets/css/skeleton.min.css" />
        <link rel="stylesheet" href="../assets/css/style.css" />
        <link rel="stylesheet" href="../assets/css/font-awesome.min.css">
    </head>
    <body>
        <header class="container">
            <div class="dynamic-row">
                <div class="dynamic-column">
                    <h1>Quiz Thing</h1>
                </div>
                <div class="dynamic-column grow">
                    <ul>
                        <li><a href="Agile/new/Home">Home</a></li>
                        <%
                            User user = (User)(request.getAttribute("person"));
                            if (user == null) {
                        %>
                        <li><a href="/Agile/new/Login">Login</a></li>
                        <li><a href="/Agile/new/Register">Register</a></li>
                        <%
                            }
                            else {
                        %>
                        <li><a href="#">Hello, ${user.getDisplayName()}</a></li>
                        <%
                            }
                        %>
                        <jsp:invoke fragment="header"/>
                    </ul>
                </div>
            </div>
        </header>
        <section class="container">
            <%
                String error = (String)request.getAttribute("error");
                if (!(error == null)) {
            %>
            <p class="error"><i class="fa fa-bug" aria-hidden="true"></i> ${error}</p>
            <%
                    request.setAttribute("error", null);
                }
            %>
            <jsp:doBody/>    
        </section>
        <footer class="container">
            <jsp:invoke fragment="footer"/>
        </footer>
    </body>
</html>