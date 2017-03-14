package Misc;

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
    public List<ResultModel> fetchResultOverview() {
        List<ResultModel> results = null;
        try {
            results = ResultModel.fetch(Helpers.connect());
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ResultModel.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        
        return results;
    }
}
