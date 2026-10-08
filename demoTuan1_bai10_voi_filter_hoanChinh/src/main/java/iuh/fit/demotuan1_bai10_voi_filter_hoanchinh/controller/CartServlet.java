package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.controller;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model.CartItem;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model.Product;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service.ProductCatalog;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service.ShoppingCart;
import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.session.UserSession;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/cart/add")
public class CartServlet extends HttpServlet {
    @Inject
    private UserSession userSession;

    @Inject
    private ProductCatalog productCatalog;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id= Long.valueOf(req.getParameter("id"));
        Product pNew= productCatalog.findById(id);
        if(pNew!=null){
            userSession.getShoppingCart().addCartItemVoGioHang(new CartItem(pNew));
            resp.sendRedirect(req.getContextPath()+"/products");
        }
    }
}
