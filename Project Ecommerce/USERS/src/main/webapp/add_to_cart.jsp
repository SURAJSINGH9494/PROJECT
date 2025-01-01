<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Category - E-Commerce</title>
  <style>
    /* General Body Styles */
    body {
      font-family: Arial, sans-serif;
      margin: 0;
      padding: 0;
      background-color: #f4f4f4;
    }
    /* Header and Navigation Bar */
    .navbar {
      background: linear-gradient(135deg, #007bff, #6c757d);
      padding: 10px 20px;
      color: white;
      display: flex;
      justify-content: space-between;
      align-items: center;
    }
    .navbar .logo {
      font-size: 24px;
      font-weight: bold;
    }
    .navbar a {
      color: white;
      margin-left: 20px;
      text-decoration: none;
      font-weight: bold;
    }
    /*.navbar a:hover {
      text-decoration: underline;
    }*/
    /* Form Section */
    .form-container {
      max-width: 400px;
      margin: 50px auto;
      background-color: white;
      padding: 20px;
      border-radius: 5px;
      box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.2);
      text-align: left;
    }
    .form-container h2 {
      color: #333;
      text-align: center;
    }
    .form-container input[type="text"],
    .form-container input[type="file"] {
      width: 100%;
      padding: 10px 2px 2px 2px;
      margin: 10px 0;
      border: 1px solid #ddd;
      border-radius: 3px;
    }
    /* Buttons */
    .form-container .button-container {
      display: flex;
      justify-content: space-around;
    }
    .form-container button {
      padding: 10px 20px;
      border: none;
      border-radius: 5px;
      cursor: pointer;
      color: white;
      font-weight: bold;
    }
    .form-container .submit-btn {
      background-color: #4CAF50;
    }
    .form-container .reset-btn {
      background-color: #f44336;
    }
    .form-container button:hover {
      opacity: 0.8;
    }
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
    <div class="logo">E-Commerce</div>
    <div>
      <a href="index1.jsp">Dashboard</a>
      <a href="#">Add Product</a>
      <a href="addcat.jsp">Add Category</a>
      <a href="login.jsp">Logout</a>
    </div>
  </div>

  <!-- Form Section -->
  <div class="form-container">
    <h2>Add Category</h2>
    <form action="/submit-category" method="post" enctype="multipart/form-data">
      <label for="category-name">Name:</label>
      <input type="text" id="category-name" name="name" required>
      <label for="category-image"></label>
      <input type="file" id="category-image" name="image">
      <div class="button-container">
        <input type="submit" value="Submit" class="submit-btn">
        <button type="reset" class="reset-btn">Reset</button>
      </div>
    </form>
  </div>

  <!-- Footer -->
  <footer>
    <p>&copy; 2024 E-Commerce. All rights reserved.</p>
  </footer>

</body>
</html>
    