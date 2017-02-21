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
    String id;
    String name;
    String password;
    String email;
    String position;
    String salt;
    
    public Person()
    {
        
    }
    public Person(String id, String name,String password, String email,String position, String salt)
    {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.position = position;
        
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String firstname) {
        this.name = firstname;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

}
