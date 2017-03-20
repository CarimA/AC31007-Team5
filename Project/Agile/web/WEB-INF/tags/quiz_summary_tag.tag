
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
        List<Question> questions = quiz.getQuestions();
        
        List<Answer> answersStudent = (List<Answer>) (request.getSession().getAttribute("studentAns"));
        List<Answer> answers = new ArrayList<Answer>();
        String questionss = "";
        String studentAnswers = "";
        String check = "";
        int count = 1;
        String q ="";
        String a = "";
        String correct = "";
        int p;
        int points = 0;
%>
<h2>Summary for <%=title%> for <%=module%> module</h2> 
<h3>ID: <%=id%></h3>
<h3>Name: <%=displayname%></h3>
<h3>Email: <%=email%></h3>
<h3>Grade ......</h3><br><br><br>

<%
    for (int i=0; i<questions.size(); i++)
        {
            q = questions.get(i).getQuestion();
            %> <h4><%
            p = questions.get(i).getPoints();
            answers = questions.get(i).getAnswers();
            a = answers.get(i).getAnswer();
            
            if(answersStudent.get(i).isRight())
            {
                check = "right";
                correct = a;
                points += p;
                
            }
            else 
            {
                check = "false";
                for (int u=0; u<answers.size(); u++)
                {
                    if (answers.get(u).isRight()) 
                    {
                        correct = answers.get(u).getAnswer();
                    }
                }
            }
        }
 
    
%>


