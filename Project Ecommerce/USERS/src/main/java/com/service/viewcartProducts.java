
package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CartModel; 

public class viewcartProducts {
    
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

    // Method to fetch cart items
    public List<CartModel> getCartItems() {
    	try {
    	Connection con = connect();
        List<CartModel> cartItems = new ArrayList<>();
        String sql = "SELECT product_id, quantity FROM cart"; // Adjust as needed

             PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery(); 
             
             while (rs.next()) {
                int productId = rs.getInt("product_id");
                int quantity = rs.getInt("quantity");
                
                cartItems.add(new CartModel(productId, quantity));
            }
             return cartItems;
    	} catch (SQLException e) {
			System.out.println("GET Cart Items Exception :" +e);
		}
		return null; 
       
    }
    
    
    
    
    
    
    
    
    
}
