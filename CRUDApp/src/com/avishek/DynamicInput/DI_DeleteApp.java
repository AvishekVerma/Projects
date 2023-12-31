package com.avishek.DynamicInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DI_DeleteApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection connection=null;
		Statement statement=null;
		
//		1. Load and register the Driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Driver loaded Successfully...");
		
//		2. Establish the connection with dataBase
		String url="jdbc:mysql:///avishekdb";
		String user="root";
		String password="root123";
		connection = DriverManager.getConnection(url,user,password);
		System.out.println("Connection Object created...");
		
//		3. Create statement and execute the query
		statement = connection.createStatement();
		
		Scanner sc= new Scanner(System.in);
		
		System.out.println("\nEnter the Id of student :: ");
		int inputSid = sc.nextInt();
		
		String sqlDeleteQuery = "delete from student where sid='"+inputSid+"'";
		int rowInserted = statement.executeUpdate(sqlDeleteQuery);
		
//		4. Process the resultSet
		System.out.println();
		System.out.println("No. of Row inserted to DB :: "+rowInserted);
		
//		5. Handle the SQL exceptions
//		here used throws declaration method to handle Exceptions.
		
//		6. Close the connection.
		
		statement.close();
		connection.close();
		System.out.println("\nConnection Closed...\n***--------Thanks for using our Application.--------***");

	}

}

