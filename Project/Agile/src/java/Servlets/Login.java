/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Exception.NotImplementedException;
import Exception.PasswordInvalidException;
import Exception.UsernameInvalidException;
import Misc.Helpers;
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
@WebServlet(name = "Login", urlPatterns = { "/Login" })
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            Helpers.redirect(request, response, "login.jsp", false);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginModel lm = new LoginModel();
        
        String id = request.getParameter("id");
        String password = request.getParameter("password");
        
        HttpSession session = request.getSession();
        try {
            User user = lm.checkLogin(id, password);
            if (user == null) {
                Helpers.errorRedirect(request, response, "login.jsp", false, "An unknown error occured."); 
            } else {
                session.setAttribute("user", user);
                Helpers.successRedirect(request, response, "Home", true, "Successfully logged in!");
            }
        } catch (UsernameInvalidException | PasswordInvalidException ex) {
            Helpers.errorRedirect(request, response, "login.jsp", false, "Username and/or Password incorrect!");
        } catch (Exception e) {
            Helpers.errorRedirect(request, response, "login.jsp", false, "Something else happened");
        }
    }
}
