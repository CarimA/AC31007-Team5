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
import static org.mockito.Mockito.mock;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 * 
 * // need add this data later on to our database, was practising with my own database and this tests was passed 
 */
public class QuizModelIT {
    
    public QuizModelIT() {
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
     * Test of getQuizId method, of class QuizModel.
     */
    @Test
    public void testGetQuizId() {
        System.out.println("getQuizId");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        QuizModel instance = new QuizModel(1, "Quiz Title", "Module One", date, 1,false,0);
        int expResult = 1;
        int result = instance.getQuizId();
        assertEquals(expResult, result);
    }

    /**
     * Test of setQuizId method, of class QuizModel.
     */
    @Test
    public void testSetQuizId() {
        System.out.println("setQuizId");
        int quizId = 0;
        QuizModel instance = mock(QuizModel.class);;
        instance.setQuizId(quizId);
    }

    /**
     * Test of getModule method, of class QuizModel.
     */
    @Test
    public void testGetModule() {
        System.out.println("getModule");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        QuizModel instance = new QuizModel(1, "Quiz Title", "Module One", date, 1,false,0);
        String expResult = "Module One";
        String result = instance.getModule();
        assertEquals(expResult, result);
    }

    /**
     * Test of setModule method, of class QuizModel.
     */
    @Test
    public void testSetModule() {
        System.out.println("setModule");
        String module = "";
        QuizModel instance = mock(QuizModel.class);
        instance.setModule(module);
    }

    /**
     * Test of getDateCreated method, of class QuizModel.
     */
    @Test
    public void testGetDateCreated() {
        System.out.println("getDateCreated");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        QuizModel instance = new QuizModel(1, "Quiz Title", "Module One", date, 1,false,0);
        Date expResult = date;
        Date result = instance.getDateCreated();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDateCreated method, of class QuizModel.
     */
    @Test
    public void testSetDateCreated() {
        System.out.println("setDateCreated");
        Date dateCreated = null;
        QuizModel instance = mock(QuizModel.class);
        instance.setDateCreated(dateCreated);
 
    }

    /**
     * Test of getAvailable method, of class QuizModel.
     */
    @Test
    public void testGetAvailable() {
        System.out.println("getAvailable");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        QuizModel instance = new QuizModel(1, "Quiz Title", "Module One", date, 1,false,0);
        int expResult = 1;
        int result = instance.getAvailable();
        assertEquals(expResult, result);
    }

    /**
     * Test of setAvailable method, of class QuizModel.
     */
    @Test
    public void testSetAvailable() {
        System.out.println("setAvailable");
        int available = 0;
        QuizModel instance = mock(QuizModel.class);
        instance.setAvailable(available);
    }

    /**
     * Test of getTitle method, of class QuizModel.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        String strDate = "2017-03-02";  
        Date date=Date.valueOf(strDate);
        QuizModel instance = new QuizModel(1, "Quiz Title", "Module One", date, 1,false,0);
        String expResult = "Quiz Title";
        String result = instance.getTitle();
        assertEquals(expResult, result);
    }

    /**
     * Test of setTitle method, of class QuizModel.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String title = "";
        QuizModel instance = mock(QuizModel.class);
        instance.setTitle(title);
    }
    
}