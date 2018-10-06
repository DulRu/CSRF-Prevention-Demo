import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "/tokenvalidate", urlPatterns = {"/tokenvalidate"})
public class tokenvalidate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String scheme=request.getScheme();
        String method=request.getMethod();
        if(scheme.equals("http") && method.equals("POST"))
        {
          HttpSession session = request.getSession();
          String storedToken = (String)session.getAttribute("token");
          String token = request.getParameter("token");
          if (storedToken.equals(token))
          {
            response.sendRedirect("next.jsp");
          }
          else {
              response.sendRedirect("stpform.jsp");

          }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
