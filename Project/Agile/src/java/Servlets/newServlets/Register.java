/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets.newServlets;

import Exception.NotImplementedException;
import Models.LoginModel;
import Stores.User;
import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.length;
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
        RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
         request.setAttribute("error",error);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginModel lm = new LoginModel();
        RequestDispatcher rd;
         //rd = request.getRequestDispatcher("index.jsp");
        String error = " ";

        String userID = request.getParameter("userid");
        String pass = request.getParameter("password");
        String passConfirm = request.getParameter("passwordConfirm");
        String displayName = request.getParameter("displayName");
        String email = request.getParameter("email");
        String position = request.getParameter("position");
        
        // TODO: confirm password
        if(userID.length() != 9){
            error += "Matriculation number is invalid!";
            response.sendRedirect("login.jsp");
            return;
        }
       
        if(pass.length() < 7){
            error += "Password is to short! 7 characters minimum";
            response.sendRedirect("login.jsp");
            return;
        }
       
        HttpSession session = request.getSession();
        User user = lm.registerUser(userID, pass, displayName, email, position);
        
        if (user != null) {
            session.setAttribute("user", user);
            rd = request.getRequestDispatcher("index.jsp");
        } else {
            rd = request.getRequestDispatcher("login.jsp");
        }
        
        rd.forward(request, response);
    }

//        try { 
//            throw new NotImplementedException();
//        } catch (NotImplementedException ex) {
//            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    
    
    
    
    

