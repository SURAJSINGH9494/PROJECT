<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.service.viewCategories,com.model.categoriesmodel,java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
Set<categoriesmodel> model = viewCategories.getAllCategories();

for (categoriesmodel products : model) {
    byte[] imageBytes = products.getLabel();
    if (imageBytes != null) {
        String base64Image = Base64.getEncoder().encodeToString(imageBytes);
        products.setBase64Image(base64Image);
       

     // System.out.println("Byte Array for Category ID " + model.getId() + ": " + java.util.Arrays.toString(imageBytes));
     // System.out.println("Base64 String for Category ID " + model.getId() + ": " + base64Image);
    }
}
request.setAttribute("model", model);
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product List | E-Commerce</title>
    <link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
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
                    <a class="nav-link" href="login.jsp">Logout</a> <!-- Change href to your logout page -->
                </li>
            </ul>
        </div>
    </nav>

    <!-- Product List -->
    <div class="container my-5">
        <h2 class="text-center">Categories</h2>
        <div class="row">
            <c:forEach var="cat" items="${model}">
                <div class="col-md-4 mb-4"> <!-- Adjust column width and margin for spacing -->
                    <div class="card">
                        <img src="${cat.label}" class="card-img-top product-img" alt="${cat.name}">
                        <div class="card-body">
                            <input type="hidden" name="categoriesid" value="${cat.categoriesid}">
                            <h5 class="card-title">${cat.name}</h5>
                            <p class="card-text">${cat.description}</p>
                            <a href="product-details.jsp?categories_id=${cat.categoriesid}" class="btn btn-primary">View Products</a>
                        </div>
                    </div>
                </div>
                <!-- The closing tag for the col-md-4 div is inside the forEach loop -->
            </c:forEach>
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
