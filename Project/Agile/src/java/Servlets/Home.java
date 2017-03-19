/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Exception.NotImplementedException;
import Misc.Helpers;
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

/**
 *
 * @author carimakeju
 */
@WebServlet(name = "Home", urlPatterns = { "/Home", "" })
public class Home extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getSession().getAttribute("user") == null) {
            Helpers.redirect(request, response, "Login", true);
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if (user.getPosition().equalsIgnoreCase("student")){
                request.getRequestDispatcher("/student.jsp").forward(request, response);
            } else {
                //redirecting to admin page
                Helpers.redirect(request, response, "index.jsp", false);
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try { 
            throw new NotImplementedException();
        } catch (NotImplementedException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
