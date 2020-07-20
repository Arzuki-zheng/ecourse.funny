package tw.kewang.testserver.api;

import com.google.gson.Gson;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.*;

@Path("Create_Account")
public class API_NewAccount {
    private static Gson GSON = new Gson();
    ConnectToMySQL CONNECT = new ConnectToMySQL();

    @POST
    public Response register(String data) throws SQLException {
        UserData user = new UserData();
        user = GSON.fromJson(data, UserData.class);
        CONNECT.create(user);
        return Response.ok().entity("Register Success").build();
    }
}
