import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "/dsToken", urlPatterns = {"/dsToken"})
public class dsToken extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(username.equals("abc") && password.equals("abc"))
        {
          Cookie cookie = new Cookie("cookie", username);
          cookie.setPath("localhost/Assignment1");
          cookie.setDomain("localhost");
          response.addCookie(cookie);
          String token = UUID.randomUUID().toString();
          Cookie dscookie = new Cookie("cookie", token);
          dscookie.setPath("localhost/Assignment1");
          dscookie.setDomain("localhost");
          response.addCookie(dscookie);
          request.setAttribute("token",token);
          request.getRequestDispatcher("dsform.jsp").forward(request, response);
          response.sendRedirect("dsform.jsp");
        }
        else {

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
