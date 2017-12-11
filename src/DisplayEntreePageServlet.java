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
import T14DAOs.PullAuthorNameDAO;
import T14DAOs.PullEntreeInfoDAO;
import T14DAOs.PullEntreeReviewsDAO;



public class DisplayEntreePageServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		int	entreeNum = Integer.parseInt(request.getParameter("entreeNum"));

		
		ResultSet result = PullEntreeReviewsDAO.listReviews(entreeNum);
		String entreeName = PullEntreeInfoDAO.getName(entreeNum);
		
		
		writer.println("<h2>Reviews on "+entreeName+": </h2>");
		
		try {
		result.next();
		if (result.next())
	{
		result.previous();
		result.previous();
		writer.println("<table BORDER=2 CELLPADDING=1 CELLSPACING=1 WIDTH=75%>"
	              +"<tr><th>Posted by</th><th>Rating</th><th>Review</th></tr>");
		
			while(result.next()){
				int userNum = result.getInt("Author");
				String author = PullAuthorNameDAO.getName(userNum);
				
			//writer.println("<form action=\"entreepage\" method=\"post\">");
				
			  writer.println("<tr><td><center>"+author+"</center></td>"
					  	+	"<td><center>"+result.getString("Rating")+"</center></td>"
					  		+		"<td><center>"+result.getString("ReviewText")+"</center></td></tr>");
			  
			  writer.println("</form>");
			}
			writer.println("</table>");
		} 
		else
		{
			writer.println("<h3>No reviews currently posted... Be the first to review "+entreeName+"! </h3>");
		}
		
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		writer.println("<form action=\"leavereview\" method=\"post\">");
		writer.println("<br><input type=\"submit\" value=\"Leave your own review!\"/>");
		writer.println("<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+" />");
		writer.println("</form>");
		writer.println("</tr>");
			
			RequestDispatcher rd=request.getRequestDispatcher("entree.html");
			rd.include(request,response);
			
			
			writer.close();
			
			 

		//out.close();
	}

}
