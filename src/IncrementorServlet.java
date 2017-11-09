

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class incrementor
 */

public class IncrementorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String n=request.getParameter("num");
		int value = Integer.parseInt(n);
		
		String jsonObject = "{myvalue:"+(value+1)+"}";
		response.setContentType("application/json"); //you say you'll return a json
		// Get the printwriter object from response to write the required json object to the output stream      
		PrintWriter out = response.getWriter();
		// Assuming your json object is **jsonObject**, perform the following, it will return your json object  
		out.print(jsonObject);
		out.flush();
		

	}

}


/*
<form>
<input type="submit" value="Question Paper" style="height:25px; width:120px; background-color: royalblue;color: white;" />
<input type="submit" value="Instruction" style="height:25px; width:120px; background-color: royalblue;color: white;" />
 </form>
 
 
 */