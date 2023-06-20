package pl.pollub.integration.user.dto;

public record UserEditRequest(String name, String login, String email, String phoneNumber) {

}
