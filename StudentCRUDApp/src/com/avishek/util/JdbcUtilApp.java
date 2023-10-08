package com.avishek.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtilApp {
	
	public static Connection getConnection() throws SQLException{
		
		String url="jdbc:mysql:///avishekdb";
		String user="root";
		String password="root123";
		Connection connection = DriverManager.getConnection(url,user,password);
		return connection;
		
	}
	
	public void closeConnection(Connection con) throws SQLException {
		if(con!=null) {
			con.close();
			System.out.println("\nConnection closed....");
			System.out.println("\n------Thanks for Using our Service.-----");
		}
	}

}
