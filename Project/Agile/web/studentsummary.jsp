<%-- 
    Document   : studentsummary
    Created on : Feb 20, 2017, 2:22:07 PM
    Author     : Aleksandr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>

<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
     <jsp:body>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <script>
function myFunction() {
    window.print();
}
</script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script>
window.onload = function(){
    $("#question1").hide();
    $("#question2").hide();
    $("#question3").hide();
    $("#question4").hide();
    $("#question5").hide();
    $("#question6").hide();
    $("#question7").hide();
    $("#question8").hide();
    $("#question9").hide();
    $("#question10").hide();
}

$(document).ready(function(){
    $("#show1").click(function){
        $("#question1").show();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
});
</script>
    </head>
    <body>
        <h1>Test X Summary</h1>
        <h3>Name: .....</h3>
        <h3>Surname: .....</h3>
        <h3>Email: ......</h3>
        <h3>Score: ......</h3>
        <h3>Question 1</h3>
        <h3>Question 2</h3>
        
        
        <button onclick="myFunction()">Print Summary</button>
        
        <form method="POST" action="StudentSummary">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
     </jsp:body>
</t:wrapper>
