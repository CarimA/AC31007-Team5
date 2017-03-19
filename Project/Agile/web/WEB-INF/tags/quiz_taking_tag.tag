<%-- 
    Document   : quiz_taking_tag
    Created on : 08-Mar-2017, 10:06:52
    Author     : Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
--%>
<%--
this page fetches and displays the questions of the quiz selected which their respective answers.
The answers are displayed using field-sets of radio buttons which separates the answers of each question. 
The radio button groups are identified using a unique name generated depending on the id of the questions.
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
            /*String query = "SELECT * FROM results WHERE PersonID = ? and QuizID = ? ";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, PersonID);
            statement.setInt(2, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {//if the student has not taken the quiz 
                Helpers.errorRedirect(request, response, "Home", true, "You have already done this quiz");
            }else{*/
            
            Quiz quiz = new Quiz();
            Question q;
            Answer a;
            //an error here
            List<Question> questions = quiz.fetchQuestions(connection, id);
            int possibleResults = 0;
            session.setAttribute("quizQuestions", questions);
            int arraySize = questions.size();
            if (!questions.isEmpty()) {//qustions array is not empty
        %>
        <h4><%=title%></h4>
        <h5>Answer All The Questions</h5>
        <div class="dynamic-row" hidden="true">  
<!--            displaying questions along side with choices-->
<!--  for the further student results process for overview and printing need to change this link -->
            <form method="POST" action="processResults.jsp">
                <input type="hidden" name="arraySize" value=<%=arraySize%>><br>                
                <%
                    //looping through the questions
                    for (int i = 0; i < questions.size(); i++) {
                        String ans = "ans";
                        q = questions.get(i);
                %>
                <ul style="list-style: none;">
                    <li><label><%=q.getQuestion()%> Worth <%=q.getPoints()%> points.</label><br>
                        <input type="hidden" name="quiz_id" value=<%=id%>>
                        <input type="hidden" name="question_id" value=<%=q.getId()%>>  
                        <input type="hidden" name="points" value="<%=q.getPoints()%>">
                        <%
                            List<Answer> answers = q.getAnswers();
                            //points of the questions
                            possibleResults = possibleResults = q.getPoints();
                            request.setAttribute("possibleResults", possibleResults);
                        %>
                        <fieldset id="<%= q.getId()%>">

                            <%
                                for (int j = 0; j < answers.size(); j++) {//looping through the answers
                                    a = answers.get(j);
                            %>
                            
                            <input type="radio" name="<%= ans + i%>" value="<%=a.getExplanation()%>"><%=a.getExplanation()%><br>
                            <%
                                if (a.isRight()) {//getting the correct answer for the question

                            %>
                            <input type="hidden" name="answer" value="<%=a.getExplanation()%>">
                            <%
                                    }
                                }
                            %>
                        </fieldset>
                    </li>
                </ul>

                <%}
                    } else {//if no questions in the quiz
                        Helpers.errorRedirect(request, response, "Home", true, "There are no questions in the quiz");
                    }
                %>
                <div class="dynamic-column">
                    <input type="submit" value="Submit Quiz">
                </div>
            </form>
                <%
            //}
        %>
        
        </div>