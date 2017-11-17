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

	
		/*p=p2;
		if (p==p)
		{
			out.print("Your two password entries match!");
		}
		else {out.println("According to Java, your two password entries do NOT match, even if they actually do. I'll figure this out later");}
		 */
		
		//CreateUserDAO.writeUserToTable();
		//out.println("writeUserToTable() was just called.");
		
		CreateUserDAO.newUser(n, p);
		
		out.println("Account Created! Use those credentials to log in.");
		
		RequestDispatcher rd=request.getRequestDispatcher("index.html");
		rd.include(request,response);
		
		
		
		out.close();
	}

}
