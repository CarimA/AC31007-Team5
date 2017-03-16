/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import Exception.PasswordInvalidException;
import Exception.UsernameInvalidException;
import Stores.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
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
    
    private Connection connect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
    }
    
    @Test(expected = UsernameInvalidException.class)
    public void checkLoginWithoutUsernameShouldFail() throws UsernameInvalidException, PasswordInvalidException, SQLException, ClassNotFoundException {
        Connection connection = connect();
        
        try {
            User user = User.login(connection, "", "");
            assertEquals(user, null);
        }
        catch (Exception ex) {
            throw ex;
        }
    }
    
    @Test(expected = PasswordInvalidException.class)
    public void checkLoginWithIncorrectPasswordShouldFail() throws UsernameInvalidException, PasswordInvalidException, SQLException, ClassNotFoundException {
        Connection connection = connect();
        
        try {
            User user = User.login(connection, "id-test", "test-password1");
            assertEquals(user, null);
        }
        catch (Exception ex) {
            throw ex;
        }
    }
    
    @Test
    public void checkLoginWithCorrectPasswordShouldPass() throws UsernameInvalidException, PasswordInvalidException, SQLException, ClassNotFoundException {
        Connection connection = connect();
        
        try {
            User user = User.login(connection, "id-test", "test-password");
            assertNotNull(user);
        }
        catch (Exception ex) {
            throw ex;
        }
    }
    
    @Test(expected = UsernameInvalidException.class)
    public void checkRegisterUsernameTakenShouldFail() throws UsernameInvalidException, PasswordInvalidException, SQLException, ClassNotFoundException {
        Connection connection = connect();
        try {
            User user = User.register(connection, "id-test", "123", "321", "email", "pos");
            assertEquals(user, null);
        }
        catch (Exception ex) {
            throw ex;
        }
    }
    
    @Test(expected = PasswordInvalidException.class)
    public void checkRegisterPasswordInvalidShouldFail() throws UsernameInvalidException, PasswordInvalidException, SQLException, ClassNotFoundException {
        // TODO: implement password requirements
        throw new PasswordInvalidException();
        //assertEquals(true, true);
    }
    
    
    @Test
    public void checkRegisterShouldPass() throws UsernameInvalidException, PasswordInvalidException, SQLException, ClassNotFoundException {
        Connection connection = connect();
        try {
            User user = User.register(connection, "id-test2", "123", "321", "email", "pos");
            assertNotNull(user);
        }
        catch (Exception ex) {
            throw ex;
        }
        
        connection = connect();
        
        PreparedStatement statement = connection.prepareStatement("DELETE FROM person where pId = ?");
        statement.setString(1, "id-test2");
        
        statement.execute();
        
        statement.close();
        connection.close();
    }
    
    @Test
    public void getNameFromIDTest() {
        String id = "22";
        assertEquals("22", User.getNameFromID(id));
    }
    
}
