<%-- 
    Document   : studentsummary
    Created on : Feb 20, 2017, 2:22:07 PM
    Author     : Aleksandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
function myFunction() {
    window.print();
}
</script>
    </head>
    <body>
        <h1>Hello World!</h1>
        <p>dfjopsdfkpsjfdcdfjhfijpfd
        kdsgjffkdpoksdf
        ljdpjdofkfd
        kfdjgpsjefdf</p>
        
        <button onclick="myFunction()">Print Summary</button>
        
        <form method="POST" action="StudentSummary">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
