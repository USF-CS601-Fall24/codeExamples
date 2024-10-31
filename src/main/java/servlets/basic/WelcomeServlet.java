package servlets.basic;

import org.apache.commons.text.StringEscapeUtils;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** An example that demonstrates how to process HTML forms with servlets. 
 *  Part of the example that also includes HtmlFormServer and HtmlFormServlet.
 */

@SuppressWarnings("serial")
public class WelcomeServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<head><title>Form</title></head>");
		String name = request.getParameter("name");
		System.out.println(name);
		name =  StringEscapeUtils.escapeHtml4(name); // escape special characters
		System.out.println(name);
		out.println("<body>");
		
		// Displays Hello and the name of the person
		out.println("<h1>Hello, " + name + "</h1>" );
		out.println("</body>");
		out.println("</html>");

		// Referencing Prof. Engle
		// If we did not call escapeHtml4 to "clean" the input,
		// our site would be prone to cross-site scripting attacks (XSS attacks)
		// You can comment out this line: name = StringEscapeUtils.escapeHtml4(name);
		// and uncomment the line below to disable security feature in the browser
		// response.setIntHeader("X-XSS-Protection", 0);
		// Then in the browser, try specifying the text below instead of the name:
		// ?name=<script>window.open("http://www.usfca.edu/");</script>
		// Did you see what happened? This script opened another page with usfca.edu website!

		response.setStatus(HttpServletResponse.SC_OK);
	}


}
