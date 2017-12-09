import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T14DAOs.PullEntreeNameDAO;
import T14DAOs.PullEntreeReviewsDAO;



public class LeaveReviewServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		int	entreeNum = Integer.parseInt(request.getParameter("entreeNum"));
		
		String entreeName = PullEntreeNameDAO.getName(entreeNum);
		
		writer.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		
		writer.println("<body class=\"centerText bg\">"+
					"<form action=\"newreview\" method=\"post\"><br><br>"
					+ "<h3>Leave a review on "+entreeName+", which is entree number: "+entreeNum+"</h3><br><br>"+
				    "<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+">"+
				    "<select name=\"starcount\">"+
				    	"<option value=\"1\">1/5</option>"+
				    	"<option value=\"2\">2/5</option>"+
				    	"<option value=\"3\">3/5</option>"+
				    	"<option value=\"4\">4/5</option>"+
				    	"<option value=\"5\">5/5</option>"+
				    "</select>"+
				    
					"<br><br> Leave your Review:"+
					"<br /> <textarea rows=\"4\" cols=\"50\" name =\"review\" placeholder=\"(Enter review here)\"></textarea>"+
				    "<br /> <input type=\"submit\" value=\"Submit review!\" /></form>");


writer.println("<form action=\"mainpage.html\">"+
    "<input type=\"submit\" value=\"Return to main page\" />"+
		"</form></body>");

			RequestDispatcher rd=request.getRequestDispatcher("entree.html");
			rd.include(request,response);
			
			
			writer.close();
			
			 

		//out.close();
	}

}
