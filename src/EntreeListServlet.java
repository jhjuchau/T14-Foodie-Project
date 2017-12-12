import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T14DAOs.CreateUserDAO;
import T14DAOs.EntreeListDAO;
import T14DAOs.LoginDao;
import T14DAOs.PullEntreeInfoDAO;



public class EntreeListServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		String criteria=request.getParameter("criteria");
		String searchTerm=request.getParameter("searchTerm");
		
		//later, when search results are displayed
		HttpSession session = request.getSession();
        int adminStatus = (int) session.getAttribute("adminstatus");
        
        writer.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		writer.println("<body class = \"blackbold tableformat resultsbg\">");

				
		ResultSet result = EntreeListDAO.listEntrees(criteria, searchTerm);
		
			try {
			if (result.next())
			{
				result.previous();
		writer.println("<table class=\"centerText\" BORDER=2 CELLPADDING=1 CELLSPACING=1 WIDTH=75%>"
	              +"<tr><th>Entree Name</th><th>Restaurant</th><th>Average Rating</th>"
	              + "<th>Entree Category</th><th>View Item Reviews</th><th>Leave a Review on this Entree</th>");
		
		if (adminStatus==1){
			writer.println("<th>Admin Review</th>");
		}

		
		writer.println("</tr>");
		while(result.next()){
			int entreeNum = result.getInt("EntreeNum");
			int attentionFlag = PullEntreeInfoDAO.getAttentionFlag(entreeNum);
			
			
			//etc etc etc
		  writer.println("<tr><td><center>"+result.getString("EntreeName")+"</center></td>" +
				  			"<td><center>"+result.getString("Restaurant")+"</center></td>"
				  		+		"<td><center>"+result.getString("AverageRating")+"</center></td>"
				  		  		+	"<td><center>"+result.getString("EntreeCategory")+"</center></td>");
		  //etc etc etc 
		      
		  if(attentionFlag!=0){
			  if (adminStatus==1){
				  writer.println("<td><center>This item needs admin attention.</center></td>");
				  writer.println("<td><center>This item needs admin attention.</center></td>");
			  }
			  else
			  {
				  writer.println("<td><center>This item hasn't been approved by administrators yet.</center></td>");
				  writer.println("<td><center>This item hasn't been approved by administrators yet.</center></td>");
			  }
		  }
		  
		  else{
		  writer.println("<form action=\"entreepage\" method=\"post\">");
		  writer.println("<td><center><input type=\"submit\" value=\"Read reviews for this entree!\"/></center></td>");
		  writer.println("<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+" />");
		  writer.println("</form>");
		  
		  writer.println("<form action=\"leavereview\" method=\"post\">");
		  writer.println("<td><center><input type=\"submit\" value=\"Write a review for this item!\"/></center></td>");
		  writer.println("<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+" />");
		  writer.println("</form>");
		  
		}
		  
		  //on the search results table
		  if (adminStatus==1){
			  writer.println("<form action=\"adminreview\" method=\"post\">");
			  writer.println("<td><center><input type=\"submit\" value=\"Perform admin review for this item\"/></center></td>");
			  writer.println("<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+" />");
			  writer.println("</form>");
			}
		  
		  writer.println("</tr>");
		  writer.println("</div>");
		}
	} 
			else
			{
				writer.println("</div>");
				writer.println("<div class = \"centerText\"><h3>No results found for that search... </h3></div>");
			}
				
		}catch (SQLException e) {
			
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	writer.println("</table>");

	
	//writer.println("<input type=\"submit\" value=\"Leave your own review!\"/>");
	//writer.println("<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+" />");
		
		RequestDispatcher rd=request.getRequestDispatcher("entreelist.html");
		rd.include(request,response);
		
		
		writer.close();
		
		 
		 
	}

}
