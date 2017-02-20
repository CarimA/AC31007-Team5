/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.servlets;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */
import java.sql.*;



public class TestCon {

  Connection connection;
  
  private void displaySQLErrors(SQLException e) {
  System.out.println("SQLException: " + e.getMessage());
  System.out.println("SQLState:     " + e.getSQLState());
  System.out.println("VendorError:  " + e.getErrorCode());
}
public TestCon() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    Class.forName("com.mysql.jdbc.Driver").newInstance();
}

public void connectToDB() {
   try {
     connection = DriverManager.getConnection(
       "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db?user=16agileteam5&password=0245.at5.5420");
   }
   catch(SQLException e) {
     displaySQLErrors(e);
   }
}
public void executeSQL() {
   try {
     Statement statement = connection.createStatement();
     ResultSet rs = statement.executeQuery(
       "SELECT * FROM answer");
     while (rs.next()) {
       System.out.println(rs.getString(1));
}
     rs.close();
     statement.close();
     connection.close();
   }
   catch(SQLException e) {
     displaySQLErrors(e);
   }
 }
 
 public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    TestCon tstcon = new TestCon();
     tstcon.connectToDB();
     tstcon.executeSQL();
   }
}