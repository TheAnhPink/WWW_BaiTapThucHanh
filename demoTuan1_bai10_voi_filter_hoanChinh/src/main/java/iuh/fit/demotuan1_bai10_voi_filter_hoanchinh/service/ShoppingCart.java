package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.model.CartItem;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {
    private List<CartItem> dsCartItemTrongGio= new ArrayList<>();

    public void addCartItemVoGioHang(CartItem cartItem){
        dsCartItemTrongGio.stream().filter(
                it-> it.getProduct().getId()== cartItem.getProduct().getId())
                .findFirst()
                .ifPresentOrElse(it->it.tangQuantity(), ()->dsCartItemTrongGio.add(cartItem));
    }

    public BigDecimal getTongTienToanBoGioHang(){
        BigDecimal tong=new BigDecimal(0);
        for(CartItem ci: dsCartItemTrongGio){
            tong=tong.add(ci.getTongTienSanPham());
        }
        return tong;
    }
    public int getTongSoMonHangTrongGio(){
        int tong=0;
        for(CartItem ci: dsCartItemTrongGio){
            tong+=ci.getQuantity();
        }
        return tong;
    }

    public List<CartItem> getDsCartItemTrongGio() {
        return dsCartItemTrongGio;
    }

    public void setDsCartItemTrongGio(List<CartItem> dsCartItemTrongGio) {
        this.dsCartItemTrongGio = dsCartItemTrongGio;
    }
}
