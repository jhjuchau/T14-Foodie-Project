import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;


public class LoggedInServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n=request.getParameter("username");
		
		out.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		out.println("<div class = \"whitebolder\">");
		out.print("<h1>Welcome, "+n+"!</h1>");
		out.print("</div>");
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		
		rd.include(request,response);
		
		
		out.close();
	}

}
