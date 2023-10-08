package com.avishek.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class SP_InsertApp{
	
	public void insertRecord(Connection connection,BufferedReader br) throws SQLException, IOException {
		
		System.out.println("Enter Name of Student :: ");
		String inputSname = br.readLine();
		
		System.out.println("Enter Age of Student :: ");
		int inputSage = Integer.parseInt(br.readLine());
		
		System.out.println("Enter Address of Student :: ");
		String inputSaddress = br.readLine();
		
		String sqlInsertQuery = "insert into student (sname,sage,saddress) values(?,?,?)";
		PreparedStatement pstmt = connection.prepareStatement(sqlInsertQuery);
		
		pstmt.setString(1, inputSname);
		pstmt.setInt(2, inputSage);
		pstmt.setString(3, inputSaddress);
		int rowInserted = pstmt.executeUpdate();
		
//		Process the resultSet
		System.out.println("\nNo. of Row Inserted :: "+rowInserted);
	}
		
	
}

