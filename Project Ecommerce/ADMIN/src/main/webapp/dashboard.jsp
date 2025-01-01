<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    <%@ page import="com.service.viewUserservice,com.model.usermodel,java.util.*" %>
		<%
		int total_Customers = viewUserservice.getTotalCustomers();
        request.setAttribute("total_Customers", total_Customers);
		%>
		
	<%@ page import="com.service.viewCategories,com.model.categoriesmodel,java.util.*" %> 
		<%
		int total_categories=viewCategories.getTotalCategories();
		request.setAttribute("total_categories", total_categories);
		%>
		
	<%@ page import="com.service.viewProducts,com.model.productmodel,java.util.*" %>     
    	<% 
    	int total_products= viewProducts.getTotalProducts();
    	request.setAttribute("total_products", total_products); 
    	%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Admin Dashboard</title>
  <style>
    /*  Body Styles */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }
    /* Nav Bar Styles */
    .navbar {
      background: linear-gradient(135deg, #007bff, #6c757d);
      padding: 1em;
      color: white;
      text-align: right;
    }
    
    .navbar a {
      color: white;
      margin-right: 20px;
      text-decoration: none;
    }
    .navbar.admin a{
      color:white;
      margin-left: 2px;
      text-decoration: none;
    }
    /* Dashboard Section Styles */
    .dashboard-container {
      padding: 20px;
      max-width: 650px;
      margin: 20px auto;
    }
    .dashboard-container h1 {
      color: #333;
      text-align: center;
    }
    /* Summary Cards Styles */
    .summary-cards {
      display: flex;
      justify-content: space-between;
      margin: 5px 5px 5px 10px;
    }
    .card {
      flex: 1;
      background-color: #fff;
      padding: 5px;
      margin: 5px;
      border-radius: 5px;
      box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
      text-align: center;
    }
    .card h4 {
      color: #000;
    }
    .card p {
      font-size: 24px;
      color: #333;
    }
    
    /* Buttons to View Details */
    .view-buttons {
      text-align: center;
    }
    .view-buttons button {
      padding: 10px 20px;
      margin: 5px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      color: white;
    }
    .view-buttons .orders { background-color:#4A90E2; }
    .view-buttons .users { background-color: #4A90E2; }
    .view-buttons .categories { background-color: #4A90E2; }
    .view-buttons .products { background-color: #4A90E2; }
    /* Footer Styles */
    footer {
      background: linear-gradient(135deg, #007bff, #6c757d);
      color: white;
      text-align: center;
      padding: 10px;
      position: fixed;
      width: 100%;
      bottom: 0;
    }
  </style>
</head>
<body>

  <!-- Navigation Bar -->
  <div class="navbar">
    <!-- <a href="index1.jsp">Dashboard</a> -->
    
    <a href="addcategories.jsp">Add Category</a>
    <a href="addproducts.jsp">Add Product</a>
    <a href="http://localhost:8080/ADMIN_ECOMMERCE/logoutservlet">Logout</a> 
  </div>

  								<!----- Admin Dashboard Section ------>
  
  <div class="dashboard-container">
   							 <h1 style="color: #4A90E2; ">Admin Dashboard</h1>

    								<!-- SUMMARY -->
    <div class="summary-cards">
      <div class="card">
     
      <div class="flex">
        <h4>Categories:		${total_categories}  </h4>
        <h4>Products:			${total_products}  </h4>  
       </div>
        
        <div class="flex">
        <h4>Customers:		${total_Customers}  </h4>
        <h4>Orders:			100 </h4>
        </div>
        
        <div class="flex">
        <h4>Capital of Business: 	₹1 CR </h4>
        </div>
        
      </div>
    </div>

   									 <!-- Buttons to View Details -->
    <div class="view-buttons">
    
      <a href="view/viewOrders.jsp">     <button class="orders"> View Orders</button></a>   
      <a href="view/viewUsers.jsp">      <button class="users">View Customer</button> </a>
      <a href="view/viewCategories.jsp"> <button class="categories">View Categories</button></a>
      <a href="view/viewProducts.jsp">   <button class="products">View Products</button></a>
      
    </div> 
  </div>

  <!-- Footer -->
  <footer>
    <p>&copy; 2024 E-Commerce. All rights reserved.</p>
  </footer>

</body>
</html>
    