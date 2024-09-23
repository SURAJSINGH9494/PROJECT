

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.dao;

import com.pojo.pojo;


@WebServlet("/view")
public class view extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public view() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
	
		
		List<pojo> list=dao.getalldata();
		
		out.print("<table border='1' width='100%'");
		out.print("<tr><th>Id</th><th>Name</th><th>Password</th><th>Email</th><th>Edit</th><th>Delete</th></tr>");
		for(pojo e:list){
			out.print("<tr><td>"+e.getRid()+"</td><td>"+e.getName()+"</td><td>"+e.getPassword()+"</td><td>"+e.getEmail()+"</td><td><a href='edit?rid="+e.getRid()+"'>edit</a></td><td><a href='delete?rid="+e.getRid()+"'>delete</a></td></tr>");
		}
		out.print("</table>");
		
		out.close();
		
		
		
	}

	
	


	

}
