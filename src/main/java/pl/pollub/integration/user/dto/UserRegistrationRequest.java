package pl.pollub.integration.user.dto;

import pl.pollub.integration.user.domain.UserRole;

public record UserRegistrationRequest(String name, String login, String password, String email, String phoneNumber, UserRole role) {
}
