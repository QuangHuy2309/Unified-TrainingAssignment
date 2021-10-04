package com.nashtech.trainingassignment;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
	public static Connection getConnection() {
		Connection conn = null;
		try {
//		String url = "jdbc:postgresql://localhost:5432/nashtech_training";
//		Properties props = new Properties();
//		props.setProperty("user","postgres");
//		props.setProperty("password","123456");
//		props.setProperty("ssl","true");
			String url = "jdbc:postgresql://localhost:5432/nashtech_training?user=postgres&password=123456";
			conn = DriverManager.getConnection(url);
			System.out.println("Connect to database success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
