<%--
    Document   : QuizOverview
    Created on : 20-Feb-2017, 13:51:04
    Author     : danielward
--%>

<%@page import="Stores.User"%>
<%@page import="Stores.Quiz"%>

<link rel="stylesheet" type="text/css" href="/Agile/assets/css/skeleton.min.css" />
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/style.css" />
<link rel="stylesheet" type="text/css" href="/Agile/assets/css/font-awesome.min.css"/>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quiz Overview</title>
    </head>

    <body>
        <div>
                <%
                    User user = (User) session.getAttribute("user");
                    String pos = " ";
                    if (user == null ) {
                        response.sendRedirect("login.jsp");
                    }
                    else
                    {
                        pos = user.getPosition();   
                    }
                    
                    if(pos.length() <= 0) //Not staff or student
                    {
                        response.sendRedirect("login.jsp");
                    }
                   
                    if( pos.equalsIgnoreCase("staff") ) {
                    %>
                <a href = "/Agile/createQuiz.jsp" role = "button"><h6>New Quiz</h6></a>
                <%
                    }
                    java.util.ArrayList<Quiz> quizzes = (java.util.ArrayList<Quiz>) request.getAttribute("quizzes");
                    boolean alt =false;
                    for (Quiz q : quizzes)
                    {  
                        alt = !alt;
                %>
                <div class="dynamic-row <%= alt ? "quiz-alt": "" %>">
                    <div class="dynamic-column grow">
                        <b><%=q.getTitle()%> : <%=q.getModule()%></b>
                    </div>
                   <%
                       if(pos.equalsIgnoreCase("staff"))
                       {
                   %>
                    <div class="dynamic-column">
                       <a href="/Agile/EditQuiz/<%=q.getId()%>">Edit Quiz</a>
                    </div>
                    <div class="dynamic-column">
                       <a href="/Agile/ViewQuiz/<%=q.getId()%>">View Quiz Results</a>
                    </div>
                   <%
                       }
                        else if(pos.equalsIgnoreCase("student"))
                       {
                   %>
                    <a href="/Agile/TakeQuiz/<%=q.getId()%>"><h6>View Quiz results</h6></a>
                    <a href="/Agile/StudentResults/<%=q.getId()%>"><h6>Student Results Quiz</h6></a> 
                   <%
                       }
%>
                </div>
                <%
                    }
                   %>
              

            </div>
            
            
        </div>
    </body>
    
</html>
