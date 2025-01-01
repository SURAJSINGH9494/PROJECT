<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="com.service.viewCategories,com.model.categoriesmodel,java.util.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%
 Set<categoriesmodel> model = viewCategories.getAllCategories();
 request.setAttribute("model", model);
 %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>viewCategories</title>
<style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
        }

        h2 {
            text-align: center;
            color: #333;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin: 20px 0;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
        }

        th, td {
            padding: 12px 15px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background-color: #4A90E2;
            color: white;
            text-transform: uppercase;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        @media (max-width: 600px) {
            body {
                padding: 10px;
            }

            table {
                font-size: 14px;
            }

            th, td {
                padding: 10px;
            }
        }
    </style>

</head>
<body>

		<h2>Categories</h2>
		
		<table>
		
		<tr>
		<th>Categories_Id</th>
		<th>Name</th>
		<th>Description</th>
		<!-- <th>Label</th> -->
		</tr>
		
		<c:forEach var="cat" items="${model}">
		
		<tr>
		<td>${cat.categories_id}</td>
		<td>${cat.name}</td>
		<td>${cat.description})</td>
		<%-- <td>${cat.label}</td> --%>
		</tr>
		</c:forEach>
		
		</table>

</body>
</html>