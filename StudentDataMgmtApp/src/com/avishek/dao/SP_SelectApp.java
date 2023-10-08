package com.avishek.dao;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SP_SelectApp {

	public void getRecord(Connection connection,BufferedReader br) throws SQLException, NumberFormatException, IOException {
		System.out.println("Enter Id of Student :: ");
		int inputSid = Integer.parseInt(br.readLine());
//		
		String sqlSelectQuery = "select sid,sname,sage,saddress from student where sid=?";
		PreparedStatement pstmt = connection.prepareStatement(sqlSelectQuery);
		
		pstmt.setInt(1, inputSid);
		ResultSet resultSet = pstmt.executeQuery();
		
//		Process the resultSet
		if(resultSet.next()) {
			System.out.println("Id\tName\tAge\tAddress");
			System.out.println(resultSet.getInt(1)+"\t"+
					   resultSet.getString(2)+"\t"+
					   resultSet.getInt(3)+"\t"+
					   resultSet.getString(4)+"\n"
			);
		}else {
			System.out.println("Record not available for Id :: "+ inputSid); 
		}
		
	}
	
}
