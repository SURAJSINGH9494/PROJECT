package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.adminmodel;

public class adminservice {

	
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
	
	

								//------ADMIN REGISTRATION-------///

		public static void Registeration(adminmodel u) {
			Connection con=connect();
			String query = "INSERT INTO admin(email,password) VALUES (?,?)";
			try {
				PreparedStatement ins = con.prepareStatement(query);
				ins.setString(1, "admin123@gmail.com");
				ins.setString(2, "admin123");
				
				if (ins.executeUpdate() == 1) {
					System.out.println("Registeration Succesfully");
				}
				} catch (SQLException e) {
					System.out.println("Registeration Exeception" + e);	
				}	
		}

								//-----ADMIN LOGIN----///
		public static boolean Login(adminmodel u) {

			Connection con = connect();
			String query = "SELECT * FROM ADMIN WHERE EMAIL=? AND PASSWORD=?";
			try {
				PreparedStatement log = con.prepareStatement(query);
				log.setString(1, u.getEmail());
				log.setString(2,u.getPassword());

				ResultSet l = log.executeQuery();  

				if(l.next()) {
					System.out.println("Login ! Successfully.......");
					return true;
				}else {
					System.out.println("Incorrect ! username or password......");
				}
			} catch (SQLException e) {
				System.out.println("Login Eroor");
			}
			return false;
		}
	
	
	
}
