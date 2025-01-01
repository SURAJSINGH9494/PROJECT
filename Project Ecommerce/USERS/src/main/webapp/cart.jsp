<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Your Cart</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 20px;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
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

        .btn-container {
            text-align: center;
            margin-top: 20px;
            margin-bottom: auto; /* Push the footer to the bottom */
        }

        .footer {
            text-align: center;
            padding: 20px;
            background-color: #4A90E2;
            color: white;
            width: 100%;
            position: relative;
            bottom: 0;
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
    <h2>Your Cart</h2>
    <table>
        <thead>
            <tr>
                <th>Product ID</th>
                <th>Quantity</th>
            </tr>
        </thead>
        <tbody>
            <c:choose>
                <c:when test="${not empty cartItems}">
                    <c:forEach var="item" items="${cartItems}">
                        <tr>
                            <td>${item.productId}</td>
                            <td>${item.quantity}</td>
                        </tr>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <tr>
                        <td colspan="2" class="text-center">Your cart is empty.</td>
                    </tr>
                </c:otherwise>
            </c:choose>
        </tbody>
    </table>

    <div class="btn-container">
        <a href="index.jsp" class="btn btn-primary">Continue Shopping</a>
        <a href="checkout.jsp" class="btn btn-primary"> Place Order </a>
    </div>

    <footer class="footer">
        <p>&copy; 2024 E-Commerce</p>
    </footer>
</body>
</html>
