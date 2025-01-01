package com.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.CartModel;

public class CartProducts {

	
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
	
    public void addToCart(CartModel c) {    	
    	try {
    		Connection con = connect();
    	String sql = "INSERT INTO cart (product_id, quantity) VALUES (?, ?) ON DUPLICATE KEY UPDATE quantity = quantity + ?";
         PreparedStatement stmt;
		
			stmt = con.prepareStatement(sql);
			    stmt.setInt(1,c.getProductId());
	            stmt.setInt(2, c.getQuantity());
	            stmt.setInt(3, c.getQuantity());
	            
	            if(stmt.executeUpdate()==1) {
	            	System.out.println("Added to cart");
	            }
			} catch (SQLException e) {
			System.out.println("ADD to Cart Exception :" +e);
				} 
     }
    
    
    
    
}
    
    

