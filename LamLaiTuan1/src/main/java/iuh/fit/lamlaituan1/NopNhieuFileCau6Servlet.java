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
import java.nio.file.Path;

@WebServlet("/nopfile")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024*10,
        maxRequestSize = 1024*1024* 50
)
public class NopNhieuFileCau6Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uploadPath= getServletContext().getRealPath("")+ "/uploads";

        File uploadDir= new File(uploadPath);

        if(!uploadDir.exists()){
            uploadDir.mkdirs();
        }

        for(Part fp: req.getParts()){
            String fileName= fp.getSubmittedFileName();
            if(fileName!=null&& !fileName.isEmpty()){
                fp.write(uploadPath+ File.separator + fileName);
            }
        }
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().println("<h1>" + "Đã nộp file vào " + uploadPath +
                "</h1>");
    }
}
