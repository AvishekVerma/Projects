package com.avishek.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		1. Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
	
		System.out.println("Driver loaded Successfully...");
		
//		2. Establish the connection with dataBase
		String url="jdbc:mysql://localhost:3306/avishekdb";
		
		String user="root";
		String password="root123";
		Connection connection = DriverManager.getConnection(url,user,password);
		System.out.println("Connection Object created...");
		
//		3. Create statement and execute the query
		String sqlInsertQuery = "insert into student (sname,sage,saddress) values('Avi',26,'Hyderabad')";
		Statement statement = connection.createStatement();
		int rowInserted = statement.executeUpdate(sqlInsertQuery);
		
		
//		4. Process the resultSet
		System.out.println("No. of rows inserted :: "+rowInserted);
		
//		5. Handle the SQL exceptions
		
		
//		6. Close the connection.
		connection.close();
		statement.close();
		System.out.println("Connection got closed...");
	}

}
