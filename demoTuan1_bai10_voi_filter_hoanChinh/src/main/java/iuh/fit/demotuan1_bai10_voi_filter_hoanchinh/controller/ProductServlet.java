package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.controller;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model.CartItem;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model.Product;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service.ProductCatalog;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private UserSession userSession;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Product> dssp= productCatalog.getAll();
        if(dssp!=null){
            req.setAttribute("dssp",dssp);
            req.setAttribute("user",userSession);
            req.getRequestDispatcher("/WEB-INF/views/products.jsp").forward(req,resp);
        }
    }
}
