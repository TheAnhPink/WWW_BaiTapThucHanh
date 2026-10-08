package iuh.fit.lamlaituan1;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter("/secure/*")
public class AuthFilterBai5 implements Filter{

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp= (HttpServletResponse) response;
        HttpSession session= req.getSession(false);

        boolean dangNhap= session!=null&& session.getAttribute("user")!=null;

        if(dangNhap) chain.doFilter(req,resp);
        else resp.sendRedirect(req.getContextPath()+ "/DangNhapCau5.jsp");

    }
}
