package iuh.fit.lamlaituan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/dangNhapCau5Servlet")
public class DangNhapCau5Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session= req.getSession();

        String userName= req.getParameter("tendn");
        String pw= req.getParameter("mk");

//        session.setAttribute("user",userName);
//        session.setAttribute("password",pw);

        if(userName.equalsIgnoreCase("admin")&&pw.equalsIgnoreCase("pw")){
            session.setAttribute("user",userName);

            resp.sendRedirect(req.getContextPath()+"/home.jsp");
        }
        else{
            req.setAttribute("loi","Sai tài khoản hoặc mật khẩu");
            req.getRequestDispatcher("/DangNhapCau5.jsp").forward(req,resp);
        }

    }
}
