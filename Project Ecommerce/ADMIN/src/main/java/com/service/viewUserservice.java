package com.service;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.usermodel;

public class viewUserservice {
							//---------  CONNECTION METHOD -------------//
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
		
								//-----GET ALL USERS----///
	
	public static List<usermodel> getAllusers(){
		
		List<usermodel> userlist = new ArrayList<>();
		Connection con = connect();
		String query = "SELECT USER_ID, USERNAME, EMAIL FROM USERS";
		try {
			PreparedStatement fetch = con.prepareStatement(query);
			ResultSet rs = fetch.executeQuery();
			while(rs.next()) {
				usermodel user = new usermodel();
				user.setUser_id(rs.getInt("user_id"));
                user.setUsername(rs.getString("username"));
                user.setEmail(rs.getString("email"));
               userlist.add(user);
                
			}return userlist;
		} catch (SQLException e) {
			System.out.println("getAllusers Exception:"+ e);
		}
		return null;
	}
	
						//-----GET TOTAL NUMBER OF CUSTOMERS----///
    public static int getTotalCustomers() {
        Connection con = connect();
        String query = "SELECT COUNT(*) AS total_customers FROM USERS";
        try {
            PreparedStatement fetch = con.prepareStatement(query);
            ResultSet rs = fetch.executeQuery();
            if (rs.next()) {
                 int  sum = rs.getInt("total_customers");
                 return sum;
            }
        } catch (SQLException e) {
            System.out.println("getTotalCustomers Exception:" + e);
        }
        return 0;
    }
	
}
