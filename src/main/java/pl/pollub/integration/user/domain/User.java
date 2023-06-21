package pl.pollub.integration.user.domain;

import io.quarkus.elytron.security.common.BcryptUtil;
import jakarta.persistence.*;
import pl.pollub.integration.user.dto.UserRegistrationRequest;
import pl.pollub.integration.user.dto.UserResponse;

import java.util.UUID;


@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(name = "name")
    private String name;

    @Column(name = "login", unique = true)
    private String login;


    @Column(name = "password")
    private String password;

    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "user_role")
    private UserRole userRole;

    public User() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    private void setRole(UserRole role) {
        this.userRole = role;
    }


    public static User fromRequest(UserRegistrationRequest registrationRequest) {
        User manager = new User();
        manager.setName(registrationRequest.name());
        manager.setLogin(registrationRequest.login());
        manager.setEmail(registrationRequest.email());
        manager.setPassword(BcryptUtil.bcryptHash(registrationRequest.password()));
        manager.setPhoneNumber(registrationRequest.phoneNumber());
        manager.setRole(registrationRequest.role());
        return manager;
    }

    public UserResponse toResponse() {
        return new UserResponse(this.id, this.name, this.login, this.email,
                this.phoneNumber, this.userRole.name());
    }

    public String role() {
        return this.userRole.name();
    }
}
