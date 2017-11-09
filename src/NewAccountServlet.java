import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import T14DAOs.CreateUserDAO;
import T14DAOs.SQLCallDAO;

import java.util.Date;


public class NewAccountServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String n=request.getParameter("username");
		String p=request.getParameter("userpass");
		String p2=request.getParameter("userpass2");
		out.println("Your attempted username: "+n+"\n");
		out.println("Your attempted password: "+p+"\n");
		out.println("Your attempted password repeat: "+p2+"\n");
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
	    out.println("newUser(n, p) was just called.");
		
		RequestDispatcher rd=request.getRequestDispatcher("createaccount.html");
		rd.include(request,response);
		
		
		out.close();
	}

}
