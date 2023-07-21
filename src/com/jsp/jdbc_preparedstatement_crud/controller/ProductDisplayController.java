package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDisplayController {
	public static void main(String[] args) {
Connection connection=null;
		
		try {
			//STEP -1 LOAD REGISTER DRIVER 
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP-2CREATE CONNECTION
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "Sham7079@";
			
			connection=DriverManager.getConnection(url,user,pass);
			
			//Step-3 Update Color
			
			String displayQuery="Select * from product";
			
			PreparedStatement preparedStatement = connection.prepareStatement(displayQuery);
			
			
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				int id= resultSet.getInt("productid");
				String name = resultSet.getString("productname");
				double price = resultSet.getDouble("productprice");
				String color = resultSet.getString("productcolor");
				
				System.out.println("Id : "+id);
				System.out.println("Name : "+name);
				System.out.println("Price : "+price);
				System.out.println("Color : "+color);
				
				System.out.println("==================================================");
			}
	} catch (SQLException | ClassNotFoundException e) {
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
