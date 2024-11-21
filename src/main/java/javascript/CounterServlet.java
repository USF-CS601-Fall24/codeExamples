package javascript;

import com.google.gson.JsonObject;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

public class CounterServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 1;
		} else {
			count = count + 1;
		}
		//System.out.println("count = " + count);
		session.setAttribute("count", count);

		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();
		// returns a json object
		JsonObject obj = new JsonObject();
		obj.addProperty("message", "A message from the server: I am waiting for you to fill out the form: " + count);
		out.println(obj);
		//System.out.println(obj);
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		//System.out.println("In Post method");
		session.setAttribute("count", null);
		session.invalidate();
		
		response.setStatus(HttpServletResponse.SC_OK);

		PrintWriter out = response.getWriter();
		// returns a json object
		
		out.println("Thank you for submitting the form!"); 
	} 

}