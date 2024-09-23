

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.dao;
import com.pojo.pojo;


@WebServlet("/insert")
public class insert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public insert() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		      response.setContentType("text/html");
		         
		      PrintWriter out= response.getWriter(); //data print 
		
		   String name = request.getParameter("name");
		   String email = request.getParameter("email");
		   String pass = request.getParameter("password");
		   
		   
		   pojo p= new pojo();
		   
		   p.setName(name);
		   p.setEmail(email);
		   p.setPassword(pass);
		   
		int status= dao.datainsert(p);
		   
		if(status > 0) {
			
			out.print("data inserted");
			request.getRequestDispatcher("index.jsp").include(request, response);
			
			// sendredirect - 
		}else {
			
			out.print("data not inserted");
		}
		   
		   // sendredirect  reqdispatcher -forward and include 
		   
		   
		   
		   
		   
		   
		   
		   
		   
		   
	}

	
	

}
