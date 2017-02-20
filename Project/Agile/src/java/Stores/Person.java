/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;
import java.util.UUID;
/**
 *
 * @author Aleksandr,Igors
 */
public class Person {
    UUID id;
    String firstname;
    String password;
    String email;
    String position;
    String salt;
    
    public Person()
    {
        
    }
    public Person(UUID id, String firstname,String password, String email,String position, String salt)
    {
        this.id = id;
        this.firstname = firstname;
        this.password = password;
        this.email = email;
        this.position = position;
        
    }
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
    
    public String getFirstname(String firstname) {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    
    public String getPassword(String password) {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail(String email) {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPosition(String position) {
        return position;
    }

    public void setModule(String position) {
        this.position = position;
    }

    public String getSalt(String salt) {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
