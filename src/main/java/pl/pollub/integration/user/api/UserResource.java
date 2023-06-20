package pl.pollub.integration.user.api;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import pl.pollub.integration.user.UserFacade;
import pl.pollub.integration.user.dto.*;

import java.util.UUID;

@ApplicationScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserFacade userFacade;


    @PUT
    @Path("/{userId}")
    public UserResponse editManager(@PathParam("userId") UUID userId, UserEditRequest editRequest) {
        return userFacade.edit(userId, editRequest);
    }


    @GET
    @Path("/{userId}")
    public UserResponse getUser(@PathParam("userId") UUID userId) {
        return userFacade.get(userId);
    }

    @POST
    @Path("/register")
    public UserCreateResponse register(UserRegistrationRequest request) {
        return userFacade.registerUser(request);
    }


    @POST
    @Path("/login")
    public JwtTokenResponse login(UserLoginRequest request) {
        String jwt = userFacade.login(request);
        return new JwtTokenResponse(jwt);
    }

}
