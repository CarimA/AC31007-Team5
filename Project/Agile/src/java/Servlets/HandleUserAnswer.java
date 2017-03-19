/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Misc.Helpers;
import Stores.Answer;
import Stores.Question;
import Stores.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
@WebServlet(name = "HandleUserAnswer", urlPatterns = {"/HandleUserAnswer"})
public class HandleUserAnswer extends HttpServlet {

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
            out.println("<title>Servlet HandleUserAnswer</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet HandleUserAnswer at " + request.getContextPath() + "</h1>");
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
        processRequest(request, response);
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
        //processRequest(request, response);
        int id = Integer.valueOf(request.getParameter("id"));
        String title = request.getParameter("title");
        String module = request.getParameter("module");
        String answer = request.getParameter("answer");
        Quiz quiz = new Quiz();
        Question q;
        Answer a;
        Connection connection;
        try {
            if (module != null && answer != null) {
                connection = Helpers.connect();
                //List<Question> questions = quiz.fetchQuestions(connection, id);
                String query = "update quiz set available = ? where id=" + id;
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setInt(1, 0);
                statement.executeUpdate();
                
                connection.close();
                
                request.setAttribute("module", module);
                request.setAttribute("id", 0);
                request.getRequestDispatcher("/takeQuiz.jsp").forward(request, response);
                //ResultSet resultSet = statement.executeQuery();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(HandleUserAnswer.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(HandleUserAnswer.class.getName()).log(Level.SEVERE, null, ex);
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
