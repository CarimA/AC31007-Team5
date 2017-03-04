/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Stores;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
public class AnswerIT {
    
    public AnswerIT() {
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
     * Test of getId method, of class Answer.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Answer instance = new Answer();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
    }


    /**
     * Test of setId method, of class Answer.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Answer instance = new Answer();
        instance.setId(id);
        
    }

    /**
     * Test of getNumber method, of class Answer.
     */
    @Test
    public void testGetNumber() {
        System.out.println("getNumber");
        Answer instance = new Answer();
        int expResult = 0;
        int result = instance.getNumber();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setNumber method, of class Answer.
     */
    @Test
    public void testSetNumber() {
        System.out.println("setNumber");
        int number = 0;
        Answer instance = new Answer();
        instance.setNumber(number);
       
    }

    /**
     * Test of getAnswer method, of class Answer.
     */
    @Test
    public void testGetAnswer() {
        System.out.println("getAnswer");
        Answer instance = new Answer();
        String expResult = "";
        String result = instance.getAnswer();
        assertEquals(null, result);
       
    }

    /**
     * Test of setAnswer method, of class Answer.
     */
    @Test
    public void testSetAnswer() {
        System.out.println("setAnswer");
        String answer = "";
        Answer instance = new Answer();
        instance.setAnswer(answer);
        
    }

    /**
     * Test of getExplanation method, of class Answer.
     */
    @Test
    public void testGetExplanation() {
        System.out.println("getExplanation");
        Answer instance = new Answer();
        String expResult = "";
        String result = instance.getExplanation();
        assertEquals(null, result);
       
    }

    /**
     * Test of setExplanation method, of class Answer.
     */
    @Test
    public void testSetExplanation() {
        System.out.println("setExplanation");
        String explanation = "";
        Answer instance = new Answer();
        instance.setExplanation(explanation);
        
    }

    /**
     * Test of isRight method, of class Answer.
     */
    @Test
    public void testIsRight() {
        System.out.println("isRight");
        Answer instance = new Answer();
        boolean expResult = false;
        boolean result = instance.isRight();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setRight method, of class Answer.
     */
    @Test
    public void testSetRight() {
        System.out.println("setRight");
        boolean right = false;
        Answer instance = new Answer();
        instance.setRight(right);
        
    }
    
}
