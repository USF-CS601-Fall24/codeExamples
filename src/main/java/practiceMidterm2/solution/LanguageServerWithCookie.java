package practiceMidterm2.solution;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class LanguageServerWithCookie {

	public static void main(String[] args) {
		Server server = new Server(8080);
		ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
		handler.addServlet(LanguagePreferenceServletWithCookie.class, "/language");
		server.setHandler(handler);

		try {
			server.start();
			server.join();
		} catch (Exception e) {
			System.out.println("Exception occurred while running the server: " + e);
		}

	}

}
