import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T14DAOs.CreateEntreeDAO;
import T14DAOs.CreateUserDAO;


public class NewEntreeServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String n=request.getParameter("name");
		String c=request.getParameter("category");
		float ra= Float.parseFloat(request.getParameter("rating"));
		String re=request.getParameter("restaurant");
		float p = Float.parseFloat(request.getParameter("price"));

		
		CreateEntreeDAO.newEntree(n, c, ra, re, p);
		
		writer.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		writer.println("<div class=\"whitebold\">");
		writer.println("Your new entree, "+n+", has been uploaded for admin review!\n");
		writer.println("</div>");
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		rd.include(request,response);
		
		
		writer.close();
	}

}
