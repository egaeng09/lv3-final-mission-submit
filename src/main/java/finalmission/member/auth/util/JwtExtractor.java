package finalmission.member.auth.util;

import finalmission.common.exception.AuthenticationException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import jakarta.servlet.http.Cookie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtExtractor {

    private static final String TOKEN_NAME = "token";

    @Value("${jwt.secret-key}")
    private String SECRET_KEY;

    public Long extractMemberId(String token) {
        return Long.valueOf(extractClaims(token).getSubject());
    }

    public String extractToken(Cookie[] cookies) {
        if (cookies == null) {
            throw new AuthenticationException("쿠키가 존재하지 않습니다.");
        }

        for (Cookie cookie : cookies) {
            if (TOKEN_NAME.equals(cookie.getName())) {
                return cookie.getValue();
            }
        }

        throw new AuthenticationException("쿠키에 Token 정보가 없습니다.");
    }

    private Claims extractClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(SECRET_KEY)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new AuthenticationException("만료된 토큰입니다.");
        } catch (MalformedJwtException e) {
            throw new AuthenticationException("잘못된 토큰입니다.");
        } catch (JwtException e) {
            throw new AuthenticationException("유효하지 않은 토큰입니다.");
        }
    }
}
