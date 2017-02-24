<%-- 
    Document   : register
    Created on : 21-Feb-2017, 14:25:30
    Author     : jimiwesterholm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register page</title>
        <script>
         function validateFormLess() {
        var x = document.forms["registerForm"]["userID"].value;
        if (x.length < 7) {
        alert("Matriculation number is invalid! Must be 8 characters");
        return false;
    }
    
        function validateFormMore() {
        var x = document.forms["registerForm"]["userID"].value;
        if (x.length 8) {
        alert("Matriculation number is invalid! Must be 8 characters");
        return false;
    }
}
            
            
        </script>
    </head>
    <body>
        <h1>Register</h1>
        <form method="POST" action="Register" name="registerForm">
            <ul>
                <li>ID <input type="text" name="userID"></li>
                <li>Password <input type="password" name="pass"></li>
                <li>Name <input type="text" name="name"></li>
                <li>Email <input type="text" name="email"></li>
                <li>Position <input type="radio" name="position" value="Staff"> Staff 
                <input type="radio" name="position" value="Student"> Student </li>
            </ul>
            <input type="submit" value="Register User">
        </form>
        <p><%=request.getAttribute("error")%></p>
    </body>
</html>

