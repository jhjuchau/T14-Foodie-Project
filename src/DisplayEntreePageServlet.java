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

import T14DAOs.LoginDao;
import T14DAOs.PullEntreeReviewsDAO;



public class DisplayEntreePageServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		int	entreeNum = Integer.parseInt(request.getParameter("entreeNum"));

		writer.println("The entree number from the previous page is "+entreeNum);
		
		ResultSet result = PullEntreeReviewsDAO.listReviews(entreeNum);
		String entreeName = PullEntreeReviewsDAO.singleEntreeInfo(entreeNum);
		
		writer.println("Reviews on "+entreeName);
		writer.println("<table BORDER=2 CELLPADDING=1 CELLSPACING=1 WIDTH=75%>"
	              +"<tr><th>Entree Name</th><th>Rating</th><th>Review</th></tr>");
		
		try {
			
			while(result.next()){
				
			//writer.println("<form action=\"entreepage\" method=\"post\">");
				
			  writer.println("<tr><td><center>"+result.getString("aboutEntree")+"</center></td>" +
					  			"<td><center>"+result.getString("Rating")+"</center></td>"
					  		+		"<td><center>"+result.getString("ReviewText")+"</center></td></tr>");
			  
			  writer.println("</form>");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		writer.println("</table>");
			
			RequestDispatcher rd=request.getRequestDispatcher("entree.html");
			rd.include(request,response);
			
			
			writer.close();
			
			 

		//out.close();
	}

}
