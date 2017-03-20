
<%@tag import="Stores.Answer"%>
<%@tag import="Stores.Question"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@tag import="Stores.Quiz"%>
<%@tag import="Stores.User"%>
<%@tag import="Stores.ResultModel"%>
<script>
    function myFunction() {
        window.print();
    }
</script>


<%
    Stores.User user = (Stores.User) (request.getSession().getAttribute("user"));
    String email = user.getEmail();
    String displayname = user.getDisplayName();
    String id = user.getId();
    Stores.Quiz quiz = (Stores.Quiz) (request.getSession().getAttribute("quiz"));
    String title = quiz.getTitle();
    String module = quiz.getModule();
    Question q;
    List<Question> questions = quiz.getQuestions();
    Answer a;
    Answer s;
    String explanation = "";
    String message = "";
    List<Answer> answersStudent = (List<Answer>) (request.getSession().getAttribute("studentAns"));

    if (user.getPosition().toLowerCase().equals("student")) {
%>


<div class="dynamic-row">
    <div class="dynamic-column">
        <p>Summary for <b><%=title%></b> for <b><%=module%></b> module</p>
    </div>
</div>
<div class="dynamic-row">
    <div class="dynamic-column">
        <%=id%>
    </div>
    <div class="dynamic-column grow">
        <%=displayname%>
    </div>
    <div class="dynamic-column">
        <%=email%>
    </div>
    <div class="dynamic-column">
        ${score}
    </div>
</div>
    
<%
    } else {
    ResultModel student = (ResultModel) session.getAttribute("studentRes");
%>

<div class="dynamic-row">
    <div class="dynamic-column">
        <p>Summary for <b><%=title%></b> for <b><%=module%></b> module</p>
    </div>
</div>
<div class="dynamic-row">
    <div class="dynamic-column">
        <%=student.getPersonId()%>
    </div>
    <div class="dynamic-column grow">
        <%=student.getDate()%>
    </div>
    <div class="dynamic-column">
        <%=student.getScore()%>
    </div>
</div> <%
    }

    for (int i = 0; i < questions.size(); i++) {
        q = questions.get(i);%>
<div class="row">
    <h3><%= q.getQuestion()%></h3>
</div>    
<div class="row">
    <p>This question was worth <%= q.getPoints()%> points.</p>
</div>

<%
    boolean newRow = false;
    List<Answer> answers = q.getAnswers();
    String background = "";
    s = answersStudent.get(i);
    for (int j = 0; j < answers.size(); j++) {
        newRow = !newRow;
        a = answers.get(j);

        if (newRow) {
%>
<div class="row">
    <%
        }

        background = "";
        if (s.isRight() && (a.getId() == s.getId())) {
            background = "correct";
        }
        if (!s.isRight() && (a.getId() == s.getId())) {
            background = "wrong";
        }
        if ((!s.isRight() && a.isRight())) {
            background = "correct";
        }
    %>
    <div class="six columns answer <%= background%>">
        <label for="c<%=a.getId()%>">
            <%=a.getAnswer()%>
        </label>
    </div> <%
        if (!newRow || j == answers.size() - 1) {
    %>
</div>
<%
        }
    }
%>
<div class="row">
    Explanation: <%=s.getExplanation()%>
</div>
<%
    }
%>
<form id="submit" method="POST" action="StudentSummary">
<input type="submit" value="Submit">
</form>
<button onclick="myFunction()">Print</button> 
    