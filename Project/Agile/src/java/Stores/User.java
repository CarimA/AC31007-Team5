/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

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
    
    public UUID getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getSalt() { return salt; }
    public Position getPosition() { return position; }
    
    enum Position {
        Student,
        Staff
    };
}
