package servlets.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;


/**
 * Demonstrates how to use cookies to track the number of user's visits to the website.
 * Modified from the example of Prof. Engle.
 */
public class NumVisitsTrackingServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getRequestURI().endsWith("favicon.ico")) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND);
			return;
		}

		response.setStatus(HttpServletResponse.SC_OK);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html><head>");
		out.println("<title> Tracking number of visits</title>");
		out.println("</head>");
		out.println("<body>");
		Cookie[] cookies = request.getCookies();
		String count = null;
		for (Cookie cookie: cookies) {
			if (cookie.getName().equals("numVisits")) {
				count = cookie.getValue();
				count = Integer.toString(Integer.parseInt(count) + 1);
				break;
			}
		}
		if (count == null) {
			count = "1";
		}
		out.println("<p>You have visited this website " + count + " times. </p>");

		// Does browser allow tracking?
		if (request.getIntHeader("DNT") != 1) { // ok to track
			response.addCookie(new Cookie("numVisits", count));
		}
		else {
			//clearCookies(request, response);
			out.println("<p>Your visits will not be tracked since your browser does not allow it.</p>");
		}
		out.println("</body>");
		out.println("</html>");
		out.flush();
		//response.flushBuffer();
	}
}