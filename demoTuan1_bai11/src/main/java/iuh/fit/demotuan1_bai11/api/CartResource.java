package iuh.fit.demotuan1_bai11.api;

import iuh.fit.demotuan1_bai11.model.Product;
import iuh.fit.demotuan1_bai11.service.ProductCatalog;
import iuh.fit.demotuan1_bai11.service.ShoppingCart;
import iuh.fit.demotuan1_bai11.session.UserSession;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.Map;
import java.util.Optional;

@Path("/cart")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@RequestScoped
public class CartResource {
    @Inject
    private UserSession userSession;
    @Inject
    private ProductCatalog dssp;
    @Inject
    private ProductCatalog productCatalog;

    private Response respChuaDangNhap() {
        return Response.status(401)
                .entity(Map.of(
                        "message",
                        "Bạn chưa đăng nhập"
                ))
                .build();
    }

    public Map<String, Object> thongTinCartItemTrongGio(){
        ShoppingCart sc= userSession.getShoppingCart();

        return Map.of(
                "items",sc.getDsCartItem(),
                "tongSPTrongGio",sc.getTongSpTrongGio(),
                "tongTienGioHang",sc.getTongTienToanBoSanPham()
        );
    }

    @GET
    public Response getSPTrongGio(){
        if(!userSession.kiemTraDangNhap()){
            return respChuaDangNhap();
        }
        return Response.ok(thongTinCartItemTrongGio()   ).build();
    }

    public record AddItemReq(Long id){}
    @POST
    @Path("/add")
    public Response addItem(AddItemReq req){
        if(!userSession.kiemTraDangNhap()){
             return respChuaDangNhap();
        }
        Optional<Product> p= req==null? Optional.empty()
                                    :productCatalog.findById(req.id());
        if(p.isEmpty()){
            return Response.status(404)
                    .entity(Map.of(
                            "message",
                            "Không tìm thấy sản phẩm"
                    ))
                    .build();
        }
        userSession.getShoppingCart().add(p.get());
        return Response.ok(thongTinCartItemTrongGio()).build();
    }

//    @POST
//    @Path("/{id}")
//    public Response themSPVaoGio(@PathParam("id") Long id){
//        for (Product p: dssp.findAll()){
//            if(id==p.getId()){
//                userSession.getShoppingCart().add(p);
//                return Response.status(Response.Status.CREATED).entity(p).build();
//            }
//        }
//        return Response.status(Response.Status.NOT_FOUND)
//                .entity("Không tìm thấy sản phẩm để thêm").build();
//    }
//
//    @DELETE
//    @Path("/{id}")
//    public Response xoaSPKhoiGio(@PathParam("id") Long id){
//        if(dssp.findAll().removeIf(p->p.getId()==id)){
//            return Response.ok().entity("Xóa thành công").build();
//        }
//        return Response.status(Response.Status.NOT_FOUND)
//                .entity("Không tìm thấy sp để xóa").build();
//    }
}
