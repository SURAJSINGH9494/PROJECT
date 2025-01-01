<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ page import="com.service.viewProducts,com.model.productmodel,java.util.*" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 List<productmodel> product = viewProducts.getAllProducts();
 request.setAttribute("product", product);
 %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details | E-Commerce</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
   
</head>
<body>
  <nav class="navbar navbar-expand-lg navbar-light bg-black">
    <a class="navbar-brand" href="index.jsp">
        <img src="logo.png" alt="Brand Logo" style="height: 40px;"> <!-- Replace with your logo path -->
        E-Commerce
    </a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item">
                <a class="nav-link" href="index.jsp">Home</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="product-list.jsp">Products</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="cart.jsp">Cart</a>
            </li>
        </ul>
        <ul class="navbar-nav">
           
            <li class="nav-item">
                <a class="nav-link" href="logout.jsp">Logout</a> <!-- Change href to your logout page -->
            </li>
        </ul>
    </div>
</nav>

    <!-- Product Details  -->
	
    <div class="container my-5">
        
        <c:forEach var="product" items="${product}">
        <div class="row">
            <div class="col-md-6">
                <img src="${product.label }" class="img-fluid" alt="Product Image">
            </div>
            <div class="col-md-6">
            	<p> <input type="hidden" name="product_id" value="${product.product_id }"></p>
                <h2>${product.name }</h2>
                <p>${product.price }</p>
                <p>${product.description }</p>
                <form action="addToCartServlet">
                <a href="product-details.jsp" class="btn btn-primary">Add to Cart</a>
                </form>
                
            </div>
        </div>
        </c:forEach> 
    </div>

    <!-- Footer -->
    <footer class="footer">
        <p>&copy; 2024 E-Commerce Website</p>
    </footer>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    
</body>
</html>
