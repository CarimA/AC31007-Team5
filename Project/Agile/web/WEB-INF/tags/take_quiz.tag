
<%@tag import="Stores.Answer"%>
<%@tag import="Stores.Question"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@tag import="Stores.Quiz"%>
<%@tag import="Stores.User"%>

<%/*
            User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().equals("staff")) {
                response.sendRedirect("index.jsp");
            }*/
    Quiz quiz = (Quiz) session.getAttribute("quiz");
    Question q;
    Answer a;
    List<Question> questions = quiz.getQuestions();
%>
<h1><%=quiz.getTitle()%></h1>

<form method="POST" action="/Agile/TakeQuiz">
    <%
        for (int i = 0; i < questions.size(); i++) {
            q = questions.get(i);
    %>
            <div class="row">
                <h3><%=q.getQuestion()%></h3>
            </div>    
            <div class="row">
                <p>This question is worth <%=q.getPoints()%> points.</p>
            </div>

    <%
            List<Answer> answers = q.getAnswers();
            boolean newRow = false;
            for (int j = 0; j < answers.size(); j++) {
                newRow = !newRow;
                a = answers.get(j);

                if (newRow) {
    %>
                    <div class="row">
    <%
                }
    %>
                <div class="six columns answer">
                    <input type="radio" id="c<%=a.getId()%>" name="<%=i%>" value="<%=a.getId()%>">
                    <label for="c<%=a.getId()%>">
                        <%=a.getAnswer()%>
                    </label>
                </div>
    <%
                if (!newRow || j == answers.size() - 1) {
    %>
                    </div>
    <%
                }
            }
        }
    %>
    <input type="submit" value="Submit">
</form>