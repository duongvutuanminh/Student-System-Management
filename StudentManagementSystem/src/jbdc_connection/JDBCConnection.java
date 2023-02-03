package jbdc_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {
	public static Connection getJDBCConnection() {
		
		// Specifying some credentials
		final String url = "jdbc:mysql://localhost:3306/studentmangement";
		final String user = "root";
		final String password = "hust12399999";
		
		try {
//			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static void test() {
		Connection con = JDBCConnection.getJDBCConnection();
		if (con != null) {
			System.out.println("Successfully connected!");	
		}
		else {
			System.out.println("Failed to connect!");
		}
	}
}
