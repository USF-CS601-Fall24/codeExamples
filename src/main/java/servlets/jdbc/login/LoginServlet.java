package servlets.jdbc.login;

import org.apache.commons.text.StringEscapeUtils;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Modified from the example of Prof. Engle
 */
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// FILL IN CODE: add session management - once the user logs in, you can store username in a cookie, for instance
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		username = StringEscapeUtils.escapeHtml4(username);

		if (request.getParameter("username") == null) {
			out.println("Please login below.</p>");
			System.out.println();
			response.setContentType("text/html");
			response.setStatus(HttpServletResponse.SC_OK);
			out.printf("<html>%n%n");
			out.printf("<head><title>%s</title></head>%n", "Form");
			out.printf("<body>%n");

			printForm(request, response);

			out.printf("%n</body>%n");
			out.printf("</html>%n");
		}
		else  {
			// already logged in
			out.println("Login successful. Welcome, " + username);
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String user = request.getParameter("username");
		String pass = request.getParameter("pass");
		System.out.println(user);

		DatabaseHandler dbHandler = DatabaseHandler.getInstance();
		boolean flag = dbHandler.authenticateUser(user, pass);
		if (flag) {
			response.sendRedirect("/login?username=" + user);
		}
		else
			response.sendRedirect("/login");

	}

	private static void printForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
		PrintWriter out = response.getWriter();

		out.printf("<form method=\"post\" action=\"%s\">%n", request.getServletPath());
		out.printf("Enter your username:<br><input type=\"text\" name=\"username\"><br>");
		out.printf("Enter your password:<br><input type=\"password\" name=\"pass\"><br>");
		out.printf("<p><input type=\"submit\" value=\"Enter\"></p>\n%n");
		out.printf("</form>\n%n");
	}
}