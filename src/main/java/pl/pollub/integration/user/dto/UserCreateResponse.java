package pl.pollub.integration.user.dto;

public record UserCreateResponse(UserResponse user,
                                 JwtTokenResponse jwt) {

}
