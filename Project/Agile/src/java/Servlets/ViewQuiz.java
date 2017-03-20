package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Misc.ResultController;
import Models.QuizModel;
import Stores.Answer;
import Stores.Quiz;
import Stores.ResultModel;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jimiwesterholm
 */
@WebServlet(urlPatterns = {"/ViewQuiz", "/ViewQuiz/*"})
public class ViewQuiz extends HttpServlet {


    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        QuizModel qm = new QuizModel();
        ResultController rc = new ResultController();
        
        String[] args = request.getRequestURI().split("/");
        int a = Integer.parseInt(args[3]);
        Quiz quiz = qm.fetchQuiz(a);
        
        
        request.getSession().setAttribute("quiz", quiz);
        request.getSession().setAttribute("results", rc.fetchResultOverview(quiz.getId()));
        RequestDispatcher rd = request.getRequestDispatcher("/viewQuiz.jsp");
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
//        ResultController rc = new ResultController();
//        int rId = (Integer) request.getSession().getAttribute("rId");
//        List<Answer> studentAns = rc.fetchAnswersIndividual(rId);
//        ResultModel rm = rc.fetchResultsIndividual(rId);
//        request.getSession().setAttribute("studentAns", studentAns);
//        request.getSession().setAttribute("studentRes", rm);
//        response.sendRedirect("/Agile/quizSummary.jsp");
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
