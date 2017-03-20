/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jimiwesterholm
 */
public class ResultControllerTest {
    ResultController rc;
    
    public ResultControllerTest() {
    }
    
    @Before
    public void setUp() {
        rc = new ResultController();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void testFetchResultsOverview() {
        int expectedResult = 88;
        int id = 1;
        List<ResultModel> results = rc.fetchResultOverview(1);
        assertEquals(expectedResult, results.get(0).getId());
    }
    
    @Test
    public void testfetchAnswersIndividual() {
        String expectedResult = "fine";
        int id = 14;
        List<Answer> answers = rc.fetchAnswersIndividual(id);
        assertEquals(expectedResult, answers.get(0).getAnswer());
    }
    
    @Test
    public void testGetQuizId() {
        int expectedResult = 1;
        int id = 88;
        int qId = rc.getQuizId(id);
        if (qId == -1) fail ("SQL not doing something right");
        assertEquals(expectedResult, qId);
    }
    
    @Test
    public void testSendResults() {
        //Get values to be stored + expected result
        int expResult = -1;
        try {
            Connection connection = Helpers.connect();
            PreparedStatement statement = connection.prepareStatement("SELECT rId FROM results ORDER BY rId Desc");
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                expResult = rs.getInt("rId") + 1;
                System.out.print(expResult);
                statement.close();
                connection.close();
            } else {
                statement.close();
                connection.close();
                fail("SQL fail");
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ResultControllerTest.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        int score = 12;
        Date date = new Date(System.currentTimeMillis());
        String pId = "666666666";
        int qId = 1;
        List<Integer> answerIDs = new ArrayList();
        answerIDs.add(1);
        answerIDs.add(6);
        answerIDs.add(10);
        
        int rId = rc.sendResults(score, date, pId, qId, answerIDs);
        assertEquals(expResult, rId);
    }
    
    @Test
    public void testFetchResultsIndividual() throws ClassNotFoundException, SQLException {
        Connection connection = Helpers.connect();
        int rId = 506;
        ResultController resultController = new ResultController();
        ResultModel expected = ResultModel.fetchResultsIndividual(rId);
        
        assertEquals(expected.getId(), resultController.fetchResultsIndividual(rId).getId());
    }
}
