package finalmission.member.controller.dto;

public record SignupRequest(
        String name,
        String email,
        String password
) {
}
