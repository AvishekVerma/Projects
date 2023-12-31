package com.avishek.DynamicInput;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DI_SelectApp {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		Connection connection=null;
		Statement statement=null;
		ResultSet resultSet=null;
		
		
//		1. Load and register the Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("Driver loaded Successfully...");
		
//		2. Establish the connection with dataBase
		String url="jdbc:mysql:///avishekdb";
		String user="root";
		String password="root123";
		connection = DriverManager.getConnection(url,user,password);
		System.out.println("Connection Object created...");
		
//		3. Create statement and execute the query
		statement = connection.createStatement();
		
		Scanner sc= new Scanner(System.in);
		System.out.println("\nEnter the valid Id of student :: ");
		Integer inputSid = sc.nextInt();
		
		String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid='"+inputSid+"'";
		resultSet = statement.executeQuery(sqlSelectQuery);
		
//		4. Process the resultSet
		System.out.println();
		System.out.println("Id\tName\tAge\tAddress");
		while(resultSet.next()) {
			Integer sid = resultSet.getInt(1);
			String sname = resultSet.getString(2);
			Integer sage = resultSet.getInt(3);
			String saddress = resultSet.getString(4);
			System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddress);
		}
		
//		5. Handle the SQL exceptions
//		here used throws declaration method to handle Exceptions.
		
//		6. Close the connection.
		
		resultSet.close();
		statement.close();
		connection.close();
		System.out.println("\nConnection Closed...\n***--------Thanks for using our Application.--------***");

	}

}
