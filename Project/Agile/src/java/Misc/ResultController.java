
package Misc;

import Stores.Answer;
import Stores.ResultModel;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author jimiwesterholm
 */
public class ResultController {
    
    public List<ResultModel> fetchResultOverview(int id) {
        List<ResultModel> results = null;
        
        try {
            results = ResultModel.fetch(Helpers.connect(), id);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResultModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return results;
    }
    
    public List<Answer> fetchAnswersIndividual(int rId) {
        List<Answer> answers = null;
        try {
            answers = Answer.getStudentAnswers(Helpers.connect(), rId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResultModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answers;
    }
    
    public int getQuizId(int rId) {
        int qId = -1;
        
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement = connection.prepareStatement("SELECT QuizID FROM results WHERE rId = ?");
            statement.setInt(1, rId);
            ResultSet rs = statement.executeQuery();
            
            if (rs.next()) {
                qId = rs.getInt("QuizID");
            }
            
            rs.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return qId;
    }
    
    public int sendResults(int score, Date date, String pId, int qId, List<Integer> answerIDs) {
        try {
            return ResultModel.upload(score, date, pId, qId, answerIDs);
        } catch (SQLException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    
    public ResultModel fetchResultsIndividual(int rId){
        try {
            return ResultModel.fetchResultsIndividual(rId);
        } catch (SQLException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultController.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
