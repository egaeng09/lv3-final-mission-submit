package finalmission.payment.controller.dto;

import finalmission.payment.service.PaymentFrontService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/payments")
@RestController
public class PaymentController {

    private final PaymentFrontService paymentFrontService;

    @PostMapping
    public ResponseEntity<PaymentReadyResponse> readyPayment(@RequestBody final PaymentReadyRequest paymentReadyRequest) {
        final PaymentReadyResponse ready = paymentFrontService.ready(paymentReadyRequest);
        return ResponseEntity.ok(ready);
    }
}
