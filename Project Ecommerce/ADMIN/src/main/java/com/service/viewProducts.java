package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.productmodel;

public class viewProducts {

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
			

					/*--------VIEW PRODUCTS--------*/
			public static List<productmodel> getAllProducts(){
				List<productmodel> product = new ArrayList<>();
				Connection con = connect();
				String query = "SELECT * from products";
				try {
					PreparedStatement pro = con.prepareStatement(query);
				    ResultSet rs = pro.executeQuery();
				    
				    while(rs.next()) {
				    	productmodel obj = new productmodel();
				    	obj.setId(rs.getInt("id"));
				    	obj.setName(rs.getString("name"));
				    	obj.setPrice(rs.getDouble("price"));
				    	obj.setDescription(rs.getString("description"));
				    	obj.setImage(rs.getBytes("image"));
				    	
				    	
				    	
				    	product.add(obj);
				    }
				    return product;
				} catch (SQLException e) {
					System.out.println("getAllProduct Exception:"+e);
				} 
				return null;
			}
	
					//---------------SUM OF PRODUCTS------------------//
					public static int getTotalProducts()
						{
						
						Connection con = connect();
						String query = "SELECT COUNT(*) as TOTAL_PRODUCTS from PRODUCTS";
						try {
							PreparedStatement ps = con.prepareStatement(query);
							ResultSet rs = ps.executeQuery();
							if(rs.next()) {
								int sum = rs.getInt("TOTAL_PRODUCTS");
								return sum;
							}
							} catch (SQLException e) {
							System.out.println("getTotalProducts Exception:"+e);
						}
						return 0;
						}
					/*--------------------------VIEW Electronics----------------------------------*/
					public static List<productmodel> getAllProductsElectronics(){
						List<productmodel> product = new ArrayList<>();
						Connection con = connect();
						String query = "SELECT * from products where category ='Electronics' ";
						try {
							PreparedStatement pro = con.prepareStatement(query);
						    ResultSet rs = pro.executeQuery();
						    
						    while(rs.next()) {
						    	productmodel obj = new productmodel();
						    	obj.setId(rs.getInt("id"));
						    	obj.setName(rs.getString("name"));
						    	obj.setDescription(rs.getString("description"));
						    	//obj.setCategoryId( rs.getInt("Categoryid"));
						    	obj.setImage(rs.getBytes("image"));
						    	obj.setPrice(rs.getDouble("price"));
						    
						    	product.add(obj);
						    }
						    return product;
						} catch (SQLException e) {
							System.out.println("getAllProduct Exception:"+e);
						} 
						return null;
					}
					
					
					
}
