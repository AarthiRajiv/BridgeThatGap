package com.btg.work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtility {
	private static Connection conn;
	
	public static Connection getConnection() throws SQLException {
		try {
			Class.forName("org.postgresql.Driver"); //without this, JDBC Driver for Postgres is not being found 
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres","password"); //dburl, username, pwd		
		conn.setSchema("BridgeThatGap");
		return conn;
	}
	
	public static void closeConnection() throws SQLException {
		conn.close();
	}	
}