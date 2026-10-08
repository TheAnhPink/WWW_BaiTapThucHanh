package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean dangNhap(String userName, String pw){
        if("admin".equals(userName)&&"123".equals(pw)){
            return true;
        }
        return false;
    }
}
