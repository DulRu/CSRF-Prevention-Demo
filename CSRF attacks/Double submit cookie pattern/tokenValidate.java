import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebServlet(name = "tokenvValidate", urlPatterns = {"/tokenValidate"})
public class tokenValidate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = null;
        Cookie[] cookies = null;
        cookies = request.getCookies();
        String scheme=request.getScheme();
        String token = request.getParameter("token");
        if(scheme.equals("http")) {
            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    cookie = cookies[i];
                    if (cookie.getValue().equals(token)) {
                          response.sendRedirect("next.jsp");
                    }
                }
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
