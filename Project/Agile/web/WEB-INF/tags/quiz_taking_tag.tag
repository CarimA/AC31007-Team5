<%-- 
    Document   : quiz_taking_tag
    Created on : 08-Mar-2017, 10:06:52
    Author     : Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
--%>

<%@tag import="Stores.ResultModel"%>
<%@tag import="Misc.Helpers"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="Stores.QuizModel"%>
<%@tag import="Stores.Answer"%>
<%@tag import="Stores.Question"%>
<%@tag import="java.util.List"%>
<%@tag import="Stores.Quiz"%>
<%@tag import="Stores.User"%>
<%@tag import="java.sql.*" %>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
          <%
            int id = Integer.valueOf(request.getParameter("qId"));//getting the quiz id
            session.setAttribute("selectedQuizId", id);
            String title = request.getParameter("Title");
            String module = request.getParameter("Module");
            String PersonID = session.getAttribute("userIDKey").toString();
            Connection connection = Helpers.connect();
            /**
             * Checking whether the student has already done the quiz
             */
            String query = "SELECT * FROM results WHERE PersonID = ? and QuizID = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, PersonID);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            
            if (resultSet.next()) {//if the student has not taken the quiz 
                Helpers.errorRedirect(request, response, "Home", true, "You have already done this quiz");
            }else{
                
            Quiz quiz = new Quiz();
            Question q;
            Answer a;  
         
            
                
                
                
            }
        %>
    </body>    
</html>