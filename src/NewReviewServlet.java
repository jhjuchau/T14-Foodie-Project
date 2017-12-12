import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import T14DAOs.CreateReviewDAO;




public class NewReviewServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		int entreeNum=Integer.parseInt(request.getParameter("entreeNum"));
		float count= Float.parseFloat(request.getParameter("starcount"));
		String text=request.getParameter("review");
		//int attentionFlag=Integer.parseInt(request.getParameter("AttentionFlag"));
		
		
		HttpSession session = request.getSession();
		int userNum = (int) session.getAttribute("usernum");
		
		//CreateReviewDAO.newReview(String text, int entreeNum, int userNum, float rating)
		CreateReviewDAO.newReview(text, entreeNum, userNum , count);
		
		out.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		
		out.println("<div class = \"whitebold\"> ");
	    out.println("Review successfully created!");
	    out.println("</div>");
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		rd.include(request,response);
		
		
		out.close();
	}

}
