import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T14DAOs.ChangeEntreeDAO;
import T14DAOs.LoginDao;
import T14DAOs.PullEntreeInfoDAO;



public class AdminActionServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int actionVal=Integer.parseInt(request.getParameter("actionval"));
		int entreeNum=Integer.parseInt(request.getParameter("entreeNum"));

		out.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		out.println("<body class = \"centerText mainbg\">");
		out.println("<div class = \"whitebolder\">");
		
		
		out.println("Regarding entree number: "+entreeNum+", listed as "+PullEntreeInfoDAO.getName(entreeNum));
		out.println("<br><br><br>");
		if (actionVal==1)
		{
			ChangeEntreeDAO.clearFlag(entreeNum);
			out.println("The flag on item number "+entreeNum+" has been cleared!<br>");
			out.println("</div>");
			
			RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
			rd.include(request,response);
		}
		
		if (actionVal==2)
		{
			  out.println("</div>");
			  out.println("<form action=\"confirmdelete\" method=\"post\">");
			  out.println("<td><center><input type=\"submit\" value=\"Confirm you want to delete this entree\"/></center></td>");
			  out.println("<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+" />");
			  out.println("</form>");
		}
		
		
	
		
		
		
		//out.close();
	}

}
