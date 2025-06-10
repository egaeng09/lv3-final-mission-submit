package finalmission.payment.service.client;

import finalmission.payment.service.client.dto.TossPaymentRequest;
import finalmission.payment.service.client.dto.TossPaymentResponse;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@RequiredArgsConstructor
@Component
public class TossPaymentClient {

    private static final String SECRET_KEY = "temp_key";

    private final RestClient restClient;

    public TossPaymentResponse confirm(final TossPaymentRequest request) {
        return restClient.post().uri("/confirm")
                .contentType(MediaType.APPLICATION_JSON)
                .header("Authorization", "Basic " + Base64.getEncoder()
                        .encodeToString((SECRET_KEY + ':').getBytes(StandardCharsets.UTF_8)))
                .body(request)
                .retrieve()
                .body(TossPaymentResponse.class);
    }
}
