package servlets.basic;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletHandler;
import org.eclipse.jetty.servlet.ServletHolder;

/**
 * A simple web server that sends the same response for each GET request (an
 * html page that says Hello, friends!)
 *
 */
public class SimpleHelloServer {

	public static final int PORT = 8080;

	public static void main(String[] args) throws Exception {
		Server server = new Server(PORT);

		ServletHandler handler = new ServletHandler();

		// when the user goes to http://localhost:8080/welcome, the get request is
		// going to go to a SimpleHelloServlet
		handler.addServletWithMapping(SimpleHelloServlet.class, "/hello"); // test by going to http://localhost:8080/hello
		// Alternative: use a ServletHolder
		// handler.addServletWithMapping(new ServletHolder(new SimpleHelloServlet()), "/hello");

		// handler.addServletWithMapping(WelcomeServlet.class, "/welcome"); // takes the name as a parameter for a custom greeting
		// test WelcomeServlet by typing the following in the browser
		// http://localhost:8080/welcome?name=Swetha


		server.setHandler(handler);

		server.start();
		server.join();
	}
}