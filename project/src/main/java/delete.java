

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.dao.dao;


@WebServlet("/delete")
public class delete extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public delete() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sid=request.getParameter("rid");
		int id=Integer.parseInt(sid);
		dao.datadelete(id);
		response.sendRedirect("view");	
	}

	

}
