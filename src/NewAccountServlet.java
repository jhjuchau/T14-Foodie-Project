import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T14DAOs.CreateUserDAO;



public class NewAccountServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n=request.getParameter("username");
		String p =request.getParameter("userpass");
		String p2=request.getParameter("userpass2");

	
		if (p.equals(p2))
		{
			CreateUserDAO.newUser(n, p);
			out.println("Account Created! Use those credentials to log in.");
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request,response);
		}
		else 
		{
			RequestDispatcher rd=request.getRequestDispatcher("createaccount.html");
			rd.include(request,response);
			out.println("<br><br>");
			out.println("<h2>Your two password entries don't match. Try again!</h2>");
		}
		
		//CreateUserDAO.writeUserToTable();
		//out.println("writeUserToTable() was just called.");
		

		
		
		
		out.close();
	}

}
