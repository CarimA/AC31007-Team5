/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Misc.Helpers;
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
            quiz = Quiz.fetch(Helpers.connect(), id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return quiz;
    }
    
    public void updateQuiz(int id,String title,String module,boolean available){
        Connection connection;
        try {
            connection = Helpers.connect();
            
            
                PreparedStatement statement;
                statement = connection.prepareStatement("UPDATE quiz SET Title = ?, Module = ?, Available = ? WHERE qId = ?");
                statement.setString(1, title);
                statement.setString(2, module);
                statement.setBoolean(3, available);
                statement.setInt(4, id);
                statement.executeUpdate();
                statement.close();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public int CreateQuiz(String title, String module){
        int id = 0;
        try {
            Connection connection = Helpers.connect();
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
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }
    

}
