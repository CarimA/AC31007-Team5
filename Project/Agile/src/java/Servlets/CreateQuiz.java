/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.*;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Danstev
 */
@WebServlet(name = "createQuiz", urlPatterns = {"/createQuiz"})
public class CreateQuiz extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd;
        int numberOfQuestions = Integer.parseInt(request.getParameter("questions"));
        //request.setAttribute("number",numberOfQuestions);
        QuizModel qm = new QuizModel();
        int quizID = qm.createQuizReturnId("Quiz Name", "Module Name");
        for(int i=1;i<=numberOfQuestions;i++){
            qm.addQuestion("Question Name", i, 0, quizID);
        }
        rd = request.getRequestDispatcher("/Agile/EditQuiz/" + quizID);
        rd.forward(request,response);
    }

}
