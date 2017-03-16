/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;


import Exception.PasswordInvalidException;
import Exception.UsernameInvalidException;
import Stores.User;
import org.bouncycastle.openssl.PasswordException;
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
public class LoginModelIT {
    
    public LoginModelIT() {
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
     * NEET TO DO MORE CHECKS
     * Test of checkLogin method, of class LoginModel.
     * @throws java.lang.Exception
     */
     @Test (expected = PasswordInvalidException.class)
     
    public void testCheckLogin() throws Exception {
        System.out.println("checkLogin");
        String username = "13";
        String password = "password";
        LoginModel instance = new LoginModel();
        User expResult = new User();
        User result = instance.checkLogin(username, password);
        assertEquals(expResult, result);
        
    } 
    @Test (expected = UsernameInvalidException.class)
     
    public void testCheckLogin2() throws Exception {
        System.out.println("checkLogin");
        String username = "13";
        String password = "password";
        LoginModel instance = new LoginModel();
        User expResult = new User();
        User result = instance.checkLogin(username, password);
        assertEquals(expResult, result);
        
    }

    /**
     * pass
     * Test of registerUser method, of class LoginModel.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        String userID = "123456712";
        String password = "password";
        String displayName = "admin";
        String email = "123456712@gmail.com";
        String position = "staff";
        LoginModel instance = new LoginModel();
        User expResult = null;
        User result = instance.registerUser(userID, password, displayName, email, position);
        assertEquals(expResult, result);
       
    }
    
}
