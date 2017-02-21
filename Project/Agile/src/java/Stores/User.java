/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import Misc.Helpers;
import java.util.UUID;

/**
 *
 * @author carimakeju
 */
public class User {
    private UUID id;
    private String username;
    private String password;
    private String email;
    private String salt;
    private Position position;
    
    public User() { }
    public User(String username, String password, String email, Position position) {
        setId(UUID.randomUUID());
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setPosition(position);
    }
    
    // getters
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    private String getPassword() { return password; }
    public String getEmail() { return email; }
    private String getSalt() { return salt; }
    public Position getPosition() { return position; }
    
    // setters
    private void setId(UUID id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
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
    public void setPosition(Position position) { this.position = position; }
    
    public enum Position {
        Student,
        Staff
    };
    
    public boolean checkPassword(String password) {
        return true;
    }    
}
