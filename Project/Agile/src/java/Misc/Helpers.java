package Misc;


import java.io.IOException;
import java.security.MessageDigest;
import java.sql.DriverManager;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author carimakeju
 */
public final class Helpers {
    // from http://stackoverflow.com/a/25243174
    public static String sha256(String base) {
        try{
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }

            return hexString.toString();
        } catch(Exception ex){
           throw new RuntimeException(ex);
        }
    }
    
    public static Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
    }
    
    public static void successRedirect(HttpServletRequest request, HttpServletResponse response, String redirectPage, boolean hardRedirect, String message) throws ServletException, IOException {
        request.getSession().setAttribute("success", message);
        redirect(request, response, redirectPage, hardRedirect);
    }
    
    public static void errorRedirect(HttpServletRequest request, HttpServletResponse response, String redirectPage, boolean hardRedirect, String message) throws ServletException, IOException {
        request.getSession().setAttribute("error", message);
        redirect(request, response, redirectPage, hardRedirect);
    }
    
    public static void redirect(HttpServletRequest request, HttpServletResponse response, String redirectPage, boolean hardRedirect) throws ServletException, IOException { 
        if (hardRedirect) {
            response.sendRedirect(redirectPage);            
        } else {
            RequestDispatcher rd = request.getRequestDispatcher(redirectPage);
            rd.forward(request, response);
        } 
    }
}
