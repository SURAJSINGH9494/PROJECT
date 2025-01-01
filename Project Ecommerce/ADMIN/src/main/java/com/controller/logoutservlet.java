package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logoutservlet")
public class logoutservlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get the current session, if any
        HttpSession session = request.getSession(false); // false means don’t create a new session if one doesn't exist

        // Invalidate the session if it exists
        if (session != null) {
            session.invalidate();
        }

        // Redirect to the login page or home page after logout
        response.sendRedirect("http://localhost:8080/ADMIN_ECOMMERCE/adminlogin.jsp");
    }
}
