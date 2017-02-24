package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.QuizModel;
import Stores.Answer;
import Stores.Question;
import Stores.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.util.List;
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
@WebServlet(urlPatterns = {"/takeQuiz"})
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
        HttpSession session = request.getSession();
        QuizModel qm = new QuizModel();
        
        //String[] args = request.getRequestURI().split("/");
        Quiz quiz = qm.fetchQuiz(/*parseInt(args[1])*/1);
        
        
        request.setAttribute("quiz", quiz);
        RequestDispatcher rd = request.getRequestDispatcher("takeQuiz.jsp");
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
        RequestDispatcher rd = request.getRequestDispatcher("studentsummary.jsp");
        Quiz quiz = (Quiz) request.getAttribute("quiz");
        List<Question> questions = quiz.getQuestions();
        
        for (int i = 0; i < questions.size(); i++) {
            List<Answer> answers = questions.get(i).getAnswers();
            
            //Get answer object
            int q = questions.get(i).getId();
            String a = request.getParameter(Integer.toString(q));
            int answerID = Integer.getInteger(a);
            
            int j = 0;
            while (answers.get(j).getId()!=answerID) j++;
            
            request.setAttribute(Integer.toString(questions.get(i).getId()), answers.get(j));
        }
        
        rd.forward(request, response);
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
