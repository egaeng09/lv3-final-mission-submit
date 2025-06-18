package finalmission.common.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;

public class ErrorResponse {

    private final String method;
    private final String uri;
    private final HttpStatus status;
    private final String message;

    public ErrorResponse(final String method, final String uri, final HttpStatus status, final String message) {
        this.method = method;
        this.uri = uri;
        this.status = status;
        this.message = message;
    }

    public static ErrorResponse of(final HttpServletRequest request, final ErrorCode errorCode) {
        return new ErrorResponse(
            request.getMethod(),
            request.getRequestURI(),
            errorCode.getStatus(),
            errorCode.getMessage()
        );
    }
}
