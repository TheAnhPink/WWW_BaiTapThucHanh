package iuh.fit.demo;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/user")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private static List<User> dsUser= new ArrayList<>();

    static {
            dsUser.add(new User(1,"Anh","123abc@gmail.com"));
            dsUser.add(new User(2,"Hong","456def@gmail.com"));
    }

    @GET
    @Path("/view")
    public String viewUser(){
        return "The Anh";
    }

    @GET
    public Response getUser(){
        return Response.ok(dsUser).build();
    }

    @GET
    @Path("/{id}")
    public Response getUserByID(@PathParam("id") int id){
        for(User u: dsUser){
            if(u.getId()==id){
                return Response.ok(u).build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Không tìm thấy user có id: "+id).build();
    }

    @GET
    @Path("/add/{a}/{b}")
    public int cong(@PathParam("a") int a, @PathParam("b") int b){
        return a+b;
    }

    @GET
    @Path("/getmark")
    public String getMark(@QueryParam("diem") String diem, @QueryParam("ten") String ten){
        return "Chào bạn "+ ten +", gpa: "+ diem;
    }

    @POST
    public Response themUser(User user){
        return dsUser.add(user)?
                Response.status(Response.Status.CREATED).entity("Đã thêm người dùng thành công").build():
                Response.status(Response.Status.BAD_REQUEST).entity("Thêm thất bại").build();
    }

    @PUT
    @Path("/{id}")
    public Response capNhatUser(@PathParam("id") int id,User usermoi){
        for(User u : dsUser){
            if(u.getId()==id){
                u.setName(usermoi.getName());
                u.setEmail(usermoi.getEmail());
                return Response.ok("Cập nhật thành công").build();
            }
        }
        return Response.status(Response.Status.NOT_FOUND).entity("Không có user có id: "+id).build();
    }

    @DELETE
    @Path("/{id}")
    public Response xoaUser(@PathParam("id") int id){
        return dsUser.removeIf(user -> user.getId()==id)?
                 Response.status(Response.Status.OK).entity("Xóa thành công").build():
                Response.status(Response.Status.NOT_FOUND).entity("Không có user có id: "+id+"để xóa").build();
    }


}
