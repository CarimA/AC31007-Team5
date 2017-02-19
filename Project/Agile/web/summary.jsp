<%-- 
    Document   : summary
    Created on : Feb 18, 2017, 10:41:16 PM
    Author     : Aleksandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="Summary">
            <ul>
                <li>ID <input type="text" name="id"></li>
                <li>Firstname <input type="text" name="firstname"></li>
                <li>Lastname <input type="text" name="lastname"></li>
                <li>Module <input type="text" name="module"></li>
            </ul>
            <input type="submit" value="Request">
        </form>
    </body>
</html>
