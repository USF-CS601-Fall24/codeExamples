package servlets.formProcessing;

import org.apache.commons.text.StringEscapeUtils;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/** Example courtesy of Prof. Rollins */

public class EchoServlet extends HttpServlet {

	/** The method that displays an HTML form. When we create the form, we specify that it will be
	 * processed by a doPost method of the servlet mapped to /echo (which in this example is EchoServlet) */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		//When HTTP GET response is sent to /echo this method is going to get invoked
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter out = response.getWriter();
		out.println("<html><title>EchoServlet</title><body>");
		out.println("<form action=\"echo\" method=\"post\">");
		out.println("Message: <br/>");
		
		// notice that the message will be stored in the parameter "usermsg"
		out.println("<input type=\"text\" name=\"usermsg\"><br/>"); 
		
		out.println("<input type=\"submit\" value=\"Submit\"></form>");		
		
		out.println("</body></html>");	
	}
	
	/** The method that will process the form once it's submitted */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// Will be invoked when the form is submitted (we send a POST request to /echo)
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
		
		PrintWriter out = response.getWriter();

		String msg = request.getParameter("usermsg");
		msg = StringEscapeUtils.escapeHtml4(msg); // "clean up" whatever the user typed

		out.println("<html><title>EchoServlet</title><body>You said: " + msg + "</body></html>");

	}
	
}