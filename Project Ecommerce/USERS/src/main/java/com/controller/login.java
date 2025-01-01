package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.usermodel;
import com.service.userservice;

@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public login() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String email= request.getParameter("email");
		String password = request.getParameter("password");
		
		usermodel m = new usermodel();
		
		m.setEmail(email);
		m.setPassword(password);
		
		userservice.Login(m);
		response.sendRedirect("http://localhost:8080/USERS/index.jsp");
		
	}

	

}
