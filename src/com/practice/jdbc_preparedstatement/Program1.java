package com.practice.jdbc_preparedstatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Program1 {
	public static void main(String[] args) { {
			
			
			try {
				// Load / Register Driver
				Class.forName("com.mysql.cj.jdbc.Driver");
				
				//Create Connection
				System.out.println("111222221111111111111111");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc-preparedstatement", "root", "Sham7079@");
				System.out.println(con);//"jdbc:mysql://localhost:3306/jdbc-preparedstatement","root","Sham7079@"
			
				
				//Create statement
				PreparedStatement pst = con.prepareStatement("insert into product values(13,'pencil',2,'dsd')");
				
				//execute query
				System.out.println(pst);
				System.out.println(pst.execute());
				
//				if(pst.execute())
//				{
//					System.out.println("data stored ");
//				}
//				else
//				{
//					System.out.println("data is not stored ");	
//				}
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO: handle exception
			}
			
		}
	}
}
