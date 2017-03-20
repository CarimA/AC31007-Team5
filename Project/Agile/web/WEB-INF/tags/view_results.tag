<%@tag import="Stores.User"%>
<%@tag import="Stores.ResultModel"%>
<%@tag import="java.util.List"%>
<%@tag import="java.text.SimpleDateFormat"%>
<%@tag import="Misc.ResultController"%>
<%@tag import="Stores.Quiz"%>
<%@tag import="Models.QuizModel"%>


<%
    User user = (User) session.getAttribute("user");
            if (user == null || user.getPosition().toLowerCase().equals("student")) {
                response.sendRedirect("index.jsp");
            }
    Quiz quiz = (Quiz) session.getAttribute("quiz");

    ResultModel result = new ResultModel();
    List<ResultModel> results = (List<ResultModel>) session.getAttribute("results");
%>


<h1><%=quiz.getTitle()%></h1>
<%
    boolean alt = false;
    for (int i = 0; i < results.size(); i++) {
        alt = !alt;
        result = results.get(i);
%>
        <div class="dynamic-row <%= alt ? "quiz-alt": "" %>">
            <div class="dynamic-column">
                <%=result.getPersonId()%>
            </div>
            <div class="dynamic-column grow">
                <%=User.getNameFromID(result.getPersonId())%>
            </div>
            <div class="dynamic-column">
                <%=result.getScore()%> points
            </div>
            <div class="dynamic-column">
                <%
                SimpleDateFormat sdf = new SimpleDateFormat("EEEE dd MMMM yyyy");

                %>
                <%= sdf.format(result.getDate()) %>
            </div>
            <div class="dynamic-column">
                <a href="/Agile/StudentResults/<%= result.getId() %>">View Details</a>
            </div>
        </div>
<% 
}
%>