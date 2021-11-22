package dao;
import java.sql.*;

public class SQLConnection {
	private static Connection conn;

	public static Connection getConnection() {
		if (conn == null) {
			try {
				String password = System.getenv("DB_PASSWORD");
				String user = System.getenv("DB_USER");
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/tp6", user, password);
			} catch (Exception e) {
				System.out.println("degls fsfs not");
				e.printStackTrace();
			}

		}
		return conn;
	}
}
