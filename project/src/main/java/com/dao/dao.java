package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.pojo;

public class dao {

	  //conn 
	       public static Connection getconn() {
	    	   Connection cn=null;
	    	   
	    	   try {
				Class.forName("com.mysql.jdbc.Driver");
				
				cn= DriverManager.getConnection("jdbc:mysql://localhost/foursept", "root", "");
			} catch (Exception e) {
				System.out.println("con not found");
			}
			return cn;
	    	     
	       }
	       
	       //insert
	       public static int datainsert(pojo p) {
	    	   
	    	   int status= 0;
	    	   
	    	   Connection cn=getconn();
	    	   
	 String insert= "insert into registration (name,email,password) values (?,?,?)" ;
	 
	 
	  try {
		PreparedStatement ps = cn.prepareStatement(insert);
		
		 ps.setString(1, p.getName());
		 ps.setString(2, p.getEmail());
		 ps.setString(3, p.getPassword());
		 
		status=    ps.executeUpdate();
		
		 if(status > 0) {
			 
			     System.out.println("data inserted");
		 }
		 
	} catch (Exception e) {
	
		  System.out.println("data not inserted");
	}
	    	    
			return status;
	    	   
	    	   
	       }
	       
	       
	       //delete
	       public static int datadelete(int id) {
	    	   
	    	   int status= 0;
	    	   
	    	   Connection cn=getconn();
	    	   
	 String delete= "delete from registration where rid=? ";
	 
	 
	  try {
		PreparedStatement ps = cn.prepareStatement(delete);
		
		 ps.setInt(1,id);
		
		 
		status=    ps.executeUpdate();
		
		 if(status > 0) {
			 
			     System.out.println("data deleted");
		 }
		 
	} catch (Exception e) {
	
		  System.out.println("data not deleted");
	}
	    	    
			return status;
	    	   
	    	   
	       }
	       
	       //update
	       public static int dataupdate(pojo p) {
	    	   
	    	   int status= 0;
	    	   
	    	   Connection cn=getconn();
	    	   
	 String update= "update registration set name=?,email=?,password=? where rid=?";
	 
	 
	  try {
		PreparedStatement ps = cn.prepareStatement(update);
		
		 ps.setString(1, p.getName());
		 ps.setString(2, p.getEmail());
		 ps.setString(3, p.getPassword());
		 ps.setInt(4, p.getRid());
		 
		status=    ps.executeUpdate();
		
		 if(status > 0) {
			 
			     System.out.println("data update");
		 }
		 
	} catch (Exception e) {
	
		  System.out.println("data not updated");
	}
	    	    
			return status;
	    	   
	    	   
	       } 
	       
	       
	       // single data fetch by id for update 
	       
	        public static pojo getdatafetchbyid(int id) {
	        	
	        	pojo p=null;
	        	
	        	 Connection cn = getconn();
	 	    	
		    	 String dfetch1 = "select * from registration where rid=?";
	        	
	        	
		    	 try {
						PreparedStatement ps = cn.prepareStatement(dfetch1);
						
						 ps.setInt(1, id);
						ResultSet rs= ps.executeQuery();
						
						
						while (rs.next()) {
							
							 p= new pojo();
							 
							 p.setRid(rs.getInt("rid"));
							 p.setName(rs.getString("name"));
							 p.setEmail(rs.getString("email"));
							 p.setPassword(rs.getString("password"));
							 
							
						}
					} catch (Exception e) {
						
						System.out.println("single data not fetch");
					}
			    	 
	        	
				return p;
	        	
	        	
	        	
	        	
	        }
	       
	      // data fetch from db 
	       
	       
	     public static List<pojo> getalldata(){
	    	 
	    	 List<pojo> p = new ArrayList<pojo>();
	    	 
	    	 Connection cn = getconn();
	    	
	    	 String dfetch = "select * from registration";
	    	 
	    	 try {
				PreparedStatement ps = cn.prepareStatement(dfetch);
				
				ResultSet rs= ps.executeQuery();
				
				
				while (rs.next()) {
					
					 pojo b= new pojo();
					 
					 b.setRid(rs.getInt("rid"));
					 b.setName(rs.getString("name"));
					 b.setEmail(rs.getString("email"));
					 b.setPassword(rs.getString("password"));
					 
					 p.add(b);
				}
			} catch (Exception e) {
				
				System.out.println("data not fetch");
			}
	    	 
	    	 
			return p;
	    	 
	    	 
	    	 
	    	 
	     }
	       
	       
}
