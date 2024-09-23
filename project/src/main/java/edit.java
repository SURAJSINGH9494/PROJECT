

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.dao;

import com.pojo.pojo;


@WebServlet("/edit")
public class edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public edit() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		String sid=request.getParameter("rid");
		int id=Integer.parseInt(sid);
		
		pojo e=dao.getdatafetchbyid(id);
		
		out.print("<form action='edit1'>");
		out.print("<table>");
		out.print("<tr><td></td><td><input type='hidden' name='rid' value='"+e.getRid()+"'/></td></tr>");
		out.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+e.getName()+"'/></td></tr>");
		out.print("<tr><td>Password:</td><td><input type='password' name='password' value='"+e.getPassword()+"'/></td></tr>");
		out.print("<tr><td>Email:</td><td><input type='email' name='email' value='"+e.getEmail()+"'/></td></tr>");
		
		out.print("<tr><td colspan='2'><input type='submit' value='Edit'/></td></tr>");
		out.print("</table>");
		out.print("</form>");
		
		out.close();
	}

	

}
