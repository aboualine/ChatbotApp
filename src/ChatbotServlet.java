import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ChatbotServlet")
public class ChatbotServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Simple chatbot responses
    private static final Map<String, String> responses = new HashMap<>();

    static {
        responses.put("hello", "Hi! How can I assist you?");
        responses.put("how are you", "I'm just a chatbot, but I'm doing great!");
        responses.put("what is your name", "I'm your simple chatbot.");
        responses.put("bye", "Goodbye! Have a great day.");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        String userMessage = request.getParameter("message").toLowerCase();
        String botReply = responses.getOrDefault(userMessage, "Sorry, I don't understand.");

        response.setContentType("text/plain");
        response.getWriter().write(botReply);
    }
}
