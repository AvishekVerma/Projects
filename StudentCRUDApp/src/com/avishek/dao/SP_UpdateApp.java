package com.avishek.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SP_UpdateApp {

	public void updateRecord(Connection connection,BufferedReader br) throws SQLException, NumberFormatException, IOException {
//		Get the connection object
//		Connection connection = JdbcUtilApp.getConnection();
//		Create statement and execute SQL query 
//		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Id of Student :: ");
		int inputSid = Integer.parseInt(br.readLine());
		
		System.out.println("Enter Age of Student :: ");
		int inputSage = Integer.parseInt(br.readLine());
		
		System.out.println("Enter Address of Student :: ");
		String inputSaddress = br.readLine();
		
		String sqlUpdateQuery = "update student set sage=?,saddress=? where sid=?";
		PreparedStatement pstmt = connection.prepareStatement(sqlUpdateQuery);
		
		pstmt.setInt(1, inputSage);
		pstmt.setString(2, inputSaddress);
		pstmt.setInt(3, inputSid);
		int rowUpdated = pstmt.executeUpdate();
		
//		Process the resultSet
		System.out.println("\nNo. of Row Updated :: "+rowUpdated);	}
}
