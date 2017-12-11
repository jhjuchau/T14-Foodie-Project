import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.Date;


public class PullSessionInfoServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
        String user = (String)session.getAttribute("user");
        int adminStatus = (int) session.getAttribute("adminstatus");
        int userNum = (int) session.getAttribute("usernum");
        out.println("<head><link rel=\"import\" href=\"header.html\"></head>");
		out.println("<div class = \"whitebolder\">");
        //else{session.setAttribute("adminstatus", 0);}
        //session.setAttribute("adminstatus", 1);
        
        
        out.println("Welcome to Foodie, "+user+"!   \n");
        out.println("Your account has");
        if (adminStatus!=1){out.println(" NO ");}
        out.println("administrator privileges.\n");
        out.println("Your unique user number is "+userNum);
        out.println("</div>");
        
		
		RequestDispatcher rd=request.getRequestDispatcher("mainpage.html");
		rd.include(request,response);
		out.close();
	}

}
