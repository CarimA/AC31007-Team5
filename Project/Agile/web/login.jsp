<%-- 
    Document   : login
    Created on : 17-Feb-2017, 13:12:46
    Author     : jimiwesterholm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method="POST" action="login">
            <ul>
                <li>ID <input type="text" name="user"></li>
                <li>Password <input type="password" name="pass"></li>
            </ul>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
