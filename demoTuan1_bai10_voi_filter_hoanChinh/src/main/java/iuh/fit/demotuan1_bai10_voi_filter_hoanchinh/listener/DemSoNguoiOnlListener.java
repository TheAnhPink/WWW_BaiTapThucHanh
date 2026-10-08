package iuh.fit.demotuan1_bai10_voi_filter_hoanchinh.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.util.concurrent.atomic.AtomicInteger;

@WebListener
public class DemSoNguoiOnlListener implements ServletContextListener,HttpSessionListener {
    private String bienLuuTenAtt= "userCounter";
    private AtomicInteger count=new AtomicInteger(0);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute(bienLuuTenAtt,count);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute(bienLuuTenAtt);
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        AtomicInteger soHienTai= (AtomicInteger) se.getSession()
                                .getServletContext().getAttribute(bienLuuTenAtt);
        if(soHienTai!=null){
            count.incrementAndGet();
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        AtomicInteger soHienTai= (AtomicInteger) se.getSession()
                            .getServletContext().getAttribute(bienLuuTenAtt);
        if(soHienTai!=null&&soHienTai.get()>0){
            count.decrementAndGet();
        }
    }
}
