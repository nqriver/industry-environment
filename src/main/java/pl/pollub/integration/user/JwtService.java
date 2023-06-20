package pl.pollub.integration.user;

import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import pl.pollub.integration.user.domain.User;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

@ApplicationScoped
public class JwtService {
    @ConfigProperty(name = "mp.jwt.verify.issuer")
    String jwtIssuer;

    public String getJwt(User user) {
        Instant now = Instant.now();

        return Jwt.issuer(jwtIssuer)
                .upn(user.getLogin())
                .issuedAt(now)
                .groups(user.role())
                .expiresAt(now.plus(2, ChronoUnit.HOURS))
                .claim("userId", user.getId())
                .claim("email", user.getEmail())
                .sign();
    }
}
