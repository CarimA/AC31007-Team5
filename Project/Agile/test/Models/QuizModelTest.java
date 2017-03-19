/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Stores.Answer;
import Stores.Question;
import Stores.Quiz;
import java.io.InputStream;
import java.util.List;
import java.util.Vector;
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
public class QuizModelTest {
    
    public QuizModelTest() {
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
     * Test of fetchQuiz method, of class QuizModel.
     */
//    @Test
//    public void testFetchQuiz() {
//        System.out.println("fetchQuiz");
//        int id = 0;
//        QuizModel instance = new QuizModel();
//        Quiz expResult = null;
//        Quiz result = instance.fetchQuiz(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of fetchQuestion method, of class QuizModel.
//     */
//    @Test
//    public void testFetchQuestion() {
//        System.out.println("fetchQuestion");
//        int id = 0;
//        QuizModel instance = new QuizModel();
//        Question expResult = null;
//        Question result = instance.fetchQuestion(id);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateQuiz method, of class QuizModel.
//     */
//    @Test
//    public void testUpdateQuiz() {
//        System.out.println("updateQuiz");
//        int id = 0;
//        String title = "";
//        String module = "";
//        boolean available = false;
//        QuizModel instance = new QuizModel();
//        instance.updateQuiz(id, title, module, available);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateQuestion method, of class QuizModel.
//     */
//    @Test
//    public void testUpdateQuestion() {
//        System.out.println("updateQuestion");
//        int id = 0;
//        String question = "";
//        int points = 0;
//        QuizModel instance = new QuizModel();
//        instance.updateQuestion(id, question, points);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of updateAnswer method, of class QuizModel.
//     */
//    @Test
//    public void testUpdateAnswer() {
//        System.out.println("updateAnswer");
//        int id = 0;
//        String answer = "";
//        String explanation = "";
//        boolean right = false;
//        QuizModel instance = new QuizModel();
//        instance.updateAnswer(id, answer, explanation, right);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteQuiz method, of class QuizModel.
//     */
//    @Test
//    public void testDeleteQuiz() {
//        System.out.println("deleteQuiz");
//        int id = 0;
//        QuizModel instance = new QuizModel();
//        instance.deleteQuiz(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteQuestion method, of class QuizModel.
//     */
//    @Test
//    public void testDeleteQuestion() {
//        System.out.println("deleteQuestion");
//        int id = 0;
//        QuizModel instance = new QuizModel();
//        instance.deleteQuestion(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of deleteAnswer method, of class QuizModel.
//     */
//    @Test
//    public void testDeleteAnswer() {
//        System.out.println("deleteAnswer");
//        int id = 0;
//        QuizModel instance = new QuizModel();
//        instance.deleteAnswer(id);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addQuestion method, of class QuizModel.
//     */
//    @Test
//    public void testAddQuestion() {
//        System.out.println("addQuestion");
//        String question = "";
//        int number = 0;
//        int points = 0;
//        int quizID = 0;
//        QuizModel instance = new QuizModel();
//        instance.addQuestion(question, number, points, quizID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addQuestionGetID method, of class QuizModel.
//     */
//    @Test
//    public void testAddQuestionGetID() {
//        System.out.println("addQuestionGetID");
//        String question = "";
//        int number = 0;
//        int points = 0;
//        int quizID = 0;
//        QuizModel instance = new QuizModel();
//        int expResult = 0;
//        int result = instance.addQuestionGetID(question, number, points, quizID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addAnswer method, of class QuizModel.
//     */
//    @Test
//    public void testAddAnswer() {
//        System.out.println("addAnswer");
//        String answer = "";
//        int number = 0;
//        String explanation = "";
//        boolean right = false;
//        int questionID = 0;
//        QuizModel instance = new QuizModel();
//        instance.addAnswer(answer, number, explanation, right, questionID);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of createQuiz method, of class QuizModel.
//     */
//    @Test
//    public void testCreateQuiz() {
//        System.out.println("createQuiz");
//        String title = "";
//        String module = "";
//        QuizModel instance = new QuizModel();
//        int expResult = 0;
//        int result = instance.createQuiz(title, module);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addQuestionWithImage method, of class QuizModel.
//     */
//    @Test
//    public void testAddQuestionWithImage() {
//        System.out.println("addQuestionWithImage");
//        String question = "";
//        int number = 0;
//        int points = 0;
//        int quizID = 0;
//        InputStream i = null;
//        QuizModel instance = new QuizModel();
//        instance.addQuestionWithImage(question, number, points, quizID, i);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getIdFromQ method, of class QuizModel.
//     */
//    @Test
//    public void testGetIdFromQ() {
//        System.out.println("getIdFromQ");
//        String question = "";
//        int number = 0;
//        int points = 0;
//        int quizID = 0;
//        QuizModel instance = new QuizModel();
//        int expResult = 0;
//        int result = instance.getIdFromQ(question, number, points, quizID);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of getAllQuizzes method, of class QuizModel.
//     */
//    @Test
//    public void testGetAllQuizzes() {
//        System.out.println("getAllQuizzes");
//        QuizModel instance = new QuizModel();
//        Vector<Quiz> expResult = null;
//        Vector<Quiz> result = instance.getAllQuizzes();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getCorrectAnswers method, of class QuizModel.
     */
    @Test
    public void testGetCorrectAnswers() {
        System.out.println("getCorrectAnswers");
        QuizModel qm = new QuizModel();
        Quiz quiz = qm.fetchQuiz(1);
        int expResult = 8;
        List<Answer> result = QuizModel.getCorrectAnswers(quiz);
        assertEquals(expResult, result.get(0).getId());
        // TODO review the generated test code and remove the default call to fail.
    }
    
}
