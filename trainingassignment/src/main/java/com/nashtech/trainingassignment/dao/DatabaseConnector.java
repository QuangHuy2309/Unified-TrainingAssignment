package com.nashtech.trainingassignment.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class DatabaseConnector {
	private static final Logger logger = Logger.getLogger(DatabaseConnector.class);

	public static Connection getConnection() {
		Connection conn = null;

		try {
			String url = "jdbc:postgresql://localhost:5432/nashtech_training?user=postgres&password=123456";
			conn = DriverManager.getConnection(url);
			logger.info("Connect to database");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
}
