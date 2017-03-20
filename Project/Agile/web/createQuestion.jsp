<%-- 
    Document   : createAnswer
    Created on : 22-Feb-2017, 23:32:13
    Author     : Danstev
--%>


<%@page import="Stores.User"%>
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/skeleton.min.css" />
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/font-awesome.min.css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<c:set var="content">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Questions</title>
    </head>
    <body> 
        <h1>Create a Quiz!</h1>
        <div>
            <h3>Add a question to a quiz</h3>
            <%
            int q = (int) request.getAttribute("number");
            User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().equals("student")) {
                response.sendRedirect("index.jsp");
            }
            %>
            <div>  
            <form method="POST"  action="createQuestion">
                
                    Title: <input type="text" name="title" ><br/>
                    Module: <input type="text" name="module"><br/>
                    <input type="hidden" name="questions" value="<%=q%>">Amount of questions: <%=q%><br/>
                
                <%
                for(int i = 1; i <= q;  i++)
                {
                %>
                    <h5>Question <%=i%></h5>
                    <input type="hidden" name="number<%=i%>" value="<%=1%>" >
                    Question text: <input type="text" name="question<%=i%>" maxlength="255"><br/>
                    Points awarded: <input type="number" name="points<%=i%>" maxlength="5"><br/>
                    Image: <input type="file" name="file<%=i%>"><br/>
                
                <%
                    for(int x = 0; x < 4; x++)
                    {
                        %>
                            <h6>Answer: <%=x + 1%></h6>
                            <input type="hidden" name="number<%=i%><%=x%>" value="<%=x + 1%>" >
                            Answer: <input type="text" name="answer<%=i%><%=x%>" maxlength="255"><br/>
                            Explanation: <input type="text" name="explanation<%=i%><%=x%>" maxlength="255">
                            Correct Answer: <input type="checkbox" value="true" name="right<%=i%><%=x%>"><br/>
                <%
                    }
                }
                %>
                <input type="submit" value="Create Quiz"> 
            </form>
        </div>
    </body>

</c:set>
<t:wrapper>
    <jsp:attribute name="header">
        
    </jsp:attribute>
    <jsp:attribute name="footer">
        
    </jsp:attribute>
    <jsp:body>
        ${content}
    </jsp:body>
</t:wrapper>
