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



public class AdminReviewServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		int	entreeNum = Integer.parseInt(request.getParameter("entreeNum"));
		int attentionFlag = PullEntreeInfoDAO.getAttentionFlag(entreeNum);
		
		String entreeName = PullEntreeInfoDAO.getName(entreeNum);
		
		writer.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		
		writer.println("<body class=\"centerText mainbg\">"+
					"<div class = \"whitebold\"> "+
				
					"<form action=\"adminaction\" method=\"post\"><br><br>"	//form open to adminAction
					
					
					+ "<h3>Item in question: "+entreeName+", which is entree number: "+entreeNum+"</h3><br><br>"+
					"<h2>Attention flag value: "+attentionFlag+"</h2>"+
				    "<input type=\"hidden\" name=\"entreeNum\" value="+entreeNum+">");
		
					writer.println("For reference, <br>0=no action necessary, <br>1=new entree in need of approval, <br>2=recently altered recipe<br></div>");
		
				   if(attentionFlag!=0){ 
					   
					   writer.println("<select name=\"actionval\">"+
				    	"<div class=\"green\"><option value=1>Clear the flag and allow users to post reviews.</option></div>"+
				    	"<option value=2>Delete the item in question</option>"+
				    	"</select>"+
							   "<br /> <input type=\"submit\" value=\"Perform action\" />");}
				   else{
					   writer.println("<div class = \"whitebolder\"> No action needs to be taken for this item.</div>");
					   writer.println("<input type=\"hidden\" name=\"actionval\" value=2>");
					   writer.println("<input type=\"submit\" value=\"Delete this item\">");
					   
				   }
		
				    writer.println("</form><br><br>");						//form close to adminAction

			RequestDispatcher rd=request.getRequestDispatcher("entree.html");
			rd.include(request,response);
			
			
			writer.close();
			
			 

		//out.close();
	}

}
