package iuh.fit.demomvcproduct.servlet;
import iuh.fit.demomvcproduct.model.Product;
import jakarta.annotation.Resource;
import iuh.fit.demomvcproduct.dao.ProductDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;

@WebServlet("/products")
public class ProductServlet extends HttpServlet {
    @Resource(name="jdbc/productdb")
    private DataSource dataSource;
    private ProductDAO productDAO;


    @Override
    public void init() throws ServletException {
        try {
            productDAO = new ProductDAO(dataSource);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String hanhDong = req.getParameter("action");
        if (hanhDong == null) {
            hanhDong = "list";
        }

        switch (hanhDong) {
            case "list":
                List<Product> danhSach = productDAO.getAllProducts();
                req.setAttribute("products", danhSach);
                req.getRequestDispatcher("views/products.jsp").forward(req, resp);
                break;
            case "add":
                req.getRequestDispatcher("views/product-form.jsp").forward(req, resp);
                break;
            case "edit":
                int maId = Integer.parseInt(req.getParameter("id"));
                Product sanPhamCu = productDAO.getProductById(maId);
                req.setAttribute("product", sanPhamCu);
                req.getRequestDispatcher("views/product-form.jsp").forward(req, resp);
                break;
            case "delete":
                int maXoa = Integer.parseInt(req.getParameter("id"));
                productDAO.deleteProduct(maXoa);
                resp.sendRedirect("products");
                break;
            default:
                resp.sendRedirect("products");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String idChuoi = req.getParameter("id");
        String ten = req.getParameter("name");
        double gia = Double.parseDouble(req.getParameter("price"));

        Product sanPham = new Product();
        sanPham.setName(ten);
        sanPham.setPrice(gia);

        if (idChuoi == null || idChuoi.isEmpty()) {
            productDAO.addProduct(sanPham);
        } else {
            sanPham.setId(Integer.parseInt(idChuoi));
            productDAO.updateProduct(sanPham);
        }
        resp.sendRedirect("products");
    }
}
