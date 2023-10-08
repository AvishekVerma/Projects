package com.avishek.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;

import com.avishek.dao.SP_DeleteApp;
import com.avishek.dao.SP_InsertApp;
import com.avishek.dao.SP_SelectApp;
import com.avishek.dao.SP_UpdateApp;
import com.avishek.util.JdbcUtilApp;

public class TestApp {

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {
		
		JdbcUtilApp util = new JdbcUtilApp();
		SP_SelectApp select = new SP_SelectApp();
		SP_InsertApp insert = new SP_InsertApp();
		SP_DeleteApp delete = new SP_DeleteApp();
		SP_UpdateApp update = new SP_UpdateApp();
		
		Connection connection = JdbcUtilApp.getConnection();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("***********WELCOME to Avishek Deep Tech Solutions pvt.ltd************** ");
		System.out.println(
				"----Operations menu----\n"
				+ "Press 1 to Insert Student Record\n"
				+ "Press 2 to Select Student Record\n"
				+ "Press 3 to Update Student Record\n"
				+ "Press 4 to Delete Student Record\n"
				+ "Press 5 to EXIT from application\n"
				);
		
		while(true) {
			System.out.println("\nPlease Enter your Opetion(1/2/3/4/5) :: ");
			int userInput=Integer.parseInt(br.readLine());
			
			if(userInput==1) {
				insert.insertRecord(connection, br);
			}else if(userInput==2) {
				select.getRecord(connection,br);	
			}else if(userInput==3) {
				update.updateRecord(connection, br);
			}else if(userInput==4) {
				delete.deleteRecord(connection, br);
			}else if(userInput==5) {
				System.out.println("Exit......");
				util.closeConnection(connection);
				break;	
			}else {
				System.out.println("Please Enter valid input in the range of 1 to 5.");
			}
		}
	}

}
