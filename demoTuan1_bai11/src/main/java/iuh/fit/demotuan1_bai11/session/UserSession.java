package iuh.fit.demotuan1_bai11.session;

import iuh.fit.demotuan1_bai11.service.ShoppingCart;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("userSession")
@SessionScoped
public class UserSession implements Serializable {
    private String userName;
    private ShoppingCart shoppingCart= new ShoppingCart();

    public void setDLKhiDangNhap(String userName){
        this.userName=userName;
    }

    public boolean kiemTraDangNhap(){
        return userName!=null;
    }

    public UserSession() {
    }

    public UserSession(String userName, ShoppingCart shoppingCart) {
        this.userName = userName;
        this.shoppingCart = shoppingCart;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ShoppingCart getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ShoppingCart shoppingCart) {
        this.shoppingCart = shoppingCart;
    }
}
