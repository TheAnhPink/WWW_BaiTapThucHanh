package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.session;

import iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service.ShoppingCart;
import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

import java.io.Serializable;

@Named("userSession")
@SessionScoped
public class UserSession   implements Serializable {
    private String userName;
    private ShoppingCart shoppingCart= new ShoppingCart();

    public void login(String un){
        this.userName= un;
    }
    public boolean kiemTraDangNhap(){
        return userName!=null;
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


}
