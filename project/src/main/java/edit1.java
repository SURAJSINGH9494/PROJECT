

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.dao;
import com.pojo.pojo;


@WebServlet("/edit1")
public class edit1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public edit1() {
        super();
      
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
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
	   
	if(status>0){
		response.sendRedirect("view");
	}else{
		out.println("not updated");
	}
	
	}

	
	
}
