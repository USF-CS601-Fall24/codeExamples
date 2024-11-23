package practiceMidterm2.solution;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LanguagePreferenceServlet extends HttpServlet {
    private static final Map<String, String> greetings = Map.of(
            "English", "Welcome!",
            "Spanish", "¡Bienvenido!",
            "French", "Bienvenue!",
            "Turkish", "Hoşgeldiniz!"
    );

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String language = request.getParameter("language");
        if (language == null || !greetings.containsKey(language))
            language = "English"; // default language

        out.println("<html><body>");
        out.println("<h1>" + greetings.get(language) + "</h1>");
        out.println("<form method='GET' action='/language'>"); // the form will be sent via GET request, processed by the same servlet
        out.println("Enter language: <input type='text' name='language'><br>");
        out.println("<input type='submit'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}