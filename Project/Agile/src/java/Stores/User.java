/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import Misc.Helpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.UUID;

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
    
    public User() { }
    public User(String id, String displayName, String password, String email, String position) {
        setId(id);
        setDisplayName(displayName);
        setPassword(password);
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
    
    public enum Position {
        Student,
        Staff
    };
    
    public static User login(Connection connection, String id, String password) {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM person where pId = ?");
        statement.setString(1, user);
        ResultSet rs = statement.executeQuery();
        
        String hashedPassword = rs.getString("Password");
        String salt = rs.getString("Salt");
        String email = rs.getString("Email");
        
        
        
            
            if (rs.next()) {
                if (rs.getString("Password").equals(pass)) {
                    person = new User();
                    
                    String id;
                    id = rs.getString("pId");
                    person.setId(id);
                    person.setName(rs.getString("Name"));
                    person.setEmail(rs.getString("Email"));
                    person.setPosition(rs.getString("Position"));
                }
                
            }
            
            rs.close();
            statement.close();
            connection.close();
            
            return person;
            
        String displayName;
        String salt;
        String email;
        Position position;
        
        User u = new User(
                
                id,
                
        )
    }
    
    public boolean checkPassword(String password) {
        String hashedPassword = Helpers.sha256(password + getSalt());
        return (getPassword() == hashedPassword);
    }    
}
