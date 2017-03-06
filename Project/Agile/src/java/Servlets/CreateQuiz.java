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
        request.setAttribute("number",numberOfQuestions);
        rd = request.getRequestDispatcher("createQuestions");
        //String title = request.getParameter("title");
        //String module = request.getParameter("module");
        //QuizModel qm = new QuizModel();
        //int QuizID = qm.CreateQuiz(title, module);
        //todo: link the id to the create question page with rd;
        //rd = request.getRequestDispatcher("createQuestion/" + QuizID); //Is this right for a get?
        //Do i even want a get? just pass along a quiz object?
    }

}
