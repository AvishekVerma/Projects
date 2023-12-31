package com.avishek.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PS_InsertApp {

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
		String sqlInsertQuery = "insert into student (sname,sage,saddress) value(?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sqlInsertQuery);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Name of Student :: ");
		String inputSname = sc.next();
		
		System.out.println("Enter Age of Student :: ");
		int inputSage = sc.nextInt();
		
		System.out.println("Enter Address of Student :: ");
		String inputSaddress = sc.next();
		
		pstmt.setString(1,inputSname);
		pstmt.setInt(2, inputSage);
		pstmt.setString(3,inputSaddress);
		
		int rowInserted = pstmt.executeUpdate();
		
//		4. Process the resultSet
		System.out.println("No. of Row Inserted : "+rowInserted);
		
//		5. Handle the SQL exception - handled using throw keyword.
		
//		6. Close the connection
		
		sc.close();
		pstmt.close();
		connection.close();
		System.out.println("\n Connection closed...\n\n ------Thanks for using our Application-----");
	}

}
