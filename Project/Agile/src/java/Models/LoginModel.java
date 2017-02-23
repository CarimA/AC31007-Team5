/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Exception.PasswordInvalidException;
import Exception.UsernameInvalidException;
import Misc.Helpers;
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
        
    }
    
    public User checkLogin(String username, String password) throws UsernameInvalidException, PasswordInvalidException {
        try {
            return User.login(Helpers.connect(), username, password);
        } catch (UsernameInvalidException | PasswordInvalidException ex) {
            throw ex;
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public User registerUser(String userID, String password, String displayName, String email, String position) {
        try {
            return User.register(Helpers.connect(), userID, password, displayName, email, position);
        } catch (UsernameInvalidException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (PasswordInvalidException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (SQLException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginModel.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
