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
		String name=request.getParameter("username");
		String pass =request.getParameter("userpass");
		String p2=request.getParameter("userpass2");

		out.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		
		out.println("<div class = \"whitebold\"> ");
		if (pass.equals(p2))
		{
			if(CreateUserDAO.isUniqueUsername(name))
			{
				CreateUserDAO.newUser(name, pass);
				out.println("Account Created! Use those credentials to log in.");
				out.println("</div>");
				RequestDispatcher rd=request.getRequestDispatcher("index.html");
				rd.include(request,response);
			}
			else{
				out.println("<br><br>");
				out.println("<h2>This username is already in use. Try again!</h2>");
				out.println("</div>");
				RequestDispatcher rd=request.getRequestDispatcher("createaccount.html");
				rd.include(request,response);
			}
		}
		else 
		{
			out.println("<br><br>");
			out.println("<h2>Your two password entries don't match. Try again!</h2>");
			out.println("</div>");
			RequestDispatcher rd=request.getRequestDispatcher("createaccount.html");
			rd.include(request,response);
		}
		
		
		
		
		//CreateUserDAO.writeUserToTable();
		//out.println("writeUserToTable() was just called.");
		

		
		
		
		out.close();
	}

}
