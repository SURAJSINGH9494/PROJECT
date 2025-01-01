<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Product</title>
   <!-- Bootstrap CSS -->
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet">
  <style>
    * {
      box-sizing: border-box;
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
    }

    body {
      display: flex;
      justify-content: center;
      align-items: center;
      min-height: 100vh;
      background-color: #f0f2f5;
    }

    .container {
      background-color: #fff;
      padding: 25px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.15);
      width: 100%;
      max-width: 550px;
    }

    h2 {
      text-align: center;
      color: #4A90E2;
      margin-bottom: 25px;
      font-size: 1.8em;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
      color: #555;
      margin-bottom: 8px;
    }

    .form-group input[type="text"],
    .form-group textarea,
    .form-group input[type="file"],
    .form-group input[type="number"],
    .form-group select {
      width: 100%;
      padding: 12px;
      border: 1px solid #ddd;
      border-radius: 6px;
      outline: none;
      transition: border-color 0.3s;
    }

    .form-group input[type="text"]:focus,
    .form-group textarea:focus,
    .form-group input[type="file"]:focus,
    .form-group input[type="number"]:focus,
    .form-group select:focus {
      border-color: #4A90E2;
    }

    .form-group textarea {
      resize: vertical;
      height: 100px;
    }

    .buttons {
      display: flex;
      justify-content: space-between;
      gap: 12px;
    }
    .buttons input {
      width: 100%;
      padding: 12px;
      font-size: 16px;
      font-weight: bold;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s;
      color: #fff;
    }

    .buttons button {
      width: 100%;
      padding: 12px;
      font-size: 16px;
      font-weight: bold;
      border: none;
      border-radius: 6px;
      cursor: pointer;
      transition: background-color 0.3s;
      color: #fff;
    }

    .buttons .add-button {
      background-color: #4A90E2;
    }

    .buttons .add-button:hover {
      background-color: #357ABD;
    }

    .buttons .reset-button {
      background-color: #555;
    }

    .buttons .reset-button:hover {
      background-color: #333;
    }
  </style>
</head>
<body>

													   <!-- FORM  STARTS -->
  <div class="container">
    <h2>Add Product</h2>
    <form action="productservlet" method="post" enctype="multipart/form-data">
      <div class="form-group">
        <label for="product-name">Product Name</label>
        <input type="text" id="product-name" name="name" placeholder="Enter product name" required>
      </div>
      
       <div class="form-group">
        <label for="price">Price (₹)</label>
        <input type="number" id="price" name="price" placeholder="Enter product price"required>
      </div>
      
      <div class="form-group">
        <label for="description">Description</label>
        <textarea id="description" name="description" placeholder="Enter product description" required></textarea>
      </div>
      
      
      
      <div class="form-group">
        <label for="category">Category</label>
        <select id="category" name="category" required>
          <option value="" disabled selected>Select category</option>
          <option value="electronics">Electronics</option>
          <option value="apparel">Apparel</option>
          <option value="home-goods">Home Goods</option>
          <option value="beauty">Beauty</option>
        </select>
        </div>
        <div class="form-group">
        <label for="product-photo">Product Image</label>
        <input type="file" id="image" name="image" accept="image/*" required>
      </div>
        
      <div class="buttons">
        <input type="submit" value="Add Product" class="add-button">
        <button type="reset" class="reset-button">Reset</button>
      </div>
    </form>
  </div>
  

</body>
</html>
    