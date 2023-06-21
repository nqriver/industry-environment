package pl.pollub.integration.user.api;

import io.quarkus.security.Authenticated;
import io.quarkus.security.UnauthorizedException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.jwt.JsonWebToken;
import pl.pollub.integration.user.UserFacade;
import pl.pollub.integration.user.dto.*;

import java.util.Objects;
import java.util.UUID;

@ApplicationScoped
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UserResource {

    @Inject
    UserFacade userFacade;


    @Inject
    JsonWebToken loggedInUserJwt;

    @PUT
    @Path("/{userId}")
    @Authenticated
    public UserResponse editUser(@PathParam("userId") UUID userId, UserEditRequest editRequest) {
        if (!Objects.equals(loggedInUserJwt.getClaim("userId"), userId.toString())) {
            throw new UnauthorizedException();
        }
        return userFacade.edit(userId, editRequest);
    }


    @GET
    @Path("/{userId}")
    @Authenticated
    public UserResponse getUser(@PathParam("userId") UUID userId) {
        if (!Objects.equals(loggedInUserJwt.getClaim("userId"), userId.toString())) {
            throw new UnauthorizedException();
        }
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
