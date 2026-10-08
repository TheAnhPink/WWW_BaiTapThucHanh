import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@WebServlet("/login_servlet")
@MultipartConfig(
        fileSizeThreshold = 1024*1024,
        maxFileSize = 1024*1024 *10,
        maxRequestSize = 1024*1024 *10
)
public class LoginServletBai4 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String name= req.getParameter("name");
        String pw= req.getParameter("pw");
        String gender= req.getParameter("gender");
        String[] hobbies= req.getParameterValues("hobbies");
        String country= req.getParameter("country");
        String birthDate=req.getParameter("birth");

        Part filePart=req.getPart("file");
        String fileName=filePart.getSubmittedFileName();

        String uploadPath= System.getProperty("user.home") + File.separator+ "uploads";
        // lỗi khi ko thêm file
//        File uploadDir = new File(uploadPath);
//
//        if(!uploadDir.exists()){
//            uploadDir.mkdirs();
//        }
//        filePart.write(uploadPath+File.separator + fileName);

        if (fileName != null && !fileName.isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdirs();
            }

            filePart.write(uploadPath + File.separator + fileName);
        } else {
            fileName = "No file";
        }

        // xuat dlieu

        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().println("Thong tin da nhap");
        resp.getWriter().println("Name: " + name +"<br>");
        resp.getWriter().println("Password: " + pw +"<br>");
        resp.getWriter().println("Gender: " + gender +"<br>");

        // chuyen mang thanh chuoi
        String hobbiesStr = (hobbies != null) ? String.join(", ", hobbies) : "None";
        resp.getWriter().println("Hobbies: " + hobbiesStr + "<br>");

//        resp.getWriter().println("Hobbies: " + hobbies +"<br>");

        resp.getWriter().println("Country: " + country +"<br>");
        resp.getWriter().println("Birth date: " + birthDate +"<br>");
        resp.getWriter().println("Uploaded file: " + (fileName != null ? fileName: "No file") +"<br>");
        resp.getWriter().println("Saved to : " + uploadPath +"<br>");


    }
}
