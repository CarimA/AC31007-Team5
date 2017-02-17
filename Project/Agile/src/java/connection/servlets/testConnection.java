/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */

public class testConnection {

	
	public static void main(String[] args) throws SQLException {
		try ( // TODO Auto-generated method stub
                        Connection conn = DBsetup.getConnection(DBType.MYSQLDB)) {
			
			
			System.out.println("Connection Established to MYSQL Database");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.err.println(e.getMessage());
                        System.out.println("Connection fail");
		}
		
		
	

	}

}