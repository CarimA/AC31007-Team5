/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;


import Misc.Helpers;
import Misc.ResultController;
import Models.QuizModel;
import Stores.Answer;
import Stores.Question;
import Stores.Quiz;
import Stores.User;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author jimiwesterholm
 */
@WebServlet(urlPatterns = {"/TakeQuiz", "/TakeQuiz/*"})
public class TakeQuiz extends HttpServlet {


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
        QuizModel qm = new QuizModel();
        
        String[] args = request.getRequestURI().split("/");
        int a = Integer.parseInt(args[3]);
        Quiz quiz = qm.fetchQuiz(a);
        
        
        request.getSession().setAttribute("quiz", quiz);
        RequestDispatcher rd = request.getRequestDispatcher("/takeQuiz.jsp");
        rd.forward(request, response);
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
        User user = (User) request.getSession().getAttribute("user");
        Quiz quiz = (Quiz) request.getSession().getAttribute("quiz");
        
        if (user == null || quiz == null) {
            Helpers.errorRedirect(request, response, "Home", true, "An unknown error occured.");
        }
        
        int score = 0;
        Date date = new Date(System.currentTimeMillis());
        String pId = user.getId();
        int qId = quiz.getId();
        
        List<Question> questions = quiz.getQuestions();
        List<Integer> answerIDs = new ArrayList();
        
        for (int i = 0; i < questions.size(); i++) {
            List<Answer> answers = questions.get(i).getAnswers();
            
            //Get answer id
            String qs = String.valueOf(i);
            String a = request.getParameter(qs);
            System.out.println(a);
            int answerID = Integer.parseInt(a);
            
            //Check if correct
            for (int j = 0; j < answers.size(); j++) {
                if (answers.get(j).isRight() && answerID == answers.get(j).getId()) score += questions.get(i).getPoints();
            }
            answerIDs.add(answerID);
        }
        
        ResultController rc = new ResultController();
        int rId = rc.sendResults(score, date, pId, qId, answerIDs);
        request.getSession().setAttribute("rId", rId);
        request.getSession().setAttribute("score", score);
        //QuizModel qm2 = new QuizModel();
        //Quiz quiz2 = qm2.fetchQuiz(rc.getQuizId(rId));
        List<Answer> studentAns = rc.fetchAnswersIndividual(rId);
        
        //request.getSession().setAttribute("quiz", quiz2);
        request.getSession().setAttribute("studentAns", studentAns);
        
        response.sendRedirect("/Agile/quizSummary.jsp");
        
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
