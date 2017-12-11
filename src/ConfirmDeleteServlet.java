import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T14DAOs.ChangeEntreeDAO;


public class ConfirmDeleteServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		int entreeNum=Integer.parseInt(request.getParameter("entreeNum"));

		ChangeEntreeDAO.deleteEntree(entreeNum);
		ChangeEntreeDAO.deleteAssociatedReviews(entreeNum);
		
		out.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		out.println("<div class = \"whitebolder\">");
		out.println("Item number "+entreeNum+" has been deleted.<br>");
		out.println("All reviews associated with item number "+entreeNum+" have also been deleted.<br>");
		out.println("</div>");
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		rd.include(request,response);
		
	}

}
