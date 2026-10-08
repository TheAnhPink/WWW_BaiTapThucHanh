package iuh.fit.demotuan1_bai11.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    private  Product product;
    private int quantity;

    public CartItem() {
    }

    public CartItem(Product product) {
        this.quantity = 1;
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getTongTien1SanPham(){
        return product.getPrice().multiply(BigDecimal.valueOf(quantity));
    }
    public void tangSoLuong(){
        quantity++;
    }
}
