import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "/index", urlPatterns = {"/index"})
public class stpToken extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("abc") && password.equals("abc"))
        {
            String token = UUID.randomUUID().toString();
            Cookie cookie = new Cookie("Cookie",username);
            cookie.setPath("localhost/Assignment1");
            cookie.setDomain("localhost");
            response.addCookie(cookie);
            HttpSession session = request.getSession(true);
            session.setAttribute("token", token);
            response.sendRedirect("stpform.jsp");
        }
        else {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
