package servlets.cookies;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/**
 Responsible for clearing cookies from NumVisitsTrackingServer.
 Based on the example of Prof. Engle.
 */
@SuppressWarnings("serial")
public class ClearCookiesServlet extends HttpServlet {

	@Override
	protected void doGet(
			HttpServletRequest request,
			HttpServletResponse response)
			throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("numVisits")) {
					cookie.setValue(null);
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
		}

		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML>");
		out.println("<html><head>");
		out.println("<title> Clearing the cookie that tracks the number of visits. </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<p>Cleared cookies.</p>");
		out.println("</body>");
		out.println("</html>");
		out.println();
		out.flush();
	}


}