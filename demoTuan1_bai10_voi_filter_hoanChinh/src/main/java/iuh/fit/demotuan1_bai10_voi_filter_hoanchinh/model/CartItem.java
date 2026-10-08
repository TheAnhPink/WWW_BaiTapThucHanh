package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class CartItem implements Serializable {
    private Product product;
    private int quantity;

    public CartItem(Product product) {
        this.product = product;
        this.quantity=1;
    }

    public CartItem() {
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal getTongTienSanPham(){
        return this.product.getPrice().multiply(BigDecimal.valueOf(this.quantity));
    }

    public void tangQuantity(){
        this.quantity+=1;
    }
}
