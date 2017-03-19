<%-- 
    Document   : quiz_tag
    Created on : 12-Mar-2017, 12:38:20
    Author     : Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
--%>
<%--
quizzes are fetched and displayed to the user.
Each quiz is displayed depending on whether is available and complete. 
All the quizzes which are not available have the ‘Take Quiz’ button disabled. 
--%>

<%@tag import="Stores.ResultModel"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@tag import="Stores.QuizModel"%>
<%@tag import="Misc.Helpers"%>
<%@tag import="java.sql.Connection"%>
<%@tag description="put the tag description here" pageEncoding="UTF-8"%>
<%@tag import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<%-- The list of normal or fragment attributes can be specified here: --%>
<%@attribute name="message"%>

<%-- any content can be specified here e.g.: --%>
<h2>${message}</h2>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="assets/css/skeleton.min.css" />
        <link rel="stylesheet" href="assets/css/style.css" />
        <link rel="stylesheet" href="assets/css/style" />
        <link rel="stylesheet" href="assets/css/font-awesome.min.css">
    </head>
    <body>
        <div class="row">
            <a href="moduleSort.jsp"><button>Filter by Module</button></a>&nbsp;&nbsp;
            &nbsp;&nbsp;<a href="moduleSort.jsp"><input type="checkbox" name="filter"> </a> Filter by Completion           
        </div>
        <%
            String PersonID = session.getAttribute("userIDKey").toString();
            
            Connection connection = Helpers.connect();
            String resQuery = "SELECT * FROM results where PersonID=" + PersonID;
            PreparedStatement resstatement = connection.prepareStatement(resQuery);
            ResultSet resresultSet = resstatement.executeQuery();
            List<ResultModel> resquizes = new ArrayList<ResultModel>();
            ResultModel resModel;

            while (resresultSet.next()) {//fetching the quiz results
                resModel = new ResultModel(resresultSet.getInt("rId"), resresultSet.getInt("QuizID"), resresultSet.getDate("Date"), resresultSet.getString("PersonID"), resresultSet.getInt("Score"));
                resquizes.add(resModel);
            }

            String query = "SELECT * FROM quiz";//to order the quizzes by module
            PreparedStatement statement = connection.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            List<QuizModel> quizes = new ArrayList<QuizModel>();
            QuizModel quizModel;
            int theme = 0;
            while (resultSet.next()) {//fetching the quizzes
                quizModel = new QuizModel(resultSet.getInt("qId"), resultSet.getString("Title"), resultSet.getString("Module"), resultSet.getDate("DateCreated"), resultSet.getInt("Available"),false,0);
                 
                           
                if (!resquizes.isEmpty()) {//determining the completed quizzes
                    for (ResultModel resultModel : resquizes) {
                        if ((resultModel.getQuizId() == quizModel.getQuizId()) && (resultModel.getPersonId().equals(PersonID))) {
                            quizModel.setAvailable(0);
                            quizModel.setComplete(true);
                            quizModel.setScore(resultModel.getScore());
                        }
                    }
                }
                quizes.add(quizModel);
            }
            boolean resultsAvailable=false;
            int score =0;
            for (QuizModel quizObj : quizes) {
                if (quizObj.getComplete()) {
                    resultsAvailable = true;
                    score = quizObj.getScore();
                } else {
                    resultsAvailable = false;
                }
                if (theme % 2 == 0) {//keeps track of changing row color
                    
                    if (quizObj.getAvailable() == 0) {//the quiz is not available

        %>

        <div class="dynamic-row quiz-row" hidden="true">
            <div class="dynamic-column">
                <%=quizObj.getTitle()%>
            </div>
            <div class="dynamic-column grow">
                <%= quizObj.getModule()%>
            </div>
            <div class="dynamic-column grow">
                
                <%
                    if(resultsAvailable){//not available because its done already
                    out.println("(Quiz completed Score: "+ score+")" );
                    }
                %>
            </div>


            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>

        </div>
        <%
        } else {//the quiz is available but not complete
        %>
        <div class="dynamic-row quiz-row" hidden="true">
            <div class="dynamic-column">
                <%= quizObj.getTitle()%>
            </div>
            <div class="dynamic-column grow">
                <%= quizObj.getModule()%>
            </div>
            <div class="dynamic-column">
                <br><br>
                <form name="frm" method="post" action="takeQuizStudent.jsp">
                    <input type="hidden" name="qId" value="<%= quizObj.getQuizId()%>" />
                    <input type="hidden" name="title" value="<%= quizObj.getTitle()%>" />
                    <input type="hidden" name="module" value="<%= quizObj.getModule()%>" />
                    <input type="submit" name="button" value="Take quiz"/>
                </form>
            </div>
        </div>

        <%
            }
            theme++;
        } else {//to handle change of color
            if (quizObj.getAvailable() == 0) {//the quiz is not available
        %>
        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                <%=quizObj.getTitle()%>
            </div>
            <div class="dynamic-column grow">
                <%= quizObj.getModule()%>
            </div>
            <div class="dynamic-column grow">
                
                <%
                    if(resultsAvailable){
                    out.println("(Quiz completed Score: "+ score+")" );
                    }
                %>
            </div>
            <div class="dynamic-column">
                <i class="fa fa-lock" aria-hidden="true"></i>
                <i class="fa fa-cog" aria-hidden="true"></i>
            </div>


        </div>
        <%
        } else {//the quiz is available but not available
        %>

        <div class="dynamic-row quiz-row quiz-alt">
            <div class="dynamic-column">
                <%=quizObj.getTitle()%>
            </div>
            <div class="dynamic-column grow">
                <%= quizObj.getModule()%>
            </div>
            <div class="dynamic-column">
                <br><br>
                <form name="frm" method="post" action="takeQuizStudent.jsp">
                    <input type="hidden" name="qId" value="<%= quizObj.getQuizId()%>" />
                    <input type="hidden" name="title" value="<%= quizObj.getTitle()%>" />
                    <input type="hidden" name="module" value="<%= quizObj.getModule()%>" />
                    <input type="submit" name="button" value="Take quiz"/>
                </form>
            </div>
        </div>
        <%
                    }
                    theme++;
                }
            }
        %>
    </body>