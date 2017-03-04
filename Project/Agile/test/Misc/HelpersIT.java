/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Misc;

import java.sql.Connection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
public class HelpersIT {
    
    public HelpersIT() {
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
     * Test of sha256 method, of class Helpers.
     */
    @Test
    public void testSha256() {
        System.out.println("sha256");
        String base = "password";
        String expResult = "5e884898da28047151d0e56f8dc6292773603d0d6aabbdd62a11ef721d1542d8";
        String result = Helpers.sha256(base);
        assertEquals(expResult, result);
      
    }

    /**
     * Test of connect method, of class Helpers.
     * @throws java.lang.Exception
     */
    @Test
    public void testConnect() throws Exception {
        System.out.println("connect");
        try (Connection result = Helpers.connect()) {
            Assert.assertNotNull(result);
            Assert.assertTrue(result.isValid(0));
        }
      
    }

    /**
     * Test of successRedirect method, of class Helpers.
     * @throws java.lang.Exception
     */
    @Test (expected = NullPointerException.class)
    public void testSuccessRedirect() throws Exception {
        System.out.println("successRedirect");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        String redirectPage = "Home";
        boolean hardRedirect = false;
        String message = "Yes Its working";
        Helpers.successRedirect(request, response, redirectPage, hardRedirect, message);
    }

    /**
     * Test of errorRedirect method, of class Helpers.
     * @throws java.lang.Exception
     */
    @Test (expected = NullPointerException.class)
    public void testErrorRedirect() throws Exception {
        System.out.println("errorRedirect");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        String redirectPage = "Home";
        boolean hardRedirect = false;
        String message = "Yes Its working";
        Helpers.errorRedirect(request, response, redirectPage, hardRedirect, message);
    }

    /**
     * Test of redirect method, of class Helpers.
     * @throws java.lang.Exception
     */
    @Test (expected = NullPointerException.class)
    public void testRedirect() throws Exception {
        System.out.println("redirect");
        HttpServletRequest request = mock(HttpServletRequest.class);
        HttpServletResponse response = mock(HttpServletResponse.class);
        String redirectPage = "Home";
        boolean hardRedirect = false;
        Helpers.redirect(request, response, redirectPage, hardRedirect);
    }
    
}
