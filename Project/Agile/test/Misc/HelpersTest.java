/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Misc;

import static Misc.Helpers.sha256;
import java.sql.Connection;
import java.sql.SQLException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import org.junit.Test;

/**
 *
 * @author jimiwesterholm
 */
public class HelpersTest {
    @Test
    public void testSha256ShouldPass() {
        assertEquals(sha256("test"), "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08");
    }
    
    @Test
    public void testSha256IncorrectShouldPass() {
        assertNotEquals(sha256("test"), "9f86d081884c7d659a2feaa0c55ad015a3bf4f1b2b0b822cd15d6c15b0f00a08 Should Fail");        
    }
    
    @Test
    public void testConnectShouldPass() throws ClassNotFoundException, SQLException {
        Connection connection = Helpers.connect();
        assertEquals(connection.isClosed(), false);
    }
}
