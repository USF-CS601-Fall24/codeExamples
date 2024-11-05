package servlets.cookies;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;

/**
 * Demonstrates how to use cookies to track the number of user's visits to the website.
 * Modified from the example of Prof. Engle.
 */
public class NumVisitsTrackingServer {
	public final static int PORT = 8090;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();
		handler.addServletWithMapping(NumVisitsTrackingServlet.class, "/");
		handler.addServletWithMapping(ClearCookiesServlet.class, "/clear");

		server.setHandler(handler);
		server.start();
		server.join();
	}
}