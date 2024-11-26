package javascript;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class StudentDBServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
		response.setStatus(HttpServletResponse.SC_OK);
		String query = request.getParameter("q"); // the name of the student for which to get GPA
		System.out.println(query);
		DatabaseHandler test = DatabaseHandler.getInstance();
		// connect to the database and get student info
		String res = test.getStudentInfo(query);
		System.out.println(res);

		// send student info to the client
		PrintWriter out = response.getWriter();
		out.println(res);
	}

}