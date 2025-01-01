package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

import com.model.categoriesmodel;

public class viewCategories {

	
public static Connection connect() {
		
		Connection con = null;
		
		String PATH = "com.mysql.cj.jdbc.Driver";
		String URL="jdbc:mysql://localhost:3306/ECOMMERCE_EC";
		String USERNAME= "root";
		String PASSWORD="rahul3107";
		
		try {
			Class.forName(PATH);
		return	DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Connection Exception :"+e);
			}
		
		return con;
	}
			

					/*--------VIEW CATEGORIES--------*/

public static Set<categoriesmodel> getAllCategories()
{
	
	Set<categoriesmodel> cat = new HashSet<>();
	
	Connection con = connect();
	String query = "SELECT * FROM CATEGORIES";
	try {
		PreparedStatement fetch = con.prepareStatement(query);
		ResultSet rs = fetch.executeQuery();
		while(rs.next()) {
		categoriesmodel m = new categoriesmodel();	
		m.setCategoriesId(rs.getInt("categoriesid"));
		m.setName(rs.getString("name"));
		m.setDescription(rs.getString("description"));
		m.setLabel(rs.getBytes("label"));
		cat.add(m);
		
		} 
		return cat;
	} catch (SQLException e) {
		System.out.println("View Categories Exception :"+ e);
	}
	return null;
}

						//----------SUM OF ALL CATEGORIES---------//
		
		
		public static int getTotalCategories() {
			Connection con = connect();
			String query = "SELECT COUNT(*) as total_categories from CATEGORIES";
			
			try {
				PreparedStatement get = con.prepareStatement(query);
				ResultSet rs = get.executeQuery();
				if(rs.next()) {
					int  sum = rs.getInt("total_categories");
	                 return sum;
				}
			} catch (SQLException e) {
				System.out.println("Sum of Categories Exception :"+ e);
			}			
			return 0;
			
		}
}
