package pl.pollub.integration.user.dto;

public record UserRegistrationRequest(String name, String login, String password, String email, String phoneNumber) {
}
