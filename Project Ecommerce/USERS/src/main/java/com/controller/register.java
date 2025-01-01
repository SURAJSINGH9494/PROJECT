package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.usermodel;
import com.service.userservice;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public register() {
        super();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email    = request.getParameter("email");
			
			usermodel m = new usermodel();
			
			m.setUsername(username);
			m.setPassword(password);
			m.setEmail(email);
			
			userservice.Registeration(m);
			response.sendRedirect("login.jsp");
			RequestDispatcher Dispatch=request.getRequestDispatcher("signup.jsp");
			Dispatch.include(request, response);
    
    }

}
