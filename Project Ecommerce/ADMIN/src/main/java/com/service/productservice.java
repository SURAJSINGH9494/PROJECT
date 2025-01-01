package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.productmodel;

public class productservice {

public static Connection connect() {
		
		Connection con = null;
		
		String PATH = "com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/ECOMMERCE_EC";
		String USERNAME= "root";
		String PASSWORD="3107";
		
		try {
			Class.forName(PATH);
		return	DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Connection Exception :"+e);
			}
		
		return con;
	}


						/*-------PRODUCT INSERTION---------*/
	public static void InsertProduct(productmodel u) {
			Connection con = connect();
			String Query = "INSERT INTO products (NAME, PRICE, DESCRIPTION, LABEL, CATEGORY_ID) VALUES (?,?,?,?,?)" ;
					
			
			try {
				PreparedStatement ins = con.prepareStatement(Query);
				ins.setString(1, u.getName());
				ins.setDouble(2, u.getPrice());
				ins.setString(3, u.getDescription());
				ins.setBytes(4, u.getImage());
				ins.setInt(5, u.getCategoryId());
				
				
		
				
				if(ins.executeUpdate()==1) {
					System.out.println("Product Inserted......Successfully.");
				}else {
					System.out.println("Product not Inserted......");
				}
			} catch (SQLException e) {
				System.out.println("InsertProduct....Exception."+e);
			}
			
	}
	
}
