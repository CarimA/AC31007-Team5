/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.DBConnect;
import Models.QuizModel;
import Stores.Answer;
import Stores.Question;
import Stores.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import sun.security.ssl.Debug;

/**
 *
 * @author finlaybrooker
 */
@WebServlet(urlPatterns = {
    "/EditQuiz",
    "/EditQuestion",
    "/EditAnswer",
    "/EditQuiz/*",
    "/EditQuestion/*",
    "/EditAnswer/*"
        
})
public class EditQuiz extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditQuiz</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet EditQuiz at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("We got to here");
        String[] args = request.getRequestURI().split("/");
        //System.out.println(args[0]);
        System.out.println(args[1]);
        System.out.println(args[2]);
        System.out.println(args[3]);
        if(args[2].equals("EditQuiz")){
            Quiz quiz = new Quiz();
            QuizModel qm = new QuizModel();
            quiz = qm.fetchQuiz(parseInt(args[3]));
            RequestDispatcher rd = request.getRequestDispatcher("/editQuiz.jsp");
            request.setAttribute("Quiz",quiz);
            
            rd.forward(request, response);
        }
        else if(args[2].equals("EditQuestion")){
            // get question with id depicted in url
            Question q = new Question();
            Quiz quiz = new Quiz();
            QuizModel qm = new QuizModel();
            quiz = qm.fetchQuiz(parseInt(args[3]));
            for(int i=0;i<quiz.getQuestions().size();i++){
                if(quiz.getQuestions().get(i).getId() == parseInt(args[3])){
                    q= quiz.getQuestions().get(i);
                    break;
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher("/editQuestion.jsp");
            request.setAttribute("QuizID",quiz.getId());
            request.setAttribute("Question", q);
            rd.forward(request, response);
        }
        else if(args[2].equals("EditAnswer")){
            Answer a = new Answer();
            Question q = new Question();
            Quiz quiz = new Quiz();
            QuizModel qm = new QuizModel();
            quiz = qm.fetchQuiz(parseInt(args[3]));
            for(int i=0;i<quiz.getQuestions().size();i++){
                q = quiz.getQuestions().get(i);
                for(int j =0;j<q.getAnswers().size();j++){
                if(q.getAnswers().get(j).getId() == parseInt(args[3])){
                    a = q.getAnswers().get(j);
                    break;
                }
            }
            }
            
            //Answer a = GetAnswer(args[3]);
            RequestDispatcher rd = request.getRequestDispatcher("/editAnswer.jsp");
            request.setAttribute("QuizID",quiz.getId());
            request.setAttribute("QuestionID", q.getId());
            request.setAttribute("Answer", a);
            rd.forward(request, response);
        }
        
        //processRequest(request, response);
    }
    
    

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] args = request.getRequestURI().split("/");
        
        if(args[2].equals("EditQuiz")){
            String title = request.getParameter("title");
            String module = request.getParameter("module");
            String available = request.getParameter("available");
            System.out.println(available);
            boolean a;
            if(available == null){
                a = false;
            }
            else if(available.equals("on")){
                a = true;
            }
            else{
                a = false;
            }
            System.out.println(a);
            int quizID = parseInt(request.getParameter("QuizID"));
            QuizModel qm = new QuizModel();
            qm.updateQuiz(quizID,title,module,a);
            System.out.println(available);
            response.sendRedirect("/Agile/EditQuiz/"+quizID);
        }
        else if(args[2].equals("EditQuestion")){
            String question = request.getParameter("question");
            //String image = request.getParameter("image");
            int points = parseInt(request.getParameter("points"));
            int questionID = parseInt(request.getParameter("QuestionID"));
            // qm.updateQuestion(question,image,points,questionID):
            QuizModel qm = new QuizModel();
            qm.updateQuestion(questionID, question, points);
            response.sendRedirect("/Agile/EditQuestion/"+questionID);
        }
        else if(args[2].equals("EditAnswer")){
            String answer = request.getParameter("answer");
            String explanation = request.getParameter("explanation");
            String right = request.getParameter("right");
            int answerID = parseInt(request.getParameter("AnswerID"));
            // qm.updateAnswer(answer,explanation,right,answerID):
            System.out.println(right);
            boolean a;
            if(right == null){
                a = false;
            }
            else if(right.equals("on")){
                a = true;
            }
            else{
                a = false;
            }
            System.out.println(a);
            QuizModel qm = new QuizModel();
            qm.updateAnswer(answerID, answer, explanation, a);
            response.sendRedirect("/Agile/EditAnswer/" +answerID);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
