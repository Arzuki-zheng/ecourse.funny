package tw.kewang.testserver.api;

import com.google.gson.Gson;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;


@Path("Login_User")
public class API_Login {
    private static final
    Gson GSON = new Gson();

    @POST
    public Response Login(String data) {
        UserData user = new UserData();
        user = GSON.fromJson(data, UserData.class);


        return Response.ok().entity("NMSL").build();

    }

}











