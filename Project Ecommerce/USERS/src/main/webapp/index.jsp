<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"> 
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>E-Commerce  </title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <link href="./css/styles.css" rel="stylesheet">
</head>
<body>
   
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <a class="navbar-brand" href="index.jsp">
            <img src="https://img.favpng.com/11/23/17/web-development-e-commerce-logo-electronic-business-online-shopping-png-favpng-yjDNxAK8mM45kp5sBzMNhJx9v.jpg" alt="Brand Logo" style="height: 40px;">
            E-Commerce
        </a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="categories.jsp">Categories</a>
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
                    <a class="nav-link" href="login.jsp">Logout</a>
                </li>
            </ul>
        </div>
    </nav>

    <!-- Banner -->
    <div class="container text-center my-5">
        <h1>Welcome to Our Store</h1>
        <p>Discover amazing products at unbeatable prices.</p>
        <a href="product-list.jsp" class="btn btn-primary btn-lg">Shop Now</a>
    </div>

    <!-- Featured Products -->
    <div class="container my-5">
        <h2 class="text-center mb-4">Featured Products</h2>
        <div class="row">
           <!-- <c:forEach var="product" items="${products}"> --> 
                <div class="col-md-4">
                    <div class="card">
                        	<img src="${product.imageUrl}" class="card-img-top" alt="Product Image">
                       		<div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.description}</p>
                            <a href="product-details?id=${product.id}" class="btn btn-primary">View Details</a>
                 	</div>
                 	
                 	
                    </div>
                </div>
          <!--   </c:forEach> -->
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer text-center">
    <div class="container">
        <p class="footer-text">&copy; 2024 E-Commerce. All Rights Reserved.</p>
    </div>
</footer>
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
