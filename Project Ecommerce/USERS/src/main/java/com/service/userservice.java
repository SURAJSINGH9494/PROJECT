package com.service;

import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.usermodel;

public class userservice {
							//---------  CONNECTION METHOD -------------//
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
									//------USER REGISTRATION-------///
	
	public static void Registeration(usermodel u) {
		Connection con=connect();
		String query = "INSERT INTO users(username,password,email) VALUES (?,?,?)";
		try {
			PreparedStatement ins = con.prepareStatement(query);
			ins.setString(1, u.getUsername());
			ins.setString(2,u.getPassword());
			ins.setString(3,u.getEmail());
			if (ins.executeUpdate() == 1) {
				System.out.println("Registeration Succesfully");
			}
		} catch (SQLException e) {
		System.out.println("Registeration Exeception"+e);	
		}
	}
	
								//-----USER LOGIN----///
	public static void Login(usermodel u) {
		
		Connection con = connect();
		String query = "SELECT * FROM USERS WHERE USERNAME=? AND PASSWORD=?";
		try {
			PreparedStatement log = con.prepareStatement(query);
			log.setString(1, u.getUsername());
			log.setString(2,u.getPassword());

			ResultSet l = log.executeQuery();  
			
			if(l.next()) {
				System.out.println("Login ! Successfully........");
			}else {
				System.out.println("Incorrect ! username or password......");
			}
		} catch (SQLException e) {
		System.out.println("Login Eroor"+e);
		}
		
	}
	
	public static List<usermodel> getAllusers(){
		
		List<usermodel> userlist = new ArrayList<>();
		Connection con = connect();
		String query = "SELECT * FROM USERS";
		try {
			PreparedStatement fetch = con.prepareStatement(query);
			ResultSet rs = fetch.executeQuery();
			while(rs.next()) {
				usermodel user = new usermodel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                userlist.add(user);
                return userlist;
			}
		} catch (SQLException e) {
			System.out.println("getAllusers Exception:"+ e);
		}
		return null;
	}
	
	
}
