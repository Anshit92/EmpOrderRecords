package com.mindtree.util;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.SQLException;



	public class ConnectionManager {
	    private static String url = "jdbc:mysql://104.215.249.127:3306/employee_order_db";    
	    private static String driverName = "com.mysql.jdbc.Driver";   
	    private static String username = "root";   
	    private static String password = "Welcome123";
	    private static Connection con;
	  

	    public static Connection getConnection() {
	        try {
	            Class.forName(driverName);
	            try {
	                con = DriverManager.getConnection(url, username, password);
	            } catch (SQLException ex) {
	                // log an exception
	                System.out.println("Failed to create the database connection."); 
	            }
	        } catch (ClassNotFoundException ex) {
	            // log an exception. for example:
	            System.out.println("Driver not found."); 
	        }
	        return con;
	    }
	}


