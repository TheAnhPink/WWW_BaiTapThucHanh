import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServletBai5 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String username = req.getParameter("tendn");
        String password = req.getParameter("matkhau");

        if (username.equals("admin") && password.equals("123")) {
            HttpSession session = req.getSession();
            session.setAttribute("user",username);
            resp.sendRedirect(req.getContextPath()+ "/home.jsp");
        } else {
            req.setAttribute("error","Sai tài khoản");
            req.getRequestDispatcher("/dangnhapBai5.jsp").forward(req,resp);
        }
    }
}