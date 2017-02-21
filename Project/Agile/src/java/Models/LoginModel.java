/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Stores.Person;
import java.sql.*;
import java.util.UUID;

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
    
    public Person checkLogin(String user, String pass) {
        Person person = null;
        try {
            //ADD MATRIC ID TO DATABASE
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM person where pId = ?");
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                if (rs.getString("Password").equals(pass)) {
                    person = new Person();
                    
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
            
        }
       catch(SQLException e) {
            System.out.println("SQLException: " + e.getMessage());
            System.out.println("SQLState:     " + e.getSQLState());
            System.out.println("VendorError:  " + e.getErrorCode());
            return null;
        }
    }
    
}
