package persistence.test_result;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/collection_test";
	private static final String USER = "root";
	private static final String PASS = "root";

	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);
			return conn;
		} catch (ClassNotFoundException e) {
			return null;
		}
		
	}
}