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

import T14DAOs.PullEntreeInfoDAO;
import T14DAOs.PullEntreeReviewsDAO;



public class LeaveReviewServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		int	entreeNum = Integer.parseInt(request.getParameter("entreeNum"));
		
		String entreeName = PullEntreeInfoDAO.getName(entreeNum);
		
		writer.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		
		writer.println("<body class=\"centerText mainbg\">"+
					"<form action=\"newreview\" method=\"post\"><br><br>"+
					"<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+">");
		
		writer.println("<div class = \"whitebold\" \"fontsizeup\"><h3>Leave a review on "+entreeName+"</h3></div><br><br>"+
					"<br>"+
				
				    "<div class = \"whitebold\">Rating: </div>"+
				    "<select name=\"starcount\">"+
				    	"<option value=\"1\">1/5</option>"+
				    	"<option value=\"2\">2/5</option>"+
				    	"<option value=\"3\">3/5</option>"+
				    	"<option value=\"4\">4/5</option>"+
				    	"<option value=\"5\">5/5</option>"+
				    "</select><br><br><br><br>");
				    
		writer.println("<div class = \"whitebold\">Check any that apply: "+ 
					  "<br><br>"+	
				
				      "<input type=\"radio\" id=\"contactChoice1\" name=\"AttentionFlag\" value=1>"+
				      "<label for=\"contactChoice1\">This item recently changed its recipe</label>"+
				      "<br><br>"+
				      
				      "<input type=\"radio\" id=\"contactChoice2\" name=\"AttentionFlag\" value=2>"+
				      "<label for=\"contactChoice2\">This item has been discontinued</label>"+
				      "<br><br>"+

				      "<input type=\"radio\" id=\"contactChoice3\" name=\"AttentionFlag\" value=3 checked>"+
				      "<label for=\"contactChoice3\">None of the above</label>"+
				      "<br><br>"+
				      
							"</div>"+
				    
					"<br><br> <div class = \"whitebold\">Leave your Review: </div>"+
					"<br /> <textarea rows=\"6\" cols=\"60\" name =\"review\" placeholder=\"(Enter review here)\"></textarea>"+
				    "<br /> <input type=\"submit\" value=\"Submit review!\" /></form>");


			writer.println("</body>");

			RequestDispatcher rd=request.getRequestDispatcher("entree.html");
			rd.include(request,response);
			
			
			writer.close();
			
			 

		//out.close();
	}

}
