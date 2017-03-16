/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Misc;

import Stores.Answer;
import Stores.ResultModel;
import java.util.List;
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
        int expectedResult = 12;
        int id = 1;
        List<ResultModel> results = rc.fetchResultOverview(1);
        assertEquals(expectedResult, results.get(0).getId());
    }
    
    @Test
    public void testFetchResultsIndividual() {
        String expectedResult = "fine";
        int id = 14;
        List<Answer> answers = rc.fetchResultsIndividual(id);
        assertEquals(expectedResult, answers.get(0).getExplanation());
    }
    
}
