package com.jsp.jdbc_preparedstatement_crud.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductUpdateController {
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
			
			String updateColorQuery="update product set productcolor=? where productid=?";
			
			PreparedStatement preparedStatement = connection.prepareStatement(updateColorQuery);
			
			preparedStatement.setString(1, "Green");
			preparedStatement.setInt(2, 100);
			
			int a=preparedStatement.executeUpdate();
			
			if(a==1){
				System.out.println("Data is Updated");
			}
			else {
				System.out.println("Given is is not present");
			}
	} catch (Exception e) {
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
