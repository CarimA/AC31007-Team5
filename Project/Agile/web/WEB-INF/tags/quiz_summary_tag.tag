
<%@tag import="Stores.Answer"%>
<%@tag import="Stores.Question"%>
<%@tag import="java.util.ArrayList"%>
<%@tag import="java.util.List"%>
<%@tag import="Stores.Quiz"%>
<%@tag import="Stores.User"%>

<%
    Stores.User user = (Stores.User)(request.getSession().getAttribute("user"));
        String email = user.getEmail();
        String displayname = user.getDisplayName();
        String id = user.getId();
        
        Stores.Quiz quiz = (Stores.Quiz) (request.getSession().getAttribute("quiz"));
        String title = quiz.getTitle();
        String module = quiz.getModule();
        
        
        List<Answer> answersStudent = (List<Answer>) (request.getSession().getAttribute("studentAns"));
        //List<Answer> answers = new ArrayList<Answer>();
        String questionss = "";
        String studentAnswers = "";
        String check = "";
        int count = 1;
        Question q;
        List<Question> questions = quiz.getQuestions();
        Answer a;
        
        String correct = "";
        int p;
        int points = 0;
%>
<h1>Summary for <%=title%> for <%=module%> module</h1> 
<h2>ID: <%=id%></h2>
<h2>Name: <%=displayname%></h2>
<h2>Email: <%=email%></h2>
<h2>Grade ......</h2><br><br><br>

<%
    for (int i=0; i<questions.size(); i++)
        {
%> <br><br> <%
            q = questions.get(i);%>
            
            <h4><%=q.getQuestion()%></h4>
            <%
                List<Answer> answers = q.getAnswers();
                for (int b=0; b<answers.size(); b++)
                {
                    a = answers.get(b);%>
                    <h5><%=a.getAnswer()%></h5>
                    <%
                    
                }
        }
 
    
%>


