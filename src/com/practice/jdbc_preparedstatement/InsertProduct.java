package com.practice.jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertProduct {
	public static void main(String[] args) {
		Connection con=null;
		try {
			//LOAD DRIVER 
			Class.forName("com.mysql.jdbc.Driver");
			
			//CREATE CONNECTION 
			
			con =DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-preparedstatement","root","Sham7079@");
			
			
			//INSERT QUERY
			
			PreparedStatement pst =con.prepareStatement("insert into product(productid,productname,productprice,productcolor) values(?,?,?,?)");
			
			pst.setInt(1,1 );
			pst.setString(2, "pencil");
			pst.setDouble(3, 300);
			pst.setString(4, "green");
			
			pst.execute();
			
			System.out.println("Data Inserted");
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}
	}

}
