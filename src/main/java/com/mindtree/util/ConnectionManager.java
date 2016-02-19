package com.mindtree.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ConnectionManager {
	static InputStream inputStream;
	private static final Logger logger = Logger.getLogger(ConnectionManager.class);
	private static String url = "jdbc:mysql://104.215.249.127:3306/employee_order_db";    
	private static String driverName = "com.mysql.jdbc.Driver";   

	private static Connection con;

	public static Connection getConnection() {
		/*Properties prop = new Properties();
		InputStream input = null;
		input = ConnectionManager.class.getClassLoader().getResourceAsStream("config.properties");
		try {
			prop.load(input);
		} catch (IOException e) {
			System.out.println("IO Error");
		}*/
		String username ="demo";   
		String password = "Welcome123";
		try {
			Class.forName(driverName);
			try {
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException ex) {
				logger.error("Failed to create the database connection.");
			}
		} catch (ClassNotFoundException ex) {
			logger.error("Driver not found.");
		}
		return con;
	}
}


