package hu.neuron.java.project.core.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static final String URL = "jdbc:mysql://localhost:3306/test";
	private static final String USER = "root";
	private static final String PASS = "";
	
	static{
		try {
		    Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (Exception ex) {
		    System.err.println(ex.getMessage());
		}
	}

	public static Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		System.out.println("Connection: " + conn.toString());
		return conn;
	}
}
