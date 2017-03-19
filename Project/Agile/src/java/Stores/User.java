/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import Exception.PasswordInvalidException;
import Exception.UsernameInvalidException;
import Misc.Helpers;
import Models.LoginModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author carimakeju
 */
public class User {
    private String id;
    private String displayName;
    private String password;
    private String email;
    private String salt;
    private String position;
    

   public  User() { }


    private User(String id, String displayName, String password, String email, String position) {
        setId(id);
        setDisplayName(displayName);
        setNewPassword(password);
        setEmail(email);
        setPosition(position);
    }
    private User(String id, String displayName, String hashedPassword, String salt, String email, String position) {
        setId(id);
        setDisplayName(displayName);
        setPassword(hashedPassword);
        setSalt(salt);
        setEmail(email);
        setPosition(position);
    }
    
    // getters
    public String getId() { return id; }
    public String getDisplayName() { return displayName; }
    private String getPassword() { return password; }
    public String getEmail() { return email; }
    private String getSalt() { return salt; }
    public String getPosition() { return position; }
    
    // setters
    private void setId(String id) { this.id = id; }
    public void setDisplayName(String displayName) { this.displayName = displayName; }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setNewPassword(String password) { 
        // set a new random salt
        setSalt(UUID.randomUUID().toString());
                
        // hash the password
        String hashedPassword = Helpers.sha256(password + getSalt());
        
        // store new password
        this.password = hashedPassword; 
    }
    private void setSalt(String salt) { this.salt = salt; }
    public void setEmail(String email) { this.email = email; }
    public void setPosition(String position) { this.position = position; }
    
    
    public static User login(Connection connection, String id, String password) throws UsernameInvalidException, PasswordInvalidException, SQLException {        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person where pId = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            
            if (!rs.next()) {
                throw new UsernameInvalidException();
            }
            
            String hashedPassword = rs.getString("Password");
            String idInDB = rs.getString("pId");
            String displayName = rs.getString("DisplayName");            
            String salt = rs.getString("Salt");
            String email = rs.getString("Email");
            String position = rs.getString("Position");

            rs.close();
            statement.close();
            connection.close();
        
            User u = new User(id, displayName, hashedPassword, salt, email, position);
            if (u.checkPassword(password)) {
                return u;
            } else {
                throw new PasswordInvalidException();
            }
        }
        catch (UsernameInvalidException | PasswordInvalidException ex) {
            throw ex;
        }
    }
    
    public static User register(Connection connection, String id, String password, String displayName, String email, String position) throws UsernameInvalidException, PasswordInvalidException, SQLException {    
        
        // check password requirements (todo)
        
        
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person where pId = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            
            if (rs.isBeforeFirst()) {
                throw new UsernameInvalidException();
            }

            rs.close();
            
            if (false/*ADD PASSWORD VALIDITY CHECK*/) {
                throw new PasswordInvalidException();
            }
            
            User user = new User(id, displayName, password, email, position);
            String salt = user.getSalt();
            
            
            statement = connection.prepareStatement("INSERT INTO person (pId, DisplayName, Password, Email, Position, Salt) values (?, ?, ?, ?, ?, ?)");
            statement.setString(1, id);
            statement.setString(2, displayName);
            statement.setString(3, user.getPassword());
            statement.setString(4, email);
            statement.setString(5, position);
            statement.setString(6, salt);
            statement.execute();
            
            statement.close();
            connection.close();
            
            return user;
        }
        catch (UsernameInvalidException | PasswordInvalidException ex) {
            throw ex;
        }
    }
    
    public boolean checkPassword(String password) {
        String hashedPassword = Helpers.sha256(password + getSalt());
        return (getPassword().equals(hashedPassword));
    }
    
    public static String getNameFromID(String id) {
        PreparedStatement statement;
        Connection connection;
        String name = null;
        try {
            connection = Helpers.connect();
            statement = connection.prepareStatement("SELECT DisplayName FROM person where pId = ?");
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                name = rs.getString("DisplayName");
            }
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(User.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
}
