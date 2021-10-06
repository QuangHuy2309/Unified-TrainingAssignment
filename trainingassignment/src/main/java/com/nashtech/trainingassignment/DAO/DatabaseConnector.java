package com.nashtech.trainingassignment.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
	public static Connection getConnection() {
		Connection conn = null;
		try {
			String url = "jdbc:postgresql://localhost:5432/nashtech_training?user=postgres&password=123456";
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
