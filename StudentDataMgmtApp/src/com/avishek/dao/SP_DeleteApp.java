package com.avishek.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SP_DeleteApp {

	public void deleteRecord(Connection connection,BufferedReader br) throws SQLException, NumberFormatException, IOException {
		
		System.out.println("Enter Id of Student :: ");
		int inputSid = Integer.parseInt(br.readLine());
		
		String sqlDeleteQuery = "delete from student where sid=?";
		PreparedStatement pstmt = connection.prepareStatement(sqlDeleteQuery);
		
		pstmt.setInt(1, inputSid);
		int rowDeleted = pstmt.executeUpdate();
		
//		Process the resultSet
		System.out.println("\nNo. of Row Deleted :: "+rowDeleted);
	}
}
