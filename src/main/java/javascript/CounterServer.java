package javascript;

import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.HandlerList;
import org.eclipse.jetty.server.handler.ResourceHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;

/** AJAX example. counterAjax.html file has javascript code that makes AJAX calls to the CounterServlet */
public class CounterServer {

	public static void main(String[] args) {
		Server server = new Server(8080);

		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(CounterServlet.class, "/counter");

		ResourceHandler resourceHandler = new ResourceHandler(); // a handler for serving static pages
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
