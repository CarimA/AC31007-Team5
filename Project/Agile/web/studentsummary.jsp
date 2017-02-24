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
};

$(document).ready(function(){
    $("#show1").click(function(){
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
    $("#show2").click(function(){
        $("#question1").hide();
        $("#question2").show();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show3").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").show();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show4").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").show();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show4").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").show();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show5").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").show();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show6").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").show();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show7").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").show();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show8").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").show();
        $("#question9").hide();
        $("#question10").hide();
    });
    $("#show9").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").show();
        $("#question10").hide();
    });
    $("#show10").click(function(){
        $("#question1").hide();
        $("#question2").hide();
        $("#question3").hide();
        $("#question4").hide();
        $("#question5").hide();
        $("#question6").hide();
        $("#question7").hide();
        $("#question8").hide();
        $("#question9").hide();
        $("#question10").show();
    });
    $("#showall").click(function(){
        $("#question1").show();
        $("#question2").show();
        $("#question3").show();
        $("#question4").show();
        $("#question5").show();
        $("#question6").show();
        $("#question7").show();
        $("#question8").show();
        $("#question9").show();
        $("#question10").show();
        $("#show1").hide();
        $("#show2").hide();
        $("#show3").hide();
        $("#show4").hide();
        $("#show5").hide();
        $("#show6").hide();
        $("#show7").hide();
        $("#show8").hide();
        $("#show9").hide();
        $("#show10").hide();
        $("#showall").hide();
        $("#submit").hide();
        location.reload();
        window.print();
        location.reload();
    });
});
</script>
    </head>
    <body>
        <h1>Test X Summary</h1>
        <h3>Name: ${user.getDisplayName()}</h3>
        <h3>Email: ${user.getEmail()}</h3>
        <h3>Grade ......</h3>
        <h3>Date ......</h3>
        <button id="show1">Question 1</button><br>
        <table id="question1" width ="100%">
            <tr>
                <td>
                    Question 1<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show2">Question 2</button><br>
        <table id="question2" width ="100%">
            <tr>
                <td>
                    Question 2<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show3">Question 3</button><br>
        <table id="question3" width ="100%">
            <tr>
                <td>
                    Question 3<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show4">Question 4</button><br>
        <table id="question4" width ="100%">
            <tr>
                <td>
                    Question 4<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table> 
        <button id="show5">Question 5</button><br>
        <table id="question5" width ="100%">
            <tr>
                <td>
                    Question 5<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show6">Question 6</button><br>
        <table id="question6" width ="100%">
            <tr>
                <td>
                    Question 6<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show7">Question 7</button><br>
        <table id="question7" width ="100%">
            <tr>
                <td>
                    Question 7<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show8">Question 8</button><br>
        <table id="question8" width ="100%">
            <tr>
                <td>
                    Question 8<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show9">Question 9</button><br>
        <table id="question9" width ="100%">
            <tr>
                <td>
                    Question 9<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        <button id="show10">Question 10</button><br>
        <table id="question10" width ="100%">
            <tr>
                <td>
                    Question 10<br>
                    Correct/Incorrect
                </td>
                <td>
                    What is object oriented programming?<br>
                    Option 1<br>
                    <u> Option 2 </u> (Selected answer)<br>
                    Option 3<br>
                    <u> Option 4 </u> (Correct answer)<br>
                    Explanation: ...........
                </td>
            </tr>
        </table>
        
        
        
        
        <button id="showall">Print Summary</button>
        
        <form id="submit" method="POST" action="StudentSummary">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
    </jsp:body>
</t:wrapper>