package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProductDeleteController {
	public static void main(String[] args) {
		Connection connection=null;
		
		try {
			//STEP -1 LOAD REGISTER DRIVER 
			Class.forName("com.mysql.jdbc.Driver");
			
			//STEP-12CREATE CONNECTION
			String url = "jdbc:mysql://localhost:3306/jdbc-preparedstatement";
			String user = "root";
			String pass = "Sham7079@";
			
			connection=DriverManager.getConnection(url,user,pass);
			
			//Step-3 Update Color
			
			String deleteQuery="delete from product where productid=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
			
			preparedStatement.setInt(1, 100);
			
			int a=preparedStatement.executeUpdate();
			
			if(a==1){
				System.out.println("Data is Deleted");
			}
			else {
				System.err.println("Given is is not present");
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
