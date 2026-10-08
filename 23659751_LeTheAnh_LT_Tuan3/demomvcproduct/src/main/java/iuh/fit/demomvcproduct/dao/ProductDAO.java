package iuh.fit.demomvcproduct.dao;

import iuh.fit.demomvcproduct.model.Product;
import iuh.fit.demomvcproduct.util.DBUtil;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    private DBUtil dbUtil;

    public ProductDAO(DataSource dataSource) {
        this.dbUtil = new DBUtil(dataSource);
    }

    public List<Product> getAllProducts(){
        List<Product> dsProducts= new ArrayList<>();
        String sql= "select * from products";
        try{
            Connection conn= dbUtil.getConnection();
            PreparedStatement ps= conn.prepareStatement(sql);
            ResultSet rs= ps.executeQuery();
            while(rs.next()){
                Product p= new Product(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"));
                dsProducts.add(p);
            }
            return dsProducts;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public Product getProductById(int id) {
        Product pro = null;
        String sql = "SELECT * FROM products WHERE id = ?";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    pro = new Product();
                    pro.setId(rs.getInt("id"));
                    pro.setName(rs.getString("name"));
                    pro.setPrice(rs.getDouble("price"));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return pro;
    }

    public void addProduct(Product product) {
        String sql = "INSERT INTO products (name, price) VALUES (?, ?)";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void updateProduct(Product product) {
        String sql = "UPDATE products SET name = ?, price = ? WHERE id = ?";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, product.getName());
            ps.setDouble(2, product.getPrice());
            ps.setInt(3, product.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void deleteProduct(int id) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (Connection con = dbUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
