package iuh.fit.demotuan1_bai11.service;

import iuh.fit.demotuan1_bai11.model.CartItem;
import iuh.fit.demotuan1_bai11.model.Product;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private List<CartItem> dsCartItem= new ArrayList<>();

    public ShoppingCart(List<CartItem> dsCartItem) {
        this.dsCartItem = dsCartItem;
    }

    public ShoppingCart() {
    }

    public List<CartItem> getDsCartItem() {
        return dsCartItem;
    }

    public void setDsCartItem(List<CartItem> dsCartItem) {
        this.dsCartItem = dsCartItem;
    }

    public void add(Product p){
        dsCartItem.stream().filter(it-> it.getProduct().getId()== p.getId())
                .findFirst().ifPresentOrElse(
                        it->it.tangSoLuong(),
                        ()-> dsCartItem.add(new CartItem(p))
                );
    }
    public BigDecimal getTongTienToanBoSanPham(){
        BigDecimal tong= new BigDecimal(0);
        for (CartItem i: dsCartItem){
            tong=tong.add(i.getTongTien1SanPham());
        }
        return tong;
    }

    public int getTongSpTrongGio(){
        int tong=0;
        for(CartItem i : dsCartItem){
            tong+=i.getQuantity();
        }
        return tong;
    }
}
