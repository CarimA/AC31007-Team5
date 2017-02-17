
package connection.servlets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Igors Bogdanovs <i.bogdanovs@dundee.ac.uk>
 */

public class DBsetup {

private static final String mySqlUser = "16agileteam5";
private static final String mySqlPwd = "0245.at5.5420";
private static final String mySQLCS = "jdbc:mysql://silva.computing.dundee.ac.uk:3306/16agileteam5db";

public static Connection getConnection(DBType dbType) throws SQLException {
	switch (dbType) {
	case MYSQLDB:
		return DriverManager.getConnection(mySQLCS, mySqlUser, mySqlPwd);
	default:
		return null;
	}
}

public static void showErrorMessage(SQLException e){
	System.err.println("Error :" + e.getMessage());
	System.err.println("Error Code :" + e.getErrorCode());
}
}
