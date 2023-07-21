package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class ProductInsertController {
	public static void main(String[] args) {
		Connection connection = null;
		
		try {
//			//STEP - 1
//			Driver driver =new Driver();
//			DriverManager.registerDriver(driver);
			
			//STEP -1 LOAD REGISTER DRIVER 
			
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP-12CREATE CONNECTION
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "Sham7079@";
			
			
			connection= DriverManager.getConnection(url,user,pass);//getConnection will throw a exception which is checked exception
			
			
			
			//STEP-3 CREATE STATEMENT
			String insertQuery = "insert into product values(?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
			preparedStatement.setInt(1, 100);
			preparedStatement.setString(2, "pen");
			preparedStatement.setDouble(3, 20);
			preparedStatement.setString(4, "Black");
			
			preparedStatement.execute();
			
			System.out.println("Data ---- Inserted");
			
			
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			
		}
		
	}

}
