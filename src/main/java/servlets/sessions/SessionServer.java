package servlets.sessions;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 * Demonstrates how to use the HttpSession class to keep track of the number of visits for each client 
 * (and the date of the last visit).
 * Modified from the example of Prof. Rollins.
 *
 */
public class SessionServer {
	public final static int PORT = 8081;
	public static void main(String[] args)  {
		Server server = new Server(PORT);
		
        ServletContextHandler servHandler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        servHandler.addServlet(SessionServlet.class, "/session");
        server.setHandler(servHandler);

		try {
			server.start();
			server.join();
		}
		catch (Exception e) {
			System.out.println(e);
		}
	}
}