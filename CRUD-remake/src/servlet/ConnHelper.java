package servlet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author ENAIP04
 * Hardcoded class for the database connection
 * MUST be changed on ANY and ALL different machines
 */
public class ConnHelper {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

<<<<<<< HEAD
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "Marco", "marco");
=======
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "ATTILIO", "0000");
>>>>>>> branch 'slave' of https://github.com/Shadow4774/Crud_remake

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
