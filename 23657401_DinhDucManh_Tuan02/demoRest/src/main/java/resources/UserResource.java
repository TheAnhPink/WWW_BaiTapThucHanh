package resources;

import jakarta.inject.Named;
import jakarta.ws.rs.*;

@Named
@Path("/user")
public class UserResource {
    @GET
    @Path("/view")
    @Produces("text/json")
    public String viewUser(){
      return "Duc Manh";
    };
    @GET
    @Path("/add/{a}/{b}")
    public int Add(@PathParam("a") int a, @PathParam("b") int b){
        return a+b;
    }
    @GET
    @Path("/getmark")
    public String GetMarkStd(@QueryParam("diem") String diem, @QueryParam("ten") String ten){
        return "Chao ban" + ten + " gpa: " + diem;
    }
}
