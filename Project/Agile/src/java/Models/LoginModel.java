/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Exception.PasswordInvalidException;
import Exception.UsernameInvalidException;
import Stores.User;
import java.sql.*;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jimiwesterholm
 */
public class LoginModel {
    Connection connection;
    
    public LoginModel() {
        try {
            connection = DriverManager.getConnection(
                "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
        }
        catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState:     " + e.getSQLState());
            System.out.println("VendorError:  " + e.getErrorCode());
        }
    }
    
    public User checkLogin(String username, String password) {
        try {
            return User.login(connection, username, password);
        } catch (UsernameInvalidException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (PasswordInvalidException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public User registerUser(String userID, String password, String displayName, String email, String position) {
        try {
            return User.register(connection, userID, password, displayName, email, position);
        } catch (UsernameInvalidException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (PasswordInvalidException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
