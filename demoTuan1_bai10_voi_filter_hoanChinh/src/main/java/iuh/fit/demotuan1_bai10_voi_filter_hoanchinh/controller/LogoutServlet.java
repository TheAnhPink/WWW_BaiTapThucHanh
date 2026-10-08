package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.controller;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    @Inject
    private UserSession userSession;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if(req.getSession(false)!=null){
            req.getSession(false).invalidate();
        }
        resp.sendRedirect(req.getContextPath()+"/login");
    }
}
