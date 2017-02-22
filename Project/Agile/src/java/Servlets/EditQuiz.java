/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Models.DBConnect;
import Stores.Quiz;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
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
@WebServlet(name = "EditQuiz", urlPatterns = {
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
            try {
                Class.forName("com.mysql.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, null, ex);
            }
            DBConnect db = new DBConnect();
            String query = "Select * from quiz where qId = " + args[3];
            Vector<Quiz> temp = db.getQuizes(query);
            System.out.println(temp.size());
            quiz = temp.elementAt(0);
            
            RequestDispatcher rd = request.getRequestDispatcher("/editQuiz.jsp");
            request.setAttribute("Quiz",quiz);
            
            rd.forward(request, response);
        }
        else if(args[2].equals("EditQuestion")){
            // get question with id depicted in url
            //Question q = GetQuestion(args[2]);
            //request.setAttribute("Question", q);
        }
        else if(args[2].equals("EditAnswer")){
            // get answer with id depicted in url
            //Answer a = GetAnswer(args[2]);
            //request.setAttribute("Answer", a);
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
        
        if(args[1].equals("/EditQuiz")){
            String title = request.getParameter("title");
            String module = request.getParameter("module");
            String available = request.getParameter("available");
        }
        else if(args[1].equals("/EditQuestion")){
            String question = request.getParameter("question");
            String image = request.getParameter("image");
            int points = parseInt(request.getParameter("available"));
        }
        else if(args[1].equals("/EditAnswer")){
            String answer = request.getParameter("answer");
            String explanation = request.getParameter("explanation");
            String right = request.getParameter("right");
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