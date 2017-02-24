/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.newServlets;

import Exception.NotImplementedException;
import Models.LoginModel;
import Stores.User;
import java.io.IOException;
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
 * @author carimakeju
 */
@WebServlet(name = "Register", urlPatterns = { "/Register" })
public class Register extends HttpServlet {
    private String error = "";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
         request.setAttribute("error",error);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String error = "";
       
       String userID = request.getParameter("userID");
       String pass = request.getParameter("pass");
       String displayName = request.getParameter("name");
       String email = request.getParameter("email");
       String position = request.getParameter("position");
       
       if(userID.length() <= 0){
           error += "Matriculation number is invalid!";
           return;
           
       }
        
        

        try { 
            throw new NotImplementedException();
        } catch (NotImplementedException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
}
