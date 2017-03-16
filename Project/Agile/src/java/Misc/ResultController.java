package Misc;

import Stores.Answer;
import Stores.ResultModel;
import java.sql.SQLException;
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
    
    public List<Answer> fetchResultsIndividual(int rId) {
        List<Answer> answers = null;
        try {
            answers = Answer.getStudentAnswers(Helpers.connect(), rId);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResultModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return answers;
    }
}
