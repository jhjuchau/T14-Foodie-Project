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
		HttpSession session = request.getSession();
		int userNum = (int) session.getAttribute("usernum");
		
		
		CreateReviewDAO.newReview(text, entreeNum, userNum , count);
	    out.println("newReview() was just called.");
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		rd.include(request,response);
		
		
		out.close();
	}

}
