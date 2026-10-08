package iuh.fit.demotuan1_bai11.api;

import iuh.fit.demotuan1_bai11.service.ProductCatalog;
import iuh.fit.demotuan1_bai11.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.io.IOException;
import java.util.Map;

@Path("/products")
@RequestScoped
@Produces(MediaType.APPLICATION_JSON)
public class ProductResource {

    @Inject
    private ProductCatalog productCatalog;
    @Inject
    private UserSession userSession;

    @GET
    public Response findAll() {
        if(!userSession.kiemTraDangNhap()){
            return Response.status(401)
                    .entity(Map.of("message","Chưa đăng nhập")).build();
        }
        return Response.ok(productCatalog.findAll()).build();
    }
}
