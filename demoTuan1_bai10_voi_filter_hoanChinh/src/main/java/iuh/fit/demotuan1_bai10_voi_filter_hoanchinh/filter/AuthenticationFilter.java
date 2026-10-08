package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.filter;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;

@WebFilter(urlPatterns = {"/products", "/ctar/*"})
public class AuthenticationFilter implements Filter {
    @Inject
    private UserSession userSession;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req= (HttpServletRequest) request;
        HttpServletResponse resp= (HttpServletResponse) response;

        if(userSession.kiemTraDangNhap()){
            chain.doFilter(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+ File.separator+"/login");
        }
    }
}
