package iuh.fit.demotuan1_bai11.api;

import iuh.fit.demotuan1_bai11.service.AuthenticationService;
import iuh.fit.demotuan1_bai11.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.Map;
import java.util.Objects;

@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class AuthResource {
    @Inject
    private UserSession userSession;
    @Inject
    private AuthenticationService authenticationService;


    public record LoginReq(String un, String pw){}

    @POST
    @Path("/login")
    public Response dangNhap(LoginReq body){
        if (body == null
                || !authenticationService.dangNhap(
                body.un(),
                body.pw())
        ) {
            return Response.status(Response.Status.UNAUTHORIZED)
                            .entity(Map.of(
                            "message",
                            "Sai tài khoản hoặc mật khẩu"
                            ))
                            .build();
        }
        userSession.setDLKhiDangNhap(body.un());
        return Response.ok(Map.of(
                "loggedIn", true,
                "username", userSession.getUserName()
        )).build();
    }

    @GET
    @Path("/login")
    public Map<String, Object> getTrangThaiDangNhap(){
        return Map.of(
                "dangNhap",userSession.kiemTraDangNhap(),
                "userName", userSession.getUserName()==null ? ""
                                                        :userSession.getUserName()
        );
    }

    @GET
    @Path("/logout")
    public Response dangXuat(@Context HttpServletRequest req){
        if(req.getSession(false)!=null)
            req.getSession(false).invalidate();

        return Response.noContent().build();
    }

//    @Context // để kêu nó cung cấp các cái liên quan đến req resp
//    private HttpServletResponse respone;
//    @Context
//    private HttpServletRequest request;
//
//    @GET
//    @Path("/login")
//    public void loginPage() throws IOException, ServletException {
//        if(userSession.kiemTraDangNhap()){
//            respone.sendRedirect(request.getContextPath()+"/api/products");
//        }else{
//            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,respone);
//        }
//    }

//    @GET
//    @Path("/login")
//    public Response loginPage(){
//        if(userSession.kiemTraDangNhap()){
//            return  Response.status(Response.Status.SEE_OTHER).header("Location","/api/products").build();
//        }
//        return Response.status(Response.Status.SEE_OTHER)
//                .header("Location","WEB-INF/views/login.jsp")
//                .build();
//    }
//
////    @POST
////    @Path("/login")
////    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
////    public void login(@FormParam("un") String un, @FormParam("pw") String pw) throws IOException, ServletException {
////        if(authenticationService.dangNhap(un,pw)){
////            userSession.setUserName(un);
////            respone.sendRedirect(request.getContextPath()+"/products");
////        }else{
////            request.setAttribute("loi", "sai tài khoản hoặc mât khẩu");
////            request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request,respone);
////        }
////    }
//    @POST
//    @Path("/login")
//    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
//    public Response login(@FormParam("un") String un, @FormParam("pw") String pw){
//        if(authenticationService.dangNhap(un,pw)){
//            userSession.setUserName(un);
//            return Response.status(Response.Status.SEE_OTHER)
//                    .header("Location","/api/products")
//                    .build();
//        }
//        return Response.status(Response.Status.UNAUTHORIZED)
//                .entity("Sai tên đăng nhập hoặc mật khẩu")
//                .build();
//    }
//
////    @POST
////    @Path("/logout")
////    public void dangXuat() throws IOException {
////        request.getSession().invalidate();
////        respone.sendRedirect(request.getContextPath()+"/api/login");
////    }
//
//    @POST
//    @Path("/logout")
//    public Response dangXuat(
//            @Context HttpServletRequest req
//    ){
//        if(req.getSession(false)!=null)
//        req.getSession(false).invalidate();
//        return Response.status(Response.Status.SEE_OTHER)
//                .header("Location","WEB-INF/views/login.jsp")
//                .build();
//    }

}
