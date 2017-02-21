/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author danielward
 */
public class DBConnect {
    
    void DBConnect()
    {
        
    }
    
    public void connectToDb()
    {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM person");
            while (rs.next())
            {
                System.out.println(rs.getString(1));
            }
            rs.close();
            statement.close();
            connection.close();
        }
        catch(SQLException e) {
            
        }
    }
    
    //This doesn't work yet, will fix when i can be aresed.
    public ResultSet getResults(String query)
    {
        Connection connection;
        try {
            connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(query);
            
            rs.close();
            statement.close();
            connection.close();
            return rs;
        }
        catch(SQLException e) {
         return null;  
        }
    }
    
}


