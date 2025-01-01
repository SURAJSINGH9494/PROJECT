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

import com.model.productmodel;
import com.service.productservice;


@WebServlet("/productservlet")
public class productservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public productservlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String name 		  = request.getParameter("name");
		Double price 		  = Double.parseDouble(request.getParameter("price"));
		String descpriprtion  = request.getParameter("description");
		int categoriesId       = Integer.parseInt(request.getParameter("categoriesid"));
		
		Part filePart = request.getPart("image");
        
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
		
		
		productmodel m = new productmodel();
		m.setName(name);
		m.setPrice(price);
		m.setDescription(descpriprtion);
		m.setImage(imageBytes);
		m.setCategoryId(categoriesId);
		
		
		
		productservice.InsertProduct(m);
		response.sendRedirect("http://localhost:8080/ADMIN/dashboard.jsp");
	}

}


