package iuh.fit.demotuan1_bai11.filter;

import iuh.fit.demotuan1_bai11.session.UserSession;
import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;

import java.io.IOException;
@Provider
public class AuthenticationFilter implements ContainerRequestFilter{

    @Inject
    private UserSession userSession;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String path= requestContext.getUriInfo().getPath();

        boolean canBaoVe= path.startsWith("products")||path.startsWith("cart");
        if(canBaoVe && !userSession.kiemTraDangNhap()){
            requestContext.abortWith(
                    Response.status(Response.Status.SEE_OTHER)
                            .header("Location","/api/auth/login")
                            .build()
            );
        }
    }
}
