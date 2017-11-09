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
		PrintWriter out = response.getWriter();
		String n=request.getParameter("name");
		String c=request.getParameter("category");
		float ra= Float.parseFloat(request.getParameter("rating"));
		String re=request.getParameter("restaurant");
		float p = Float.parseFloat(request.getParameter("price"));
		out.println("Your attempted entree name: "+n+"\n");
		out.println("Your attempted category: "+c+"\n");
		out.println("Your attempted rating: "+ra+"\n");
		out.println("Your attempted restaurant: "+re+"\n");
		out.println("Your attempted price: "+p+"\n");
		

		
		/*p=p2;
		if (p==p)
		{
			out.print("Your two password entries match!");
		}
		else {out.println("According to Java, your two password entries do NOT match, even if they actually do. I'll figure this out later");}
		 */
		
		//CreateUserDAO.writeUserToTable();
		//out.println("writeUserToTable() was just called.");
		
		CreateEntreeDAO.newEntree(n, c, ra, re, p);
	    out.println("newEntree() was just called.");
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		rd.include(request,response);
		
		
		out.close();
	}

}
