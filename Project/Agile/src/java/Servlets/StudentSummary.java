/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * libraries for sending mail
 */
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import Stores.Question;
import Misc.Helpers;
import Stores.User;





/**
 *
 * @author Aleksandr
 */
@WebServlet(name = "StudentSummary", urlPatterns = {"/StudentSummary"})
public class StudentSummary extends HttpServlet {
     Connection connection;
    
    
    public StudentSummary() throws ClassNotFoundException, InstantiationException, IllegalAccessException {}
    
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
        RequestDispatcher rd = request.getRequestDispatcher("studentsummary.jsp");
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
        Stores.User user = (Stores.User)(request.getSession().getAttribute("user"));
        String email = user.getEmail();
        String displayname = user.getDisplayName();
        String id = user.getId();
        //Stores.ResultModel resultmodel = (Stores.ResultModel)(request.getSession().getAttribute("selectedQuizId"));
        int quizid = Integer.parseInt(request.getSession().getAttribute("selectedQuizId").toString());
        
        //int score = Integer.valueOf(request.getParameter("quiz_id"));
        
        sendEmail(email, displayname, id, quizid);
        rd = request.getRequestDispatcher("summarysent.jsp");
        rd.forward(request, response);
    }
    
    public void sendEmail(String email, String displayname, String id, int quizid)
    { 
        final String username = "agileteam5email@gmail.com";
        final String password = "Qwerty12345";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props,
          new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                }
            });
            try {
                Message message = new MimeMessage(session);
                message.setFrom(new InternetAddress("agileteam5email@gmail.com"));
                message.setRecipients(Message.RecipientType.TO,
                InternetAddress.parse(email));
                message.setSubject("Quiz summary for quiz" + quizid);
                message.setText("Dear " + displayname + " (Mariculation Number: " + id + "),"
                            + "\n\n Overeall score is " + quizid + "points"
                            + "");
                Transport.send(message);
                System.out.println("Done");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
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
