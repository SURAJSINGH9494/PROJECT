<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Add Category</title>
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
      padding: 30px;
      border-radius: 10px;
      box-shadow: 0 4px 12px rgba(0, 0, 0, 0.1);
      width: 100%;
      max-width: 500px;
    }

    h2 {
      text-align: center;
      color: #4A90E2;
      margin-bottom: 20px;
      font-size: 1.8em;
    }

    .form-group {
      margin-bottom: 15px;
    }

    .form-group label {
      display: block;
      font-weight: bold;
      color: #333;
      margin-bottom: 8px;
    }

    .form-group input[type="text"],
    .form-group textarea,
    .form-group input[type="file"] {
      width: 100%;
      padding: 12px;
      border: 1px solid #ddd;
      border-radius: 6px;
      outline: none;
      transition: border-color 0.3s;
    }

    .form-group input[type="text"]:focus,
    .form-group textarea:focus,
    .form-group input[type="file"]:focus {
      border-color: #4A90E2;
    }

    .form-group textarea {
      resize: vertical;
      height: 100px;
    }

    .buttons {
      display: flex;
      justify-content: space-between;
      gap: 10px;
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

  <div class="container">
    <h2>Add Category</h2>
    <form action="categoryservlet" method="post" enctype="multipart/form-data">
    
      <div class="form-group">
        <label for="category-name">Category Name</label>
        <input type="text" id="category-name" name="name" placeholder="Enter category name" required>
      </div>
      <div class="form-group">
        <label for="description">Description</label>
        <textarea id="description" name="description" placeholder="Enter category description" required></textarea>
      </div>
      <div class="form-group">
        <label for="category-photo">Category Photo</label>
        <input type="file" id="category-photo" name="label" required>
      </div>
      <div class="buttons">
        <input type="submit" value="Add Category" class="add-button">
        <button type="reset" class="reset-button">Reset Fields</button>
      </div>
    </form>
  </div>

</body>
</html>


