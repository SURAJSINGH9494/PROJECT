package com.controller;

import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.adminmodel;
import com.service.adminservice;

@WebServlet("/adminservlet")
public class adminservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		response.setContentType("text/html");

		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		adminmodel a = new adminmodel();
		
		a.setEmail(email);
		a.setPassword(password);
		
		boolean isLoggedIn = adminservice.Login(a);
        
        if (isLoggedIn) {
            // Start session and set session attributes
            HttpSession session = request.getSession();
            session.setAttribute("userEmail", email);
            session.setAttribute("isLoggedIn", true);

            response.sendRedirect("http://localhost:8080/ADMIN_ECOMMERCE/dashboard.jsp");
        } else {
            response.sendRedirect("http://localhost:8080/ADMIN_ECOMMERCE/adminlogin.jsp?error=invalid");
        }
		
		
	}
}
