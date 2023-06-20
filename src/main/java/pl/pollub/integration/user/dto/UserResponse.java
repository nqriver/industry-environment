package pl.pollub.integration.user.dto;

import java.util.UUID;

public record UserResponse(UUID id, String name, String login, String email, String phoneNumber, String role) {

}
