<%-- 
    Document   : createAnswer
    Created on : 22-Feb-2017, 23:32:13
    Author     : Danstev
--%>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="style.css">

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Questions</title>
    </head>
    <%@include file="header.jsp"%>
    <body>
        <h1>Quiz thing</h1>
        <div>
            <h3>Add an question to a quiz</h3>
            <%int q = (int) request.getAttribute("number");%>
            <form method="POST"  action="createQuestion">
                <ul>
                    <li>Title <input type="text" name="title"></li>
                    <li>Module <input type="text" name="module"></li>
                    <li><input type="hidden" name="questions"><%=q%></li>
                </ul>
                <%
                for(int i = 0; i < q; i++)
                {
                %>
                <ul>
                    <li>Question: <%=q%><input type="text" name="question<%=q%>"></li>
                    <li>Number <input type="number" name="number<%=q%>"></li>
                    <li>Points <input type="text" name="points<%=q%>"></li>
                </ul>
                <%
                    for(int x = 0; x < 4; x++)
                    {
                        %>
                        <ul>
                            <li>Answer <input type="text" name="answer<%=q%>"></li>
                            <li>Number <input type="text" name="number<%=q%>"></li>
                            <li>Explanation <input type="text" name="explanation<%=q%>"></li>
                            <li>Right <input type="checkbox" name="right<%=q%>"></li>
                        </ul>
                <%
                    }
                }
                %>
                <br/>
                <input type="submit" value="Create Quiz"> 
            </form>
        </div>
    </body>
</html>