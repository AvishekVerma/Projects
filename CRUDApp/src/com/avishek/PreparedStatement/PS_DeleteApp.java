package com.avishek.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PS_DeleteApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
//		1. Load and Register the Driver
//		Class.forName("com.mysql.cj.jdbc.Driver");
//		System.out.println("Driver Loaded Successfully...");
		
		String url="jdbc:mysql:///avishekdb";
		String user="root";
		String password="root123";
		
//		2. Establish the connection with DataBase.
		Connection connection = DriverManager.getConnection(url,user,password);
		System.out.println("Connection object created...");
		
//		3. Create Statement object and execute the query.
		String sqlDeleteQuery = "delete from student where sid=?";
		PreparedStatement pstmt = connection.prepareStatement(sqlDeleteQuery);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id of Student :: ");
		int inputSid = sc.nextInt();
		
		pstmt.setInt(1,inputSid);
		int rowDeleted = pstmt.executeUpdate();
		
//		4. Process the resultSet
		System.out.println("No. of Row Deleted : "+rowDeleted);
		
//		5. Handle the SQL exception - handled using throw keyword.
		
//		6. Close the connection
		
		sc.close();
		pstmt.close();
		connection.close();
		System.out.println("\n Connection closed...\n\n ------Thanks for using our Application-----");
	}

}
