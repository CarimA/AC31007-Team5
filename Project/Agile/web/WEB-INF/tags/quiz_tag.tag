<%-- 
    Document   : quiz_tag
    Created on : 12-Mar-2017, 12:38:20
    Author     : Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
    But basica
    lly writte
    n from scr
    atch by    : Carim Akeju
--%>
<%--
quizzes are fetched and displayed to the user.
Each quiz is displayed depending on whether is available and complete. 
All the quizzes which are not available have the ?Take Quiz? button disabled. 
--%>

<%@tag import="Stores.ResultModel"%>
<%@tag import="Stores.User"%>
<%@tag import="Stores.Quiz"%>
<%@tag import="java.util.List"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.Map"%>
<%@tag import="java.util.HashMap"%>
<%@tag import="Misc.Helpers"%>
<%@tag import="java.sql.Connection"%>
<%@tag import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<div class="dynamic-row">
	<a href="moduleSort.jsp">Filter By Module</a>&nbsp;&nbsp;
	<a href="completionSort.jsp">Filter By Completion</a>
</div>
<%
	String userID = ((User)session.getAttribute("user")).getId();
	Connection connection = Helpers.connect();
	
	// first, get the quizzes that the user has already done
	String attemptQuery = "SELECT QuizID, Score from results where PersonID = ?";
	PreparedStatement attemptStatement = connection.prepareStatement(attemptQuery);
	attemptStatement.setString(1, userID);
	ResultSet resultSet = attemptStatement.executeQuery();
	
	Map AttemptIDs = new HashMap();
	
	while (resultSet.next()) {
		AttemptIDs.put(resultSet.getInt("QuizID"), resultSet.getInt("Score"));
	}
                
	// now, get a list of all quizzes
	String quizQuery = "SELECT qID, Title, Module, Available from quiz";
	PreparedStatement quizStatement = connection.prepareStatement(quizQuery);
	resultSet = quizStatement.executeQuery();
	
	List<Quiz> quizzes = new ArrayList<Quiz>();
	
	while(resultSet.next()) {
            quizzes.add(new Quiz(resultSet.getInt("qID"), resultSet.getString("Title"), resultSet.getString("Module"), null, resultSet.getBoolean("Available"), null));
	}
	
        boolean alt = false;
	for (Quiz quiz : quizzes) {
            if(!quiz.isAvailable()){continue;}
            alt = !alt;
%>
            <div class="dynamic-row <%= alt ? "quiz-alt": "" %>">
		<div class="dynamic-column grow">
                    <b><%= quiz.getModule() %>:</b> <%= quiz.getTitle() %>
                </div>                
<%
		if (AttemptIDs.containsKey(quiz.getId())) {
%>
			<div class="dynamic-column">
                            Score: <%= AttemptIDs.get(quiz.getId()) %>
			</div>
<%
		}
%>

		<div class="dynamic-column">
			<a href="/Agile/TakeQuiz/<%= quiz.getId() %>">Take Quiz</a>
		</div>
            </div>
<%
	}	
%>
	