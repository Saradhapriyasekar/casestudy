package com.hexaware.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnUtil {
	 public static Connection getConnection(String propertyFilePath) {
		 Connection connection = null;
		 
		 try {
			 InputStream input = DBPropertyUtil.class.getClassLoader().getResourceAsStream("db.properties");
			 
			 if (input == null) {
	                System.out.println("Sorry, unable to find db.properties");
	                return null;
	            }

			 Class.forName("com.mysql.cj.jdbc.Driver");
			 String url = DBPropertyUtil.getPropertyString(propertyFilePath);
			 connection = DriverManager.getConnection(url);
			 
		 }catch (ClassNotFoundException | SQLException e) {
			 e.printStackTrace();
		 }
		 return connection;
	 }

}
