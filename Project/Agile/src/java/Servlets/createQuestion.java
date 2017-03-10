/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.QuestionModel;
import Models.QuizModel;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Danstev
 */
@WebServlet(name = "createQuestion", urlPatterns = {"/createQuestion"})
public class createQuestion extends HttpServlet {



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
                RequestDispatcher rd;
        int numberOfQuestions = Integer.parseInt(request.getParameter("questions"));
        QuizModel qm = new QuizModel();
        int qID = qm.createQuiz((String)request.getParameter("title"), (String)request.getParameter("module"));
        for(int i = 1; i <= numberOfQuestions; i++)
        {
            String questionString = "question" + Integer.toString(i);
            String q = (String) request.getParameter(questionString);
            String numberString = "number" + Integer.toString(i);
            int number =  parseInt(request.getParameter(numberString));
            String pointsString = "points" + Integer.toString(i);
            int points =  parseInt(request.getParameter(pointsString));
            int questionID = qm.addQuestionGetID(q, number, points, qID);
            qm.addQuestion(q,number,points,questionID);
            System.out.println(q);
            System.out.println(number);
            System.out.println(points);
            System.out.println(questionID);
            for(int x = 0; x < 4; x++)
            {
                String aString = "answer" + Integer.toString(i);
                aString += Integer.toString(x);
                String answer = (String) request.getParameter(aString);
                String nString = "number" + Integer.toString(i);
                nString += Integer.toString(x);
                int aNumber =  parseInt(request.getParameter(nString));
                String eString = "explanation" + Integer.toString(i);
                eString += Integer.toString(x);
                String explanation =  (String) request.getParameter(eString);
                String rString = "right" + Integer.toString(i);
                rString += Integer.toString(x);
                boolean right =  parseBoolean(request.getParameter(rString));
                qm.addAnswer(answer,aNumber,explanation,right,questionID);
                System.out.println(answer);
                System.out.println(aNumber);
                System.out.println(explanation);
                System.out.println(right);
            }
        }
        rd = request.getRequestDispatcher("quizCreated.jsp");
        rd.forward(request,response);
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
