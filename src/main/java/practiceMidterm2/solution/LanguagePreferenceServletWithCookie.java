package practiceMidterm2.solution;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

public class LanguagePreferenceServletWithCookie extends HttpServlet {
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
        if (language == null || !greetings.containsKey(language)) {
            // Check if it is in the cookie:
            Cookie[] cookies = request.getCookies();
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals("language")) {
                        language = cookie.getValue();
                        break;
                    }
                }
            }
        }
        if (language == null || !greetings.containsKey(language)) // was not in the form or invalid, and did not find in the cookie
            language = "English";

        out.println("<html><body>");
        out.println("<h1>" + greetings.get(language) + "</h1>");
        out.println("<form method='GET' action='/language'>");
        out.println("Enter language: <input type='text' name='language'><br>");
        out.println("<input type='submit'>");
        out.println("</form>");
        out.println("</body></html>");

        response.addCookie(new Cookie("language", language));
    }
}