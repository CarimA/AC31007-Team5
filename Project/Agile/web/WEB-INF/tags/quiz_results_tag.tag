<%-- 
    Document   : quiz_results_tag
    Created on : 12-Mar-2017, 11:35:06
    Author     : Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
--%>

<%@tag import="Stores.Question"%>
<%@tag import="java.util.List"%>
<%@tag import="java.util.Calendar"%>
<%@tag import="java.util.Date"%>
<%@tag import="java.sql.ResultSet"%>
<%@tag import="Misc.Helpers"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.PreparedStatement"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h3>Your Results</h3>
        <%

            int quizid = Integer.parseInt(session.getAttribute("selectedQuizId").toString());
            String PersonID = session.getAttribute("userIDKey").toString();
            Connection connection = Helpers.connect();

            /**
             * Checking whether the student has already done the quiz
             */
            String query = "SELECT * FROM results WHERE PersonID = ? and QuizID = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, PersonID);
            statement.setInt(2, quizid);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Helpers.errorRedirect(request, response, "Home", true, "You have already done this quiz");
            } else {//if the student has not taken the quiz 

                int correctAnswers = 0;
                int arraySize = Integer.valueOf(request.getParameter("arraySize"));// size of the questions array from quiz_tzking_tag
                String rightAnswers[] = request.getParameterValues("Answer");//right answers from quiz_tzking_tag
                
                String points[] = request.getParameterValues("Points");//answer points from quiz_tzking_tag
                int quiz_id = Integer.valueOf(request.getParameter("QuizID"));
                List<Question> quizQuestions = (List<Question>) session.getAttribute("quizQuestions");
                for (int i = 0; i < arraySize; i++) {//looping through all the answers
                    String studentAnswer = request.getParameter(String.valueOf("ans" + i));
                    String correctAnswer = rightAnswers[i];
                  
        %>
<!--        //displaying the question title  -->
        <br/><br/><p><%=quizQuestions.get(i).getQuestion()%></p>
        <%
            if (studentAnswer != null) {//student has selected an answer
                if (studentAnswer.equals(correctAnswer)) {//correct answer
                    correctAnswers = correctAnswers + Integer.parseInt(points[i]);
        %>
        <label>Your Answer:   </label><p><%=studentAnswer%>  <i class="fa fa-check" aria-hidden="true" style="color: green;"></i></p>
            <%
            } else {//wrong answer
            %>
        <label>Your Answer:   </label><p><%=studentAnswer%>  <i class="fa fa-times" aria-hidden="true" style="color: red;"></i></p></label>
    <label>Correct Answer:   </label><p style="display: inline;"><%=correctAnswer%>  <i class="fa fa-check" aria-hidden="true" style="color: green;"></i></p>
        <%
            }
        } else {//student has not selected any answer
        %>
    <label>Your Answer:   </label><p>Not Answered  <i class="fa fa-times" aria-hidden="true" style="color: red;"></i></p></label>
<label>Correct Answer:   </label><p style="display: inline;">  <%=correctAnswer%><i class="fa fa-check" aria-hidden="true" style="color: green;"></i></p>
    <%
        }
    %>

<%
    }
    //Recording results to the database
    String insertQuery = "INSERT INTO `results`(`Score`, `Date`, `PersonID`, `Quiz_id`) VALUES (?,?,?,?)";
    PreparedStatement insertStatement = connection.prepareStatement(insertQuery);
    insertStatement.setInt(1, correctAnswers);
    java.sql.Date d = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    insertStatement.setDate(2, d);
    insertStatement.setString(3, PersonID);
    insertStatement.setInt(4, quiz_id);
    insertStatement.executeUpdate();
    connection.close();
%>
<br><br><p><%="Your Score is:  " + correctAnswers%></p>
<%
    }
%>       
</body>
</html>
