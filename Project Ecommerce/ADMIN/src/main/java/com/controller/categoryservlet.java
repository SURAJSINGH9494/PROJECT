package com.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.model.categoriesmodel;
import com.service.categoryservice;


@WebServlet("/categoryservlet")
public class categoryservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public categoryservlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		
		
        Part filePart = request.getPart("label");
        
        // Read the image content into a byte array
        byte[] imageBytes = null;
        try (InputStream fileContent = filePart.getInputStream();
             ByteArrayOutputStream buffer = new ByteArrayOutputStream()) {
             
            byte[] temp = new byte[1024];
            int bytesRead;
            while ((bytesRead = fileContent.read(temp)) != -1) {
                buffer.write(temp, 0, bytesRead);
            }
            imageBytes = buffer.toByteArray();
        }
	
		categoriesmodel m = new categoriesmodel();
		m.setName(name);
		m.setDescription(description);
		m.setLabel(imageBytes);
		
		categoryservice.InsertCategory(m);
		response.sendRedirect("http://localhost:8080/ADMIN_ECOMMERCE/dashboard.jsp");
	}

}
