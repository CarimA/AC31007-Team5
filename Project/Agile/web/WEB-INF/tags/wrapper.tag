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
        
        <link rel="stylesheet" href="/Agile/assets/css/skeleton.min.css" />
        <link rel="stylesheet" href="/Agile/assets/css/style.css" />
        <link rel="stylesheet" href="/Agile/assets/css/print.css" />
        <link rel="stylesheet" href="/Agile/assets/css/font-awesome.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <header class="container">
            <div class="dynamic-row">
                <div class="dynamic-column">
                    <h1><a href="/Agile/Home">Quiz Thing</a></h1>
                </div>
                <div class="dynamic-column grow">
                    <ul>
                        <%
                            User user = (User)(request.getSession().getAttribute("user"));
                            if (user == null) {
                        %>
                        <li><a href="/Agile/Login">Login</a></li>
                        <li><a href="/Agile/Register">Register</a></li>
                        <%
                            }
                            else {
                        %>
                        <li>Hello, ${user.getDisplayName()}</li>
                        <li><a href="/Agile/Logout">Log Out</a></li>
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
                String success = (String)session.getAttribute("success");
                if (!(success == null)) {
            %>
            <p id="success-message" class="success" onclick="this.parentElement.removeChild(document.getElementById('success-message'));"><i class="fa fa-rocket" aria-hidden="true"></i> ${success}</p>
            <%
                    session.setAttribute("success", null);
                }

                String error = (String)session.getAttribute("error");
                if (!(error == null)) {
            %>
            <p id="error-message" class="error" onclick="this.parentElement.removeChild(document.getElementById('error-message'));"><i class="fa fa-bug" aria-hidden="true"></i> ${error}<span>(Click anywhere on this error message to close it)</span></p>
            <%
                    session.setAttribute("error", null);
                }
            %>
            <jsp:doBody/>    
        </section>
        <footer class="container">
            This website was designed by Team 5
            <jsp:invoke fragment="footer"/>
        </footer>
    </body>
</html>