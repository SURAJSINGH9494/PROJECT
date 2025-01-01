package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.service.CartProducts; // Import your DAO
import com.model.CartModel; // Import your model

@WebServlet("/addToCartServlet")
public class AddToCartServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private CartProducts cartService = new CartProducts(); // Use your DAO class

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        try {
            int productId = Integer.parseInt(request.getParameter("product_id"));
            int quantity = Integer.parseInt(request.getParameter("quantity"));

            // Create a CartModel object
            CartModel cartItem = new CartModel(productId, quantity);
            
            // Use the cartProducts service to add to cart
            cartService.addToCart(cartItem);
            
            response.sendRedirect("cart.jsp"); // Redirect to cart page after adding
        } catch (NumberFormatException e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid input for product ID or quantity.");
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }
}
