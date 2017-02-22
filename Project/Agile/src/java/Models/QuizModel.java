/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Stores.Quiz;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author jimiwesterholm
 */
public class QuizModel {
    Connection connection;
    
    public QuizModel() {
        
    }
    
    public Quiz fetchQuiz(int id) {
        Quiz quiz = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            quiz = Quiz.fetch(connection, id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return quiz;
    }
    
    public int CreateQuiz(String title, String module){
        int id = 0;
        try {
            Connection connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO Quiz (Title, Module, DateCreated) values (?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            //Date date = new Date(); SHould work?
            //statement.setString(3, date);
            statement.execute();
            
            statement = connection.prepareStatement("SELECT qId FROM Quiz where (Title, Module, DateCreated) values (?, ?, ?)");
            statement.setString(1, title);
            statement.setString(2, module);
            //Date date = new Date(); SHould work?
            //statement.setString(3, date);
            
            ResultSet rs = statement.executeQuery();
            while (rs.next())
            {
                id = rs.getInt("qId");
            }
            statement.close();
            connection.close();
            return id;
        }
        catch(SQLException e)
        {
           return 0; 
        }
    }
    

}
