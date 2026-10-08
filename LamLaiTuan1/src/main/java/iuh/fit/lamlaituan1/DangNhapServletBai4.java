package iuh.fit.lamlaituan1;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet(value="/dangNhap")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024*10
)
public class DangNhapServletBai4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");

        String tendn=req.getParameter("tendn");
        String pw=req.getParameter("pw");
        String so=req.getParameter("so");
        String gender=req.getParameter("gender");
        String[] sothich=req.getParameterValues("sothich");

        Part fP= req.getPart("file");
        String fN= fP.getSubmittedFileName();

        String uploadPath= "D:\\Hoc\\Web\\WWW\\BaiTap";

        if( fN==null||fN.isEmpty()){
            fN="No file";
        }else{
            File uploadDir=new File(uploadPath);
            if(!uploadDir.exists()){
                uploadDir.mkdirs();
            }
            fP.write(uploadPath + File.separator+ fN);
        }

        // trả về lên màn hình
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("tendn: "+ tendn+ "<br>");
        resp.getWriter().println("mk: "+ pw+ "<br>");
        resp.getWriter().println("gender: "+ gender+ "<br>");
        resp.getWriter().println("so: "+ so+ "<br>");
//        resp.getWriter().println("sothich: "+ sothich!=null? String.join(", ", sothich): "Không có" + "<br>");
        String sothichStr = (sothich != null) ? String.join(", ", sothich) : "Không có";
        resp.getWriter().println("sothich: " + sothichStr + "<br>");
        resp.getWriter().println("noi file up: "+ fN+ "<br>");
        resp.getWriter().println("noi file luu: "+ uploadPath+ "<br>");

    }
}
