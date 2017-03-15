/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import java.sql.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
//import static org.mockito.Mockito.mock;


/**
 * the same, this data worked on my db , need to add later to this database
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
public class ResultModelIT {
    
    public ResultModelIT() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getId method, of class ResultModel.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        int expResult = 1;
        int result = instance.getId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setId method, of class ResultModel.
     */
    @Test 
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        instance.setId(id);
       
    }

    /**
     * Test of getQuizId method, of class ResultModel.
     */
    @Test
    public void testGetQuizId() {
        System.out.println("getQuizId");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        int expResult = 10;
        int result = instance.getQuizId();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of setQuizId method, of class ResultModel.
     */
    @Test
    public void testSetQuizId() {
        System.out.println("setQuizId");
        int quizId = 0;
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        instance.setQuizId(quizId);
        
    }

    /**
     * Test of getDate method, of class ResultModel.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        Date expResult = date;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setDate method, of class ResultModel.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        instance.setDate(date);
      
    }

    /**
     * Test of getPersonId method, of class ResultModel.
     */
    @Test
    public void testGetPersonId() {
        System.out.println("getPersonId");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        String expResult = "001";
        String result = instance.getPersonId();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setPersonId method, of class ResultModel.
     */
    @Test
    public void testSetPersonId() {
        System.out.println("setPersonId");
        String personId = "";
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        instance.setPersonId(personId);
        
    }

    /**
     * Test of getScore method, of class ResultModel.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);;
        int expResult = 20;
        int result = instance.getScore();
        assertEquals(expResult, result);       
    }

    /**
     * Test of setScore method, of class ResultModel.
     */
    @Test
    public void testSetScore() {
        System.out.println("setScore");
        int score = 0;
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        ResultModel instance = new ResultModel(1, 10, date, "001", 20);
        instance.setScore(score);
        
    }
    
}
