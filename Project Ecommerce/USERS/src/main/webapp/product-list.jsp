<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@ page import="com.service.viewProducts,com.model.productmodel,java.util.*" %>
	 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 List<productmodel> product = viewProducts.getAllProducts();
 

 // Convert image byte array to Base64 for each product
 for (productmodel products : product) {
     byte[] imageBytes = products.getImage();
     if (imageBytes != null) {
         String base64Image = Base64.getEncoder().encodeToString(imageBytes);
         products.setBase64Image(base64Image);
        

      // System.out.println("Byte Array for Product ID " + product.getId() + ": " + java.util.Arrays.toString(imageBytes));
      // System.out.println("Base64 String for Product ID " + product.getId() + ": " + base64Image);
     }
 }
 
 request.setAttribute("product", product);

 %>
 
 
<!DOCTYPE html> 
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List | E-Commerce</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
    <style>
        .product-img {
            height: 200px; /* Fixed height for images */
            object-fit: cover; /* Maintain aspect ratio */
        }
    </style>
</head>
<body>
    <!-- Navbar -->
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
                <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
                <li class="nav-item"><a class="nav-link" href="categories.jsp">Categories</a></li>
                <li class="nav-item"><a class="nav-link" href="cart.jsp">Cart</a></li>
            </ul>
            <ul class="navbar-nav">
                <li class="nav-item"><a class="nav-link" href="login.jsp">Logout</a></li>
            </ul>
        </div>
    </nav>

    <!-- Product List -->
    <div class="container my-5">
        <h2 class="text-center">All Products</h2> <br>
        <div class="row">
        <!-- Iterate over the products -->
            <c:forEach var="product" items="${product}">
                <div class="col-md-6 mb-4"> <!-- Two cards per row -->
                    
                   
                    <div class="card">     
                    <img src="data:image/*;base64,${product.base64Image}" class="card-img-top product-img" alt="${product.name}">     
                    <div class="card-body">
                            <h5 class="card-title">${product.name}</h5>
                            <p class="card-text">${product.price}</p>
                           
                            <a href="product-details.jsp?id=${product.product_id}" class="btn btn-primary">View Product Details</a>
                             
                        </div>
                    </div>
                    
                    
                </div>
            </c:forEach>
        </div>
    </div>

    <!-- Footer -->
    <footer class="footer text-center mt-5">
        <p>&copy; 2024 E-Commerce Legend</p>
    </footer>
    
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
