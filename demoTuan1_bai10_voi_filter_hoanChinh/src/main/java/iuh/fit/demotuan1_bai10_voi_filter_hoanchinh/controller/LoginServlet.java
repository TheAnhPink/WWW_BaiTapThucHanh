package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.controller;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service.AuthenticationService;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebServlet("/login")

public class LoginServlet extends HttpServlet {
    @Inject
    private UserSession userSession;
    @Inject
    private AuthenticationService authenticationService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(!userSession.kiemTraDangNhap()){
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/products");
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String un= req.getParameter("un");
        String pw= req.getParameter("pw");

        boolean dn=authenticationService.dangNhap(un,pw);
        if(dn){
            userSession.login(un);
            resp.sendRedirect(req.getContextPath()+"/products");
        }else{
            req.setAttribute("loi","Sai tên đăng nhập hoặc mật khẩu");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req,resp);
        }
    }
}
