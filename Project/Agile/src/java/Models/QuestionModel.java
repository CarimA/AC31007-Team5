/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Misc.Helpers;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Danstev
 */
public class QuestionModel {
    
    public void CreateQuestion(String id, String question, String image, String points){
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement;
            statement = connection.prepareStatement("INSERT INTO `Question` (`qId`, `Question`, `image`,`points`) VALUES\n" +
"(?, ?, ?, ?);");
            statement.setString(1, id);
            statement.setString(2, question);
            statement.setString(3, image);
            statement.setString(4, points);
            statement.execute();
            statement.close();
            connection.close();
            return;
        }
        catch(SQLException e)
        {
           return; 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuizModel.class.getName()).log(Level.SEVERE, null, ex);
            return;
        }
    }
    
}
