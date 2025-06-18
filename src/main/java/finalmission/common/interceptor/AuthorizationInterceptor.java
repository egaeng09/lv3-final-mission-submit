package finalmission.common.interceptor;

import finalmission.member.auth.annotation.PermitAll;
import finalmission.member.auth.util.JwtExtractor;
import finalmission.member.auth.vo.MemberInfo;
import finalmission.member.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

@RequiredArgsConstructor
public class AuthorizationInterceptor implements HandlerInterceptor {

    private final JwtExtractor jwtExtractor;
    private final AuthService authService;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if (!(handler instanceof HandlerMethod handlerMethod)) {
            return true;
        }

        if (handlerMethod.hasMethodAnnotation(PermitAll.class)) {
            return true;
        }

        final String token = jwtExtractor.extractToken(request.getCookies());
        final MemberInfo memberInfo = authService.get(token);

        return true;
    }
}
