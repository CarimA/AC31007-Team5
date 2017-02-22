/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Stores.User;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author carimakeju
 */
public class UserTest {
    @Test
    public void checkPasswordComparisonA() {
        User user = new User();
        user.setNewPassword("test");
        
        // check that passwords are correctly hashing and returning true for a match
        assertEquals(user.checkPassword("test"), true);
    }
    
    @Test
    public void checkPasswordComparisonB() {
        User user = new User();
        user.setNewPassword("test");
        
        // check that passwords are correctly hashing and returning false for a mismatch
        assertEquals(user.checkPassword("test2"), false);
    }
}
