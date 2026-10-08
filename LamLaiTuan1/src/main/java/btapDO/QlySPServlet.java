package btapDO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/quan_ly_SP")
public class QlySPServlet extends HttpServlet {
    private static List<String> dsSP= new ArrayList<>();


    @Override
    public void init() throws ServletException {
        if(dsSP.isEmpty()){
            dsSP.add("iphone");
            dsSP.add("nero");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("danhSach",dsSP);
        req.getRequestDispatcher("/baiTapDoGetPostDeletePut/danh_sach.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String tensp= req.getParameter("tenSP");
        if(tensp!=null && !tensp.trim().isEmpty()){
            dsSP.add(tensp);
        }
        resp.sendRedirect(req.getContextPath()+"/quan_ly_SP");
    }
}
