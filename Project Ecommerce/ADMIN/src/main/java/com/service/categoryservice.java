package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.categoriesmodel;

public class categoryservice {
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

							//------CATEGORY INSERTION-------///

	public static void InsertCategory(categoriesmodel u) {
		Connection con=connect();
		String query = "INSERT INTO categories(name,description,label) VALUES (?,?,?)";
		try {
			PreparedStatement ins = con.prepareStatement(query);
			ins.setString(1, u.getName());
			ins.setString(2, u.getDescription());
			ins.setBytes(3, u.getLabel());
			
			if (ins.executeUpdate() == 1) {
				System.out.println("Category added Successfully.......");
			}
			} catch (SQLException e) {
				System.out.println("Add Category...... Exeception" + e);	
			}	
	}

							//-----FETCH CATEGORIES----///
	public static void category(categoriesmodel u) {

		Connection con = connect();
		String query = "SELECT * FROM categories WHERE categoriesId=?";
		try {
			PreparedStatement log = con.prepareStatement(query);
			log.setString(1, u.getName());
			log.setString(2, u.getDescription());
			log.setBytes(3, u.getLabel());
			

			ResultSet l = log.executeQuery();  

			if(l.next()) {
				System.out.println("Category ! Found.......");
			}else {
				System.out.println("Incorrect ! Categories_id......");
			}
		} catch (SQLException e) {
			System.out.println("Category Exception : "+ e);
		}
	}
}
