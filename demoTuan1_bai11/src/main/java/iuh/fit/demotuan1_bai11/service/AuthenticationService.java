package iuh.fit.demotuan1_bai11.service;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class AuthenticationService {
    public boolean dangNhap(String un,String pw){
        if("theanhpink".equals(un) && "123".equals(pw)){
            return true;
        }
        return false;
    }
}
