package com.avishek.PreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PS_SelectApp {

	@SuppressWarnings("resource")
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
		String sqlSelectQuery = "Select sid,sname,sage,saddress from student where sid=?";
		PreparedStatement pstmt = connection.prepareStatement(sqlSelectQuery);
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id of Student :: ");
		int inputSid = sc.nextInt();
		
		pstmt.setInt(1,inputSid);
		ResultSet resultSet = pstmt.executeQuery();
		
//		4. Process the resultSet
		System.out.println("Id\tName\tAge\tAddress");
		while(resultSet.next()) {
			Integer sid = resultSet.getInt(1);
			String sname = resultSet.getString(2);
			Integer sage = resultSet.getInt(3);
			String saddress = resultSet.getString(4);
			System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddress);
		}
		
//		5. Handle the SQL exception - handled using throw keyword.
		
//		6. Close the connection
		
		sc.close();
		resultSet.close();
		pstmt.close();
		connection.close();
		System.out.println("\n Connection closed...\n\n ------Thanks for using our Application-----");
	}

}
