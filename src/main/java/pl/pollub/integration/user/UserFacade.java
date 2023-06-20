package pl.pollub.integration.user;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.security.UnauthorizedException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import pl.pollub.integration.commons.ServiceErrorCode;
import pl.pollub.integration.commons.ServiceException;
import pl.pollub.integration.user.domain.User;
import pl.pollub.integration.user.domain.UserRepository;
import pl.pollub.integration.user.dto.*;

import java.util.UUID;

@ApplicationScoped
public class UserFacade {

    @Inject
    UserRepository userRepository;

    @Inject
    JwtService jwtService;


    @Transactional
    public UserCreateResponse registerUser(UserRegistrationRequest registrationRequest) {
        if (userRepository.findByLogin(registrationRequest.login()).isPresent()) {
            throw new ServiceException(ServiceErrorCode.USER_LOGIN_TAKEN);
        } else if (userRepository.findByEmail(registrationRequest.email()).isPresent()) {
            throw new ServiceException(ServiceErrorCode.USER_EMAIL_TAKEN);
        }

        User user = User.fromRequest(registrationRequest);
        userRepository.persist(user);
        JwtTokenResponse jwt = new JwtTokenResponse(jwtService.getJwt(user));
        return new UserCreateResponse(user.toResponse(), jwt);
    }


    public String login(UserLoginRequest loginRequest) {
        User user = userRepository.findByLogin(loginRequest.login())
                .orElseThrow(UnauthorizedException::new);

        if (!BcryptUtil.matches(loginRequest.password(), user.getPassword())) {
            throw new UnauthorizedException();
        }

        return jwtService.getJwt(user);
    }


    public UserResponse get(UUID userId) {
        return findOne(userId)
                .toResponse();
    }

    private User findOne(UUID userId) {
        return userRepository.findByIdOptional(userId).orElseThrow(() -> new ServiceException(ServiceErrorCode.USER_NOT_FOUND));
    }

    @Transactional
    public UserResponse edit(UUID userId, UserEditRequest editRequest) {
        User user = findOne(userId);

        if (editRequest.email() != null) {
            assertEmailIsNotUsed(editRequest.email(), userId);
            user.setEmail(editRequest.email());
        }
        if (editRequest.phoneNumber() != null) {
            user.setPhoneNumber(editRequest.phoneNumber());
        }
        if (editRequest.login() != null) {
            assertLoginIsNotUsed(editRequest.login(), userId);
            user.setLogin(editRequest.login());
        }
        if (editRequest.name() != null) {
            user.setName(editRequest.name());
        }
        userRepository.persist(user);
        return user.toResponse();
    }

    private void assertEmailIsNotUsed(String email, UUID userId) {
        userRepository.find("email", email).firstResultOptional().ifPresent(found -> {
            if (!userId.equals(found.getId())) {
                throw new ServiceException(ServiceErrorCode.USER_EMAIL_TAKEN);
            }
        });
    }

    private void assertLoginIsNotUsed(String login, UUID userId) {
        userRepository.find("login", login).firstResultOptional().ifPresent(found -> {
            if (!userId.equals(found.getId())) {
                throw new ServiceException(ServiceErrorCode.USER_LOGIN_TAKEN);
            }
        });
    }
}
