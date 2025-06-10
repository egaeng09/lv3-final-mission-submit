package finalmission.member.controller;

import finalmission.member.controller.dto.LoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Void> login(@RequestBody LoginRequest loginRequest) {
        HttpHeaders headers = new HttpHeaders();
        // TODO: 로그인 기능 구현
        //       임시로 Token 대신 사용자의 이름을 사용
        headers.add("Set-Cookie", "token=" + loginRequest.name() + "; Path=/; HttpOnly");

        return ResponseEntity.ok().headers(headers).build();
    }
}
