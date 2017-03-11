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
            <h3>Add a question to a quiz</h3>
            <%int q = (int) request.getAttribute("number");%>
            <form method="POST"  action="createQuestion">
                <ul>
                    <li>Title <input type="text" name="title"></li>
                    <li>Module <input type="text" name="module"></li>
                    <li><input type="hidden" name="questions" value="<%=q%>"><%=q%></li>
                </ul>
                <%
                for(int i = 1; i <= q;  i++)
                {
                %>
                <ul>
                    <li>Question: <%=i%><input type="text" name="question<%=i%>"></li>
                    <li>Number <input type="number" name="number<%=i%>"></li>
                    <li>Points <input type="number" name="points<%=i%>"></li>
                    <li>Image <input type="file" name="file<%=i%>"></li>
                </ul>
                <%
                    for(int x = 0; x < 4; x++)
                    {
                        %>
                        <ul>
                            <li>Answer <input type="text" name="answer<%=i%><%=x%>"></li>
                            <li>Number <input type="text" name="number<%=i%><%=x%>"></li>
                            <li>Explanation <input type="text" name="explanation<%=i%><%=x%>"></li>
                            <li>Right <input type="checkbox" value="true" name="right<%=i%><%=x%>"></li>
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