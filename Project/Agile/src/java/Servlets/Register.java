package Servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Models.LoginModel;
import Stores.User;
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
 * @author jimiwesterholm
 */
@WebServlet(name = "Register", urlPatterns = {"/oldRegister"})
public class Register extends HttpServlet {


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
        request.setAttribute("message", "");
        RequestDispatcher rd = request.getRequestDispatcher("register.jsp");
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
        RequestDispatcher rd;
        LoginModel lm = new LoginModel();
        
        String message = "";
        
        String userID = request.getParameter("userID");
        String pass = request.getParameter("pass");
        String displayName = request.getParameter("name");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        
        if (userID.length() != 9) {
            message = "ID must be 9 characters long./n";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
        
        if(/*PASSWORD CHECKS*/true) {
            message = message + "Password must be X";
            request.setAttribute("message", message);
            rd = request.getRequestDispatcher("register.jsp");
            rd.forward(request, response);
        }
        
        HttpSession session = request.getSession();
        User user = lm.registerUser(userID, pass, displayName, email, position);
        
        if (user != null) {
            session.setAttribute("person", user);
            if ("Staff".equals(user.getPosition())) {
                rd = request.getRequestDispatcher("index.jsp");
            } else {
                rd = request.getRequestDispatcher("index.jsp");
            }
        } else {
            rd = request.getRequestDispatcher("register.jsp");
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
