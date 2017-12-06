import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T14DAOs.CreateUserDAO;
import T14DAOs.EntreeListDAO;
import T14DAOs.LoginDao;



public class EntreeListServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String criteria=request.getParameter("criteria");
		String searchTerm=request.getParameter("searchTerm");

		ResultSet result = EntreeListDAO.listEntrees(criteria, searchTerm);
		
		writer.println("<table BORDER=2 CELLPADDING=1 CELLSPACING=1 WIDTH=80%>"
	              +"<tr><th>Entree Name</th><th>Entree Category</th></tr>");

	try {
		while(result.next()){
		  writer.println("<tr><td><center>"+result.getString("EntreeName")+"</center></td>"
		               + "<td><center>"+result.getString("EntreeCategory")+"</center></td></tr>");
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	writer.println("</table>");
		
		RequestDispatcher rd=request.getRequestDispatcher("entreelist.html");
		rd.include(request,response);
		
		writer.println("4");
		writer.close();
		
		 
		 
	}

}
