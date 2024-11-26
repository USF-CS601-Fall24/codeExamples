package javascript;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

/** AJAX example. ajaxEx.html file has javascript code that makes AJAX calls to the CounterServlet */
public class StudentDBServer {

	public static void main(String[] args) {

		// Example modified from Prof. Rollins' example

		Server server = new Server(8080);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);

		// for the ajaxDBDemo example
		handler.addServlet(StudentDBServlet.class, "/students");

		ResourceHandler resourceHandler = new ResourceHandler(); // a handler for serving static files
		resourceHandler.setDirectoriesListed(true);
		resourceHandler.setResourceBase("static");

		HandlerList handlers = new HandlerList();
		handlers.setHandlers(new Handler[] { resourceHandler, handler });
		server.setHandler(handlers);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			System.out.println("Exception occurred while running the server: " + e);
		}

	}

}
